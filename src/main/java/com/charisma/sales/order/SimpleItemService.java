package com.charisma.sales.order;

import com.charisma.sales.order.dao.ItemRepository;
import com.charisma.sales.order.valueobjects.ItemRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SimpleItemService implements IItem {

    private final ItemRepository repository;

    private final ItemMapper itemMapper;


    @Override
    public void add(List<ItemRequest> request, long orderId) {
        var items = itemMapper.mapToItems(request);
        items.forEach(x->x.setOrderId(orderId));
        repository.saveAll(items);
    }
}
