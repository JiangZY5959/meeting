package com.caztc.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.caztc.domain.UserInfo;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.UserInfoServiceImpl;
import com.caztc.utils.Md5Util;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/userInfoUpdateServlet")
@MultipartConfig
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoUpdateServlet() {
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

		System.out.println(userId);

		// ҵ���߼�����
		UserInfoService service = new UserInfoServiceImpl();
		UserInfo user = service.getUser(userId);

		request.setAttribute("user", user);

		request.getRequestDispatcher("/view/userinfo/userinfo_update.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {


		// ��request�����ݴ˴��UserInfo��������
		UserInfo userinfo = RequestBeanUtils.requestToSimpleBean(request,
				UserInfo.class);
		System.out.println(userinfo.toString());

		// ҵ���߼�����
		UserInfoService service = new UserInfoServiceImpl();
		
		Part part = request.getPart("userUrl");
	

		String root = request.getServletContext().getRealPath("//upload");

		String name = part.getHeader("content-disposition");

		if (name.lastIndexOf(".") != -1) {
			String ext = name.substring(name.lastIndexOf("."),
					name.length() - 1);

			String url = root + "//" + userinfo.getUserId() + ext;
			userinfo.setUserUrl("upload//" + userinfo.getUserId() + ext);

			part.write(url);
		}
		if (userinfo.getUserPw() != null && !userinfo.getUserPw().equals("")){
			userinfo.setUserPw(Md5Util.generate(userinfo.getUserPw()));
		}
		boolean mark = service.updateUser(userinfo);
		
		if(mark){
			UserInfo user = service.getUser(userinfo.getUserId());

			request.setAttribute("user", user);
			request.setAttribute("info", "�޸��û���Ϣ�ɹ�");
		}else{
			request.setAttribute("info", "�޸��û���Ϣʧ��");
		}
		
		request.getRequestDispatcher("/view/userinfo/userinfo_update.jsp")
		.forward(request, response);

	}

}
