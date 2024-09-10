package com.example.pizza1.controller;

import com.example.pizza1.entity.Order;
import com.example.pizza1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestParam Long userId, @RequestParam Set<Long> orderItemIds) {
        Order order = orderService.placeOrder(userId, orderItemIds);
        return ResponseEntity.ok(order);
    }
}
