package com.workmotion.io.peopleflow;

import com.workmotion.io.peopleflow.model.entity.Employee;
import com.workmotion.io.peopleflow.model.enums.States;
import com.workmotion.io.peopleflow.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void addNewEmployee(){
        // given
        Employee emp1 = new Employee();
        emp1.setName("employee 1");
        emp1.setAge(22);
        emp1.setNotes("employee notes 1");
        emp1.setHiringStatus(States.ADDED);

        // when
        var addedEntity = employeeRepository.save(emp1);
        // then
        assertThat (addedEntity).isNotNull();
        assertThat(addedEntity.getName()).isEqualTo(emp1.getName());
        assertThat(addedEntity.getHiringStatus()).isEqualTo(States.ADDED);
    }

    @Test
    public void changeStatus(){
        // given
        Employee emp2 = new Employee();
        emp2.setName(String.format("employee test %s",new Random().nextInt()));
        emp2.setAge(new Random().nextInt(50));
        emp2.setNotes("notes ..");
        emp2.setHiringStatus(States.ADDED);
        // when
        var entity = employeeRepository.save(emp2);
        // change status
        var toBeUpdated = employeeRepository.getById(entity.getId());
        toBeUpdated.setHiringStatus(States.IN_CHECK);
        toBeUpdated = employeeRepository.save(toBeUpdated);
        // then
        assertThat (toBeUpdated).isNotNull();
        assertThat(toBeUpdated.getHiringStatus()).isEqualTo(States.IN_CHECK);
    }
}
