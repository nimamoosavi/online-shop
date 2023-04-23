package com.charisma.sales.cart;

import com.charisma.common.mapper.Mapper;
import com.charisma.sales.cart.valueobjects.Item;
import org.springframework.stereotype.Component;

@Component
@org.mapstruct.Mapper
public abstract class ItemMapper extends Mapper<Item, com.charisma.sales.cart.entities.Item> {

}
