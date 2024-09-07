package com.foodiehaven.adddish.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entity representing a dish.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Dish {
    @Id
    private int id;
    private String name;
    private double price;
    private String image;
    private String description;
}
