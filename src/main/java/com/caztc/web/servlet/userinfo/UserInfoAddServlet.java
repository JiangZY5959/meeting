package com.caztc.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.caztc.domain.UserInfo;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.UserInfoServiceImpl;
import com.caztc.utils.Md5Util;

/**
 * Servlet implementation class UserInfoAddServlet
 */
@WebServlet("/userinfoadd")
@MultipartConfig
public class UserInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String userUrl = request.getParameter("userUrl");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");

		String userSex = request.getParameter("userSex");
		String userAge = request.getParameter("userAge");
		String userPhone = request.getParameter("userPhone");
		String userBeizhu = request.getParameter("userBeizhu");
		String userDepartment = request.getParameter("userDepartment");
		String userMail = request.getParameter("userMail");

		UserInfo user = new UserInfo();
		user.setUserId(userId);
		user.setUserPw(Md5Util.generate(userPw));
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setUserMail(userMail);
		user.setUserDepartment(userDepartment);

		try {
			if (userAge != null && !"".equals(userAge)) {
				user.setUserAge(Integer.parseInt(userAge));
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (userPhone != null && !"".equals(userPhone)) {
				user.setUserPhone(Integer.parseInt(userPhone));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		user.setUserBeizhu(userBeizhu);
		
		System.out.println(user);

		Part part = request.getPart("userUrl");
		System.out.println(part.getName());

		String root = request.getServletContext().getRealPath("//upload");

		String name = part.getHeader("content-disposition");

		if (name.lastIndexOf(".") != -1) {
			String ext = name.substring(name.lastIndexOf("."),
					name.length() - 1);

			String url = root + "//" + userId + ext;
			user.setUserUrl("upload//" + userId + ext);

			part.write(url);
		}
		UserInfoService service = new UserInfoServiceImpl();

		boolean mark = service.add(user);

		if (mark) {
			request.setAttribute("info", "����û���Ϣ�ɹ�");
		} else {
			request.setAttribute("info", "����û���Ϣʧ��");
		}

		request.getRequestDispatcher("/view/userinfo/userinfo_add.jsp")
				.forward(request, response);

	}
}
