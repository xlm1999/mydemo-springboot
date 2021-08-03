package com.meng.service.impl;

import com.meng.service.ICar;
import org.springframework.stereotype.Service;

@Service("bmw")
public class BMWCar implements ICar {
    
    public String getCarName(){
        return "BMW car";
    }
}
