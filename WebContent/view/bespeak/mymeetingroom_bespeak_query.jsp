<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会议预约管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
	<h4 class="page-header">会议室预约<small>我的预约</small></h4>
	<div align="center" style="color: red">${info }</div>
<div class="container">
<form class="form-inline" role="form" action="mymeetingroomBespeakQueryServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">会议名称</label>
    <input type="text" name="meetingName" class="form-control" id="" placeholder="请输入名称">
  </div>
    <div class="form-group">
    <label class="sr-only" for="">预约状态</label>
    <select name="bespeakState" class="form-control" >
    	<option value="">请选择</option>
    	<option value="0">未审核</option>
    	<option value="1">审核通过</option>
    	<option value="2">审核不通过</option>
    </select>
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<d:table class="table table-striped" name="list" pagesize="8"
			requestURI="mymeetingroomBespeakQueryServlet">
			<d:column property="bespeakId" title="编号"></d:column>
			<d:column property="meetingName" title="会议名称"></d:column>
			<d:column property="meetingroomName" title="会议室"></d:column>
			<d:column property="stratTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="开始时间"></d:column>
			<d:column property="endTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="结束时间"></d:column>
			<d:column property="bespeakState"   title="预约状态"></d:column>
			<d:column href="mymeetingroomBespeakShowServlet" paramId="bespeakId" paramProperty="bespeakId" value="查看" title="查看"></d:column>
	<d:column href="cancelBespeak_1" paramId="bespeakId" paramProperty="bespeakId" value="取消"
			  title="取消"></d:column>
</d:table>


</div>
</body>
</html>
