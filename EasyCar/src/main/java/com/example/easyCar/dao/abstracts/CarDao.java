package com.example.easyCar.dao.abstracts;

import com.example.easyCar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDao extends JpaRepository<Car,Integer> {

    public List<Car> findCarByModelId(int id);
    public List<Car> findCarByPremium(int id);
    public List<Car> findCarByModelIdAndPremium(int id , int premiumId) ;

}
