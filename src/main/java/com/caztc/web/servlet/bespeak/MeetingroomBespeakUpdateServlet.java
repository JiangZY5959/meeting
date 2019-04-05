package com.caztc.web.servlet.bespeak;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.MeetingRoom;
import com.caztc.domain.MeetingUserinfo;
import com.caztc.domain.MeetingroomBespeak;
import com.caztc.domain.UserInfo;
import com.caztc.service.BespeakService;
import com.caztc.service.MeetingRoomService;
import com.caztc.service.MeetingUserinfoService;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.caztc.service.impl.MeetingRoomServiceImpl;
import com.caztc.service.impl.MeetingUserinfoServiceImpl;
import com.caztc.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomBespeakUpdateServlet
 */
@WebServlet("/meetingroomBespeakUpdateServlet")
public class MeetingroomBespeakUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingroomBespeakUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 锟斤拷取预约锟斤拷锟斤拷锟揭憋拷锟�
		String bespeakId = request.getParameter("bespeakId");
		System.out.println("锟斤拷锟�" + bespeakId);

		// 预约锟斤拷锟斤拷锟斤拷锟斤拷息
		BespeakService service = new BespeakServiceImpl();
		MeetingroomBespeak bespeak = service.getMeetingroomBespeak(bespeakId);
		request.setAttribute("bespeak", bespeak);

		// 锟斤拷锟斤拷锟斤拷锟斤拷息
		MeetingRoomService meetservice = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetingroomlist = meetservice
				.getAllMeetingRoooms(null);
		request.setAttribute("meetingroomlist", meetingroomlist);

		// 锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷员
		UserInfoService userService = new UserInfoServiceImpl();
		UserInfo user = new UserInfo();
		user.setBespeakId(bespeakId);
		List<UserInfo> userlist = userService.getAllUser(user);
		request.setAttribute("userlist", userlist);

		// 锟斤拷锟斤拷渭踊锟斤拷锟斤拷锟皆�
		MeetingUserinfoService muservice = new MeetingUserinfoServiceImpl();
		MeetingUserinfo mu = new MeetingUserinfo();
		mu.setBespeakId(bespeakId);
		List<MeetingUserinfo> mulist = muservice.getAllMeetingUserinfo(mu);
		request.setAttribute("mulist", mulist);

		request.getRequestDispatcher(
				"/view/bespeak/meetingroom_bespeak_update.jsp").forward(
				request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//锟斤拷取页锟斤拷锟斤拷息
		MeetingroomBespeak bespeak = RequestBeanUtils.requestToSimpleBean(
				request, MeetingroomBespeak.class);
		
		//锟斤拷锟斤拷渭锟斤拷锟皆憋拷撕锟�
		String userIds = request.getParameter("userIds");
		
		//锟斤拷取时锟斤拷
		String stratTimestr = request.getParameter("stratTimestr");
		String endTimestr = request.getParameter("endTimestr");
		
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			bespeak.setStratTime(sdf.parse(stratTimestr));
			bespeak.setEndTime(sdf.parse(endTimestr));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//业锟斤拷锟竭硷拷锟斤拷
		BespeakService service =  new BespeakServiceImpl();
		
		boolean mark = service.updateMeetingroomBespeak(bespeak, userIds);

		if(mark){
			request.setAttribute("info", "预约锟斤拷锟斤拷锟斤拷锟睫改成癸拷");
		}else{
			request.setAttribute("info", "预约锟斤拷锟斤拷锟斤拷锟睫革拷失锟斤拷");
		}
		doGet(request, response);

	}

}
