package com.charisma.sales.cart;

import com.charisma.sales.cart.exception.ItemNotFoundException;
import com.charisma.sales.cart.dao.ItemRepository;
import com.charisma.sales.cart.entities.Item;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SimpleItemService implements IItem {

    private final ItemRepository repository;

    private final ItemMapper itemMapper;
    @Override
    public com.charisma.sales.cart.valueobjects.Item findByProductIdAndCartId(long productId, long cartId) {
        var item = repository.findByProductIdAndCartId(productId, cartId).orElseThrow(
                ()->new ItemNotFoundException("Item Not Found cartId: "+ cartId)
        );

        return itemMapper.requestToSource(item);

    }

    @Override
    public void remove(long productId, long cartId) {
        var item = repository.findByProductIdAndCartId(productId, cartId).orElseThrow(
                ()-> new ItemNotFoundException("Item not found: "+ cartId)
        );
        repository.delete(item);
    }

    @Override
    public void add(long productId, long cartId, int quantity) {
        var entity = repository.findByProductIdAndCartId(productId, cartId);
        Item item;

        if (entity.isPresent())
            item = entity.get();
        else {
            item = new Item();
            item.setProductId(productId);
            item.setCartId(cartId);
        }

        item.setQuantity(quantity);
        repository.save(item);
    }

    @Override
    public void removeAll(long cartId) {
        var items = repository.findAllByCartId(cartId);
        repository.deleteAll(items);
    }

    @Override
    public List<com.charisma.sales.cart.valueobjects.Item> getAllItems(long cartId) {
        var items = repository.findAllByCartId(cartId);
        return itemMapper.requestToSource(items);
    }
}
