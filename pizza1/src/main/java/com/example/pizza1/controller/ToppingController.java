package com.example.pizza1.controller;

import com.example.pizza1.entity.Pizza;
import com.example.pizza1.entity.Topping;
import com.example.pizza1.entity.User;
import com.example.pizza1.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/toppings")
public class ToppingController {

    @Autowired
    private ToppingService toppingService;


    @PostMapping
    public ResponseEntity<Topping> createTopping(@RequestBody Topping topping) {
        Topping createdTopping = toppingService.createTopping(topping);
        return ResponseEntity.ok(createdTopping);
    }
    @GetMapping
    public List<Topping> getAllUToppings() {
        return toppingService.getAllToppings();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Topping> getToppingById(@PathVariable Long id) {
        return toppingService.getToppingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Topping> updateTopping(@PathVariable Long id, @RequestBody Topping topping) {
        return toppingService.updateTopping(id, topping)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopping(@PathVariable Long id) {
        if (toppingService.deleteTopping(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
