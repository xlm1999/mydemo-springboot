package com.meng.service;

import org.springframework.stereotype.Service;

@Service
public class BrokerService {
    public void  method1() {
        System.out.println(this.getClass() + "-->start");
    }
}
