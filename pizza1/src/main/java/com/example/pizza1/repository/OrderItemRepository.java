package com.example.pizza1.repository;


import com.example.pizza1.entity.Order;
import com.example.pizza1.entity.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<Order_Item, Long>, JpaSpecificationExecutor<Order_Item> {
}
