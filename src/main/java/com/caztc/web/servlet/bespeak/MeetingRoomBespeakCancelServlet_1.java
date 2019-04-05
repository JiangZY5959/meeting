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
            info += "取消预约成功";
            if (service.sendMail(bespeakId)) {
                info += ";邮件发送成功！";
            } else {
                info += ";邮件发送失败！";
            }
        } else {
            info += "取消预约失败";
        }

        request.setAttribute("info", info);

        //获取页面数据
        MeetingroomBespeak meetingroomBeapeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomBespeak.class);

        //获取当前登录用户信息
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("userinfo");

        if(meetingroomBeapeak == null ){
            meetingroomBeapeak = new MeetingroomBespeak();
        }
        meetingroomBeapeak.setUserId(userInfo.getUserId());
        meetingroomBeapeak.setBespeakState("0");
        //查询
        List<MeetingroomBespeak> list = service.getAllMeetingroomBespeak(meetingroomBeapeak);

        request.setAttribute("list", list);

        request.getRequestDispatcher("/view/bespeak/mymeetingroom_bespeak_query.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
