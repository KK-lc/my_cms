<%--
  Created by IntelliJ IDEA.
  User: KK
  Date: 2022/10/11
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" scope="application" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>文章后台管理器</title>
    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${path}/static/js/jquery.js"></script>
    <script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.js"></script>
    <style>
    body{
      background: url("${path}/static/img/login.jpg");

    }
    .row{
      margin-top: 200px;
      margin-right:0 !important;
      margin-left:0 !important;
    }

    button{
      margin-top: 20px;
      margin-left: 40%;
    }
    .msg{
      margin-left: 30%;
      color: red;
    }
  </style>
  </head>
  <body>
  <div class="container-fluid">
    <%--<div class="row">
      <div class="col-md-8">.col-md-8</div>
      <div class="col-md-4">.col-md-4</div>
    </div>
  </div>--%>

      <!-- 顶部 -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">
              &nbsp;欢迎使用文章管理后台系统
            </a>
          </div>
        </div>
      </nav>

      <!-- 表单区 -->
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-2 col-md-offset-5">
            <form class="form-horizontal" action="${path}/user" method="post">
<%--              加入隐藏域type：hidden--%>
              <input type="hidden" name="cmd" value="login">
              <div class="form-group">
                <label for="userName">用户名</label>
                <input type="text" name="name" class="form-control" id="userName" placeholder="Name">
              </div>
              <div class="form-group">
                <label for="password">密 码</label>
                <input type="password" name="pwd" class="form-control" id="password" placeholder="Password">
              </div>
              <p class="msg">${param.msg}</p>
              <button type="submit" class="btn btn-default btn-lg btn-success">登录</button>
            </form>

          </div>
        </div>
      </div>
  </body>
</html>
