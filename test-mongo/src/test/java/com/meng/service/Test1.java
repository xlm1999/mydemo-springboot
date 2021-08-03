package com.meng.service;

import com.meng.MainApp;
import com.meng.utils.MongoDBUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
public class Test1 {
    @Autowired
    private PersonService personService;

    @Test
    public void testInsert() {
        //获取集合
        MongoCollection<Document> collection = MongoDBUtil.getConnect().getCollection("user");
        //要插入的数据
        Document document = new Document("name","张三")
                .append("sex", "男")
                .append("age", 18);
        //插入一个文档
        collection.insertOne(document);
    }

    //查找集合中的所有文档
    @Test
    public void findTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    //删除与筛选器匹配的单/多个文档
    @Test
    public void deleteOneTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //申明删除条件
        Bson filter = Filters.eq("age",18);
        //删除与筛选器匹配的单个文档
        collection.deleteMany(filter);
    }

    //插入多个文档
    @Test
    public void insertManyTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //要插入的数据
        List<Document> list = new ArrayList<Document>();
        for(int i = 1; i <= 3; i++) {
            Document document = new Document("name", "皓皓")
                    .append("sex", "男")
                    .append("age", 1);
            list.add(document);
        }
        //插入多个文档
        collection.insertMany(list);
    }



}
