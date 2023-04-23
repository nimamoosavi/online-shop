package com.charisma.warehouse.packing;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface IPack {

    PackReference pack(@NotEmpty List<Item> items, @NotNull String trackingCode);

    Pack findByPackReference(@NotNull String packReference);

    List<Pack> findByTrackingCode(@NotNull String trackingCode);

}
