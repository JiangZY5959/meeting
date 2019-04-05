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
 * Servlet implementation class UserInfoQueryServlet
 */
@WebServlet("/userInfoQueryServlet")
public class UserInfoQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ������
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userDepartment = request.getParameter("userDepartment");
		
		//�����ݷŵ�UserInfo������
		UserInfo user = new UserInfo();
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setUserDepartment(userDepartment);
		
		//ҵ���߼�����
		UserInfoService service = new UserInfoServiceImpl();
		List<UserInfo> list= service.getAllUser(user);
	
		
		
		
		request.setAttribute("list", list);
		
		//ת��
		request.getRequestDispatcher("/view/userinfo/userinfo_query.jsp").forward(request, response);
		
	}

}
