<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>

<%@ taglib prefix="d" uri="http://displaytag.sf.net/el" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <script src="js/jquery-1.9.0.min.js"></script>
    <script src="js/bootstrap.js"></script>
</head>

<body>
<div>
    <h4 class="page-header">用户管理
        <small>公告管理</small>
    </h4>
    <div align="center" style="color: red">${info }</div>
    <div class="container">
        <d:table name="notice_list" class="table table-striped" pagesize="5" requestURI="noticeListServlet">
            <d:column property="title" title="标题"></d:column>
            <d:column property="data" title="内容"></d:column>
            <d:column property="formatTime" title="创建时间"></d:column>
            <d:column href="noticeDeleteServlet" value="删除" paramId="id" paramProperty="id"
                      title="删除"></d:column>
        </d:table>
    </div>


</div>

</body>
</html>

