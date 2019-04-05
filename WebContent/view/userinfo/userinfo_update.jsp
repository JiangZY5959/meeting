<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>



</head>

<body>

<div  >

	<h4 class="page-header">用户管理<small>用户修改</small></h4>
	<div align="center" style="color: red" >${info }</div>
    <form  action="userInfoUpdateServlet" method="post" class="form-horizontal"  enctype="multipart/form-data">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 账号</label>
            <div class="col-xs-4">
            	<input type="text" name="userId"  placeholder="请输入账号" readonly="readonly" value="${user.userId }"  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 密码 </label>
            <div class="col-xs-4">
            	<input type="text" name="userPw" id="name" placeholder="请输入密码" value=""   class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 姓名</label>
            <div class="col-xs-4">
            	<input type="text" name="userName"  placeholder="请输姓名" value="${user.userName }"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 头像</label>
            <div class="col-xs-4">
            	<input type="file" name="userUrl"  class="form-control"  />
            	<img alt="" src="${user.userUrl }" width="50" height="50">
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 性别</label>
            <div class="col-xs-4">
            	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="男"  ${user.userSex=='男'?'checked':'' }>男
                    </label>
                </div>
                          	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="女"  ${user.userSex=='女'?'checked':'' }>女
                    </label>
                </div>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 年龄</label>
            <div class="col-xs-4">
            	<input type="text" name="userAge"  placeholder="请输年龄"  value="${user.userAge }"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 电话号码</label>
            <div class="col-xs-4">
            	<input type="text" name="userPhone"  placeholder="请输电话号码"   value="${user.userPhone }"  class="form-control" />
             </div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label " > 邮箱</label>
            <div class="col-xs-4">
                <input type="text" name="userMail"  placeholder="请输邮箱"   value="${user.userMail }"  class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label " > 部门</label>
            <div class="col-xs-4">
                <input type="text" name="userDepartment"  placeholder="请输部门"   value="${user.userDepartment }"  class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-xs-2 control-label " > 状态</label>
            <div class="col-xs-4">
                <select class="form-control" name="userState">
                    <option value="启用" <c:if test="${user.userState == '启用'}">selected</c:if>>启用</option>
                    <option value="停用" <c:if test="${user.userState == '停用'}">selected</c:if>>停用</option>
                </select>
            </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea name="userBeizhu" class="form-control" rows="3">${user.userBeizhu }</textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改用户"/>
            	<c:if test="${user.userAnthority == 2 || user.userAnthority == 3}">
                    <a class="btn btn-default"  href="userInfListServlet"> 返回上一级</a>
                </c:if>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
