package com.example.pizza1.controller;

import com.example.pizza1.entity.Pizza;
import com.example.pizza1.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPizza(@RequestBody Pizza pizza) {
        // Create the pizza (size and crust will be handled as predefined)
        Pizza createdPizza = pizzaService.createPizza(pizza);

        // Prepare the response with predefined values
        Map<String, Object> response = new HashMap<>();
        response.put("pizza", createdPizza);
        response.put("sizes", Arrays.asList(Pizza.Size.values()));
        response.put("crusts", Arrays.asList(Pizza.Crust.values()));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllPizzas() {
        List<Pizza> pizzas = pizzaService.getAllPizzas();

        // Create a response map with pizzas and predefined values
        Map<String, Object> response = new HashMap<>();
        response.put("pizzas", pizzas);
        response.put("sizes", Arrays.asList(Pizza.Size.values()));
        response.put("crusts", Arrays.asList(Pizza.Crust.values()));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        if (pizzaService.deletePizza(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
