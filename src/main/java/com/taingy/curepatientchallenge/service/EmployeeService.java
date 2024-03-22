package com.taingy.curepatientchallenge.service;

import com.taingy.curepatientchallenge.model.Employee;

import java.util.List;

interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    List<Employee> findAllByEmployeeIdOrNameStartsWith(String search);
    void delete(Employee employee);

}
