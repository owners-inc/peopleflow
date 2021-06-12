package com.workmotion.io.peopleflow.controller;

import com.workmotion.io.peopleflow.model.entity.Employee;
import com.workmotion.io.peopleflow.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        var employeeEntity =  service.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeEntity);
    }
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        var updatedEmployee =  service.updateEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
        var updatedEmployee =  service.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        var updatedEmployee =  service.getEmployees();
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        var deleted =  service.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(deleted);
    }
}
