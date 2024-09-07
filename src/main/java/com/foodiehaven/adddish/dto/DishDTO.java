package com.foodiehaven.adddish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for a dish.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DishDTO {
    private int id;
    private String name;
    private double price;
    private String image;
    private String description;
}
