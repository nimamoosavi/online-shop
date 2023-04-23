package com.charisma.payment.payment.web;

import com.charisma.payment.payment.IPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.charisma.payment.payment.web.PaymentUrlMapping.PAY;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final IPayment payment;

    @PostMapping(PAY)
    public ResponseEntity<Object> pay(@PathVariable String reference){
        payment.pay(reference);
        return ResponseEntity.ok().build();
    }
}
