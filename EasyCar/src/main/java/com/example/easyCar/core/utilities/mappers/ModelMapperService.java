package com.example.easyCar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    public ModelMapper forResponse();
    public ModelMapper forRequest();

}
