package com.caztc.web.servlet.meetingroom;

import com.caztc.domain.EnzhequipmentInfo;
import com.caztc.domain.MeetingRoom;
import com.caztc.service.EnquipmentService;
import com.caztc.service.MeetingRoomService;
import com.caztc.service.impl.EnquipmentServiceImpl;
import com.caztc.service.impl.MeetingRoomServiceImpl;
import com.sun.net.httpserver.HttpServer;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author narata
 * @since 2019/03/31
 */

@WebServlet("/meetingRoomUseStateChangeServlet")
public class MeetingRoomUseStateChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String meetingroomId = req.getParameter("meetingroomId");
        MeetingRoomService service = new MeetingRoomServiceImpl();
        MeetingRoom meetingRoom = service.getMeetingRoom(meetingroomId);
        if ("enable".equals(meetingRoom.getMeetingRoomUseState())) {
            meetingRoom.setMeetingRoomUseState("disable");
        } else {
            meetingRoom.setMeetingRoomUseState("enable");
        }
        service.updatemeetingRoom(meetingRoom, null);

        List<MeetingRoom> list = service.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/view/meetingroom/meetingroom_main.jsp").forward(req, resp);
    }
}
