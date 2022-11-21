package com.article.manager.test;

import com.article.manager.dao.ArticleDao;
import com.article.manager.dao.impl.ArticleDaoImpl;
import com.article.manager.entity.Article;
import com.article.manager.service.ArticleService;
import com.article.manager.service.impl.ArticleServiceImpl;
import org.testng.annotations.Test;

import java.util.List;

public class ArticleTest {
    
   @Test
    public void getAll(){
       ArticleService service = new ArticleServiceImpl();
       List<Article> articles = service.selectAll();
       for (Article article:articles){
           System.out.println("article = " + article);

       }
   }
   @Test
    public void getOneById(){
       ArticleDao dao=new ArticleDaoImpl();
       Article article = dao.getOneById("1f72f8ce-28b4-47b9-b95d-ae914ac23adf");
       System.out.println("article.getArticleType().getTypeName() = " + article.getArticleType().getTypeName());
   }
   @Test
    public void getAllByLike(){
       ArticleDao dao = new ArticleDaoImpl();
       List<Article> articles = dao.selectAllByLike(1, "%对象%");
       System.out.println(articles.size());
   }
}
