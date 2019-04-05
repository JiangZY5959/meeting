<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>会议室管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets_1/data/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="assets_1/data/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="assets_1/data/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script language="javascript">
        $(document).ready(function () {

            $("#xuanzhe").click(function () {
                var userIdstr = "";
                var userNamestr = "";
                $('input[name="enzheq"]:checked').each(function () {
                    var enzheqs = $(this).val().split(",");
                    userIdstr += enzheqs[0] + ",";
                    userNamestr += enzheqs[1] + ",";

                });
                $("#userIds").val(userIdstr);
                $("#info").html(userNamestr);
            });

        });

    </script>

</head>

<body>
<div>
    <h4 class="page-header">会议室预约
        <small>预约</small>
    </h4>
    <div align="center" style="color: red">${info }</div>
    <form class="form-horizontal" action="meetingRoomBespeakServlet" method="post">
        <input type="hidden" name="userIds" id="userIds" value=""/>
        <div class="form-group">
            <label class="col-xs-2 control-label "> 会议名称</label>
            <div class="col-xs-4">
                <input type="text" name="meetingName" placeholder="请输会议名称" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-xs-2 control-label "> 会议室 </label>
            <div class="col-xs-3">
                <select class="form-control" name="meetingroomId" id="meetRoom">
                    <c:forEach items="${meetingroomlist }" var="meet">
                        <option value="${meet.meetingroomId }" id="name_${meet.meetingroomId}" >${meet.meetingroomName}</option>
                        <p id="size_${meet.meetingroomId}">${meet.meetingroomSize}</p>
                    </c:forEach>
                </select>
                <c:forEach items="${meetingroomlist }" var="meet">
                    <p id="size_${meet.meetingroomId}" hidden>${meet.meetingroomSize}</p>
                </c:forEach>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="name" class="col-xs-2 control-label "> 开始时间</label>--%>
<%--            <div class="col-xs-4">--%>
<%--                <input type="text" readonly="readonly"--%>
<%--                       onclick="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})" name="stratTimeStr"--%>
<%--                       id="stratTimeStr" placeholder="请输会议开始时间" class="form-control"/>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="dtp_input1" class="col-md-2 control-label">开始时间</label>
            <div class="input-group date form_datetime col-md-4" data-date="${date}" data-date-format="yyyy/mm/dd hh:ii:ss" data-link-field="dtp_input1">
                <input class="form-control" size="16" type="text" value="" name="stratTimeStr" id="stratTimeStr" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input1" value="" /><br/>
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="name" class="col-xs-2 control-label "> 结束时间</label>--%>
<%--            <div class="col-xs-4">--%>
<%--                <input type="text" readonly="readonly"--%>
<%--                       onclick="WdatePicker({isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})" name="endTimeStr"--%>
<%--                       id="endTimeStr" placeholder="请输会议结束时间" class="form-control"/>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="dtp_input2" class="col-md-2 control-label">结束时间</label>
            <div class="input-group date form_datetime col-md-4" data-date="${date}" data-date-format="yyyy/mm/dd hh:ii:ss" data-link-field="dtp_input1">
                <input class="form-control" size="16" type="text" value="" name="endTimeStr" id="endTimeStr" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input2" value="" /><br/>
        </div>
        <div class="form-group">
            <label for="name" class="col-xs-2 control-label "> 会议人员</label>
            <div class="col-xs-4">
                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    请选择
                </button>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                            </div>
                            <div class="modal-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>用户编号</th>
                                        <th>用户姓名</th>
                                        <th>用户性别</th>
                                        <th>用户年龄</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${userlist }" var="user">
                                        <tr>
                                            <td><input type="checkbox" name="enzheq"
                                                       value="${user.userId },${user.userName}"></td>
                                            <td>${user.userId} </td>
                                            <td>${user.userName} </td>
                                            <td>${user.userSex}</td>
                                            <td>${user.userAge} </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" id="xuanzhe" class="btn btn-primary" data-dismiss="modal">选择
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="info" style="display:inline"></div>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-xs-2 control-label "> 备注</label>
            <div class="col-xs-4">
                <textarea name="meetingroomNote" class="form-control" rows="3"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-xs-4">
                <button class="btn btn-default" data-target="#myModal-1" data-toggle="modal" id="meet_check">预约</button>
            </div>
            <div class="modal fade" id="myModal-1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-1"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel-1">
                                预定会议室信息确认
                            </h4>
                        </div>
                        <div class="modal-body" id="meet_info">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">返回修改
                            </button>
                            <input type="submit" class="btn btn-primary" value="确定提交" id="submit"/>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </div>

    </form>

</div>
<script>
    judge = function(str) {
        var data = str.split(" ")[1].split(":");
        return 8 <= parseInt(data[0]) && parseInt(data[0]) <= 21;
    };
    $(document).ready(function(){
        $("#meet_check").click(function(){
            var meetRoomId = $("#meetRoom").val();
            var meetRoomName = $("#name_"+meetRoomId).text();
            var meetRoomSize = $("#size_"+meetRoomId).text();
            var startTime = $("#stratTimeStr").val();
            var endTime = $("#endTimeStr").val();
            // alert(judge(startTime));
            if (judge(startTime) && judge(endTime) && endTime > startTime) {
                var data = "会议室名称：" + meetRoomName + "<br>会议室容量：" + meetRoomSize + "<br>开始时间：" + startTime + "<br>结束时间：" + endTime;
                $("#meet_info").html(data);
            } else {
                $("#meet_info").html("请选择早八点到晚10点的时间,且结束时间晚于开始时间");
                $("#submit").attr("disabled", "true");
            }

        });
    });
</script>
<script type="text/javascript">
    var end = new Date();
    end.setDate(end.getDate() + 7);
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        initialDate: new Date(),
        startDate: new Date(),
        endDate: end,
        minView: 0
    });
</script>
</body>
</html>
