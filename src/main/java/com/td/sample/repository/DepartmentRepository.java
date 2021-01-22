package com.td.sample.repository;

import com.td.sample.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

    List<Department> findDepartmentByName(String deptName);
}
