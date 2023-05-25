package com.company.project.mongodbtest;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Log
public class MongoDbTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/mongo1")
    public long test()  {
        long start = System.currentTimeMillis();
//        mongoTemplate.createCollection("wuguoqing");
        boolean emp = mongoTemplate.collectionExists("emp");
        if (emp){
            mongoTemplate.dropCollection("emp");
        }
//        mongoTemplate.createCollection("emp");
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            employees.add(new Employee(i,"wuguoqing"+i,20+i,Math.random(),new Date()));
        }
        mongoTemplate.insertAll(employees);
        return System.currentTimeMillis()-start;
    }

    @GetMapping("/mongo2/{name}")
    public String test1(@PathVariable String name)  {
        long start = System.currentTimeMillis();


        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("id").lte(20),Criteria.where("userName").regex("wuguoqing1"));
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.asc("salary"))).skip(2).limit(3);
        List<Employee> employees = mongoTemplate.find(query, Employee.class);
        return employees.toString();
    }


}
