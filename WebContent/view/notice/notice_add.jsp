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
    <h4 class="page-header">用户管理<small>发布公告</small></h4>
    <div>${info }</div>

    <form  action="noticeAdd" method="post" class="form-horizontal">
        <div class="form-group">
            <label  class="col-xs-2 control-label " > 标题</label>
            <div class="col-xs-8">
                <input type="text" name="title" placeholder="请输入标题"  class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label " > 内容</label>
            <div class="col-xs-8">
                <textarea name="data" class="form-control" rows="6"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-xs-4">
                <input class="btn btn-default" type="submit" value="发布公告"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
