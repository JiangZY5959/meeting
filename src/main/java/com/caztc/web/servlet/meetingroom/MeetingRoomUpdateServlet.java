package com.caztc.web.servlet.meetingroom;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class MeetingRoomUpdateServlet
 */
@WebServlet("/meetingRoomUpdateServlet")
public class MeetingRoomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// �����ұ��
		String meetingroomId = request.getParameter("meetingroomId");

		// ҵ���߼�����
		MeetingRoomService service = new MeetingRoomServiceImpl();

		MeetingRoom meetingroom = service.getMeetingRoom(meetingroomId);

		request.setAttribute("meetingroom", meetingroom);

		// �豸��Ϣ��ҵ����ʵ����
		EnquipmentService enservice = new EnquipmentServiceImpl();
		EnzhequipmentInfo info = new EnzhequipmentInfo();
		info.setMeetingroomId(Integer.parseInt(meetingroomId));
		List<EnzhequipmentInfo> enlist = enservice.selectEnquipmentInfo(info);

		List<EnzhequipmentInfo> list = enservice.queryEnzhequipmentInfo();

		request.setAttribute("eninfolist", list);

		request.setAttribute("enlist", enlist);

		request.getRequestDispatcher("/view/meetingroom/meetingroom_update.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��û�������Ϣ
		MeetingRoom meetingroom = RequestBeanUtils.requestToSimpleBean(request,
				MeetingRoom.class);
		
		//�豸�����Ϣ
		String enzhequipmentIds = request.getParameter("enzhequipmentIds");
				
		MeetingRoomService service = new MeetingRoomServiceImpl();
		boolean mark = service.updatemeetingRoom(meetingroom, enzhequipmentIds);
		
		if(mark){
			request.setAttribute("info", "��������Ϣ�޸ĳɹ�");
		}else{
			request.setAttribute("info", "��������Ϣ�޸�ʧ��");
		}
		
		doGet(request, response);
		
	}

}
