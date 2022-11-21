package com.article.manager.servlet;

import com.article.manager.common.StringUtil;
import com.article.manager.entity.Article;
import com.article.manager.entity.ArticleType;
import com.article.manager.entity.SystemUser;
import com.article.manager.service.ArticleService;
import com.article.manager.service.ArticleTypeService;
import com.article.manager.service.impl.ArticleServiceImpl;
import com.article.manager.service.impl.ArticleTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    private ArticleService articleService;
    private ArticleTypeService articleTypeService;
    public ArticleServlet(){
        articleService = new ArticleServiceImpl();
        articleTypeService = new ArticleTypeServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        System.out.println("cmd = " + cmd);
        if (cmd!=null){
            switch (cmd){
                case "list":
                    list(req,resp);
                    break;
                case  "toUpdate" :
                    toUpdate(req,resp);
                    break;
                case "update":
                    update(req,resp);
                    break;
                case "toAdd":
                    toAdd(req,resp);
                    break;
                case "add":
                    add(req,resp);
                    break;
                case "delete":
                    delete(req,resp);
                    break;
               /* case "search":
                    search(req,resp);
                    break;*/
                case "listOne":
                    listOne(req,resp);
                    break;
                case "toUpdateOne" :
                    toUpdateOne(req,resp);
                    break;
                case "updateOne":
                    updateOne(req,resp);
                    break;
            }
        }
    }

    private void updateOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println(req.getMethod());
        Map<String, String[]> parameterMap = req.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String[]> next = iterator.next();
            System.out.println("next.getKey() = " + next.getValue()[0]);
        }
        System.out.println("updateOne");

        String aIdOne = req.getParameter("aIdOne");
        String typeName = req.getParameter("typeName");
        String typeDesc = req.getParameter("typeDesc");

        ArticleType articleType =new ArticleType();
        articleType.setTypeId(aIdOne);
        articleType.setTypeName(typeName);
        articleType.setTypeDesc(typeDesc);


        boolean flag = articleService.updateOne(articleType);
        String path = req.getContextPath();
        String msg=flag?"操作成功":"操作失败";
        resp.getWriter().write("<script>alert('"+msg+"');</script>");
        resp.getWriter().write("<script>location.href='"+path+"/article?cmd=listOne';</script>");


    }

    private void toUpdateOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String aIdOne = req.getParameter("aIdOne");
        if (!StringUtil.isEmpty(aIdOne)){
            ArticleType articleType = articleService.selectOneByIdOne(aIdOne);
            List<ArticleType> articleTypes = articleTypeService.getAll();
            req.setAttribute("articleType",articleType);
            req.setAttribute("articleTypes",articleTypes);
            req.getRequestDispatcher("/back/article/updateOne.jsp").forward(req,resp);
        }
    }

    private void listOne(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException  {
        List<ArticleType> articleTypes = articleService.selectAllOne();
        req.setAttribute("articleTypes",articleTypes);
        req.getRequestDispatcher("/back/article/listOne.jsp").forward(req,resp);
    }



    private void list (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String state = req.getParameter("state");
        String title = req.getParameter("title");
        System.out.println(state);
        System.out.println(title);
        int aState = -1;
        if(!StringUtil.isEmpty(state)){
            aState = Integer.parseInt(state);
        }

        List<Article> articles = articleService.selectAllByLike(aState, title);
        req.setAttribute("articles", articles);
        req.setAttribute("state", aState);
        req.setAttribute("title", title);
        req.getRequestDispatcher("/back/article/list.jsp").forward(req, resp);
        /*req.setAttribute("articles",articles);
        req.getRequestDispatcher("/back/article/list.jsp").forward(req,resp);*/}

    private void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        String aid = req.getParameter("aId");
        System.out.println("aid = " + aid);
        boolean flag = articleService.delete(aid);
        String path = req.getContextPath();
        String msg=flag?"删除成功":"删除失败";
        resp.getWriter().write("<script>alert('"+msg+"');</script>");
        //重定向
        resp.getWriter().write("<script>location.href='"+path+"/article?cmd=list';</script>");
    }

    //添加
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String articleTitle = req.getParameter("articleTitle");
        String typeId = req.getParameter("articleType");
        String articleState = req.getParameter("articleState");
        String articleContent = req.getParameter("articleContent");
        Article article = new Article();
        ArticleType articleType = new ArticleType();

        articleType.setTypeId(typeId);
        article.setArticleType(articleType);
        article.setArticleTitle(articleTitle);
        article.setArticleContent(articleContent);

        int state = Integer.parseInt(articleState);
        article.setArticleState(state);

        article.setArticleId(UUID.randomUUID().toString());//转换生成,随机生成字符串48位

        SystemUser user = (SystemUser)req.getSession().getAttribute("user");
        article.setSystemUser(user);

        boolean flag = articleService.add(article);
        String path = req.getContextPath();
        String msg=flag?"添加成功":"添加失败";
        resp.getWriter().write("<script>alert('"+msg+"');</script>");
        //重定向
        resp.getWriter().write("<script>location.href='"+path+"/article?cmd=list';</script>");


        /*String  articleTitle= req.getParameter("articleTitle");
        String typeId = req.getParameter("articleType");
        String articleState = req.getParameter("articleState");
        String articleContent = req.getParameter("articleContent");
        Article article=new Article();
        ArticleType articleType=new ArticleType();
        articleType.setTypeId(typeId);
        article.setArticleType(articleType);
        article.setArticleTitle(articleTitle);
        article.setArticleContent(articleContent);
        int state = Integer.parseInt(articleState);
        article.setArticleState(state);
        //UUID()产生随机字符串48位
        article.setArticleId(UUID.randomUUID().toString());//转换自动生成

        SystemUser user =(SystemUser) req.getSession().getAttribute("user");
        article.setSystemUser(user);

        boolean flag = articleService.add(article);
        String path=req.getContextPath();
        String msg =flag?"添加成功":"添加失败";
        resp.getWriter().write("<script>alert('"+msg+"');</script>");
        resp.getWriter().write("<script>location.href='"+path+"/article?cmd=list';</script>");*/


    }
    //添加
    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ArticleType> articleTypes = articleTypeService.getAll();
        req.setAttribute("articleTypes",articleTypes);
        req.getRequestDispatcher("/back/article/add.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        System.out.println(req.getMethod());
        Map<String, String[]> parameterMap = req.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String[]> next = iterator.next();
            System.out.println("next.getKey() = " + next.getValue()[0]);
        }
        System.out.println("update");

        String aid = req.getParameter("aId");
        String articleTitle = req.getParameter("articleTitle");
        String typeId = req.getParameter("articleType");

        Article article =new Article();
        article.setArticleId(aid);
        article.setArticleTitle(articleTitle);
        ArticleType articleType = new ArticleType();
        articleType.setTypeId(typeId);
        article.setArticleType(articleType);
        boolean flag = articleService.update(article);
        /*if (flag){
            req.getRequestDispatcher("/article?cmd=list").forward(req,resp);
        }else {
            String path = req.getContextPath();
            resp.getWriter().write("<script>alert('修改失败');</script>");
            resp.getWriter().write("<script>location.href='"+path+"/article?cmd=list';</script>");
        }*/
        String path = req.getContextPath();
        /*String msg="修改失败";
        if (flag){
            msg="操作成功";
        }*/
        //带提示功能
        String msg=flag?"操作成功":"操作失败";
        resp.getWriter().write("<script>alert('"+msg+"');</script>");
        //重定向
        resp.getWriter().write("<script>location.href='"+path+"/article?cmd=list';</script>");
    }

    //到update页面
    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aId = req.getParameter("aId");
        if (!StringUtil.isEmpty(aId)){
            Article article = articleService.selectOneById(aId);
            List<ArticleType> articleTypes = articleTypeService.getAll();
            req.setAttribute("article",article);
            req.setAttribute("articleTypes",articleTypes);
            req.getRequestDispatcher("/back/article/update.jsp").forward(req,resp);
        }
    }

    /*private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articleService.selectAll();
        req.setAttribute("articles",articles);
        req.getRequestDispatcher("/back/article/list.jsp").forward(req,resp);
    }*/
}
