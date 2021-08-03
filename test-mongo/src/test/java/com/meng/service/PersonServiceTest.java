package com.meng.service;

import com.meng.MainApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void savePerson() {
    }

    @Test
    void removePerson() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void findPersonById() {
    }
}