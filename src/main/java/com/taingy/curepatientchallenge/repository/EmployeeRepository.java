package com.taingy.curepatientchallenge.repository;

import com.taingy.curepatientchallenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByEmployeeIdOrNameStartsWith(Integer id, String name);

    List<Employee> findAllBySupervisors(String supervisor);

    @Query(nativeQuery = true, value = "SELECT * FROM employees ORDER BY salary DESC LIMIT 10")
    List<Employee> findAllTopSalary();

}
