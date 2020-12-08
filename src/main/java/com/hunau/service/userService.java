package com.hunau.service;

import com.hunau.bean.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Wking
 * @create 2020-12-04 9:09
 */

public interface userService {
    public int insertUser(User u);
    public void updateUser(User u);
    public void deleteUser(User u);
    public User selectUser(String username,String password) throws IOException;
}
