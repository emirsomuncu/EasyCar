package com.example.easyCar.dao.abstracts;

import com.example.easyCar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand,Integer> {
}
