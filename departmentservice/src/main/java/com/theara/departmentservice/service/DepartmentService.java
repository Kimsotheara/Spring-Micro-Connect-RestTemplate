package com.theara.departmentservice.service;

import com.theara.departmentservice.entity.Department;
import com.theara.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll(){
        List<Department> depart = this.departmentRepository.findAll();
        if (depart.isEmpty())
            throw new RuntimeException("Department list is empty");
        return depart;
    }
    public Department findDepartmentById(Long id){
        Optional<Department> depart = this.departmentRepository.findById(id);
        if (depart.isEmpty())
            throw new RuntimeException("Department list is empty");
        return depart.get();
    }
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }
}
