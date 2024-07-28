package com.example.easyCar.services.concretes;

import com.example.easyCar.core.utilities.mappers.ModelMapperService;
import com.example.easyCar.dao.abstracts.CarDao;
import com.example.easyCar.entities.Car;
import com.example.easyCar.services.abstracts.CarService;
import com.example.easyCar.services.requests.AddOrUpdateCarRequest;
import com.example.easyCar.services.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao ;
    private ModelMapperService modelMapperService ;

    @Autowired
    public CarServiceImpl (CarDao carDao , ModelMapperService modelMapperService) {
        this.carDao = carDao ;
        this.modelMapperService = modelMapperService ;
    }

    @Override
    public List<GetAllCarResponse> getAllCar() {

        List<Car> cars = this.carDao.findAll();
        List<GetAllCarResponse> getAllCarResponses = cars.stream().map(gacr -> this.modelMapperService
                .forResponse().map(gacr , GetAllCarResponse.class)).toList();

        return getAllCarResponses;
    }
    @Override
    public GetCarByIdResponse getCarById(int id) {

        Optional<Car> car = this.carDao.findById(id);
        GetCarByIdResponse getCarByIdResponse = this.modelMapperService
                .forResponse().map(car , GetCarByIdResponse.class);

        return getCarByIdResponse;
    }

    @Override
    public List<GetAllCarsByModelIdResponse> getAllCarsByModelId(int id) {

        List<Car> cars = this.carDao.findCarByModelId(id);
        List<GetAllCarsByModelIdResponse> getAllCarsByModelIdResponses = cars.stream().map(gacbmı->this.modelMapperService
                .forResponse().map(gacbmı , GetAllCarsByModelIdResponse.class)).toList();

        return getAllCarsByModelIdResponses;
    }

    @Override
    public List<GetCarByPremiumResponse> getCarByPremium(int id) {

        List<Car> cars = this.carDao.findCarByPremium(id);
        List<GetCarByPremiumResponse> getCarByPremiumResponses = cars.stream().map(cc -> this.modelMapperService
                .forResponse().map(cc , GetCarByPremiumResponse.class)).toList();

        return getCarByPremiumResponses;
    }

    @Override
    public List<GetCarByModelIdAndPremium> getCarByModelIdAndPremium(int id, int premiumId) {

        List<Car> cars = this.carDao.findCarByModelIdAndPremium(id , premiumId) ;
        List<GetCarByModelIdAndPremium> getCarByModelIdAndPremiums = cars.stream().map(gcbmıap -> this.modelMapperService
                .forResponse().map(gcbmıap , GetCarByModelIdAndPremium.class)).toList();

        return getCarByModelIdAndPremiums;
    }

    //Syntax and logic could be seem bad , but ı have to design this method for update form structure
    @Override
    public AddOrUpdateCarRequest getCarByIdForUpdateForm(int id) {

        Optional<Car> car = this.carDao.findById(id);
        AddOrUpdateCarRequest addOrUpdateCarRequest = this.modelMapperService.forResponse().map(car,AddOrUpdateCarRequest.class);

        return addOrUpdateCarRequest;
    }

    @Override
    public void addOrUpdateCar(AddOrUpdateCarRequest addOrUpdateCarRequest) {

        Car car = this.modelMapperService.forRequest().map(addOrUpdateCarRequest, Car.class);
        this.carDao.save(car);

    }

    @Override
    public void deleteById(int id) {
        this.carDao.deleteById(id);
    }
}
