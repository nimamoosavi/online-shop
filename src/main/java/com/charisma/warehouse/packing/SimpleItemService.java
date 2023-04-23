package com.charisma.warehouse.packing;


import com.charisma.warehouse.packing.dao.ItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SimpleItemService implements IItem{

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;
    @Override
    public void addAll(List<Item> items,Long reference) {
        var itemList = itemMapper.toRequestModel(items);
        itemList.forEach(x->x.setPackId(reference));
        itemRepository.saveAll(itemList);
    }
}
