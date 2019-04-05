<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<%@ taglib prefix="d"  uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会议室管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">会议室管理<small>修改删除</small></h4>
<div align="center" style="color: red" >${info }</div>
<div class="container">
<form class="form-inline" role="form" action="meetingRoomServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">名称</label>
    <input type="text"  name="meetingroomName" class="form-control" id="" placeholder="请输入名称">
  </div>
	<div class="form-group">
		<label class="sr-only" for="">容量</label>
		<input type="text"  name="meetingroomSize"  class="form-control" id="" placeholder="请输入容量">
	</div>
	<div class="form-group">
		<label class="sr-only" for="">设备</label>
		<input type="text"  name="equipmentName"  class="form-control" id="" placeholder="请输入设备">
	</div>
  <button type="submit" class="btn btn-default">查询</button>
</form>


<d:table name="list" class="table table-striped" pagesize="5" requestURI="meetingRoomServlet"> 
	<d:column property="meetingroomId" title="编号"></d:column>
	<d:column property="meetingroomName" title="名称"></d:column>
	<d:column property="meetingroomSize" title="会议室大小"></d:column>
	<d:column property="meetingRoomUseState" title="会议室状态"></d:column>
	<d:column href="meetingRoomUpdateServlet" paramId="meetingroomId" paramProperty="meetingroomId" value="修改" title="修改"></d:column>
	<d:column href="meetingRoomDeleteServlet" paramId="meetingroomId" paramProperty="meetingroomId" value="删除" title="删除"></d:column>
</d:table>

</div>

    
</div>

</body>
</html>
