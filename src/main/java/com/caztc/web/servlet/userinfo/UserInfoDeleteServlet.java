package com.caztc.web.servlet.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.UserInfo;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoDeleteServlet
 */
@WebServlet("/userInfoDeleteServlet")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");

		// ҵ���߼��ӿ�
		UserInfoService service = new UserInfoServiceImpl();

		boolean mark = service.deleteUser(userId);
		List<UserInfo> list= service.getAllUser(null);
		request.setAttribute("list", list);
		if(mark){
		
			request.setAttribute("info", "ɾ���û���Ϣ�ɹ�");
		}else{
			request.setAttribute("info", "ɾ���û���Ϣʧ��");
		}
		
		
		//ת��
		request.getRequestDispatcher("/view/userinfo/userinfo_list.jsp").forward(request, response);
				
	}

}
