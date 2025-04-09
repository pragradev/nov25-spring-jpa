package io.pragra.learning.novspringjpa.api;

import io.pragra.learning.novspringjpa.dto.ResponseDTO;
import io.pragra.learning.novspringjpa.entity.Employee;
import io.pragra.learning.novspringjpa.exceptions.BaseExcetion;
import io.pragra.learning.novspringjpa.repo.EmployeeRepo;
import io.pragra.learning.novspringjpa.service.EmployeeService;
import io.pragra.learning.novspringjpa.util.AppConstants;
import io.pragra.learning.novspringjpa.util.SchemaConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeAPI {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeAPI.class);
    public static final Map<String, String> statusCodeDescMapping = new HashMap<>();
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addAll")
    public List<Employee> addALL(@RequestBody List<Employee> employees){
        return employeeService.addAll(employees);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return employee1;
    }

    @GetMapping("/byId")
    public ResponseEntity<ResponseDTO> getEmployeeById(@RequestParam Integer id){
        // 5 < id < 7
        // 8 digit
        // validate Input
        if(!validateId(id)){
            // return error woth proper details
            ResponseDTO responseDTO = new ResponseDTO(null,"1112","id is not valid");

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("asdsa","asdsfdfsdf")
                    .body(responseDTO);
            return responseEntity;
        }
        Optional<Employee> tempEmp = null;
        try{
            tempEmp = employeeService.getById(id);
            // AAA(1011) App: (id) -> receiving custId, SS0 // XYZ(down)(2023)
            System.out.println("sadsdfd");
            // BBB(1012) App : (custId) -> account numbers
            System.out.println("sadsdfd");
            // ccc(1013) app: acc # :-> AccountAccessId
            System.out.println("sadsdfd");
            // DDD(1014) App AccountAccessId :-|> (process payment and gives object back)

        } catch (BaseExcetion ex){
            ResponseDTO responseDTO = new ResponseDTO(
                    null,
                    ex.getMessage().substring(0,4),
                    ex.getMessage().substring(4));

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("asdsa","asdsfdfsdf")
                    .body(responseDTO);
            return responseEntity;
        }

        if (tempEmp.isPresent()){
            Employee employee = tempEmp.get();
            ResponseDTO responseDTO = new ResponseDTO(
                    employee,
                    "SS0",
                    null);
//            ResponseDTO responseDTO = ResponseDTO.builder()
//                    .data(employee)
//                    .statusCode("SS0")
//                    .build();
            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header(SchemaConstants.HTTP_HEADER_ASDFFG,"asdsfdfsdf")
                    .body(responseDTO);

            return responseEntity;
        } else {
            ResponseDTO responseDTO = new ResponseDTO(
                    null,
                    AppConstants.SUCCESS_RESPONSE,
                    "Employee not available for that id");
            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("asdsa","asdsfdfsdf")
                    .body(responseDTO);
            return responseEntity;
        }
        //return tempEmp; // (1000)
    }

    private boolean validateId(Integer id){
        return id < 10000000 && id > 9999;
    }
    @GetMapping("/hello")
    public String testAPI(){
        return "Hello World!";
    }

    @GetMapping("/nameById")
    public String getEmployeeFirstNameById(@RequestParam Integer id){
        return employeeService.getById(id).get().getFirstName();
        //sdfsdfgdfvncdsjcn
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

    // Exception Handling Class level
    @ExceptionHandler
    public ResponseEntity<ResponseDTO> exceptionHandler(Exception ex){
        // logger.error(dadsjncsdjchbnsjxsnckjndcds)
        ResponseDTO responseDTO = new ResponseDTO(
                null,
                AppConstants.EMPLOYEE_CONTROLLER_FAILED,
                AppConstants.EMPLOYEE_CONTROLLER_FAILED_DESC+ " " + ex.getMessage());
        ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                .ok()
                .header("asdsa","asdsfdfsdf")
                .body(responseDTO);
        return responseEntity;
    }

}
