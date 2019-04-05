<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备添加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">设备管理<small>添加</small></h4>
	<div align="center" style="color: red;">${info }</div>
    <form class="form-horizontal" action="enquipmentAddServlet" method="post">
    	<div class="form-group"> 
        	<label for="enzhequipmentName" class="col-xs-2 control-label " > 设备名称</label>
            <div class="col-xs-4">
            	<input type="text" name="enzhequipmentName" id="enzhequipmentName" placeholder="请输入设备名称"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="procurementTime" class="col-xs-2 control-label " > 采购时间</label>
            <div class="col-xs-5">
            	<input type="text" name="procurementDateTime" id="procurementTime" placeholder="请输入采购时间：例如2019-2-14"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="enzhequipmentPrice" class="col-xs-2 control-label " > 价格</label>
            <div class="col-xs-4">
            	<input type="text" name="enzhequipmentPrice" id="enzhequipmentPrice" placeholder="请输入价格"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea class="form-control" name="enzhequipmentRemerk" rows="3"></textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="添加"/>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
