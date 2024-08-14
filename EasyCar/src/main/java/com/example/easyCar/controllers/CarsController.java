package com.example.easyCar.controllers;

import com.example.easyCar.services.abstracts.CarService;
import com.example.easyCar.services.abstracts.ModelService;
import com.example.easyCar.services.requests.AddOrUpdateCarRequest;
import com.example.easyCar.services.responses.GetAllCarsByModelIdResponse;
import com.example.easyCar.services.responses.GetAllModelResponse;
import com.example.easyCar.services.responses.GetCarByIdForUpdateFormResponse;
import com.example.easyCar.services.responses.GetCarByIdResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarsController {

    private CarService carService ;
    private ModelService modelService ;

    @Autowired
    public CarsController(CarService carService , ModelService modelService) {
        this.carService = carService ;
        this.modelService = modelService ;
    }

    @GetMapping("/getCars")
    public String getAllCarsByModelId(@RequestParam int id , Model model) {

        List<GetAllCarsByModelIdResponse> getAllCarsByModelIdResponses = this.carService.getAllCarsByModelId(id);
        model.addAttribute("getAllCarsByModelIdResponses" , getAllCarsByModelIdResponses) ;

        return "cars" ;
    }

    @GetMapping("/getCarDetail")
    public String getCarById(@RequestParam int id , Model model){
        GetCarByIdResponse getCarByIdResponse = this.carService.getCarById(id);
        model.addAttribute("getCarByIdResponse", getCarByIdResponse);
        return "car-details" ;
    }


    @GetMapping("/showAddCarForm")
    public String addCarForm(Model model) {

        AddOrUpdateCarRequest addOrUpdateCarRequest = new AddOrUpdateCarRequest();

        model.addAttribute("addOrUpdateCarRequest" , addOrUpdateCarRequest);

        List<GetAllModelResponse> getAllModelResponses = modelService.getAllModel();
        model.addAttribute("getAllModelResponses" ,getAllModelResponses );

        return "add-car-form";

    }

    @RequestMapping("/saveAddCarForm")
    public String saveCarForm(@Valid @ModelAttribute("addCarRequest") AddOrUpdateCarRequest addOrUpdateCarRequest, BindingResult bindingResult) {


        if(bindingResult.hasErrors()) {
            return "add-car-form" ;
        }
        else {
            carService.addOrUpdateCar(addOrUpdateCarRequest);
        }

        return "redirect:/" ;
    }

    @RequestMapping("/deleteCar")
    public String deleteCar(@RequestParam int id) {

        carService.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/showUpdateCarForm")
    public String updateCarForm(@RequestParam int id , Model model) {

        GetCarByIdForUpdateFormResponse getCarByIdForUpdateFormResponse = this.carService.getCarByIdForUpdateForm(id);

        AddOrUpdateCarRequest addOrUpdateCarRequest = new AddOrUpdateCarRequest();

        addOrUpdateCarRequest.setId(getCarByIdForUpdateFormResponse.getId());
        addOrUpdateCarRequest.setFuelType(getCarByIdForUpdateFormResponse.getFuelType());
        addOrUpdateCarRequest.setColour(getCarByIdForUpdateFormResponse.getColour());
        addOrUpdateCarRequest.setKm(getCarByIdForUpdateFormResponse.getKm());
        addOrUpdateCarRequest.setPrice(getCarByIdForUpdateFormResponse.getPrice());
        addOrUpdateCarRequest.setCarTitle(getCarByIdForUpdateFormResponse.getCarTitle());
        addOrUpdateCarRequest.setCarExplanation(getCarByIdForUpdateFormResponse.getCarExplanation());
        addOrUpdateCarRequest.setYear(getCarByIdForUpdateFormResponse.getYear());
        addOrUpdateCarRequest.setModelId(getCarByIdForUpdateFormResponse.getModelId());


        //AddOrUpdateCarRequest addOrUpdateCarRequest = this.carService.getCarByIdForUpdateForm(id);
        model.addAttribute("addOrUpdateCarRequest" , addOrUpdateCarRequest );

        List<GetAllModelResponse> getAllModelResponses = modelService.getAllModel();
        model.addAttribute("getAllModelResponses" ,getAllModelResponses );

        return "add-car-form" ;

    }

}
