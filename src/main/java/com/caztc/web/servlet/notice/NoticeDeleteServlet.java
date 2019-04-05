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
import java.util.List;

/**
 * @author narata
 * @since 2019/03/31
 */

@WebServlet("/noticeDeleteServlet")
public class NoticeDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        NoticeService noticeService = new NoticeServiceImpl();
        if (noticeService.delete(id)) {
            req.setAttribute("info", "Delete success");
        } else {
            req.setAttribute("info", "Delete failed");
        }
        List<Notice> list = noticeService.list();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/view/notice/notice_list.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
