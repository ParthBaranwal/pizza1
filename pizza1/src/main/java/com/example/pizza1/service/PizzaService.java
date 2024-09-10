package com.example.pizza1.service;

import com.example.pizza1.entity.Pizza;
import com.example.pizza1.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private static final Logger logger = LoggerFactory.getLogger(PizzaService.class);

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza createPizza(Pizza pizza) {
        try {
            return pizzaRepository.save(pizza);
        } catch (Exception e) {
            logger.error("Error creating pizza: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Optional<Pizza> getPizzaById(Long id) {
        try {
            return pizzaRepository.findById(id);
        } catch (Exception e) {
            logger.error("Error retrieving pizza with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public Optional<Pizza> updatePizza(Long id, Pizza updatedPizza) {
        try {
            Optional<Pizza> existingPizzaOpt = pizzaRepository.findById(id);

            if (existingPizzaOpt.isPresent()) {
                Pizza existingPizza = existingPizzaOpt.get();

                existingPizza.setPizza_name(updatedPizza.getPizza_name());
                existingPizza.setDescription(updatedPizza.getDescription());
                existingPizza.setPizza_price(updatedPizza.getPizza_price());

                return Optional.of(pizzaRepository.save(existingPizza));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            logger.error("Error updating pizza with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public boolean deletePizza(Long id) {
        try {
            if (pizzaRepository.existsById(id)) {
                pizzaRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Error deleting pizza with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }
}
