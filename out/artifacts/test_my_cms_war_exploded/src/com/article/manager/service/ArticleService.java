package com.article.manager.service;

import com.article.manager.entity.Article;
import com.article.manager.entity.ArticleType;

import java.util.List;

public interface ArticleService {
    List<Article> selectAll();
    Article selectOneById(String aId);
    boolean update(Article article);
    //添加
    boolean add(Article article);
    boolean delete(String aId);
    List<Article> selectAllByLike(int state,String title);


    List<ArticleType> selectAllOne();
    ArticleType selectOneByIdOne(String aIdOne);
    boolean updateOne(ArticleType articleType);
}
