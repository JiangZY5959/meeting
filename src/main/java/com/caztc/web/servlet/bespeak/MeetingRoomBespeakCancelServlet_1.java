package com.caztc.web.servlet.bespeak;

import com.caztc.domain.MeetingroomBespeak;
import com.caztc.domain.UserInfo;
import com.caztc.service.BespeakService;
import com.caztc.service.impl.BespeakServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author narata
 * @since 2019/03/27
 */
@WebServlet("/cancelBespeak_1")
public class MeetingRoomBespeakCancelServlet_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bespeakId = request.getParameter("bespeakId");
        BespeakService service = new BespeakServiceImpl();
        String info = "";
        if (service.delMeetingRoomBespeak(bespeakId)) {
            info += "ȡ��ԤԼ�ɹ�";
            if (service.sendMail(bespeakId)) {
                info += ";�ʼ����ͳɹ���";
            } else {
                info += ";�ʼ�����ʧ�ܣ�";
            }
        } else {
            info += "ȡ��ԤԼʧ��";
        }

        request.setAttribute("info", info);

        //��ȡҳ������
        MeetingroomBespeak meetingroomBeapeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomBespeak.class);

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

        request.getRequestDispatcher("/view/bespeak/mymeetingroom_bespeak_query.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
