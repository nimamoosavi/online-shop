package com.charisma.warehouse.packing;

import com.charisma.warehouse.packing.dao.PackRepository;
import com.charisma.warehouse.packing.entities.Pack;
import com.charisma.warehouse.packing.enums.PackingType;
import com.charisma.warehouse.packing.events.IEvent;
import com.charisma.warehouse.packing.events.PackEvent;
import com.charisma.warehouse.packing.exception.PackNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.charisma.warehouse.packing.enums.PackingType.BREAKABLE;
import static com.charisma.warehouse.packing.enums.PackingType.NORMAL;

@RequiredArgsConstructor
public class SimplePackService implements IPack{

    private final PackRepository packRepository;

    private final IItem simpleItemService;

    private final PackMapper packMapper;

    private final IEvent<PackEvent> event;
    @Override
    public PackReference pack(List<Item> items,String trackingCode) {
        var packReference = new ArrayList<String>(2);

        var breakableItems = items.stream()
                .filter(x -> x.getPackingType().equals(BREAKABLE))
                .collect(Collectors.toList());

        var normalItems = items.stream()
                .filter(x -> x.getPackingType().equals(NORMAL))
                .collect(Collectors.toList());

        if (!breakableItems.isEmpty()){
            var reference = packing(breakableItems, BREAKABLE, trackingCode);
            packReference.add(reference);
        }

        if (!normalItems.isEmpty()){
            var reference = packing(normalItems, NORMAL, trackingCode);
            packReference.add(reference);
        }

        var reference = new PackReference(packReference);
        publishPackEvent(trackingCode,reference);

        return reference;
    }

    @Override
    public com.charisma.warehouse.packing.Pack findByPackReference(String packReference) {
        var pack = packRepository.findByPackReference(packReference).orElseThrow(
                () -> new PackNotFoundException("Pack Not Found")
        );

        return packMapper.requestToSource(pack);
    }

    @Override
    public List<com.charisma.warehouse.packing.Pack> findByTrackingCode(String trackingCode) {
        var packs = packRepository.findAllBy(trackingCode);
        return packMapper.requestToSource(packs);
    }

    private String packing(List<Item> items, PackingType packingType, String trackingCode){
        var pack = new Pack();
        pack.setPackingType(packingType);
        pack.setTrackingCode(trackingCode);
        var object = packRepository.save(pack);
        simpleItemService.addAll(items,object.getId());
        return object.getPackReference();
    }

    private void publishPackEvent(String trackingCode, PackReference reference){
        var packEvent = new PackEvent(LocalDateTime.now(),trackingCode,reference);
        event.publish(packEvent);
    }

}
