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
		//删除当前用户登录信息
		session.removeAttribute("userinfo");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//业务逻辑层
		UserInfoService service = new UserInfoServiceImpl();

		
		//获取账号密码
		String userId = request.getParameter("userId");
		String passWord = request.getParameter("passWord");

		UserInfo user = service.getUser(userId);
		if (user != null && Md5Util.verify(passWord, user.getUserPw())) {
			if ("启用".equals(user.getUserState())) {
				//获取session
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
				//转发
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				request.setAttribute("info", "此账号已被停用，请联系管理员解决");
				//转发
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} else{
			
			request.setAttribute("info", "账号或密码错误！请重新输入");
			//转发
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
