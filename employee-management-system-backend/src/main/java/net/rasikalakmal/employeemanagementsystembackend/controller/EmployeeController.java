package net.rasikalakmal.employeemanagementsystembackend.controller;

import net.rasikalakmal.employeemanagementsystembackend.exception.ResourceNotFoundException;
import net.rasikalakmal.employeemanagementsystembackend.model.Employee;
import net.rasikalakmal.employeemanagementsystembackend.reposiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/employees")
//    public ResponseEntity<HttpResponse> getAllEmployees(@RequestParam Optional<String> firstname,
//                                                        @RequestParam Optional<String> page,
//                                                        @RequestParam Optional<String> size){
//        return ResponseEntity.ok().body(
//                HttpResponse.builder()
//                        .timeStamp(now().toString())
//        );
//    }

    //create employee
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        return employeeRepository.save(employee);
    }

    //get employee by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    //update employee
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeedetails){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstname(employeedetails.getFirstname());
        employee.setLastname(employeedetails.getLastname());
        employee.setEmailId(employeedetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    //delete employee
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
