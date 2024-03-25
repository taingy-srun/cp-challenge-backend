package com.taingy.curepatientchallenge.controller;

import com.taingy.curepatientchallenge.controller.response.EmployeeResponse;
import com.taingy.curepatientchallenge.controller.response.EmployeeResponseMessage;
import com.taingy.curepatientchallenge.model.Employee;
import com.taingy.curepatientchallenge.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final EmployeeResponseMessage responseMessage;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService, EmployeeResponseMessage responseMessage) {
        this.employeeService = employeeService;
        this.responseMessage = responseMessage;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(value = "search", required = false) String search) {
        List<Employee> employees;
        if (search == null || search.isEmpty()) {
            employees = employeeService.findAll();
        } else {
            employees = employeeService.findAllByEmployeeIdOrNameStartsWith(search);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            return new ResponseEntity<>(new EmployeeResponse(responseMessage.notFound), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody Employee employee) {
        Employee isExist = employeeService.findById(employee.getEmployeeId());
        if(isExist != null) {
            return new ResponseEntity<>(new EmployeeResponse(responseMessage.addAlreadyExisted), HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(new EmployeeResponse(responseMessage.addSuccess), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") int employeeId, @RequestBody Employee employee) {
        Employee findEmployee = employeeService.findById(employeeId);
        if(findEmployee == null) {
            return new ResponseEntity<>(new EmployeeResponse(responseMessage.notFound), HttpStatus.NOT_FOUND);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(new EmployeeResponse(responseMessage.updated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@PathVariable("id") int employeeId) {
        try {
            Employee employee = employeeService.findById(employeeId);
            employeeService.delete(employee);
        } catch (Exception e) {
            return new ResponseEntity<>(new EmployeeResponse(responseMessage.notFound), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new EmployeeResponse(responseMessage.deleted), HttpStatus.OK);
    }
}
