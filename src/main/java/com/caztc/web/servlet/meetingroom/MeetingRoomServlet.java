package com.caztc.web.servlet.meetingroom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.EnzhequipmentInfo;
import com.caztc.domain.MeetingRoom;
import com.caztc.service.EnquipmentService;
import com.caztc.service.MeetingRoomService;
import com.caztc.service.impl.EnquipmentServiceImpl;
import com.caztc.service.impl.MeetingRoomServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomServlet
 */
@WebServlet("/meetingRoomServlet")
public class MeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 锟斤拷页锟斤拷锟饺★拷锟斤拷锟�
		MeetingRoom meetingroom = RequestBeanUtils.requestToSimpleBean(request,
				MeetingRoom.class);
		
		MeetingRoomService service = new MeetingRoomServiceImpl();
		List<MeetingRoom> list = service.getAllMeetingRoooms(meetingroom);

		if (meetingroom.getEquipmentName() != null && meetingroom.getEquipmentName() != "") {
			EnquipmentService enquipmentService = new EnquipmentServiceImpl();
			EnzhequipmentInfo enzhequipmentInfo = new EnzhequipmentInfo();
			enzhequipmentInfo.setEnzhequipmentName(meetingroom.getEquipmentName());
			Set<Integer> set = new HashSet<>();
			List<EnzhequipmentInfo> enzhequipmentInfos = enquipmentService.getAllEnzhequipmentInfo(enzhequipmentInfo);
			for (EnzhequipmentInfo info : enzhequipmentInfos) {
				set.add(info.getMeetingroomId());
			}
			List<MeetingRoom> resultlist = new ArrayList<>();
			for (MeetingRoom room : list) {
				if (set.contains(room.getMeetingroomId())) {
					resultlist.add(room);
				}
			}
			request.setAttribute("list", resultlist);
		} else {
			request.setAttribute("list", list);
		}
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_main.jsp").forward(request, response);
	}

}
