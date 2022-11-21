<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" scope="application" value="${pageContext.request.contextPath}"/>
<html lang="zh-CN">
<head>
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
        td {
            vertical-align: middle !important;
        }

        .row {
            margin-bottom: 30px;
            margin-right:0 !important;
            margin-left:0 !important;
        }

        th {
            text-align: center;
        }
        #add{
            margin: 0 50px;
        }
        textarea{
            resize: none;
        }

        .form-group{
            margin-bottom: 30px;
        }
        .submit{
            margin-left: 30px;
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
                <li class="active">文章类型管理</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-4 col-sm-offset-6">
            <div class="input-group input-group-sm">
                <span class="input-group-addon">是否可用</span>
                <select class="form-control" id="searchState">

                    <option value="0" ${state == 0 ? 'selected':''}>可用</option>
                    <option value="1" ${state == 1 ? 'selected':''}>不可用</option>
                    <option value="-1" ${state == -1 ? 'selected':''}>全部</option>

                </select>
                <span class="input-group-addon">按名称搜索</span>
                <input type="text" class="form-control" placeholder="输入包含的类型名称" id="searchWord"/>
                <span class="input-group-btn">
	                    <button class="btn btn-success" type="button" id="search">
	                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	                    </button>
	                </span>
            </div><!-- /input-group -->
        </div>
    </div>

    <div class="row">
        <div class="col-sm-6 col-sm-offset-2">
            <div class="btn-toolbar">
                <div class="btn-group btn-group-sm">
                    <button class="btn btn-success" id="all-select">全选</button>
                    <button class="btn btn-info" id="inverse-select">反选</button>
                    <button class="btn btn-success" id="notall-select">全不选</button>
                </div>
                <div class="btn-group btn-group-sm">
                    <button class="btn btn-primary" id="add" data-cmd="add">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加
                        <%--                        <a href="${path}/article?cmd=toAdd&aId=${article.articleId}" class="btn btn-primary active" role="button">添加</a>--%>
                    </button>
                </div>
                <div class="btn-group btn-group-sm">
                    <button class="btn btn-danger" id="batch_delete">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 批量删除
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <table class="table table-sm table-bordered table-hover text-center">
                <tr>
                    <th><input type="checkbox" id="main-type-id"/></th>
                    <th>文章名字</th>
                    <th>文章内容</th>
                    <th>分类</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <c:if test="${not empty articleTypes}">
                    <c:forEach items="${articleTypes}" var="articleType">
                        <tr>
                            <td><input type="checkbox" class="ids" value="${articleType.typeId}"></td>
                            <td>${articleType.typeId}</td>
                            <td>${articleType.typeDesc}</td>
                            <td>${articleType.typeSort}</td>
                            <td>${articleType.typeState == 0?'可用':'不可用'}</td>
                            <td>
                                <a href="${path}/article?cmd=toUpdateOne&aIdOne=${articleType.typeId}" class="btn btn-primary active" role="button">修改</a>
                                    <%--                                <a href="${path}/article?cmd=delete&aId=${article.articleId}" class="btn active btn-danger" role="button">删除</a>--%>
                                    <%--                                html标签自定义属性 可以直接写属性名，html规范使用date-xx--%>
                                <button class="btn btn-primary delete" name="delete" date-aIdOne="${articleType.typeId}" date-aTitleOne="${articleType.typeName}">
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
</div>




</div>
</div>
<script type="text/javascript">
    document.getElementById("add").onclick=function () {
        location.href="${path}/article?cmd=toAdd";
    }
    let  delBtn = document.getElementsByName("delete");
    for (let i=0;i<delBtn.length;i++){
        delBtn[i].onclick=function () {
            console.log("点击操作")
            let title = this.getAttribute("date-aTitle");
            //let title = this.dataset["aTitle"];
            //打印效果 变量及常量.log + enter键
            console.log(title);
            if(confirm("是否删除" + title + "的信息？")){
                let aId = this.getAttribute("date-aId");
                //模板字符串
                <%--console.log(`article?cmd=delete&aId=${"aId"}`);--%>
                location.href="${path}/article?cmd=delete&aId=" + aId;
            }
        }
    }

    let searchBtn = document.getElementById("search");
    searchBtn.onclick = function () {
        let state = document.getElementById("searchState").value;
        let word = document.getElementById("searchWord").value;
        console.log(state);
        console.log(word);
        location.href="${path}/article?cmd=list&state="+ state + "&title=" + word;
    }




</script>
</body>
</html>