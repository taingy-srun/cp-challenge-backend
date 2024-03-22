package com.taingy.curepatientchallenge.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:messages.properties")
public class EmployeeResponseMessage {

    @Value("${msg.employee.added}")
    public String addSuccess;
    @Value("${msg.employee.existed}")
    public String addAlreadyExisted;
    @Value("${msg.employee.notFound}")
    public String notFound;
    @Value("${msg.employee.updated}")
    public String updated;
    @Value("${msg.employee.deleted}")
    public String deleted;
}
