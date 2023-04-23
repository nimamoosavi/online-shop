package com.charisma.shipping.web;

import com.charisma.shipping.IDispatch;
import com.charisma.shipping.enums.DispatchingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.charisma.shipping.web.ShippingUrlMapping.CHANGE_SHIPPING_STATUS;
import static com.charisma.shipping.web.ShippingUrlMapping.SHIPPING_STATUS;

@RestController
@RequiredArgsConstructor
public class ShippingController {

    private final IDispatch simpleDispatchService;



    @GetMapping(SHIPPING_STATUS)
    public ResponseEntity<DispatchingStatus> getStatus(@PathVariable String reference){
        var status = simpleDispatchService.getStatus(reference);
        return ResponseEntity.ok(status);
    }

    @PutMapping(CHANGE_SHIPPING_STATUS)
    public ResponseEntity<Object> changeStatus(@PathVariable String reference,@PathVariable DispatchingStatus status){
        simpleDispatchService.changeStatus(reference, status);
        return ResponseEntity.ok().build();
    }
}
