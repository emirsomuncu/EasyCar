package com.example.easyCar.services.concretes;

import com.example.easyCar.core.utilities.mappers.ModelMapperService;
import com.example.easyCar.dao.abstracts.ModelDao;
import com.example.easyCar.entities.Model;
import com.example.easyCar.services.abstracts.ModelService;
import com.example.easyCar.services.requests.AddModelRequest;
import com.example.easyCar.services.requests.UpdateModelRequest;
import com.example.easyCar.services.responses.GetAllModelsByBrandIdResponse;
import com.example.easyCar.services.responses.GetAllModelResponse;
import com.example.easyCar.services.responses.GetModelByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private ModelDao modelDao ;
    private ModelMapperService modelMapperService;

    @Autowired
    public ModelServiceImpl(ModelDao modelDao , ModelMapperService modelMapperService){
        this.modelDao = modelDao;
        this.modelMapperService =modelMapperService;
    }

    @Override
    public List<GetAllModelResponse> getAllModel() {

        List<Model> models = this.modelDao.findAll();

        List<GetAllModelResponse> getAllModelResponses = models.stream().map(model -> this.modelMapperService
                .forResponse().map(model , GetAllModelResponse.class)).toList();

        return getAllModelResponses;
    }

    @Override
    public GetModelByIdResponse getModelById(int id) {

        Model model = this.modelDao.getReferenceById(id);
        GetModelByIdResponse getModelByIdResponse = this.modelMapperService
                .forResponse().map(model , GetModelByIdResponse.class);

        return getModelByIdResponse;
    }

    @Override
    public List<GetAllModelsByBrandIdResponse> getAllModelByBrandId(int id) {


        List<Model> models = this.modelDao.findModelByBrandId(id);
        List<GetAllModelsByBrandIdResponse> getAllModelByBrandIds = models.stream().map(gm -> this.modelMapperService
                .forResponse().map(gm , GetAllModelsByBrandIdResponse.class)).toList();

        return getAllModelByBrandIds;
    }

    @Override
    public void addModel(AddModelRequest addModelRequest) {

        Model model = this.modelMapperService.forRequest().map(addModelRequest , Model.class);

        this.modelDao.save(model);
    }

    @Override
    public void updateModel(UpdateModelRequest updateModelRequest) {

        Model model = this.modelMapperService.forRequest().map(updateModelRequest , Model.class);
        this.modelDao.save(model);
    }

    @Override
    public void deleteById(int id) {

        this.modelDao.deleteById(id);
    }
}
