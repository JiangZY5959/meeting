<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>会议室预约系统</title>

	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
	<link rel="stylesheet" href="assets_1/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets_1/css/form-elements.css">
	<link rel="stylesheet" href="assets_1/css/style.css">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script src="assets_1/js/jquery-1.11.1.min.js"></script>
	<script src="assets_1/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets_1/js/jquery.backstretch.min.js"></script>
	<script src="assets_1/js/scripts.js"></script>
    <script type="text/javascript">
        function check() {
            //账号
            var  userId =document.getElementById("userId").value;
            if (userId.length == 0){
                alert('请输入您的账号');
                return false;
            }
            //账号
            var  userPw =document.getElementById("userPw").value;
            if (userPw.length == 0){
                alert('请输入您的密码');
                return false;
            }
        }

    </script>
</head>
<body>

<div class="top">
	<ul>
		<li><a href="roomCalendar.jsp" class="hover">会议预约情况展示</a></li>
		<li><a class="launch-modal" href="#" data-modal-id="modal-register1">问题反馈</a></li>
		<li><a class="launch-modal" href="#" data-modal-id="modal-register2">联系我们</a></li>
		<li><a href="http://www.caztc.edu.cn/">返回主站</a></li>
	</ul>
</div>
<div align="center" style="color: red" id="info">${feedbackInfo}</div>
<div class="main">
	<div class="denglu">
		<div class="text" align="left" style="font-size:20px; font-family: 'Microsoft YaHei UI'"><strong>重要提示：</strong><br /><br />
			一、用户登录本系统可对我校主要会议室、学术报告厅等进行会议预约。<br />
			二、如只需查看全校会议室预约情况，请点击此页左上方“查看会议预约情况”即可，如需预约会议室请先登录本系统。<br />
			三、会议室为学校公共资源，请保持会议室内卫生。</div>
		<div class="dlk">
            <form action="loginServlet" method="post" onsubmit="return check()" >
			<table width="292" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="76" colspan="3"></td>
				</tr>
				<tr>
					<td width="65" style="font-size:14px;"><strong>用户账户</strong></td>
					<td colspan="2"><input id="userId" name="userId" type="text" class="dlinput" /></td>
				</tr>
				<tr>
					<td height="16" colspan="3"></td>
				</tr>
				<tr>
					<td><strong>登录密码</strong></td>
					<td colspan="2"><input id="userPw" name="passWord" type="password" class="dlinput" /></td>
				</tr>
				<tr>
					<td height="16" colspan="3"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td colspan="2">
						<button type="submit"
								class="loginbtn">
							<i class="icon-key"></i> 登陆
						</button>
						<%--<input type="submit" value="登 录" class="loginbtn" />--%>
					</td>
				</tr>
				<tr>

			</table></td>
			</tr>
                <div style="color: red" align="center">${info}</div>
			</table>
            </form>
		</div>
	</div>
</div>

<div class="footer"><br />Copyright &copy; 2019   www.caztc.edu.cn   All Rights Reserved　<br />版权所有 沧州师范学院</div>


<div class="modal fade" id="modal-register1" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="modal-register-label">用户反馈</h3>
				<p>请如实填写以下信息:</p>
			</div>

			<div class="modal-body">
				<form role="form" action="feedbackAdd" method="post" class="registration-form">
					<div class="form-group">
						<label class="sr-only" for="form-first-name">主题</label>
						<input type="text" name="subject" placeholder="主题..." class="form-first-name form-control" id="form-first-name">
					</div>
					<div class="form-group">
						<label class="sr-only" for="form-last-name">姓名</label>
						<input type="text" name="name" placeholder="姓名..." class="form-last-name form-control" id="form-last-name">
					</div>
					<div class="form-group">
						<label class="sr-only" for="form-email">电话</label>
						<input type="text" name="phone" placeholder="电话..." class="form-email form-control" id="form-email">
					</div>
					<div class="form-group">
						<label class="sr-only" for="form-about-yourself">详细情况</label>
						<textarea name="description" placeholder="详细情况..."
								  class="form-about-yourself form-control" id="form-about-yourself"></textarea>
					</div>
					<button type="submit" class="btn" id="submit">提交反馈</button>
				</form>
			</div>

		</div>
	</div>
</div>
<div class="modal fade" id="modal-register2" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title">联系我们</h3>
			</div>
			<div class="modal-body">
				<form role="form" class="registration-form">
					<div align="center" class="form-group">
						<h3 class="modal-title">作者：JiangZY</h3>
						<h3 class="modal-title">邮箱：674661761@qq.com</h3>
						<h3 class="modal-title">电话：18631886335</h3>
					</div>
					<div  class="form-group">
						<img src="images/weixinerweima.png" alt=""/>
					</div>
					<button type="submit" class="btn" onclick="close()">好的</button>
				</form>
			</div>

		</div>
	</div>
</div>
</body>
</html>
