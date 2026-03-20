package com.restaurante.menu_service.repository;

import com.restaurante.menu_service.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}