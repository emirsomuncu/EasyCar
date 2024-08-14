package com.example.easyCar.services.responses;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarByIdForUpdateFormResponse {

    private int id ;
    private Integer year ;
    private String fuelType ;
    private String colour ;
    private Integer km ;
    private Integer price;
    private String carTitle ;
    private String carExplanation;
    private int modelId;
}
