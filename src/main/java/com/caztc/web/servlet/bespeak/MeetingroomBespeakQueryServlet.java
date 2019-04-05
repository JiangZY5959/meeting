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
 * Servlet implementation class MeetingroomBespeakQueryServlet
 */
@WebServlet("/meetingroomBespeakQueryServlet")
public class MeetingroomBespeakQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakQueryServlet() {
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
		MeetingroomBespeak bespeak = RequestBeanUtils.requestToSimpleBean(
				request, MeetingroomBespeak.class);

		// ҵ��
		BespeakService bespeakService = new BespeakServiceImpl();



		List<MeetingroomBespeak> list = bespeakService
				.getAllMeetingroomBespeak(bespeak);
		
		for(MeetingroomBespeak mb:list){
			if("0".equals(mb.getBespeakState())){
				mb.setBespeakState("<a href='bespeakAuditingServlet?bespeakId="+mb.getBespeakId()+"'>δ���</a>");
			}
			if("1".equals(mb.getBespeakState())){
				mb.setBespeakState("ͨ��");
			}
			if("2".equals(mb.getBespeakState())){
				mb.setBespeakState("��ͨ��");
			}
		}

		request.setAttribute("list", list);

		request.getRequestDispatcher(
				"/view/bespeak/meetingroom_bespeak_query.jsp").forward(
				request, response);
	}

}
