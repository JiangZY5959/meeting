package com.caztc.web.servlet;

import com.caztc.domain.Feedback;
import com.caztc.service.FeedbackService;
import com.caztc.service.impl.FeedbackServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author narata
 * @since 2019/03/27
 */

@WebServlet("/listFeedback")
public class FeedbackListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackService feedbackService = new FeedbackServiceImpl();
        List<Feedback> list = feedbackService.list();

        req.setAttribute("list", list);

        req.getRequestDispatcher("/view/feedback/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
