package com.example.easyCar.services.concretes;

import com.example.easyCar.dao.abstracts.BrandDao;
import com.example.easyCar.entities.Brand;
import com.example.easyCar.services.abstracts.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao ;

    @Autowired
    public BrandServiceImpl(BrandDao brandDao) {
        this.brandDao = brandDao ;
    }

    @Override
    public List<Brand> getAllBrand() {

        List<Brand> brandList = this.brandDao.findAll();

        return brandList;
    }

    @Override
    public Brand getBrandById(int id) {

        Brand brand = this.brandDao.getReferenceById(id);

        return brand;
    }

    @Override
    public void addBrand(Brand brand) {

        this.brandDao.save(brand);
    }

    @Override
    public void updateBrand(Brand brand) {

        this.brandDao.save(brand);
    }

    @Override
    public void deleteById(int id) {

        this.brandDao.deleteById(id);
    }
}
