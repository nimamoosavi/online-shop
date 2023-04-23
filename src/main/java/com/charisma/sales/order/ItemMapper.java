package com.charisma.sales.order;


import com.charisma.common.mapper.Mapper;
import com.charisma.sales.order.entities.Item;
import com.charisma.sales.order.events.WareHouseOrder;
import com.charisma.sales.order.valueobjects.ItemRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.mapstruct.Mapper
public abstract class ItemMapper extends Mapper<com.charisma.sales.order.valueobjects.Item, Item> {

    public abstract List<Item> mapToItems(List<ItemRequest> requests);

    public abstract List<WareHouseOrder> mapToWareHouseItems(List<Item> items);

}
