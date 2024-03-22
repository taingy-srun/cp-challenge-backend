package com.taingy.curepatientchallenge.repository;

import com.taingy.curepatientchallenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByEmployeeIdOrNameStartsWith(int id, String name);

}
