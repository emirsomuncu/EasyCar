package com.example.easyCar.services.abstracts;

import com.example.easyCar.services.requests.AddOrUpdateCarRequest;
import com.example.easyCar.services.responses.*;

import java.util.List;

public interface CarService {

    public List<GetAllCarResponse> getAllCar();
    public GetCarByIdResponse getCarById(int id);
    public List<GetAllCarsByModelIdResponse> getAllCarsByModelId(int id);
    public List<GetCarByPremiumResponse> getCarByPremium(int id);
    public List<GetCarByModelIdAndPremium> getCarByModelIdAndPremium(int id , int premiumId);
    public GetCarByIdForUpdateFormResponse getCarByIdForUpdateForm(int id);
    public void addOrUpdateCar(AddOrUpdateCarRequest addOrUpdateCarRequest);
    public void deleteById(int id);

}
