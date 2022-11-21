package com.article.manager.dao;

import com.article.manager.entity.Article;
import com.article.manager.entity.ArticleType;

import java.util.List;

public interface ArticleDao {
    List<Article> selectAll();
    Article getOneById(String aId);
    boolean update(Article article);
    //添加
    boolean add(Article article);
    boolean deleteById(String aId);
    List<Article> selectAllByLike(int state,String title);


    List<ArticleType>  selectAllOne();
    ArticleType getOneByIdOne(String aIdOne);
    boolean updateOne(ArticleType articleType);
}
