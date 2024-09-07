package com.foodiehaven.adddish.service;

import com.foodiehaven.adddish.dto.DishDTO;
import com.foodiehaven.adddish.entity.Dish;
import com.foodiehaven.adddish.repository.DishRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling dish-related business logic.
 */
@Service
@Transactional
public class DishService {

    private final ModelMapper modelMapper;
    private final DishRepository dishRepository;

    @Autowired
    public DishService(ModelMapper modelMapper, DishRepository dishRepository) {
        this.modelMapper = modelMapper;
        this.dishRepository = dishRepository;
    }

/**
 * Adds a new dish.
 *
 * @param dishDTO The dish to add.
 * @return The added dish.
    */
public DishDTO addDish(DishDTO dishDTO) {
    try {
        Dish dish = modelMapper.map(dishDTO, Dish.class);
        dish = dishRepository.save(dish);
        return modelMapper.map(dish, DishDTO.class);
    } catch (Exception e) {
        throw new RuntimeException("Error adding dish", e);
    }
}

    /**
     * Retrieves a list of all dishes.
     *
     * @return A list of DishDTO objects.
     */
    public List<DishDTO> getAllDishes() {
        try {
            List<Dish> dishList = dishRepository.findAll();
            return modelMapper.map(dishList, new TypeToken<List<DishDTO>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving dishes", e);
        }
    }

    /**
     * Updates an existing dish.
     *
     * @param dishDTO The dish to update.
     * @return The updated dish.
     */
    public DishDTO updateDish(DishDTO dishDTO) {
        try {
            Dish dish = dishRepository.findById(dishDTO.getId()).orElseThrow();
            dish.setName(dishDTO.getName());
            dish.setPrice(dishDTO.getPrice());
            dish.setImage(dishDTO.getImage());
            dish.setDescription(dishDTO.getDescription());
            dishRepository.save(dish);
            return modelMapper.map(dish, DishDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Error updating dish", e);
        }
    }

    /**
     * Deletes a dish.
     *
     * @param dishDTO The dish to delete.
     * @return True if the dish was deleted successfully.
     */
    public boolean deleteDish(DishDTO dishDTO) {
        try {
            Dish dish = dishRepository.findById(dishDTO.getId()).orElseThrow();
            dishRepository.delete(dish);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting dish", e);
        }
    }
}