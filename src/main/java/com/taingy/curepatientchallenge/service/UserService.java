package com.taingy.curepatientchallenge.service;

import com.taingy.curepatientchallenge.model.User;

public interface UserService {

    User login(String username, String password);
}
