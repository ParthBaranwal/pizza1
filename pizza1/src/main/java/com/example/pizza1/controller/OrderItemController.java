package com.example.pizza1.controller;

import com.example.pizza1.entity.Order_Item;
import com.example.pizza1.entity.Pizza;
import com.example.pizza1.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<?> createOrderItem(
            @RequestParam Long userId,
            @RequestParam Long pizzaId,
            @RequestParam(required = false) Long sidesId,
            @RequestParam(required = false) Long beverageId,
            @RequestParam(required = false) Set<Long> toppingIds,
            @RequestParam int quantity) {

        try {
            Order_Item orderItem = orderItemService.createOrderItem(userId, pizzaId, toppingIds, quantity, sidesId, beverageId);
            return ResponseEntity.ok(orderItem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating order item: " + e.getMessage());
        }
    }

    @PostMapping("/{orderItemId}/set-size-crust")
    public ResponseEntity<?> setSizeAndCrust(
            @PathVariable Long orderItemId,
            @RequestParam Pizza.Size size,
            @RequestParam Pizza.Crust crust) {

        try {
            Order_Item updatedOrderItem = orderItemService.updateSizeAndCrust(orderItemId, size, crust);
            return ResponseEntity.ok(updatedOrderItem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating size and crust: " + e.getMessage());
        }
    }
}
