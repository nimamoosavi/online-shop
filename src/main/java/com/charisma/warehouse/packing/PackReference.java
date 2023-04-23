package com.charisma.warehouse.packing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class PackReference {
    private final List<String> packReferences;
}
