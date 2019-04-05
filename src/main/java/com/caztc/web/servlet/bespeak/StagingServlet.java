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

/**
 * Servlet implementation class StagingServlet
 */
@WebServlet("/stagingServlet")
public class StagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StagingServlet() {
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

		// ��ȡ��ǰ��¼�û���Ϣ
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("userinfo");

		BespeakService bespeakService = new BespeakServiceImpl();

		// ��ѯԤԼ�����ң�δ��ˣ�
		MeetingroomBespeak meetbe = new MeetingroomBespeak();
		meetbe.setUserId(user.getUserId());
		meetbe.setBespeakState("0");
		List<MeetingroomBespeak> mylist = bespeakService
				.getAllMeetingroomBespeak(meetbe);
		request.setAttribute("mylist", mylist);

		// ��ѯԤԼ�����ң����ͨ����
		MeetingroomBespeak meetbe1 = new MeetingroomBespeak();
		meetbe1.setUserId(user.getUserId());
		meetbe1.setBespeakState("1");
		List<MeetingroomBespeak> myyeslist = bespeakService
				.getAllMeetingroomBespeak(meetbe1);
		request.setAttribute("myyeslist", myyeslist);

		// ��ѯԤԼ�����ң����δͨ����
		MeetingroomBespeak meetbe2 = new MeetingroomBespeak();
		meetbe2.setUserId(user.getUserId());
		meetbe2.setBespeakState("2");
		List<MeetingroomBespeak> mynolist = bespeakService
				.getAllMeetingroomBespeak(meetbe2);
		request.setAttribute("mynolist", mynolist);

		// ��ѯԤԼ�����ң���ѯδ��ˣ�
		MeetingroomBespeak meetbe3 = new MeetingroomBespeak();
		// meetbe2.setUserId(user.getUserId());
		meetbe3.setBespeakState("0");
		List<MeetingroomBespeak> noaanditlist = bespeakService
				.getAllMeetingroomBespeak(meetbe3);
		request.setAttribute("noaanditlist", noaanditlist);

		// ��ѯԤԼ�����ң���ѯ�Ѿ���ˣ�
		MeetingroomBespeak meetbe4 = new MeetingroomBespeak();
		meetbe4.setUseUserId(user.getUserId());
		meetbe4.setMark("-1");
		List<MeetingroomBespeak> yesaanditlist = bespeakService
				.getAllMeetingroomBespeak(meetbe4);
		request.setAttribute("yesaanditlist", yesaanditlist);

		request.getRequestDispatcher("/staging.jsp").forward(request, response);

	}

}
