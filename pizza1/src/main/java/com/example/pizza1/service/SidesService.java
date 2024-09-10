package com.example.pizza1.service;

import com.example.pizza1.entity.Sides;
import com.example.pizza1.repository.SidesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SidesService {

    private static final Logger logger = LoggerFactory.getLogger(SidesService.class);

    @Autowired
    private SidesRepository sidesRepository;

    public Sides createSides(Sides sides) {
        try {
            return sidesRepository.save(sides);
        } catch (Exception e) {
            logger.error("Error creating sides: {}", e.getMessage(), e);
            throw e;
        }
    }

    public List<Sides> getAllSides() {
        try {
            return sidesRepository.findAll();
        } catch (Exception e) {
            logger.error("Error fetching all sides: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Optional<Sides> getSidesById(Long id) {
        try {
            return sidesRepository.findById(id);
        } catch (Exception e) {
            logger.error("Error fetching sides by ID {}: {}", id, e.getMessage(), e);
            return Optional.empty();
        }
    }

    public Optional<Sides> updateSides(Long id, Sides sides) {
        try {
            Optional<Sides> existingSidesOpt = sidesRepository.findById(id);
            if (existingSidesOpt.isPresent()) {
                Sides existingSides = existingSidesOpt.get();
                // Update fields as necessary
                existingSides.setS_name(sides.getS_name()); // Example update
                return Optional.of(sidesRepository.save(existingSides));
            } else {
                logger.warn("Sides with ID {} not found", id);
                return Optional.empty();
            }
        } catch (Exception e) {
            logger.error("Error updating sides with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public boolean deleteSides(Long id) {
        try {
            if (sidesRepository.existsById(id)) {
                sidesRepository.deleteById(id);
                return true;
            } else {
                logger.warn("Sides with ID {} not found for deletion", id);
                return false;
            }
        } catch (Exception e) {
            logger.error("Error deleting sides with ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}
