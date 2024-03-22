package com.taingy.curepatientchallenge.service;

import com.taingy.curepatientchallenge.model.Employee;
import com.taingy.curepatientchallenge.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAllByEmployeeIdOrNameStartsWith(String search) {
        try {
            int toId = Integer.parseInt(search);
            return repository.findAllByEmployeeIdOrNameStartsWith(toId, search);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return repository.findAllByEmployeeIdOrNameStartsWith(0, search);
    }

    @Override
    public void delete(Employee employee) {
        repository.delete(employee);
    }
}
