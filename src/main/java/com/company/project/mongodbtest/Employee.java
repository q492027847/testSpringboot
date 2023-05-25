package com.company.project.mongodbtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("emp")
@Data
@AllArgsConstructor
public class Employee {

    @Id
    private Integer id;

    @Field("userName")
    private String name;

    @Field
    private int age;

    @Field
    private Double salary;

    @Field
    private Date birthDay;

}
