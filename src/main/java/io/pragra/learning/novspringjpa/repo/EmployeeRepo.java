package io.pragra.learning.novspringjpa.repo;

import io.pragra.learning.novspringjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
