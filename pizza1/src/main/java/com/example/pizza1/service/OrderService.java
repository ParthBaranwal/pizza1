package com.example.pizza1.service;

import com.example.pizza1.entity.Order;
import com.example.pizza1.entity.Order_Item;
import com.example.pizza1.entity.User;
import com.example.pizza1.repository.OrderItemRepository;
import com.example.pizza1.repository.OrderRepository;
import com.example.pizza1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    public Order placeOrder(Long userId, Set<Long> orderItemIds) {
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Order order = new Order();
            order.setUser(user);
            order.setOrder_date(LocalDateTime.now());
            order.setStatus(Order.Status.PENDING);

            Set<Order_Item> orderItems = new HashSet<>();
            orderItemIds.forEach(itemId -> orderItemRepository.findById(itemId).ifPresent(orderItems::add));
            order.setOrder_items(orderItems);

            // Calculate the total amount
            int totalAmount = orderItems.stream().mapToInt(item -> item.getOi_price().intValue()).sum();
            order.setTotal_amount(totalAmount);

            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Invalid User ID");
        }
    }
}
