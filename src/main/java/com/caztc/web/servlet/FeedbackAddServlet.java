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

/**
 * @author narata
 * @since 2019/03/27
 */
@WebServlet("/feedbackAdd")
public class FeedbackAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Feedback feedback = new Feedback();
        feedback.setSubject(req.getParameter("subject"));
        feedback.setName(req.getParameter("name"));
        feedback.setPhone(req.getParameter("phone"));
        feedback.setDescription(req.getParameter("description"));

        String info = "";

        FeedbackService feedbackService = new FeedbackServiceImpl();
        if (feedbackService.add(feedback)) {
            info += "反馈成功";
            if (feedbackService.sendmail(feedback)) {
                info += ";已通知管理员！";
            } else {
                info += ";通知管理员失败！";
            }
        } else {
            info += "反馈失败";
        }
        req.setAttribute("feedbackInfo", info);

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
