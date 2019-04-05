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
 * Servlet implementation class EnquipmentUpdateServlet
 */
@WebServlet("/enquipmentUpdateServlet")
public class EnquipmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enzhequipmentId = request.getParameter("enzhequipmentId");
		
		//ҵ��
		EnquipmentService service = new EnquipmentServiceImpl();
		
		EnzhequipmentInfo eninfo = service.getEnzhequipmentInfo(enzhequipmentId);
		
		request.setAttribute("eninfo", eninfo);
		
		//ת��
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_update.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡҳ������
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(
				request, EnzhequipmentInfo.class);

		// ҵ���߼�����
		EnquipmentService service = new EnquipmentServiceImpl();

		boolean mark = service.updateEnzhequipmentInfo(eninfo);

		//��ѯ�豸��Ϣ
		EnzhequipmentInfo eninfoss = service.getEnzhequipmentInfo(eninfo.getEnzhequipmentId()+"");
		request.setAttribute("eninfo", eninfoss);
		if (mark) {
			request.setAttribute("info", "�޸��豸��Ϣ�ɹ�");
		} else {
			request.setAttribute("info", "�޸��豸��Ϣʧ��");
		}

		// ת��
		request.getRequestDispatcher(
				"/view/enzhequipment/enzhequipment_update.jsp").forward(request,
				response);
	}

}
