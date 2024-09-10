package com.example.pizza1.repository;

import com.example.pizza1.entity.Sides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface SidesRepository extends JpaRepository<Sides, Long>, JpaSpecificationExecutor<Sides> {
}