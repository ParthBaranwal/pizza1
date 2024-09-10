package com.example.pizza1.service;

import com.example.pizza1.entity.Beverage;
import com.example.pizza1.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageService {

    @Autowired
    private BeverageRepository beverageRepository;

    public Beverage createBeverage(Beverage beverage) {
        return beverageRepository.save(beverage);
    }


    public List<Beverage> getAllBeverages() {
        return beverageRepository.findAll();
    }


    public Optional<Beverage> getBeverageById(Long id) {
        return beverageRepository.findById(id);
    }


    public Optional<Beverage> updateBeverage(Long id, Beverage updatedBeverages) {
        return beverageRepository.findById(id).map(existingBeverages -> {
            existingBeverages.setB_name(updatedBeverages.getB_name());
            existingBeverages.setB_price(updatedBeverages.getB_price());
            existingBeverages.setB_desc(updatedBeverages.getB_desc());
            return beverageRepository.save(existingBeverages);
        });
    }


    public boolean deleteBeverage(Long id) {
        if (beverageRepository.existsById(id)) {
            beverageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
