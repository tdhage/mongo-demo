package com.td.sample.controller;

import com.td.sample.model.Department;
import com.td.sample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurdController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/getAllDept")
    public List<Department> getAllDept() {
        return departmentRepository.findAll();
    }

    @PostMapping("/createDept")
    public Department createDept(@RequestBody Department department) {
        departmentRepository.save(department);
        return department;
    }

    @PutMapping("/updateDept/{deptId}")
    public Department updateDept(@RequestBody Department department, @PathVariable String deptId) {
        department.setId(deptId);
        departmentRepository.save(department);
        return department;
    }

    @DeleteMapping("/deleteDept/{deptId}")
    public String deleteDept(@PathVariable String deptId) {
        departmentRepository.deleteById(deptId);
        return deptId;
    }

}
