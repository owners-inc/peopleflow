package com.workmotion.io.peopleflow.repository;

import com.workmotion.io.peopleflow.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {
}
