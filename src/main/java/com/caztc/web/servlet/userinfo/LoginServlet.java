package com.caztc.web.servlet.userinfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caztc.domain.Notice;
import com.caztc.domain.UserInfo;
import com.caztc.service.NoticeService;
import com.caztc.service.UserInfoService;
import com.caztc.service.impl.NoticeServiceImpl;
import com.caztc.service.impl.UserInfoServiceImpl;
import com.caztc.utils.Md5Util;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//ɾ����ǰ�û���¼��Ϣ
		session.removeAttribute("userinfo");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ҵ���߼���
		UserInfoService service = new UserInfoServiceImpl();

		
		//��ȡ�˺�����
		String userId = request.getParameter("userId");
		String passWord = request.getParameter("passWord");

		UserInfo user = service.getUser(userId);
		if (user != null && Md5Util.verify(passWord, user.getUserPw())) {
			if ("����".equals(user.getUserState())) {
				//��ȡsession
				HttpSession session = request.getSession();
				NoticeService noticeService = new NoticeServiceImpl();
				List<Notice> list = noticeService.list();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				for (Notice notice: list
					 ) {
					notice.setFormatTime(sdf.format(notice.getCreateTime()));
				}
				session.setAttribute("notice_list", list);

				session.setAttribute("userinfo", user);
				//ת��
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				request.setAttribute("info", "���˺��ѱ�ͣ�ã�����ϵ����Ա���");
				//ת��
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} else{
			
			request.setAttribute("info", "�˺Ż������������������");
			//ת��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
