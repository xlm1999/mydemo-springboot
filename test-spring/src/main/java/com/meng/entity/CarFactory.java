package com.meng.entity;

import com.meng.service.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CarFactory {

    @Autowired
    @Qualifier("benz")
    private ICar car;

    public String toString(){
        return car.getCarName();
    }
}
