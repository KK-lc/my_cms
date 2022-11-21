package com.article.manager.servlet;

import com.article.manager.entity.SystemUser;
import com.article.manager.service.SystemUserService;
import com.article.manager.service.impl.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
//功能模块
@WebServlet("/user")
public class SystemUserServlet extends HttpServlet {
    private SystemUserService userService;

    public SystemUserServlet() {
        userService =new SystemUserServiceImpl();
    }
    //设置操作参数：cmd login loginout update toupdate toadd add delete selectall selectone
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        if (cmd!=null){
            switch (cmd){
                case "login":
                    login(req,resp);
                    break;
                case "loginOut" :
                    loginOut(req,resp);
                    break;
            }
        }
    }

    private void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        //手动销毁当前用户session
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException  {
        if ("post".equalsIgnoreCase(req.getMethod())){
            req.setCharacterEncoding("UTF-8");//解决中文乱码问题
            String user = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            System.out.println("user = " + user);
            System.out.println("pwd = " + pwd);
            SystemUser systemUser = userService.selectByNameAndPwd(user, pwd);
            HttpSession session = req.getSession();
            session.setAttribute("user",systemUser);
            resp.setContentType("text/html;charset=UTF-8");
            if (systemUser != null){
                resp.sendRedirect(req.getContextPath()+"/back/main.jsp");
            }else{
                //req.getRequestDispatcher("/index.jsp?=msg="+ URLEncoder.encode("用户名或者密码错误","UTF-8")).forward(req,resp);
                resp.sendRedirect(req.getContextPath()+"/index.jsp?msg="+ URLEncoder.encode("用户名或者密码错误","UTF-8"));
            }
        }else{

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

   /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//解决中文乱码问题
        String user = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("user = " + user);
        System.out.println("pwd = " + pwd);
        SystemUser systemUser = userService.selectByNameAndPwd(user, pwd);
        HttpSession session = req.getSession();
        session.setAttribute("user",systemUser);
        resp.setContentType("text/html;charset=UTF-8");
        if (systemUser != null){
            resp.sendRedirect(getServletContext().getContextPath()+"/main.jsp");
        }else{
            //req.getRequestDispatcher("/index.jsp?=msg="+ URLEncoder.encode("用户名或者密码错误","UTF-8")).forward(req,resp);
            resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp?msg="+ URLEncoder.encode("用户名或者密码错误","UTF-8"));
        }

    }*/
}
