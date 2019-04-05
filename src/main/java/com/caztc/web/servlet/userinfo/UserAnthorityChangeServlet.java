package com.caztc.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.UserInfo;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class UserAnthorityChangeServlet
 */
@WebServlet("/userAnthorityChangeServlet")
public class UserAnthorityChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAnthorityChangeServlet() {
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

		request.getRequestDispatcher("/view/userinfo/userinfo_anthority_change.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û���Ϣ
		UserInfo userinfo = RequestBeanUtils.requestToSimpleBean(request, UserInfo.class);
		// ҵ���߼�����
		UserInfoService service = new UserInfoServiceImpl();
		boolean mark = service.anthorityChange(userinfo);
		
		if(mark){
			request.setAttribute("info", "���Ȩ�޳ɹ�");
		}else{
			request.setAttribute("info", "���Ȩ��ʧ��");
		}
		UserInfo user = service.getUser(userinfo.getUserId());

		request.setAttribute("user", user);

		request.getRequestDispatcher("/view/userinfo/userinfo_anthority_change.jsp")
				.forward(request, response);
	}

}
