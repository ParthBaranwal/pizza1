package com.example.pizza1.controller;

import com.example.pizza1.dto.ItemDTO;
import com.example.pizza1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<ItemDTO> getAllItems() {
        ItemDTO itemDTO = itemService.getAllItems();
        return ResponseEntity.ok(itemDTO);
    }
}
