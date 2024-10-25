package com.example.mdOne.dao;

import com.example.mdOne.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findEmployeeById(Long id);
    Optional<Employee> findEmployeeByEmail(String email);

    List<Employee> findEmployeesByIdOrderById(Long id);
}
