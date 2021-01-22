package com.td.sample.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document("Department")
@Data
public class Department implements Serializable {

    @Id
    private String id;

    @Indexed(name = "deptName")
    private String name;
    private String description;

    private List<Employee> employees;

}