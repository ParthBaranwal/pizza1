package com.example.pizza1.repository;



import com.example.pizza1.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface PizzaRepository extends JpaRepository<Pizza, Long>, JpaSpecificationExecutor<Pizza> {
}