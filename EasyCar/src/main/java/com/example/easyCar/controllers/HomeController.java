package com.example.easyCar.controllers;

import com.example.easyCar.entities.Brand;
import com.example.easyCar.services.abstracts.BrandService;
import com.example.easyCar.services.abstracts.CarService;
import com.example.easyCar.services.abstracts.ModelService;
import com.example.easyCar.services.responses.GetCarByPremiumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private BrandService brandService;
    private ModelService modelService;
    private CarService carService ;

    @Autowired
    public HomeController(BrandService brandService, ModelService modelService, CarService carService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.carService = carService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Brand> brandList = this.brandService.getAllBrand();
        model.addAttribute("brandList" , brandList);

        int id = 1 ;
        List<GetCarByPremiumResponse> getCarByPremiumResponses = this.carService.getCarByPremium(id);
        model.addAttribute("getCarByPremiumResponses" , getCarByPremiumResponses);

        return "index" ;
    }






}
