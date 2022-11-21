package com.article.manager.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    /*public static String url = "jdbc:mysql://localhost:3306/web?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String user = "root";
    public static String pwd = "123456";
    //加载接口，只需要一次
    //Driver
    //静态代码块
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,pwd);
    }*/

    public static String url;
    public static String driver;
    public static String user;
    public static String pwd;

    static {
        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1.获取链接Connection
    //2.获取statment语句对象
    //3.使用sql执行
    //4.有返回内容，ResultSet
    //5.处理结果集
    //6.关闭资源
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pwd);
    }
    //通用方法
    public static boolean updateObject(String sql,Object...args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            //获取预编译语句
    //        String sql = "insert into goods(gname,gnum) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
    //        preparedStatement.setString(1,goods.getGname());
    //        preparedStatement.setInt(2,goods.getGnum());
            if (args.length!=0){
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            int lines = preparedStatement.executeUpdate();
            return lines>0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           /*if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
            closeAll(connection,preparedStatement,null);
        }
        return false;
    }
    public static void closeAll(Connection connection,Statement statement,ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet=null;
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement=null;
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }
    }
}
