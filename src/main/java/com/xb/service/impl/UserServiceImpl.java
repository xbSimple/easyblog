package com.xb.service.impl;


import com.xb.entity.User;
import com.xb.mapper.UserMapper;
import com.xb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 验证用户名及密码
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户信息
     */
    @Override
    public User checkUser(String username, String password) {

        return userMapper.checkUser(username,DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}
