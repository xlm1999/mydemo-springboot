package com.meng;

import com.sun.jmx.snmp.internal.SnmpOutgoingRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test1() {
        System.out.println(restTemplate);
    }
}
