package io.pragra.learning.novspringjpa.service;

import io.pragra.learning.novspringjpa.entity.BankDetail;
import io.pragra.learning.novspringjpa.entity.Employee;
import io.pragra.learning.novspringjpa.exceptions.EmployeeContextException;
import io.pragra.learning.novspringjpa.repo.AddressRepo;
import io.pragra.learning.novspringjpa.repo.BankDetailRepo;
import io.pragra.learning.novspringjpa.repo.EmployeeRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    BankDetailRepo bankDetailRepo;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public List<Employee> addAll(List<Employee> employees){
        return employeeRepo.saveAll(employees);
    }
    public Employee addEmployee(Employee employee){
        Employee employee1 = null;
        logger.info(Instant.now() + " Class: EmployeeService Method: addEmployee started execution with Parameter" + employee );
        try {
            employee1 = employeeRepo.save(employee);

        }catch (DataAccessException dae){
            logger.error(Instant.now() + " Class: EmployeeService Method: addEmployee Exception occured: " + dae.getMessage());
            throw new EmployeeContextException("3445"+dae.getMessage());
        }
        logger.info(Instant.now() + " Class: EmployeeService Method: addEmployee finished execution with return" + employee1 );
        return employee1;
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
