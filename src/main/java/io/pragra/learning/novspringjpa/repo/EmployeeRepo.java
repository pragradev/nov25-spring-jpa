package io.pragra.learning.novspringjpa.repo;

import io.pragra.learning.novspringjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByFirstName(String firstName);
    //@Query("select e from Employee e where e.lastName = ?1")
    @Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE LAST_NAME = :lastName")
    List<Employee> getAllbyLName(String lastName);




}
