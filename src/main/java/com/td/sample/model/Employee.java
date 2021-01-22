package com.td.sample.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("Employee")
@Data
public class Employee implements Serializable {
    @Id
    private String empId;
    private String name;
    private int age;
    private double salary;
}
