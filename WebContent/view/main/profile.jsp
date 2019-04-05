<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    <script src="assets/js/ace-extra.min.js"></script>

</head>
<body>


<div class="page-content">
    <div class="page-header">
        <h1>个人信息</h1>
    </div>
    <!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->


            <div class="hr dotted"></div>

            <div>
                <div id="user-profile-1" class="user-profile row">
                    <div class="col-xs-12 col-sm-3 center">
                        <div>

                            <img alt="" src="${userinfo.userUrl}" width="180" class="center-block"
                                 style="margin-bottom: 10px"/>&nbsp;
                            <div
                                    class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">

                                <div class="inline position-relative">

                                    <a href="javascript:void(0)" class="user-title-label dropdown-toggle"
                                       data-toggle="dropdown"> <i
                                            class="icon-circle light-green middle"></i> &nbsp; <span
                                            class="white">${userinfo.userName }</span>
                                    </a>

                                    <ul
                                            class="align-left dropdown-menu dropdown-caret dropdown-lighter">
                                        <li class="dropdown-header">Change Status</li>

                                        <li><a href="#"> <i class="icon-circle green"></i>
                                            &nbsp; <span class="green">Available</span>
                                        </a></li>

                                        <li><a href="#"> <i class="icon-circle red"></i>
                                            &nbsp; <span class="red">Busy</span>
                                        </a></li>

                                        <li><a href="#"> <i class="icon-circle grey"></i>
                                            &nbsp; <span class="grey">Invisible</span>
                                        </a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="space-6"></div>

                        <div class="profile-contact-info">
                            <div class="profile-contact-links align-center">

                                <a class="btn btn-link" href="https://w.mail.qq.com/cgi-bin/loginpage"> <i
                                        class="icon-envelope bigger-120 pink"></i> 发送QQ邮件
                                </a>
                            </div>

                            <div class="space-6"></div>

                        </div>

                        <div class="hr hr12 dotted"></div>


                        <div class="hr hr16 dotted"></div>
                    </div>

                    <div class="col-xs-12 col-sm-9">


                        <div class="space-12"></div>

                        <div class="profile-user-info profile-user-info-striped">
                            <div class="profile-info-row">
                                <div class="profile-info-name">账号</div>

                                <div class="profile-info-value">
                                    <span class="editable"> ${userinfo.userId }</span>&nbsp;
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">姓名</div>

                                <div class="profile-info-value">
                                    <span class="editable"> ${userinfo.userName }</span>&nbsp;
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">性别</div>

                                <div class="profile-info-value">
                                    <span class="editable">${userinfo.userSex }</span>&nbsp;
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">年龄</div>

                                <div class="profile-info-value">
                                    <span class="editable">${userinfo.userAge }</span>&nbsp;
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">电话号码</div>

                                <div class="profile-info-value">
                                    <span class="editable">${userinfo.userPhone }</span>&nbsp;
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">创建时间</div>

                                <div class="profile-info-value">
										<span class="editable" id="">
										<fmt:formatDate value="${userinfo.userCtime }" type="both"
                                                        pattern="yyyy-MM-dd HH:mm:ss  EEEE"/>
										</span>&nbsp;
                                </div>
                            </div>


                        </div>
                        <div class="space-20"></div>
                    </div>
                </div>
            </div>
            <h1>公告</h1>
            <table class="table">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>内容</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="notice" items="${notice_list}">
                    <tr>
                        <td>${notice.title}</td>
                        <td>${notice.data}</td>
                        <td>${notice.formatTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</div>
<!-- /.page-content -->

</body>
</html>
