package com.article.manager.test;

import com.article.manager.dao.ArticleTypeDao;
import com.article.manager.dao.impl.ArticleTypeDaoImpl;
import com.article.manager.entity.ArticleType;
import org.junit.Test;

import java.util.List;

public class ArticleTypeTest {
    @Test
    public void getAll(){
        ArticleTypeDao dao =new ArticleTypeDaoImpl();
        List<ArticleType> all=dao.getAll();
        System.out.println("all.size() = " + all.size());
    }
}
