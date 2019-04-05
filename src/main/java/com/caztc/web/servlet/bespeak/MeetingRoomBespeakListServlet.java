package com.caztc.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caztc.domain.MeetingroomBespeak;
import com.caztc.domain.UserInfo;
import com.caztc.service.BespeakService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomBespeakListServlet
 */
@WebServlet("/meetingRoomBespeakListServlet")
public class MeetingRoomBespeakListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomBespeakListServlet() {
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
		//��ȡҳ������
		MeetingroomBespeak meetingroomBeapeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomBespeak.class);
	
		//ҵ��
		BespeakService service = new BespeakServiceImpl();
		
		//��ȡ��ǰ��¼�û���Ϣ
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userinfo");
		
		if(meetingroomBeapeak == null ){
			meetingroomBeapeak = new MeetingroomBespeak();
		}
		meetingroomBeapeak.setUserId(userInfo.getUserId());
		meetingroomBeapeak.setBespeakState("0");
		//��ѯ
		List<MeetingroomBespeak> list = service.getAllMeetingroomBespeak(meetingroomBeapeak);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak_list.jsp").forward(request, response);
		
	}

}
