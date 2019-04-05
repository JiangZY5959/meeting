package com.caztc.web.servlet.meetingroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.MeetingRoom;
import com.caztc.service.MeetingRoomService;
import com.caztc.service.impl.MeetingRoomServiceImpl;

/**
 * Servlet implementation class CheckMeetingRoomIdServlet
 */
@WebServlet("/checkMeetingRoomIdServlet")
public class CheckMeetingRoomIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMeetingRoomIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ұ��
		String meetingroomId = request.getParameter("meetingroomId");
		
		//ҵ���߼�����
		MeetingRoomService service = new MeetingRoomServiceImpl();
		
		MeetingRoom meetingroom = service.getMeetingRoom(meetingroomId);
		
		//��Ӧ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		if(meetingroom!=null){
			out.println("<font size='2' style='color: red;'>����Ѿ����ڣ�������������</font>");
		}else{
			out.println("<font size='2' style='color: green;'>��ϲ������ſ���ʹ��</font>");
		}
		
		out.flush();
		out.close();

	}

}
