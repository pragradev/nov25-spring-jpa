package io.pragra.learning.novspringjpa.api;

import io.pragra.learning.novspringjpa.dto.ResponseDTO;
import io.pragra.learning.novspringjpa.entity.Employee;
import io.pragra.learning.novspringjpa.repo.EmployeeRepo;
import io.pragra.learning.novspringjpa.service.EmployeeService;
import io.pragra.learning.novspringjpa.util.AppConstants;
import io.pragra.learning.novspringjpa.util.SchemaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    public static final Map<String, String> statusCodeDescMapping = new HashMap<>();
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
    public ResponseEntity<ResponseDTO> getEmployeeById(@RequestParam Integer id){
        // 5 < id < 7
        // 8 digit
        // validate Input
        if(!validateId(id)){
            // return error woth proper details
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode("1112")
                    .statusDesc("id is not valid")
                    .build();
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

        } catch (Exception ex){
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode(ex.getMessage().substring(0,4)) //"1111bjhhcsf sd  ff  f f   v"
                    .statusDesc(ex.getMessage().substring(4))
                    .build();
            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("asdsa","asdsfdfsdf")
                    .body(responseDTO);
            return responseEntity;
        }

        if (tempEmp.isPresent()){
            Employee employee = tempEmp.get();
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .data(employee)
                    .statusCode("SS0")
                    .build();
            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header(SchemaConstants.HTTP_HEADER_ASDFFG,"asdsfdfsdf")
                    .body(responseDTO);

            return responseEntity;
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode(AppConstants.SUCCESS_RESPONSE)
                    .statusDesc("Employee not available for that id")
                    .build();
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
