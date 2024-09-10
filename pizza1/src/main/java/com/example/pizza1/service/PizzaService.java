package com.example.pizza1.service;

import com.example.pizza1.dto.PizzaDTO;
import com.example.pizza1.entity.Pizza;
import com.example.pizza1.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private static final Logger logger = LoggerFactory.getLogger(PizzaService.class);

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaDTO createPizza(Pizza pizza) {
        try {
            Pizza createdPizza = pizzaRepository.save(pizza);
            return PizzaDTO.fromEntity(createdPizza);
        } catch (Exception e) {
            logger.error("Error creating pizza: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Optional<PizzaDTO> getPizzaById(Long id) {
        try {
            Optional<Pizza> pizzaOpt = pizzaRepository.findById(id);
            return pizzaOpt.map(PizzaDTO::fromEntity);
        } catch (Exception e) {
            logger.error("Error retrieving pizza with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public Optional<PizzaDTO> updatePizza(Long id, Pizza updatedPizza) {
        try {
            Optional<Pizza> existingPizzaOpt = pizzaRepository.findById(id);

            if (existingPizzaOpt.isPresent()) {
                Pizza existingPizza = existingPizzaOpt.get();

                existingPizza.setPizza_name(updatedPizza.getPizza_name());
                existingPizza.setDescription(updatedPizza.getDescription());
                existingPizza.setPizza_price(updatedPizza.getPizza_price());

                return Optional.of(PizzaDTO.fromEntity(pizzaRepository.save(existingPizza)));
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

    public List<PizzaDTO> getAllPizzas() {
        return pizzaRepository.findAll().stream()
                .map(PizzaDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
