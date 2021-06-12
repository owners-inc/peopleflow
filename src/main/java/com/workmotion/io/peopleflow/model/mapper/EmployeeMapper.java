package com.workmotion.io.peopleflow.model.mapper;

import com.workmotion.io.peopleflow.model.entity.Employee;

public class EmployeeMapper {

    public Employee updateEntity(Employee inputEntity, Employee outputEntity){
        outputEntity.setName(inputEntity.getName());
        outputEntity.setAge(inputEntity.getAge());
        outputEntity.setNotes(inputEntity.getNotes());
        return outputEntity;
    }

}
