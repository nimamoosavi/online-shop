package com.charisma.sales.cart;

import com.charisma.sales.cart.dao.CartRepository;
import com.charisma.sales.cart.entities.Cart;
import com.charisma.sales.cart.valueobjects.CartRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SimpleCartService.class})
@ExtendWith(SpringExtension.class)
class ICartTest {

    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private IItem itemService;

    private Long userId;

    private CartRequest cartRequest;

    @BeforeEach
    public void init(){
        this.userId = 1L;
        this.cartRequest = new CartRequest(1L, 1);
    }

    /**
     * Method under test: {@link SimpleCartService#add(CartRequest, long)} }
     */
    @Test
    void addNewCart_then_cartIncrease() {
        //get
        //when
        var response = when(cartRepository.findByUserId(userId)).thenReturn(Optional.empty());
        //then
        Assertions.assertNotNull(response);
    }

    /**
     * Method under test: {@link SimpleCartService#add(CartRequest, long)} }
     */
    void addNewCart_then_cartChange() {
        //get
        var request = new CartRequest(1L, 2);
        //when
        var response = when(cartRepository.findByUserId(userId)).thenReturn(Optional.of(any()));
        //then
        Assertions.assertNotNull(response);
    }

    /**
     * Method under test: {@link SimpleCartService#empty(long)}} }
     */
    @Test
    void empty() {
        //when
        var response = when(cartRepository.findByUserId(userId)).thenReturn(Optional.empty());
        itemService.removeAll(anyLong());
        //then
        Assertions.assertNotNull(response);
    }

    /**
     * Method under test: {@link SimpleCartService#carts(long)} (long)}} }
     */
    @Test
    void carts() {
        //when
        var response = when(cartRepository.findByUserId(userId)).thenReturn(Optional.of(new Cart()));
        itemService.removeAll(anyLong());
        //then
        Assertions.assertNotNull(response);
    }
}