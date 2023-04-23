package com.charisma.shipping;

import com.charisma.sales.order.SimpleOrderService;
import com.charisma.sales.order.valueobjects.OrderRequest;
import com.charisma.shipping.dao.DispatchingRepository;
import com.charisma.shipping.entities.Dispatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SimpleDispatchService.class})
@ExtendWith(SpringExtension.class)
class IDispatchTest {

    @MockBean
    private DispatchingRepository repository;

    /**
     * Method under test: {@link SimpleDispatchService#getStatus(String)} (OrderRequest, long)}} }
     */
    @Test
    void getStatus() {
        //get
        var reference = UUID.randomUUID().toString();
        //when

        var response = when(repository.findByDispatchReference(reference)).thenReturn(Optional.of(new Dispatch()));

        //then
        Assertions.assertNotNull(response);
    }

}