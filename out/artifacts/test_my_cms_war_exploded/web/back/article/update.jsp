<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" scope="application" value="${pageContext.request.contextPath}"/>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>文章管理</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.css">
    <script src="${path}/static/js/jquery.js"></script>
    <script src="${path}/static/bootstrap/js/bootstrap.js"></script>


    <style>
        .row {
            margin-bottom: 30px;
            margin-right:0 !important;
            margin-left:0 !important;
        }

        .form-group{
            margin-bottom: 30px;
        }

        .modal-btns{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div>
            <ol class="breadcrumb">
                <li><a href="${path}/back/main.jsp"  class="btn btn-primary btn-sm" role="button"><span class="glyphicon glyphicon-home pull-right" aria-hidden="true"></span>&nbsp;&nbsp; 主&nbsp;&nbsp; 页</a></li>
                <li class="active">文章管理</li>
                <li><a href="${path}/article?cmd=list">文章管理</a></li>
                <li class="active">文章修改</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <form class="form-horizontal" action="${path}/article?cmd=update&aId=${article.articleId}" method="post" >
                <!-- 文章标题-->
                <div class="form-group">
                    <label for="articleTitle" class="col-lg-2 control-label">标题</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="articleTitle" value="${article.articleTitle}" name="articleTitle" placeholder="输入标题">
                    </div>
                </div>

                <!-- 演示初始化下拉列表的功能 -->
                <div class="form-group">
                    <label for="articleType" class="col-lg-2 control-label">文章类型</label>
                    <div class="col-lg-10">
                        <select class="form-control" name="articleType" id="articleType">
                             <option value="-1">请选择</option>
                            <c:forEach items="${articleTypes}" var="articleType">
                                <option value="${articleType.typeId}" ${article.articleType.typeId == articleType.typeId?'selected':''}>${articleType.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <%-- <!-- 演示图片上传功能 -->
                 <div class="form-group">
                     <label class="control-label col-lg-2" for="file">图片</label>
                     <div class="col-lg-10">
                         <input type="file" id="file" name="file" multiple>
                     </div>
                 </div>--%>

                <!-- 演示富文本编辑器 -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="articleContent">文章内容</label>
                    <div class="col-lg-10">
                        <textarea rows="30" cols="62" name="articleContent" id="articleContent" class="form-control ckeditor">${article.articleContent}</textarea>
                    </div>
                </div>

                <div class="modal-btns">
                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary submit">更  新</button>--%>
                        <input type="submit" value="提交" />
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>