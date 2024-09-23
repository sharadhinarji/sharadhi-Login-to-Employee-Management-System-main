package com.Registerlogin.Registerlogin.EmployeeController;


import com.Registerlogin.Registerlogin.Dto.EmployeeDTO;
import com.Registerlogin.Registerlogin.Entity.Employee;
import com.Registerlogin.Registerlogin.Report.EmployeeRepo;
import com.Registerlogin.Registerlogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

@RequestMapping("api/v1/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepo empRepo;

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee emp) {
        return empRepo.save(emp);}



    @GetMapping("/")
    public List<Employee> getEmployee() {
        return empRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!empRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
            // Return 404 if employee not found
        }

        empRepo.deleteById(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content if deletion is successful
    }
}