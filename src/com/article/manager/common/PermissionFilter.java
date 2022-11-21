package com.article.manager.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//权限拦截
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();//获取对应的路径
        if (requestURI.contains("/static")||requestURI.contains("/index.jsp")||requestURI.contains("/user")){
            filterChain.doFilter(request,response);
        }else {
            Object o = request.getSession().getAttribute("user");
            if (o==null){
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                filterChain.doFilter(request,response);//放行
            }
        }
    }

    @Override
    public void destroy() {

    }
}
