package com.example.easyCar.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "Fill the blank")
    private int id ;

    @NotNull(message = "Fill the blank")
    @Column(name = "car_title")
    private String carTitle;

    @NotNull(message = "Fill the blank")
    @Column(name = "car_explanation")
    private String carExplanation;

    @Min(value = 1 , message = "Fill the blank")
    @Column(name = "year")
    private int year ;

    @NotNull(message = "Fill the blank")
    @Column(name="fuel_type")
    private String fuelType ;

    @NotNull(message = "Fill the blank")
    @Column(name = "colour")
    private String colour ;

    @Min(value = 1 , message = "Fill the blank")
    @Column(name = "km")
    private int km ;

    @Min(value = 1 , message = "Fill the blank")
    @Column(name = "price")
    private int price ;

    @Column(name = "premium")
    private int premium ;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model ;

}
