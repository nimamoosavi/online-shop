package com.charisma.sales.order.web;

import com.charisma.sales.order.IOrder;
import com.charisma.sales.order.OrderMapper;
import com.charisma.sales.order.valueobjects.OrderRequest;
import com.charisma.user.model.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.charisma.sales.order.web.OrderUrlMapping.ADD_ORDER;
import static com.charisma.sales.order.web.OrderUrlMapping.GET_ORDER;

/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for handling the user or admin endpoints
 * @since 1.0.1
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final IOrder orderService;

    private final OrderMapper orderMapper;

    /**
     *
     * @param request is teh users order object
     * @param authUser the object of user authentication
     * @return the reference that the user can track their order
     */
    @PostMapping(ADD_ORDER)
    public ResponseEntity<Object> order(@RequestBody OrderRequest request, AuthUser authUser){
        var reference = orderService.order(request, authUser.getUserId());
        return ResponseEntity.ok(reference);
    }


    /**
     *
     * @param reference that the user can track their order
     * @param authUser the object of user authentication
     */
    @GetMapping(GET_ORDER)
    public ResponseEntity<OrderDTO> findOrder(@PathVariable Long reference, AuthUser authUser){
        var order = orderService.findByOrderAndUser(reference,authUser.getUserId());
        var orderDTO = orderMapper.mapToOrderDTO(order);
        return ResponseEntity.ok(orderDTO);
    }
}
