package com.charisma.sales.order;


import com.charisma.sales.order.valueobjects.ItemRequest;

import java.util.List;

public interface IItem {

    void add(List<ItemRequest> items, long orderId);
}
