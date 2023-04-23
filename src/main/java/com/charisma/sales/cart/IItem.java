package com.charisma.sales.cart;

import com.charisma.sales.cart.valueobjects.Item;

import java.util.List;

public interface IItem {

    Item findByProductIdAndCartId(long productId, long userId);

    void remove(long productId,long cartId);

    void add(long productId,long cartId,int quantity);

    void removeAll(long cartId);

    List<Item> getAllItems(long cartId);
}
