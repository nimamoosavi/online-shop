package com.charisma.sales.cart.web;

import com.charisma.sales.cart.CartMapper;
import com.charisma.sales.cart.ICart;
import com.charisma.sales.cart.valueobjects.CartRequest;
import com.charisma.user.model.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.charisma.sales.cart.web.CartUrlMapping.*;
/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for handling the user or admin endpoints
 * @since 1.0.1
 */
@RestController
@RequiredArgsConstructor
public class CartController {

    private final ICart cartService;

    private final CartMapper cartMapper;

    /**
     * @apiNote this method used for a detection user basket
     * @param authUser is the User authentication object that we must implement in customer
     * @return the user cart basket
     */
    @GetMapping(CARTS)
    public ResponseEntity<CartDTO> getCards(AuthUser authUser){
        var carts = cartService.carts(authUser.getUserId());
        var cartDTO = cartMapper.mapToCartDTO(carts);
        return ResponseEntity.ok(cartDTO);
    }

    /**
     *
     * @param request is an object for adding to a user basket
     * @param authUser authUser is the User authentication object that we must implement in customer
     */
    @PostMapping(ADD_CART)
    public ResponseEntity<Object> addCart(@RequestBody @Valid CartRequest request, AuthUser authUser){
        cartService.add(request, authUser.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @apiNote this method used for deleting user carts
     * @param authUser authUser is the User authentication object that we must implement in customer
     */
    @DeleteMapping(REMOVE_CARTS)
    public ResponseEntity<Object> removeCarts(AuthUser authUser){
        cartService.empty(authUser.getUserId());
        return ResponseEntity.ok().build();
    }

}
