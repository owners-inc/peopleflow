package com.workmotion.io.peopleflow.repository;

import com.workmotion.io.peopleflow.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
