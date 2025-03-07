package io.pragra.learning.novspringjpa.api;

import io.pragra.learning.novspringjpa.entity.Employee;
import io.pragra.learning.novspringjpa.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        return employeeRepo.save(employee);
    }
}
