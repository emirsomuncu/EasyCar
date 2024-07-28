package com.example.easyCar.services.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrUpdateCarRequest {

    private int id ;

    @NotNull(message = "Fill the blank")
    @Min(value = 1 , message = "Fill the blank")
    private Integer year ;

    @NotNull(message = "Fill the blank")
    @NotEmpty(message = "Fill the blank")
    private String fuelType ;

    @NotNull(message = "Fill the blank")
    @NotEmpty(message = "Fill the blank")
    private String colour ;

    @NotNull(message = "Fill the blank")
    @Min(value = 1 , message = "Fill the blank")
    private Integer km ;

    @NotNull(message = "Fill the blank")
    @Min(value = 1 , message = "Fill the blank")
    private Integer price;

    @NotNull(message = "Fill the blank")
    @NotEmpty(message = "Fill the blank")
    private String carTitle ;

    @NotNull(message = "Fill the blank")
    @NotEmpty(message = "Fill the blank")
    private String carExplanation;

    @NotNull(message = "Fill the blank")
    @Min(value = 1 , message = "Fill the blank")
    private int modelId;

}
