package com.caztc.web.servlet.bespeak;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caztc.domain.MeetingRoom;
import com.caztc.domain.MeetingUserinfo;
import com.caztc.domain.MeetingroomBespeak;
import com.caztc.domain.UserInfo;
import com.caztc.mapper.MeetingRoomMapper;
import com.caztc.mapper.UserInfoMapper;
import com.caztc.service.BespeakService;
import com.caztc.service.MailService;
import com.caztc.service.MeetingUserinfoService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.caztc.service.impl.MailServiceImpl;
import com.caztc.service.impl.MeetingUserinfoServiceImpl;
import com.caztc.utils.DBFactoryUtils;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class BespeakAuditingServlet
 */
@WebServlet("/bespeakAuditingServlet")
public class BespeakAuditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final UserInfoMapper userMapper = DBFactoryUtils.getMapper(UserInfoMapper.class);
    private static final MailService mailService = new MailServiceImpl();
    private static final MeetingRoomMapper roomMapper = DBFactoryUtils.getMapper(MeetingRoomMapper.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BespeakAuditingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ԤԼ���
		String bespeakId = request.getParameter("bespeakId");

		// ������ԤԼ��service
		BespeakService bespeakService = new BespeakServiceImpl();
		MeetingroomBespeak bespeak = bespeakService
				.getMeetingroomBespeak(bespeakId);
		request.setAttribute("bespeak", bespeak);

		// ����μӻ�����Ա
		MeetingUserinfoService muservice = new MeetingUserinfoServiceImpl();
		MeetingUserinfo mu = new MeetingUserinfo();
		mu.setBespeakId(bespeakId);
		List<MeetingUserinfo> mulist = muservice.getAllMeetingUserinfo(mu);
		request.setAttribute("mulist", mulist);

		request.getRequestDispatcher("/view/bespeak/bespeak_auditing.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ҳ���ȡ����
		MeetingroomBespeak bespeak = RequestBeanUtils.requestToSimpleBean(
				request, MeetingroomBespeak.class);

		// ��ȡ��ǰ�û���Ϣ �������
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("userinfo");

		if (user != null && user.getUserId() != null) {
			// �����������Ϣ
			bespeak.setUseUserId(user.getUserId());
			bespeak.setAuditingTime(new Date());
		}

		System.out.println(bespeak);

		// ҵ���߼�
		BespeakService bespeakService = new BespeakServiceImpl();

		boolean mark = bespeakService.updateMeetingroomBespeak(bespeak);

		if (mark) {
			request.setAttribute("info", "�����ɹ�");
            MeetingroomBespeak meetingroomBespeak = bespeakService.getMeetingroomBespeak(bespeak.getBespeakId());
            UserInfo userInfo = userMapper.getUserInfo(meetingroomBespeak.getUserId());
            MeetingRoom meetingRoom = roomMapper.getMeetingRoom(meetingroomBespeak.getMeetingroomId());
			SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��hhʱmm��ss��");
            String content = String.format("������� %s ʹ�� %s %s��",
                    format.format(meetingroomBespeak.getStratTime()),
                    meetingRoom.getMeetingroomName(),
                    Objects.equals(meetingroomBespeak.getBespeakState(), "1") ? "��ͨ��" : "���ܾ�");
            try {
                mailService.sendMail("�µ�ԤԼ��˽��", content, userInfo.getUserMail());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
			request.setAttribute("info", "����ʧ��");
		}

	
		MeetingroomBespeak 	bespeaks = new MeetingroomBespeak();
		//��ѯδ���״̬
		bespeaks.setBespeakState("0");
		
		List<MeetingroomBespeak> list = bespeakService.getAllMeetingroomBespeak(bespeaks);
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher(
				"/view/bespeak/meetingroom_bespeak_auditing.jsp").forward(
				request, response);

	}

}
