package com.caztc.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.MeetingUserinfo;
import com.caztc.domain.MeetingroomBespeak;
import com.caztc.service.BespeakService;
import com.caztc.service.MeetingUserinfoService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.caztc.service.impl.MeetingUserinfoServiceImpl;

/**
 * Servlet implementation class MymeetingroomBespeakShowServlet
 */
@WebServlet("/mymeetingroomBespeakShowServlet")
public class MymeetingroomBespeakShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymeetingroomBespeakShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 锟斤拷取预约锟斤拷锟斤拷锟揭憋拷锟�
		String bespeakId = request.getParameter("bespeakId");
		System.out.println("锟斤拷锟�" + bespeakId);
		
		// 预约锟斤拷锟斤拷锟斤拷锟斤拷息
		BespeakService service = new BespeakServiceImpl();
		MeetingroomBespeak bespeak = service.getMeetingroomBespeak(bespeakId);
		request.setAttribute("bespeak", bespeak);
		
		
		// 锟斤拷锟斤拷渭踊锟斤拷锟斤拷锟皆�
		MeetingUserinfoService muservice = new MeetingUserinfoServiceImpl();
		MeetingUserinfo mu = new MeetingUserinfo();
		mu.setBespeakId(bespeakId);
		List<MeetingUserinfo> mulist = muservice.getAllMeetingUserinfo(mu);
		request.setAttribute("mulist", mulist);
		
		request.getRequestDispatcher(
				"/view/bespeak/mymeetingroom_bespeak_show.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
