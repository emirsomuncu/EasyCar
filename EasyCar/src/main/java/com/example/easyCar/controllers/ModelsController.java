package com.example.easyCar.controllers;

import com.example.easyCar.services.abstracts.BrandService;
import com.example.easyCar.services.abstracts.CarService;
import com.example.easyCar.services.abstracts.ModelService;
import com.example.easyCar.services.responses.GetAllModelsByBrandIdResponse;
import com.example.easyCar.services.responses.GetCarByModelIdAndPremium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/model")
public class ModelsController {

    private ModelService modelService ;
    private BrandService brandService ;
    private CarService carService ;

    @Autowired
    public ModelsController(ModelService modelService , BrandService brandService , CarService carService) {
        this.modelService = modelService ;
        this.brandService = brandService ;
        this.carService = carService ;
    }

    @RequestMapping("/getModels")
    public String getAllModelsByBrandId(@RequestParam int id , Model model) {


        List<GetAllModelsByBrandIdResponse> getAllModelsByBrandIdResponse = this.modelService.getAllModelByBrandId(id);
        model.addAttribute("getAllModelByBrandIdResponses" , getAllModelsByBrandIdResponse);

        int premiumId = 1 ;
        List<GetCarByModelIdAndPremium> getCarByModelIdAndPremiums = this.carService.getCarByModelIdAndPremium(id , premiumId) ;
        model.addAttribute("getCarByModelIdAndPremiums", getCarByModelIdAndPremiums);

        return "models";

    }




}
