package com.caztc.web.servlet.enquipment;

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
 * Servlet implementation class EnquipmentListServlet
 */
@WebServlet("/enquipmentListServlet")
public class EnquipmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(request, EnzhequipmentInfo.class);
		
		//�豸��Ϣ����ҵ���߼������
		EnquipmentService service = new EnquipmentServiceImpl();
		
		List<EnzhequipmentInfo> list = service.selectEnquipmentInfo(eninfo);
		
		request.setAttribute("list", list);
		
		
		
		//�����ҹ����ҵ���߼�������
		MeetingRoomService meetservice = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetroomlist = meetservice.getAllMeetingRoooms(null);
		request.setAttribute("meetroomlist", meetroomlist);
		
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_list.jsp").forward(request, response);
		
		
	}

}
