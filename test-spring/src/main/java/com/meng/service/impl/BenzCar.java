package com.meng.service.impl;

import com.meng.service.ICar;
import org.springframework.stereotype.Service;

@Service("benz")
public class BenzCar implements ICar {
    
    public String getCarName(){
        return "Benz car";
    }
}
