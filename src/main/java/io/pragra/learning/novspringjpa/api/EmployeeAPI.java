package io.pragra.learning.novspringjpa.api;

import io.pragra.learning.novspringjpa.entity.Employee;
import io.pragra.learning.novspringjpa.repo.EmployeeRepo;
import io.pragra.learning.novspringjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addAll")
    public List<Employee> addALL(@RequestBody List<Employee> employees){
        return employeeService.addAll(employees);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @GetMapping("/byId")
    public Optional<Employee> getEmployeeById(@RequestParam Integer id){
        return employeeService.getById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @DeleteMapping("/delete")
    public Employee deleteEmployee(@RequestParam Integer id){
        return employeeService.delete(id);
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @PatchMapping("/patch")
    public Employee patch(@RequestBody Employee employee){
        return employeeService.patchEmployee(employee);
    }

    @GetMapping("/fName")
    public List<Employee> getAllbyfName(@RequestParam String fName){
        return employeeService.getEmployeesByFirstName(fName);
    }

    @GetMapping("/lName")
    public List<Employee> getAllbylName(@RequestParam String lName){
        return employeeService.getEmployeesByLastName(lName);
    }

}
