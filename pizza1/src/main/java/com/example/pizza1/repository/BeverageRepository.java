package com.example.pizza1.repository;

import com.example.pizza1.entity.Beverage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface BeverageRepository extends JpaRepository<Beverage, Long>, JpaSpecificationExecutor<Beverage> {
}