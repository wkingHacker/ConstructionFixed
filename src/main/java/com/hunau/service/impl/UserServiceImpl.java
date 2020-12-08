package com.hunau.service.impl;

import com.hunau.bean.User;
import com.hunau.mapper.userMapper;
import com.hunau.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
@Service
/**
 * @author Wking
 * @create 2020-12-04 9:33
 */
public class UserServiceImpl implements userService {
    @Override
    public int insertUser(User u) {
        int i = userMapper.insertUser(u);
        return i;
    }

    @Override
    public void updateUser(User u) {

    }

    @Override
    public void deleteUser(User u) {

    }

@Autowired
userMapper userMapper;
    @Override
    public User selectUser(String username,String password) throws IOException {

        User u = userMapper.selectUserByUserNameAndPwd(username,password);
        return u;
    }
}
