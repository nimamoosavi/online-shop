package com.charisma.sales.order;

import com.charisma.common.event.Event;
import com.charisma.sales.cart.SimpleCartService;
import com.charisma.sales.cart.valueobjects.CartRequest;
import com.charisma.sales.catalog.product.IProduct;
import com.charisma.sales.order.dao.OrderRepository;
import com.charisma.sales.order.enums.DiscountType;
import com.charisma.sales.order.events.IEvent;
import com.charisma.sales.order.events.OrderEvent;
import com.charisma.sales.order.valueobjects.ItemRequest;
import com.charisma.sales.order.valueobjects.OrderRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SimpleOrderService.class})
@ExtendWith(SpringExtension.class)
class IOrderTest {

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private IProduct productService;

    @MockBean
    private IDiscount discountService;

    @MockBean
    private OrderMapper orderMapper;

    @MockBean
    private ItemMapper itemMapper;

    @MockBean
    private IEvent<Event> event;

    @MockBean
    private IItem itemService;

    private Long userId;

    @BeforeEach
    public void init(){
        this.userId = 2L;
    }


    /**
     * Method under test: {@link SimpleOrderService#order(OrderRequest, long)}} }
     */
    @Test
    void order_then_returnReference() {
        //get
        var items = new ArrayList<ItemRequest>();
        items.add(new ItemRequest(1L,1));
        var request = new OrderRequest(items, UUID.randomUUID().toString(), UUID.randomUUID().toString());
        var newOrder = createNewOrder(request, userId, BigDecimal.valueOf(100));
        //when
        var response = when(orderRepository.save(newOrder)).thenReturn(newOrder);
        event.publish(new OrderEvent(LocalDateTime.now(),UUID.randomUUID().toString()));
        //then
        Assertions.assertNotNull(response);
    }


    /**
     * Method under test: {@link SimpleOrderService#order(OrderRequest, long)}} }
     */
    @Test
    void findByOrderAndUser_thenReturn() {
        //get
        var orderId = 1L;

        var thenReturn = when(orderRepository.findOrderByIdAndUserId(orderId, userId)).thenReturn(Optional.empty());

        Assertions.assertNotNull(thenReturn);
    }


    private com.charisma.sales.order.entities.Order createNewOrder(OrderRequest request, long userId, BigDecimal totalOrders){
        var order = new com.charisma.sales.order.entities.Order();
        order.setTotal(totalOrders);
        order.setUserId(userId);
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setDiscountCode(request.getDiscountCode());
        return order;
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

    private BigDecimal reduceDiscountValue(BigDecimal total,String discountCode){
        var discount = discountService.findByCode(discountCode);
        if (Boolean.TRUE.equals(discount.getType().equals(DiscountType.VALUE)))
            return total.subtract(discount.getValue());
        var percentageAmount = total.multiply(new BigDecimal(discount.getPercentage()));
        return total.subtract(percentageAmount);
    }

}