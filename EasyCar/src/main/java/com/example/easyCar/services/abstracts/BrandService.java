package com.example.easyCar.services.abstracts;

import com.example.easyCar.entities.Brand;

import java.util.List;

public interface BrandService {

    public List<Brand> getAllBrand();
    public Brand getBrandById(int id);
    public void addBrand(Brand brand);
    public void updateBrand(Brand brand);
    public void deleteById(int id);

}
