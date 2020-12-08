package com.hunau.mapper;


import com.hunau.bean.User;
import com.hunau.bean.fileBean;
import com.hunau.bean.translateBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Wking
 * @create 2020-12-04 9:37
 */
@Repository

public interface userMapper {
    public int insertUser(User u);
    public void updateUser(User u);
    public void deleteUser(User u);
    public User selectUserByUserNameAndPwd( @Param("username") String username,@Param("password") String password);
    public int insertTranslateBean(translateBean fb);
    public int insertfileBean(fileBean fb);
    public List<translateBean> findAll();
    public void  deleteFile (String fileId);
}
