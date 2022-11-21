<%--
  Created by IntelliJ IDEA.
  User: KK
  Date: 2022/10/12
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" scope="application" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <style>
        .content{
            height:100%;
            background: url("${path}/static/img/back.jpg") center center no-repeat;
        }
        .footer{
            margin-top: 10px;
            height: 60px;
            line-height: 60px;
            background-color: whitesmoke
        }
        .row{
            height: 750px;
            margin-right:0 !important;
            margin-left:0 !important;
        }
        .nav-left{
            height: 100%;
            background-color: #ECECED
        }
    </style>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.css">
    <script src="${path}/static/js/jquery.js"></script>
    <script src="${path}/static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse"><!-- 修改为反显效果-->
    <div class="container-fluid">
        <!-- 显示logo -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">文章发布后台管理</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <!-- 右为普通导航条 -->
            <!--<a class="btn btn-default" href="#" role="button" id = "msg">Link</a>-->
            <ul class="nav navbar-nav navbar-right">
                <!--<li><a href="#">当前用户:<span class="badge">小明</span></a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">当前用户:<span class="badge">${sessionScope.user.userName}</span><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">修改密码</a></li>
                        <li><a href="#">个人详情</a></li>
                    </ul>
                </li>
                <li >
                    <a href="${path}/user?cmd=loginOut" ><span class="glyphicon glyphicon glyphicon-lock" aria-hidden="true"></span>注销</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="row">
    <div class="col-lg-2 text-center nav-left">
        <div class="panel-group" id="accordion-0">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion-0" href="#12rere">系统类管理</a>
                    </h4>
                </div>
            </div>
            <div id="12rere" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a href="#">系统功能管理</a>
                        </li>
                        <li>
                            <a href="#">用户管理</a>
                        </li>
                        <li>
                            <a href="#">角色管理</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel-group" id="accordion-1">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion-1" href="#eeds">文章类管理</a>
                    </h4>
                </div>
            </div>
            <div id="eeds" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a href="${path}/article?cmd=list">文章管理</a>
                        </li>
                        <li>
                            <a href="${path}/article?cmd=listOne">文章类型管理</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="splitter"></div>
    <div class="col-lg-10 content">
        <h3 class="text-center">欢迎使用本系统！</h3>
    </div>
</div>

<div class="footer">
    <p class="text-center">
        2018 &copy; 易腾创想.
    </p>
</div>
</body>
</html>