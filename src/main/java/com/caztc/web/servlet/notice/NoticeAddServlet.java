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
import java.util.Date;

/**
 * @author narata
 * @since 2019/03/31
 */

@WebServlet("/noticeAdd")
public class NoticeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String data = req.getParameter("data");
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setData(data);
        notice.setCreateTime(new Date());

        NoticeService service = new NoticeServiceImpl();
        if (service.add(notice)) {
            req.setAttribute("info", "Add success");
        } else {
            req.setAttribute("info", "Add failed");
        }
        req.getRequestDispatcher("/view/notice/notice_add.jsp")
                .forward(req, resp);
    }
}
