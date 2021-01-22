package com.td.sample.controller;

import com.td.sample.model.Department;
import com.td.sample.repository.DepartmentRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CurdController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/")
    @ApiOperation(value = "Redirect to Swagger", hidden = true)
    public RedirectView home() {
        return new RedirectView("swagger-ui/index.html");
    }

    @GetMapping("/getDept/{deptName}")
    @ApiOperation(value = "Get Departments By Name")
    public List<Department> findDeptByName(@PathVariable String deptName) {
        return departmentRepository.findDepartmentByName(deptName);
    }

    @GetMapping("/getAllDept")
    @ApiOperation(value = "Get All Departments")
    public List<Department> getAllDept() {
        return departmentRepository.findAll();
    }

    @PostMapping("/createDept")
    @ApiOperation(value = "Create New Departments")
    public Department createDept(@RequestBody Department department) {
        departmentRepository.save(department);
        return department;
    }

    @PutMapping("/updateDept/{deptId}")
    @ApiOperation(value = "Update Departments")
    public Department updateDept(@RequestBody Department department, @PathVariable String deptId) {
        department.setId(deptId);
        departmentRepository.save(department);
        return department;
    }

    @DeleteMapping("/deleteDept/{deptId}")
    @ApiOperation(value = "Delete Departments")
    public String deleteDept(@PathVariable String deptId) {
        departmentRepository.deleteById(deptId);
        return deptId;
    }

}
