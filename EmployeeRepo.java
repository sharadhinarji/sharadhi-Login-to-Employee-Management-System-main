package com.Registerlogin.Registerlogin.Report;

import com.Registerlogin.Registerlogin.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
