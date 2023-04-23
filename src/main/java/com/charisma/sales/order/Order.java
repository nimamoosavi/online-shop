package com.charisma.sales.order;



import com.charisma.sales.order.valueobjects.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public final class Order {

    private  List<Item> items;

    private  BigDecimal total;

    private  Double discount;
}
