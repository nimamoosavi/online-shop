package com.charisma.sales.order;

import com.charisma.common.event.Event;
import com.charisma.sales.catalog.product.IProduct;
import com.charisma.sales.order.dao.OrderRepository;
import com.charisma.sales.order.enums.DiscountType;
import com.charisma.sales.order.enums.OrderPaymentStatus;
import com.charisma.sales.order.events.DispatchingEvent;
import com.charisma.sales.order.events.IEvent;
import com.charisma.sales.order.events.OrderEvent;
import com.charisma.sales.order.events.WareHouseEvent;
import com.charisma.sales.order.exception.MinimumAmountRuleException;
import com.charisma.sales.order.exception.OrderNotFoundException;
import com.charisma.sales.order.exception.TimeRuleException;
import com.charisma.sales.order.listeners.OrderPaymentStatusEvent;
import com.charisma.sales.order.listeners.PackEvent;
import com.charisma.sales.order.valueobjects.ItemRequest;
import com.charisma.sales.order.valueobjects.OrderRequest;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class SimpleOrderService implements IOrder {


    private static final Integer MIN_HOUR_ORDER_RULE = 8;

    private static final Integer MAX_HOUR_ORDER_RULE = 17;

    private static final BigDecimal MIN_AMOUNT_ORDER_RULE = BigDecimal.valueOf(50_000);


    private final OrderRepository orderRepository;

    private final IProduct productService;

    private final IDiscount discountService;

    private final OrderMapper orderMapper;

    private final ItemMapper itemMapper;

    private final IEvent<Event> event;

    private final IItem itemService;

    @Override
    @Transactional
    public String order(OrderRequest request,long userId) {

        var totalOrders = totalOrders(request);

        checkOrderRules(totalOrders);

        var newOrder = createNewOrder(request,userId,totalOrders);
        var order = orderRepository.save(newOrder);
        itemService.add(request.getItems(),order.getId());

        if (Boolean.TRUE.equals(request.getDiscountCode()!=null))
            discountService.use(request.getDiscountCode());

        publishPaymentEvent(order.getTrackingCode());
        return order.getTrackingCode();
    }

    @Override
    public Order findByOrderAndUser(long orderId,long userId) {
        var order = orderRepository.findOrderByIdAndUserId(orderId,userId).orElseThrow(
                ()-> new OrderNotFoundException("Order not found ! orderId: "+orderId)
        );
        return orderMapper.requestToSource(order);
    }

    @Override
    public Order findByTrackingCode(String trackingCode) {
        var order = orderRepository.findByTrackingCode(trackingCode).orElseThrow(
                ()-> new OrderNotFoundException("Order not found ! tracking Code:"+trackingCode)
        );
        return orderMapper.requestToSource(order);
    }

    @Override
    public void finalizeOrderPayment(OrderPaymentStatusEvent request) {
        var order = orderRepository.findByTrackingCode(request.getTrackingCode()).orElseThrow(
                ()-> new OrderNotFoundException("Order not found ! tracking Code: "+request.getTrackingCode())
        );
        order.setPaymentStatus(request.getStatus());
        orderRepository.save(order);

        if (Boolean.TRUE.equals(request.getStatus().equals(OrderPaymentStatus.PAYED)))
            publishWareHouseEvent(request.getTrackingCode(),order);
    }

    @Override
    public void finalizeOrderPacking(PackEvent request) {
        publishDispatchingEvent(request);
    }

    private BigDecimal totalOrders(@Valid OrderRequest request){
        var total = request.getItems()
                .stream()
                .map(this::calculateItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (Boolean.TRUE.equals(request.getDiscountCode() != null))
           total = reduceDiscountValue(total,request.getDiscountCode());

        return total;
    }

    private BigDecimal calculateItemPrice(ItemRequest itemRequest){
        var product = productService.findById(itemRequest.getProductId());
        return product.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
    }

    private void checkOrderRules(BigDecimal total){
        checkTimeRule();
        checkTotalRule(total);
    }

    private void checkTimeRule(){
        var current = LocalDateTime.now();

        if (current.getHour()<MIN_HOUR_ORDER_RULE)
            throw new TimeRuleException("The order time must be between 8 and 17");

        if (current.getHour()>MAX_HOUR_ORDER_RULE)
            throw new TimeRuleException("The order time must be between 8 and 17");
    }

    private void checkTotalRule(BigDecimal total){
        if (total.compareTo(MIN_AMOUNT_ORDER_RULE) < 0)
            throw new MinimumAmountRuleException("The order time must be greeter than "+MIN_AMOUNT_ORDER_RULE);
    }

    private com.charisma.sales.order.entities.Order createNewOrder(OrderRequest request,long userId,BigDecimal totalOrders){
        var order = new com.charisma.sales.order.entities.Order();
        order.setTotal(totalOrders);
        order.setUserId(userId);
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setDiscountCode(request.getDiscountCode());
        return order;
    }

    private BigDecimal reduceDiscountValue(BigDecimal total,String discountCode){
        var discount = discountService.findByCode(discountCode);
        if (Boolean.TRUE.equals(discount.getType().equals(DiscountType.VALUE)))
            return total.subtract(discount.getValue());
        var percentageAmount = total.multiply(new BigDecimal(discount.getPercentage()));
        return total.subtract(percentageAmount);
    }

    private void publishPaymentEvent(String trackingCode){
        var orderEvent = new OrderEvent(LocalDateTime.now(), trackingCode);
        event.publish(orderEvent);
    }

    private void publishWareHouseEvent(String trackingCode, com.charisma.sales.order.entities.Order order){
        var wareHouseOrders = itemMapper.mapToWareHouseItems(order.getItems());
        var wareHouseOrder = new WareHouseEvent(LocalDateTime.now(),trackingCode,wareHouseOrders);
        event.publish(wareHouseOrder);
    }

    private void publishDispatchingEvent(PackEvent request){
        var order = orderRepository.findByTrackingCode(request.getTrackingCode()).orElseThrow(
                ()-> new OrderNotFoundException("Order not found ! trackingCode: "+request.getTrackingCode())
        );
        var dispatchingEvent = new DispatchingEvent(LocalDateTime.now(),request.getTrackingCode()
                ,request.getPackReference()
                ,order.getDeliveryAddress());
        event.publish(dispatchingEvent);
    }
}
