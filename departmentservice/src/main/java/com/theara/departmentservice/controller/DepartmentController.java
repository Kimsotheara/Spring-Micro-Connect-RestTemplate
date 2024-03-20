package com.theara.departmentservice.controller;

import com.theara.departmentservice.entity.Department;
import com.theara.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> findAll(){
        return ResponseEntity.ok(this.departmentService.findAll()).getBody();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Long id){
        Department department = this.departmentService.findDepartmentById(id);
        return ResponseEntity.ok(department);
    }
    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        Department departBody = this.departmentService.saveDepartment(department);
        return ResponseEntity.ok(departBody);
    }

}
