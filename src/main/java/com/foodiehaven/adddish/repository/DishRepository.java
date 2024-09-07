package com.foodiehaven.adddish.repository;

import com.foodiehaven.adddish.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository for accessing dishes.
 */
public interface DishRepository extends JpaRepository<Dish, Integer> {
}
