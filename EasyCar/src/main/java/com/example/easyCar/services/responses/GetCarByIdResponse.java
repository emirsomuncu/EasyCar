package com.example.easyCar.services.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarByIdResponse {

    private int id ;
    private int year ;
    private String fuelType ;
    private String colour ;
    private int km ;
    private int price;
    private String carTitle ;
    private String carExplanation;
    private String brandName;
    private String modelName ;

}
