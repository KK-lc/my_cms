package com.article.manager.dao.impl;

import com.article.manager.common.DBUtil;
import com.article.manager.dao.ArticleTypeDao;
import com.article.manager.entity.ArticleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleTypeDaoImpl implements ArticleTypeDao {
    @Override
    public List<ArticleType> getAll(){
        List<ArticleType> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql=" select * from article_type";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ArticleType type=null;
            while (resultSet.next()){
                type=new ArticleType();
                type.setTypeId(resultSet.getString("type_id"));
                type.setTypeName(resultSet.getString("type_name"));
                type.setTypeState(resultSet.getInt("type_state"));
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return list;
    }
}

