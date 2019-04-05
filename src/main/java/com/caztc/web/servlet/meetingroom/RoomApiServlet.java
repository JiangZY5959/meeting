package com.caztc.web.servlet.meetingroom;

import com.caztc.bean.Response;
import com.caztc.domain.MeetingRoom;
import com.caztc.domain.MeetingroomBespeak;
import com.caztc.service.BespeakService;
import com.caztc.service.MeetingRoomService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.caztc.service.impl.MeetingRoomServiceImpl;
import com.caztc.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class BespeakAuditingServlet
 */
@WebServlet("/room/list")
public class RoomApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final MeetingRoomService service = new MeetingRoomServiceImpl();
	private static final ObjectMapper mapper = new ObjectMapper();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomApiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<MeetingRoom> data = service.findAll();
		JsonUtil.writeJsonToResponse(response, Response.createSuccessResponse(data));
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
