package com.article.manager.dao.impl;

import com.article.manager.common.DBUtil;
import com.article.manager.common.StringUtil;
import com.article.manager.dao.ArticleDao;
import com.article.manager.entity.Article;
import com.article.manager.entity.ArticleType;
import com.article.manager.entity.SystemUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ArticleDaoImpl implements ArticleDao {

    @Override
    public List<Article> selectAll()  {
        List<Article> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql="SELECT a.article_id,a.article_title,a.article_summary,a.article_author,a.article_state," +
                    "b.type_name,s.user_name " +
                    "from article a " +
                    "LEFT JOIN article_type b on a.type_id = b.type_id " +
                    "LEFT JOIN system_user s on s.user_id=a.user_id";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Article article =null;
            while (resultSet.next()){
                article=new Article();
                article.setArticleId(resultSet.getString("article_id"));
                article.setArticleTitle(resultSet.getString("article_title"));
                article.setArticleSummary(resultSet.getString("article_summary"));
                article.setArticleAuthor(resultSet.getString("article_author"));
                article.setArticleState(resultSet.getInt("article_state"));

                SystemUser systemUser = new SystemUser();
                systemUser.setUserName(resultSet.getString("user_name"));
                article.setSystemUser(systemUser);

                ArticleType articleType = new ArticleType();
                articleType.setTypeName(resultSet.getString("type_name"));
                article.setArticleType(articleType);

                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Article getOneById(String aId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Article article =null;
        try {
            connection = DBUtil.getConnection();
            String sql="SELECT a.article_id,a.article_title,a.article_summary,a.article_author,a.article_state," +
                    "b.type_name,b.type_id " +
                    "from article a " +
                    "LEFT JOIN article_type b on a.type_id = b.type_id " +
                    "WHERE article_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,aId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                article=new Article();
                article.setArticleId(resultSet.getString("article_id"));
                article.setArticleTitle(resultSet.getString("article_title"));
                article.setArticleSummary(resultSet.getString("article_summary"));
                article.setArticleAuthor(resultSet.getString("article_author"));
                article.setArticleState(resultSet.getInt("article_state"));
                ArticleType articleType = new ArticleType();
                articleType.setTypeName(resultSet.getString("type_name"));
                articleType.setTypeId(resultSet.getString("type_id"));
                article.setArticleType(articleType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return article;
    }

    @Override
    public boolean update(Article article) {
        String sql="update article set article_title=?,type_id=? where article_id=?";
        return DBUtil.updateObject(sql,article.getArticleTitle(),article.getArticleType().getTypeId(),article.getArticleId());
    }
    //添加
    @Override
    public boolean add(Article article) {
        String sql = "insert into article(article_id,article_title,article_content,article_state,type_id,user_id) values(?,?,?,?,?,?)";
        return DBUtil.updateObject(sql, article.getArticleId(), article.getArticleTitle(), article.getArticleContent(),
                article.getArticleState(), article.getArticleType().getTypeId(), article.getSystemUser().getUserId());
    }

    @Override
    public boolean deleteById(String aId) {
        return DBUtil.updateObject("delete from article where article_id = ?",aId);
    }

    @Override
    public List<Article> selectAllByLike(int state ,String title) {
        List<Article> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT a.article_id,a.article_title,a.article_summary,a.article_author,a.article_state, " +
                    "b.type_name,s.user_name " +
                    "from article a " +
                    "LEFT JOIN article_type b on a.type_id = b.type_id " +
                    "LEFT JOIN system_user s on s.user_id = a.user_id where 1 = 1 ";
            Map<Integer,Object> argMap= new HashMap<>();
            int num= 0;

            if (state!=-1){
                sql +=" and a.article_state = ? ";
                num++;
                argMap.put(num,state);
            }

            if (!StringUtil.isEmpty(title)){
                sql +=" and a.article_title like ? ";
                num++;
                argMap.put(num,"%"+title+"%");
            }
            System.out.println("sql = " + sql);
            preparedStatement = connection.prepareStatement(sql);
            if (argMap.size() > 0){
                Iterator<Map.Entry<Integer, Object>> iterator = argMap.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Integer, Object> entry = iterator.next();
                    preparedStatement.setObject(entry.getKey(),entry.getValue());
                }
            }
            resultSet = preparedStatement.executeQuery();
            Article article =null;
            while (resultSet.next()){
                article=new Article();
                article.setArticleId(resultSet.getString("article_id"));
                article.setArticleTitle(resultSet.getString("article_title"));
                article.setArticleSummary(resultSet.getString("article_summary"));
                article.setArticleAuthor(resultSet.getString("article_author"));
                article.setArticleState(resultSet.getInt("article_state"));

                SystemUser systemUser = new SystemUser();
                systemUser.setUserName(resultSet.getString("user_name"));
                article.setSystemUser(systemUser);

                ArticleType articleType = new ArticleType();
                articleType.setTypeName(resultSet.getString("type_name"));
                article.setArticleType(articleType);

                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return list;
    }





    @Override
    public List<ArticleType> selectAllOne() {
        List<ArticleType> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql=" SELECT article_type.* FROM article_type ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ArticleType articleType =null;
            while (resultSet.next()){
                articleType = new ArticleType();
                articleType.setTypeId(resultSet.getString("type_id"));
                articleType.setTypeName(resultSet.getString("type_name"));
                articleType.setTypeDesc(resultSet.getString("type_desc"));
                articleType.setTypeState(resultSet.getInt("type_state"));
                articleType.setTypeSort(resultSet.getInt("type_sort"));

                /*articleType.setTypeName(resultSet.getString("type_name"));
                articleType.setTypeDesc(resultSet.getString("type_Desc"));*/
                articleType.setArticleType(articleType);
                list.add(articleType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public ArticleType getOneByIdOne(String aIdOne) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArticleType articleType = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT article_type.* FROM article_type where type_id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aIdOne);
            resultSet = preparedStatement.executeQuery();
            articleType = null;
            while (resultSet.next()) {
                articleType = new ArticleType();
                articleType.setTypeId(resultSet.getString("type_id"));
                articleType.setTypeName(resultSet.getString("type_name"));
                articleType.setTypeDesc(resultSet.getString("type_desc"));
                articleType.setTypeState(resultSet.getInt("type_state"));
                articleType.setTypeSort(resultSet.getInt("type_sort"));

                /*articleType.setTypeName(resultSet.getString("type_name"));
                articleType.setTypeDesc(resultSet.getString("type_Desc"));*/
                articleType.setArticleType(articleType);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return articleType;
    }

    @Override
    public boolean updateOne(ArticleType articleType) {
        String sql="update article_type set type_name=?  type_desc=?  where type_id=?";
        return DBUtil.updateObject(sql,articleType.getTypeName(),articleType.getTypeDesc(),articleType.getTypeId());
    }
}
