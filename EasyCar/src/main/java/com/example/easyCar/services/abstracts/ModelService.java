package com.example.easyCar.services.abstracts;

import com.example.easyCar.services.requests.AddModelRequest;
import com.example.easyCar.services.requests.UpdateModelRequest;
import com.example.easyCar.services.responses.GetAllModelsByBrandIdResponse;
import com.example.easyCar.services.responses.GetAllModelResponse;
import com.example.easyCar.services.responses.GetModelByIdResponse;

import java.util.List;

public interface ModelService {

    public List<GetAllModelResponse> getAllModel();
    public GetModelByIdResponse getModelById(int id);
    public List<GetAllModelsByBrandIdResponse> getAllModelByBrandId(int id) ;
    public void addModel(AddModelRequest addModelRequest);
    public void updateModel(UpdateModelRequest updateModelRequest);
    public void deleteById(int id);

}
