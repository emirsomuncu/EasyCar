package com.example.easyCar.services.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {

    public int id;
    public String name ;
    public int brandId;
}
