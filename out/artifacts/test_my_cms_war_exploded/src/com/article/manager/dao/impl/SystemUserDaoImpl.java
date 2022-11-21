package com.article.manager.dao.impl;

import com.article.manager.common.DBUtil;
import com.article.manager.dao.SystemUserDao;
import com.article.manager.entity.SystemUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemUserDaoImpl implements SystemUserDao {
    @Override
    public SystemUser selectByNameAndPwd(String name, String pwd){
        SystemUser user =null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql ="select user_id,user_name from system_user where user_name = ? and user_pwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pwd);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String userId = resultSet.getString("user_id");
                String userName = resultSet.getString("user_name");
                user = new SystemUser();
                user.setUserId(userId);
                user.setUserName(userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return user;
    }
}
