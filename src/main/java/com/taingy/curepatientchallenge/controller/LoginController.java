package com.taingy.curepatientchallenge.controller;

import com.taingy.curepatientchallenge.controller.response.EmployeeResponse;
import com.taingy.curepatientchallenge.controller.response.EmployeeResponseMessage;
import com.taingy.curepatientchallenge.model.Credential;
import com.taingy.curepatientchallenge.model.User;
import com.taingy.curepatientchallenge.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

    private final UserServiceImpl userService;
    private final EmployeeResponseMessage responseMessage;

    @Autowired
    public LoginController(UserServiceImpl userService, EmployeeResponseMessage responseMessage) {
        this.userService = userService;
        this.responseMessage = responseMessage;
    }

    @PostMapping("/login")
    public ResponseEntity<EmployeeResponse> login(@RequestBody Credential credential) {
        User user = userService.login(credential.getUsername(), credential.getPassword());
        EmployeeResponse response;
        if (user == null) {
            response = new EmployeeResponse(responseMessage.loginFailed);
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        response = new EmployeeResponse(responseMessage.loginSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
