package com.workmotion.io.peopleflow.service;

import com.workmotion.io.peopleflow.model.entity.Employee;
import com.workmotion.io.peopleflow.model.enums.States;
import com.workmotion.io.peopleflow.model.exceptions.BasicException;
import com.workmotion.io.peopleflow.model.exceptions.ObjectNotFoundException;
import com.workmotion.io.peopleflow.model.mapper.EmployeeMapper;
import com.workmotion.io.peopleflow.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = new EmployeeMapper();

    public Employee saveEmployee(Employee employee){
        if(employee.getCreatedAt()==null) employee.setCreatedAt(new Date());
        if(employee.getId()!=null) employee.setLastModifiedAt(new Date());
        if(employee.getHiringStatus() == null) employee.setHiringStatus(States.ADDED);
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        var entity =  employeeRepository.findById(id);
        if(entity.isEmpty()) throw new ObjectNotFoundException(String.format("employee with id:%s not found.",id));
        return entity.get();
    }

    public boolean deleteEmployeeById(Long id){
         getEmployeeById(id); // validate if not found
         employeeRepository.deleteById(id);
         return true;
    }

    public Employee updateEmployee(Employee employee){
        try {
            var existingEmployee = getEmployeeById(employee.getId());
            var toBeUpdatedEmployee = employeeMapper.updateEntity(employee, existingEmployee);
            return saveEmployee(toBeUpdatedEmployee);
        }catch (ObjectNotFoundException O){throw O;}
         catch (Exception ex){
            throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
    }

    public Employee changeStatus(Long employeeId, States status){
        try{
            // find employee
            var employee = getEmployeeById(employeeId);
            // update status
            employee.setHiringStatus(status);
            employee = saveEmployee(employee);
            return employee;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        }

    }


}
