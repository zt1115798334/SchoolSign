<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="page-header">
    <h1>学生编辑页面</h1>
</div>
<a href="${ctx}/student/edit" class="btn btn-primary" role="button">添加学生信息</a>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>#</th>
        <th>学号</th>
        <th>姓名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="stu" varStatus="xh">
        <tr>
            <th scope="row">${xh.index+1}</th>
            <td>${stu.studentId}</td>
            <td>${stu.studentName}</td>
            <td>
                <a href="${ctx}/student/get/${stu.id}" class="btn btn-primary" role="button">修改</a>
                <a href="${ctx}/signRecord/get/${stu.id}" class="btn btn-primary" role="button">查看考勤记录</a>
                <button type="button" class="btn btn-danger delete-btn" del_uri="${ctx}/student/delete/${stu.id}">删除
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" id="deleteStuForm">
    <input type="hidden" name="_method" value="delete">
</form>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>

    $(".delete-btn").click(function () {
        $("#deleteStuForm").attr("action", $(this).attr("del_uri")).submit();
        return false;
    })
</script>
</body>
</html>