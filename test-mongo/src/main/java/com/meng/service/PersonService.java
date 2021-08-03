package com.meng.service;

import com.meng.Person;

public interface PersonService {
    void savePerson(Person p);

    void removePerson(Integer id);

    void updatePerson(Person p);

    Person findPersonById(Integer id);
}
