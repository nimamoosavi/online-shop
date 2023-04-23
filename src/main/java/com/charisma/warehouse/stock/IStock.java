package com.charisma.warehouse.stock;

import com.charisma.warehouse.packing.Item;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface IStock {

    long findProductQuantity(long productId);
    void putInStock(@Valid Stock stock);

    void leftFromStock(long productId,long quantity);

    void leftFromStock(@NotEmpty List<Item> items);
}
