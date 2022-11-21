package com.article.manager.service.impl;

import com.article.manager.dao.ArticleDao;
import com.article.manager.dao.impl.ArticleDaoImpl;
import com.article.manager.entity.Article;
import com.article.manager.entity.ArticleType;
import com.article.manager.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao;

    public ArticleServiceImpl(){articleDao = new ArticleDaoImpl();}
    @Override
    public List<Article> selectAll() {return articleDao.selectAll();}

    @Override
    public Article selectOneById(String aId) {
        return articleDao.getOneById(aId);
    }

    @Override
    public boolean update(Article article) {
        return articleDao.update(article);
    }
//添加
    @Override
    public boolean add(Article article) {
        return articleDao.add(article);
    }

    @Override
    public boolean delete(String aId) {
        return articleDao.deleteById(aId);
    }

    @Override
    public List<Article> selectAllByLike(int state,String title) {
        return articleDao.selectAllByLike(state,title);
    }





    @Override
    public List<ArticleType> selectAllOne() {
        return articleDao.selectAllOne();
    }

    @Override
    public ArticleType selectOneByIdOne(String aIdOne) {
        return articleDao.getOneByIdOne(aIdOne);
    }

    @Override
    public boolean updateOne(ArticleType articleType) {
        return articleDao.updateOne(articleType);
    }


}
