package com.caztc.web.servlet.notice;

import com.caztc.domain.Notice;
import com.caztc.service.NoticeService;
import com.caztc.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author narata
 * @since 2019/03/31
 */

@WebServlet("/noticeListServlet")
public class NoticeListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService noticeService = new NoticeServiceImpl();
        List<Notice> list = noticeService.list();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (Notice notice: list
        ) {
            notice.setFormatTime(sdf.format(notice.getCreateTime()));
        }
        req.setAttribute("notice_list", list);
        req.getRequestDispatcher("/view/notice/notice_list.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
