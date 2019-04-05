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
        <small>用户反馈</small>
    </h4>
    <div class="container">
        <d:table name="list" class="table table-striped" pagesize="5" requestURI="listFeedback">
            <d:column property="subject" title="主题"></d:column>
            <d:column property="name" title="姓名"></d:column>
            <d:column property="phone" title="电话"></d:column>
            <d:column property="description" title="详情"></d:column>
        </d:table>
    </div>


</div>

</body>
</html>
