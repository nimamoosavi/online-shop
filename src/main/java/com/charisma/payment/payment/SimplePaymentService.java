package com.charisma.payment.payment;

import com.charisma.payment.contradiction.IContradiction;
import com.charisma.payment.payment.dao.PaymentRepository;
import com.charisma.payment.payment.enums.PaymentStatus;
import com.charisma.payment.payment.exceptions.PaymentNotFoundException;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static com.charisma.payment.payment.enums.PaymentStatus.NOT_KNOWN;
import static com.charisma.payment.payment.enums.PaymentStatus.PASSED;

@RequiredArgsConstructor
public class SimplePaymentService implements IPayment{

    private final PaymentRepository paymentRepository;

    private final IContradiction simpleContradictionService;

    private final PaymentMapper paymentMapper;

    private final IEvent<PaymentEvent> event;
    @Override
    public void pay(String reference) {
        var payment = paymentRepository.findByReference(reference).orElseThrow(
                () -> new PaymentNotFoundException("Reference Not Found : ref: " + reference)
        );
        var paymentStatus = checkPaymentStatus(payment.getReference());
        payment.setStatus(paymentStatus);
        paymentRepository.save(payment);
        publishPaymentEvent(payment.getTrackingCode());
    }

    @Override
    public Payment findByTrackingCode(String trackingCode) {
        var payment = paymentRepository.findByTrackingCode(trackingCode).orElseThrow(
                () -> new PaymentNotFoundException("Reference Not Found : track: " + trackingCode)
        );
        return paymentMapper.requestToSource(payment);
    }

    @Override
    public Payment findByPaymentReference(@NotNull @NotBlank String reference) {
        var payment = paymentRepository.findByReference(reference).orElseThrow(
                () -> new PaymentNotFoundException("Reference Not Found : ref: " + reference)
        );
        return paymentMapper.requestToSource(payment);
    }

    @Override
    public String create(String reserveNumber) {
        var payment = new com.charisma.payment.payment.entities.Payment();
        payment.setReserveNumber(reserveNumber);
        var newPayment = paymentRepository.save(payment);
        return newPayment.getReference();
    }

    // TODO: 4/21/23 This part of code Must be Implement with business and we can check the final status: imagine passed
    private PaymentStatus checkPaymentStatus(String reference){
        try {
            // TODO Some business logic that must implement
            return PASSED;
        }catch (Exception e){
            simpleContradictionService.resolve(reference);
            return NOT_KNOWN;
        }
    }

    private void publishPaymentEvent(String trackingCode){
        var paymentEvent = new PaymentEvent(LocalDateTime.now(), trackingCode);
        event.publish(paymentEvent);
    }
}
