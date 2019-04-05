package com.caztc.web.servlet.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.Notice;
import com.caztc.domain.UserInfo;
import com.caztc.service.NoticeService;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.NoticeServiceImpl;
import com.caztc.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoShowServlet
 */
@WebServlet("/userInfoShowServlet")
public class UserInfoShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		// ҵ���߼�����
		UserInfoService service = new UserInfoServiceImpl();
		UserInfo user = service.getUser(userId);
		request.setAttribute("user", user);


		request.getRequestDispatcher("/view/userinfo/userinfo_show.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
