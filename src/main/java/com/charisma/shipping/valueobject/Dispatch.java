package com.charisma.shipping.valueobject;

import com.charisma.warehouse.packing.PackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class Dispatch {

    @NotBlank
    public final String trackingCode;

    @NotNull
    public final PackReference packReference;

    @NotBlank
    public final String address;
}
