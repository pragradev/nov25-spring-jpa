package io.pragra.learning.novspringjpa.service;

import io.pragra.learning.novspringjpa.entity.BankDetail;
import io.pragra.learning.novspringjpa.entity.Employee;
import io.pragra.learning.novspringjpa.repo.AddressRepo;
import io.pragra.learning.novspringjpa.repo.BankDetailRepo;
import io.pragra.learning.novspringjpa.repo.EmployeeRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    BankDetailRepo bankDetailRepo;

    public List<Employee> addAll(List<Employee> employees){
        return employeeRepo.saveAll(employees);
    }
    public Employee addEmployee(Employee employee){
        System.out.println(employee.getAddress());
        // save transient instance
        addressRepo.save(employee.getAddress());
        bankDetailRepo.saveAll(employee.getBankDetails());
        System.out.println(employee.getAddress());
        return employeeRepo.save(employee);
    }
    public Optional<Employee> getById(Integer id){
        return employeeRepo.findById(id);
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee delete(Integer id){
        Optional<Employee> opEmployee = employeeRepo.findById(id);
        if (opEmployee.isPresent()){
            Employee employee = opEmployee.get();
            employeeRepo.delete(employee);
            return employee;
        }
        return null;
    }

    public Employee update(Employee updatedEmployee){
        Optional<Employee> optionalEmployee = employeeRepo.findById(updatedEmployee.getEmployeeId());
        if (optionalEmployee.isPresent()){
            employeeRepo.save(updatedEmployee);
            return updatedEmployee;
        }
        return null;
    }

    public Employee patchEmployee(Employee updatedEmployee){
        Optional<Employee> optionalEmployee = employeeRepo.findById(updatedEmployee.getEmployeeId());
        if (optionalEmployee.isPresent()){
            Employee employeeToPatch = optionalEmployee.get();
            employeeToPatch.setEmployeeId(updatedEmployee.getEmployeeId());
            if(Objects.nonNull(updatedEmployee.getFirstName())){
                employeeToPatch.setFirstName(updatedEmployee.getFirstName());
            }
            if(Objects.nonNull(updatedEmployee.getLastName())){
                employeeToPatch.setLastName(updatedEmployee.getLastName());
            }
            if(Objects.nonNull(updatedEmployee.getEmailId())){
                employeeToPatch.setEmailId(updatedEmployee.getEmailId());
            }
            employeeRepo.save(employeeToPatch);
            return employeeToPatch;
        }
        return null;

    }

    public List<Employee> getEmployeesByFirstName(String firstName){
        return employeeRepo.findAllByFirstName(firstName);
    }

    public List<Employee> getEmployeesByLastName(String LName){
        return employeeRepo.getAllbyLName(LName);
    }

}
