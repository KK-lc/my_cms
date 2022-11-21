package com.article.manager.test;

import com.article.manager.entity.Article;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

public class RefTest {
@Test
    public void testArticle() throws ClassNotFoundException {
    //class.forName()
    Class<?> aClass = Class.forName("com.article.manager.entity.Article");
    System.out.println("aClass = " + aClass);
    //类型
    Class<Article> articleClass = Article.class;
    System.out.println("articleClass = " + articleClass);

    //对象.getClass()
    Article article = new Article();
    Class<? extends Article> aClass1 = article.getClass();
    System.out.println("aClass1 = " + aClass1);

    String typeName = articleClass.getTypeName();
    System.out.println(typeName);

    String typeName1 = articleClass.getGenericSuperclass().getTypeName();
    System.out.println("typeName1 = " + typeName1);

    String name = articleClass.getPackage().getName();
    System.out.println("name = " + name);
}

@Test
    public void testObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Class<Article> articleClass = Article.class;
    //创建对象

    //基于无参构造
    Article article = articleClass.newInstance();
    System.out.println("article = " + article);
    System.out.println(" ================================== ");
    //Constructor<Article> constructor = articleClass.getConstructor(String.class);

    Constructor<Article> constructor = articleClass.getConstructor(String.class);
    Article article1 = constructor.newInstance("java EE");
    System.out.println("article1 = " + article1);
}
@Test
    public void testField() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    Class<Article> aClass = (Class<Article>) forName("com.article.manager.entity.Article");
    System.out.println("aClass = " + aClass);
    Field[] fields=aClass.getFields();
    System.out.println("fields.length = " + fields.length);
    for (Field field:fields){
        System.out.println("field = " + field);
        System.out.println(field.getType().getName());
        System.out.println(field.getName());
    }
    System.out.println("===================================");
    Field[] declaredFields = aClass.getDeclaredFields();
    for (Field field:declaredFields){
        System.out.println("field = " + field);
        System.out.println(field.getType().getName());
        System.out.println(field.getName());
    }


     Article article = aClass.newInstance();
    Field field = aClass.getDeclaredField("articleTitle");
    //设置权限为ture
    field.setAccessible(true);
    field.set(article,"ssm");
    field.setAccessible(false);
    System.out.println("article = " + article.getArticleTitle());

}
@Test
    public void testMethod() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    Class<Article> aClass = Article.class;
    Method[] methods = aClass.getMethods();
    System.out.println(methods.length);
    for (Method method : methods) {
        String name = method.getName();
        System.out.println("name = " + name);
    }

    Method method = aClass.getMethod("printArticle", String.class);
    Article article = aClass.newInstance();
    Object obj = method.invoke(article, "ssm");
    System.out.println(method.getReturnType().getTypeName());

    System.out.println("obj = " + obj);
}
}
