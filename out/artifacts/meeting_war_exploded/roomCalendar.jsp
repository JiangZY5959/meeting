<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8' />
    <link href='css/bootstrap.min.css' rel='stylesheet' />
    <link href='css/fullcalendar.min.css' rel='stylesheet' />
    <link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
    <script src='js/moment.min.js'></script>
    <script src='js/jquery.min.js'></script>
    <script src='js/bootstrap.min.js'></script>
    <script src='js/fullcalendar.min.js'></script>
    <script src='js/vue.js'></script>
    <script>
        function formatNum(num) {
            return ("0" + num).slice(-2)
        }
        
        function formatDate(timestamp) {
            var date = new Date(timestamp);
            return date.getFullYear() + '-' + formatNum(date.getMonth() + 1) + '-' + formatNum(date.getDate()) + 'T' +
                formatNum(date.getHours()) + ':' + formatNum(date.getMinutes()) + ':' +formatNum(date.getSeconds())
        }

        function formatDay(timestamp) {
            var date = new Date(timestamp);
            return date.getFullYear() + '-' + formatNum(date.getMonth() + 1) + '-' + formatNum(date.getDate());
        }

        // var startDate = new Date(new Date().getTime() - 15 * 24 * 60 * 60 * 3600);
        // startDate.setHours(0);
        // startDate.setMinutes(0);
        // startDate.setSeconds(0);
        // startDate.setMilliseconds(0);
        var startDate = new Date(0);
        var endDate = new Date(new Date().getTime() + 365 * 24 * 60 * 60 * 1000);

        $(document).ready(function() {
            var vue = new Vue({
                el: '#room',
                data: {
                    selected: 0,
                    roomList: [{meetingroomId: 0, meetingroomName: "加载中..."}]
                },
                methods: {
                    onChange: function (event) {
                        updateCalender(event.target.value)
                    }
                }
            });

            var roomList = null;
            $.getJSON("/room/list", function(result){
                roomList = result.data;
                vue.roomList = roomList;
                vue.selected = roomList[0].meetingroomId;
                updateCalender(roomList[0].meetingroomId)
            });
        });

        var initFlag = false;

        function updateCalender(roomId) {
            $('#calendar').fullCalendar('removeEvents');
            $.ajax({
                dataType: "json",
                url: "/calender",
                data: {
                    "start": "" + startDate.getTime(),
                    "end": "" + endDate.getTime(),
                    "roomId": roomId
                },
                success: function(result){
                    var data = result.data;
                    var calenderData = [];
                    if (data.length < 1) {
                        alert("该会议室目前没有会议安排记录");
                        return;
                    }
                    var colors = ['#00a65a', '#0073b7', '#2c1b10', '#9013FE'];
                    for (var i = 0; i < data.length; i ++) {
                        calenderData.push({
                            "title": data[i].meetingName,
                            "start": formatDate(data[i].stratTime),
                            "end": formatDate(data[i].endTime),
                            "color": colors[i % colors.length]
                        });
                    }
                    console.log(calenderData);
                    if (!initFlag) {
                        $('#calendar').fullCalendar({
                            buttonText: {
                                today: '今天',
                                month: '月视图',
                                week: '周视图',
                                day: '日视图'
                            },
                            allDayText: "全天",
                            monthNames: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"],
                            dayNames: ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
                            header: {
                                left: 'prev,next today',
                                center: 'title',
                                right: 'month,agendaWeek,agendaDay'
                            },
                            defaultDate: formatDay(data[0].stratTime),
                            navLinks: true,
                            // editable: true,
                            eventLimit: true,
                            events: calenderData
                        });
                        initFlag = true;
                    } else {
                        $('#calendar').fullCalendar('addEventSource', calenderData);
                        $('#calendar').fullCalendar('refetchEvents');
                        $('#calendar').fullCalendar('gotoDate', formatDay(data[0].stratTime));
                    }
                }
            });
        }
    </script>
    <style>
        #calendar {
            max-width: 900px;
            margin: 0 auto;
        }

        #room {
            max-width: 900px;
            margin: 0 auto;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">会议室预定系统</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="roomCalendar.jsp">会议室安排</a></li>
            <li><a href="login.jsp">登陆</a></li>
        </ul>
    </div>
</nav>
<div id="room">
    <span>当前会议室: </span>
    <select v-model="selected" @change="onChange($event)">
        <option v-for="room in roomList" v-bind:value="room.meetingroomId">
            {{ room.meetingroomName }}
        </option>
    </select>
</div>

<div id='calendar'></div>

</body>
</html>

