package com.foodiehaven.adddish.controller;

import com.foodiehaven.adddish.dto.DishDTO;
import com.foodiehaven.adddish.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling dish-related requests.
 */
@RestController
@RequestMapping("/api/v/dish")
@CrossOrigin
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    /**
     * Retrieves a list of all dishes.
     *
     * @return A list of DishDTO objects.
     */
    @GetMapping("/getDish")
    public ResponseEntity<List<DishDTO>> getDish() {
        try {
            List<DishDTO> dishes = dishService.getAllDishes();
            return ResponseEntity.ok(dishes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Adds a new dish.
     *
     * @param dishDTO The dish to add.
     * @return The added dish.
     */
    @PostMapping("/addDish")
    public ResponseEntity<DishDTO> addDish(@RequestBody DishDTO dishDTO) {
        try {
            DishDTO addedDish = dishService.addDish(dishDTO);
            return ResponseEntity.ok(addedDish);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Updates an existing dish.
     *
     * @param dishDTO The dish to update.
     * @return The updated dish.
     */
    @PutMapping("/updateDish")
    public ResponseEntity<DishDTO> updateDish(@RequestBody DishDTO dishDTO) {
        try {
            DishDTO updatedDish = dishService.updateDish(dishDTO);
            return ResponseEntity.ok(updatedDish);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Deletes a dish.
     *
     * @param dishDTO The dish to delete.
     * @return True if the dish was deleted successfully.
     */
    @DeleteMapping("/deleteDish")
    public ResponseEntity<Boolean> deleteDish(@RequestBody DishDTO dishDTO) {
        try {
            boolean deleted = dishService.deleteDish(dishDTO);
            return ResponseEntity.ok(deleted);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}