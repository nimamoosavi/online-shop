package com.charisma.sales.order;


import com.charisma.common.mapper.Mapper;
import com.charisma.sales.order.web.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@org.mapstruct.Mapper
@RequiredArgsConstructor
public abstract class OrderMapper extends Mapper<Order, com.charisma.sales.order.entities.Order> {

    private final ItemMapper itemMapper;
    @AfterMapping
    public void mapToTarget(@MappingTarget Order target, com.charisma.sales.order.entities.Order order) {
        var items = itemMapper.requestToSource(order.getItems());
        target.setItems(items);
    }

    public abstract OrderDTO mapToOrderDTO(Order order);

}
