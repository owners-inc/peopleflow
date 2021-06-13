package com.workmotion.io.peopleflow.controller;

import com.workmotion.io.peopleflow.model.entity.Contract;
import com.workmotion.io.peopleflow.model.entity.Employee;
import com.workmotion.io.peopleflow.model.enums.States;
import com.workmotion.io.peopleflow.model.response.BasicResponse;
import com.workmotion.io.peopleflow.service.ContractService;
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
    private EmployeeService employeeService;

    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseEntity<BasicResponse> addEmployee(@RequestBody Employee employee){
        var employeeEntity =  employeeService.saveEmployee(employee);
        var basicResponse = new BasicResponse(employeeEntity,null,HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(basicResponse);
    }
    @PutMapping
    public ResponseEntity<BasicResponse> updateEmployee(@RequestBody Employee employee){
        var updatedEmployee =  employeeService.updateEmployee(employee);
        var basicResponse = new BasicResponse(updatedEmployee,null,HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(basicResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasicResponse> getById(@PathVariable("id") Long id){
        var employee =  employeeService.getEmployeeById(id);
        var basicResponse = new BasicResponse(employee,null,HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(basicResponse);
    }

    @GetMapping
    public ResponseEntity<BasicResponse> getEmployees(){
        var employees =  employeeService.getEmployees();
        var basicResponse = new BasicResponse(employees,employees.size(),HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(basicResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BasicResponse> deleteById(@PathVariable("id") Long id){
        var deleted =  employeeService.deleteEmployeeById(id);
        var basicResponse = new BasicResponse(deleted,null,HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(basicResponse);
    }

    /*
    Start Add Employee Contract
     */
    @PostMapping("/{id}/contract")
    public ResponseEntity<BasicResponse> addEmployeeContract(@PathVariable("id") Long employeeId ,@RequestBody Contract contract){
        var contractEntity =  contractService.addEmployeeContract(employeeId,contract);
        var basicResponse = new BasicResponse(contractEntity,null,HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(basicResponse);
    }
    /*
    End Add contract
     */

    /*
    Change Status
     */
    @PostMapping("/{id}/change-status/{status}")
    public ResponseEntity<BasicResponse> addEmployeeContract(@PathVariable("id") Long employeeId , @PathVariable("status") States status){
        var contractEntity =  employeeService.changeStatus(employeeId,status);
        var basicResponse = new BasicResponse(contractEntity,null,HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(basicResponse);
    }


    /*
    End Change Status
     */
}
