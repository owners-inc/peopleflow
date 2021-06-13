package com.workmotion.io.peopleflow.model.entity;

import com.workmotion.io.peopleflow.model.enums.States;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends AbstractEntity {

    @Column(name = "AGE")
    private Integer age;

    @OneToOne
    @JoinColumn(name = "CONTRACT_ID")
    private Contract contract;

    @Enumerated(EnumType.STRING)
    @Column(name = "HIRING_STATUS",columnDefinition = "varchar(10) default 'ADDED'")
    private States hiringStatus;



}
