package com.example.pizza1.service;

import com.example.pizza1.entity.Topping;
import com.example.pizza1.entity.User;
import com.example.pizza1.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public Topping createTopping(Topping topping) {
        return toppingRepository.save(topping);
    }
    public List<Topping> getAllToppings(){
        return toppingRepository.findAll();
    }

    public Optional<Topping> getToppingById(Long id) {
        return toppingRepository.findById(id);
    }

    public Optional<Topping> updateTopping(Long id, Topping updatedTopping) {
        Optional<Topping> existingToppingOpt = toppingRepository.findById(id);

        if (existingToppingOpt.isPresent()) {
            Topping existingTopping = existingToppingOpt.get();

            existingTopping.setTop_name(updatedTopping.getTop_name());
            existingTopping.setTop_price(updatedTopping.getTop_price());

            return Optional.of(toppingRepository.save(existingTopping));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteTopping(Long id) {
        if (toppingRepository.existsById(id)) {
            toppingRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
