package com.caztc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.caztc.domain.UserInfo;

/**
 * ��ֹ�Ƿ���¼
 * @author 
 *
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {

		// ��ServletRequest ת��ΪHttpServletRequest
		HttpServletRequest httprequest = (HttpServletRequest) request;

		// ��ȡsession
		HttpSession seesion = httprequest.getSession();
		UserInfo user = (UserInfo) seesion.getAttribute("userinfo");

		// ��ȡurl
		String url = httprequest.getRequestURI();
		if (url.contains("/assets/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/css/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/font/")) {
			fc.doFilter(request, response);
		}else if (url.contains("/login.jsp")) {
			fc.doFilter(request, response);
		} else if (url.contains("/feedback.jsp")) {
			fc.doFilter(request, response);
		} else if (url.contains("/images/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/js/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/loginServlet")) {
			fc.doFilter(request, response);
		}  else if (url.contains("/feedbackAdd")) {
			fc.doFilter(request, response);
		} else if (url.contains("/roomCalendar.jsp")) {
			fc.doFilter(request, response);
		} else if (url.contains("/calender")) {
			fc.doFilter(request, response);
		} else if (url.contains("/room/list")) {
			fc.doFilter(request, response);
			// �ж�session ������û��Ƿ����
		} else if (user != null) {
			fc.doFilter(request, response);
		} else {
			httprequest.getRequestDispatcher("/login_info.jsp").forward(httprequest,
					response);

		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		//System.out.println("-----��ʼ��������----");
	}

}
