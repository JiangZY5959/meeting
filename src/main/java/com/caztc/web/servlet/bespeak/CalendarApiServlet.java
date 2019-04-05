package com.caztc.web.servlet.bespeak;

import com.caztc.bean.Response;
import com.caztc.domain.MeetingUserinfo;
import com.caztc.domain.MeetingroomBespeak;
import com.caztc.domain.UserInfo;
import com.caztc.service.BespeakService;
import com.caztc.service.MeetingUserinfoService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.caztc.service.impl.MeetingUserinfoServiceImpl;
import com.caztc.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class BespeakAuditingServlet
 */
@WebServlet("/calender")
public class CalendarApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final BespeakService service = new BespeakServiceImpl();
	private static final ObjectMapper mapper = new ObjectMapper();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarApiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String startDateStr = request.getParameter("start");
		String endDateStr = request.getParameter("end");
		String roomIdStr = request.getParameter("roomId");
		if (startDateStr != null && endDateStr != null && roomIdStr != null) {
			Date start = new Date(Long.parseLong(startDateStr));
			Date end = new Date(Long.parseLong(endDateStr));
			Integer roomId = Integer.parseInt(roomIdStr);
			List<MeetingroomBespeak> data =
					service.findAllByStartTimeAfterAndEndTimeBeforeAndRoomId(start, end, roomId);
			JsonUtil.writeJsonToResponse(response, Response.createSuccessResponse(data));
			return;
		}
		JsonUtil.writeJsonToResponse(response, new Response<>(-1, "error", null));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
