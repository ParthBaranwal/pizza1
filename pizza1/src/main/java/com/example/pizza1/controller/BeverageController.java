package com.example.pizza1.controller;

import com.example.pizza1.entity.Beverage;
import com.example.pizza1.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beverages")
public class BeverageController {

    @Autowired
    private BeverageService beverageService;


    @PostMapping
    public ResponseEntity<Beverage> createBeverage(@RequestBody Beverage beverages) {
        Beverage createdBeverage = beverageService.createBeverage(beverages);
        return ResponseEntity.ok(createdBeverage);
    }


    @GetMapping
    public List<Beverage> getAllBeverages() {
        return beverageService.getAllBeverages();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Beverage> getBeverageById(@PathVariable Long id) {
        Optional<Beverage> beverage = beverageService.getBeverageById(id);
        return beverage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Beverage> updateBeverage(@PathVariable Long id, @RequestBody Beverage beverages) {
        Optional<Beverage> updatedBeverage = beverageService.updateBeverage(id, beverages);
        return updatedBeverage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeverage(@PathVariable Long id) {
        boolean deleted = beverageService.deleteBeverage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
