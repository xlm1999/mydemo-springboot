package com.meng.service;

import com.meng.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void savePerson(Person p) {
        mongoTemplate.save(p);
    }

    @Override
    public void removePerson(Integer id) {
        mongoTemplate.remove(id);
    }

    @Override
    public void updatePerson(Person p) {
        Query query = new Query(Criteria.where("id").is(p.getId()));

        Update update = new Update();
        update.set("name", p.getName());
        update.set("age", p.getAge());

        mongoTemplate.updateFirst(query, update, Person.class);
    }

    @Override
    public Person findPersonById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        Person p = mongoTemplate.findOne(query, Person.class);
        return p;
    }
}
