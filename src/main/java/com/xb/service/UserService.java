package com.xb.service;

import com.xb.entity.User;

public interface UserService {
    User checkUser(String username, String password);
}
