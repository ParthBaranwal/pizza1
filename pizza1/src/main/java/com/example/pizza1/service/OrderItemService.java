package com.example.pizza1.service;

import com.example.pizza1.entity.*;
import com.example.pizza1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private BeverageRepository beverageRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private SidesRepository sidesRepository;

    @Autowired
    private UserRepository userRepository;

    public Order_Item createOrderItem(Long userId, Long pizzaId, Set<Long> toppingIds, int quantity, Long sidesId, Long beverageId) {
        if (userId == null || pizzaId == null) {
            throw new IllegalArgumentException("User ID and Pizza ID must not be null");
        }

        Order_Item orderItem = new Order_Item();

        // Fetch and set the required entities
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));

        Sides sides = sidesId != null ? sidesRepository.findById(sidesId).orElse(null) : null;
        Beverage beverage = beverageId != null ? beverageRepository.findById(beverageId).orElse(null) : null;

        // Validate and fetch toppings
        Set<Long> validToppingIds = toppingIds != null ? toppingIds.stream().filter(id -> id != null).collect(Collectors.toSet()) : Set.of();
        List<Topping> toppingList = toppingRepository.findAllById(validToppingIds);
        Set<Topping> toppings = toppingList.stream().collect(Collectors.toSet());

        // Set the order item fields
        orderItem.setUser(user);
        orderItem.setPizza(pizza);
        orderItem.setQuantity(quantity);
        orderItem.setSides(sides);
        orderItem.setBeverage(beverage); // Ensure this is properly set, or handle null if acceptable
        orderItem.setToppings(toppings);

        // Calculate the price
        recalculateOrderItemPrice(orderItem);

        return orderItemRepository.save(orderItem);
    }


    public Order_Item updateSizeAndCrust(Long orderItemId, Pizza.Size size, Pizza.Crust crust) {
        if (orderItemId == null || size == null || crust == null) {
            throw new IllegalArgumentException("Order item ID, size, and crust must not be null");
        }

        Order_Item orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));

        // Update size and crust
        if (orderItem.getPizza() != null) {
            orderItem.getPizza().setSize(size);
            orderItem.getPizza().setCrust(crust);
        } else {
            throw new RuntimeException("Pizza for order item not found");
        }

        // Recalculate price after updating size and crust
        recalculateOrderItemPrice(orderItem);

        return orderItemRepository.save(orderItem);
    }

    private void recalculateOrderItemPrice(Order_Item orderItem) {
        BigDecimal totalPrice = BigDecimal.ZERO;

        if (orderItem.getPizza() != null) {
            totalPrice = totalPrice.add(orderItem.getPizza().getPizza_price());
        }
        if (orderItem.getBeverage() != null) {
            totalPrice = totalPrice.add(orderItem.getBeverage().getB_price());
        }
        if (orderItem.getSides() != null) {
            totalPrice = totalPrice.add(orderItem.getSides().getS_price());
        }
        if (orderItem.getToppings() != null) {
            for (Topping topping : orderItem.getToppings()) {
                totalPrice = totalPrice.add(topping.getTop_price());
            }
        }

        orderItem.setOi_price(totalPrice.multiply(BigDecimal.valueOf(orderItem.getQuantity())));
    }
}
