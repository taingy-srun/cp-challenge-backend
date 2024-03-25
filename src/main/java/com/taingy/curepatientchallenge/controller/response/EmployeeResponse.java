package com.taingy.curepatientchallenge.controller.response;

public class EmployeeResponse {
    private String message;

    public EmployeeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
