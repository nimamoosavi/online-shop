package com.charisma.payment.payment;

import com.charisma.payment.contradiction.IContradiction;
import com.charisma.payment.payment.dao.PaymentRepository;
import com.charisma.payment.payment.entities.Payment;
import com.charisma.sales.cart.SimpleCartService;
import com.charisma.sales.cart.valueobjects.CartRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SimplePaymentService.class})
@ExtendWith(SpringExtension.class)
class SimplePaymentServiceTest {

    @MockBean
    private PaymentRepository paymentRepository;

    @MockBean
    private IContradiction simpleContradictionService;

    @MockBean
    private  PaymentMapper paymentMapper;

    @MockBean
    private IEvent<PaymentEvent> event;


    /**
     * Method under test: {@link SimplePaymentService#pay(String)} (reference)} }
     */
    @Test
    void testDoSuccessFullPayment() {
        //get
        long reference = 12L;
        //when we have an example new Payment
        var payment = when(this.paymentRepository.getReferenceById(reference)).thenReturn(new Payment());
        //then
        Assertions.assertNotNull(payment);
    }

    void testDoFailedPayment() {
        //get
        long reference = 13L;
        //when return null
        var payment = when(this.paymentRepository.getReferenceById(reference));
        //then
        Assertions.assertNull(payment);
    }
}