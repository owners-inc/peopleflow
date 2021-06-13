package com.workmotion.io.peopleflow.service;

import com.workmotion.io.peopleflow.model.entity.Contract;
import com.workmotion.io.peopleflow.model.exceptions.BasicException;
import com.workmotion.io.peopleflow.model.exceptions.ConflictException;
import com.workmotion.io.peopleflow.model.exceptions.ObjectNotFoundException;
import com.workmotion.io.peopleflow.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContractRepository contractRepository;

     public Contract addEmployeeContract(Long employeeId, Contract contractInfo){
         try{
             // find employee
             var employee = employeeService.getEmployeeById(employeeId);
             if(employee.getContract()!=null) {
                 throw new ConflictException(String.format("employee with id:%s has already contract",employeeId));
             }
             // add contract
             var contract = contractRepository.save(contractInfo);
             // join contract with employee
             employee.setContract(contract);
             employeeService.saveEmployee(employee);
             return contract;
         }catch (ConflictException | ObjectNotFoundException C) {throw C;}
          catch (Exception ex){
             ex.printStackTrace();
             throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
         }
     }

}
