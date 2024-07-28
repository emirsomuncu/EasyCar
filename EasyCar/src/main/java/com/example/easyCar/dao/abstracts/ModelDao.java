package com.example.easyCar.dao.abstracts;

import com.example.easyCar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelDao extends JpaRepository<Model,Integer> {

    public List<Model> findModelByBrandId(int id);

}
