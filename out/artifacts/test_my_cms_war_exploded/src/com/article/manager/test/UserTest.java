package com.article.manager.test;

import com.article.manager.common.DBUtil;
import com.article.manager.dao.SystemUserDao;
import com.article.manager.dao.impl.SystemUserDaoImpl;
import com.article.manager.entity.SystemUser;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserTest {
    @Test
    public void getConn(){
        try {
            Connection connection = DBUtil.getConnection();
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void login(){
        SystemUserDao userDao=new SystemUserDaoImpl();
        SystemUser user = userDao.selectByNameAndPwd("admin", "123456");
        System.out.println("user = " + user);

    }
}
