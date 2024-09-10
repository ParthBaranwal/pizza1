package com.example.pizza1.controller;

import com.example.pizza1.entity.Pizza;
import com.example.pizza1.entity.Sides;
import com.example.pizza1.entity.Topping;
import com.example.pizza1.service.SidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sides")
public class SidesController {

    @Autowired
    private SidesService sidesService;

    @PostMapping
    public ResponseEntity<Sides> createSides(@RequestBody Sides sides) {
        Sides createdSides = sidesService.createSides(sides);
        return ResponseEntity.ok(createdSides);
    }

    @GetMapping
    public List<Sides> getAllSides() {
        System.out.println("qwrqwr");
        return sidesService.getAllSides();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Sides> getSidesById(@PathVariable Long id) {
        return sidesService.getSidesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Sides> updateSides(@PathVariable Long id, @RequestBody Sides sides) {
        return sidesService.updateSides(id, sides)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSides(@PathVariable Long id) {
        if (sidesService.deleteSides(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
