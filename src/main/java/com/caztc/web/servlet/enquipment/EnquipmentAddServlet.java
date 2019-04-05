package com.caztc.web.servlet.enquipment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caztc.domain.EnzhequipmentInfo;
import com.caztc.domain.UserInfo;
import com.caztc.service.EnquipmentService;
import com.caztc.service.impl.EnquipmentServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class EnquipmentAddServlet
 */
@WebServlet("/enquipmentAddServlet")
public class EnquipmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquipmentAddServlet() {
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

		// ��ȡҳ������
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(
				request, EnzhequipmentInfo.class);

		// ҵ���߼�����
		EnquipmentService service = new EnquipmentServiceImpl();

		// ��session�л�ȡ��ǰ��¼�û���Ϣ
		HttpSession session = request.getSession();
		UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");

		// ��ȡ�ɹ�ʱ��
		String procurementDateTime = request
				.getParameter("procurementDateTime");

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(procurementDateTime);
			if (eninfo != null) {
				eninfo.setProcurementTime(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (eninfo != null && userinfo != null) {
			eninfo.setUserId(userinfo.getUserId());
		}

		boolean mark = service.addEnquipment(eninfo);

		if (mark) {
			request.setAttribute("info", "����豸��Ϣ�ɹ�");
		} else {
			request.setAttribute("info", "����豸��Ϣʧ��");
		}

		// ת��
		request.getRequestDispatcher(
				"/view/enzhequipment/enzhequipment_add.jsp").forward(request,
				response);
	}

}
