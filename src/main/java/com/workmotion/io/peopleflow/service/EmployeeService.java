package com.workmotion.io.peopleflow.service;

import com.workmotion.io.peopleflow.model.entity.Employee;
import com.workmotion.io.peopleflow.model.mapper.EmployeeMapper;
import com.workmotion.io.peopleflow.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = new EmployeeMapper();

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public boolean deleteEmployeeById(Long id){
         employeeRepository.deleteById(id);
         return true;
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = getEmployeeById(employee.getId());
        // todo handle exception
        if(existingEmployee==null) throw new RuntimeException("employee not found");
        Employee toBeUpdatedEmployee =employeeMapper.updateEntity(employee,existingEmployee);
        return saveEmployee(toBeUpdatedEmployee);
    }


}
