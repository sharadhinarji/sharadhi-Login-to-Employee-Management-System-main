package com.Registerlogin.Registerlogin.Service.Impl;

import com.Registerlogin.Registerlogin.Dto.EmployeeDTO;
import com.Registerlogin.Registerlogin.Entity.Employee;
import com.Registerlogin.Registerlogin.Report.EmployeeRepo;
import com.Registerlogin.Registerlogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        // Validate the employee DTO (you may want to add more validation)
        if (employeeDTO == null || employeeDTO.getEmail() == null || employeeDTO.getEmployeename() == null) {
            return "Invalid employee data!";
        }

        // Create a new Employee entity
        Employee employee = new Employee();
        employee.setEmployeeid(employeeDTO.getEmployeeid());
        employee.setEmployeename(employeeDTO.getEmployeename());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(employeeDTO.getPassword());
        // If you have a password field in DTO, encode it

        // Save the employee
        employeeRepo.save(employee);
        return "Employee added successfully!";
    }
}
