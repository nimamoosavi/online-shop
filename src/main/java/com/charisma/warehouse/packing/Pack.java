package com.charisma.warehouse.packing;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Pack {

    private final List<Item> items;

    private final String reference;

    private final String trackingCode;
}
