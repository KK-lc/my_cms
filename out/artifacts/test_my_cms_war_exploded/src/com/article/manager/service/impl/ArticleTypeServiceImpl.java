package com.article.manager.service.impl;

import com.article.manager.dao.ArticleTypeDao;
import com.article.manager.dao.impl.ArticleTypeDaoImpl;
import com.article.manager.entity.ArticleType;
import com.article.manager.service.ArticleTypeService;

import java.util.List;

public class ArticleTypeServiceImpl implements ArticleTypeService {
    private ArticleTypeDao typeDao;
    public  ArticleTypeServiceImpl(){
        typeDao =new ArticleTypeDaoImpl();
    }
    @Override
    public List<ArticleType> getAll() {
        return typeDao.getAll();
    }
}
