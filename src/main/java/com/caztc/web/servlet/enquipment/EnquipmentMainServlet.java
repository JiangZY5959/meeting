package com.caztc.web.servlet.enquipment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caztc.domain.EnzhequipmentInfo;
import com.caztc.service.EnquipmentService;
import com.caztc.service.impl.EnquipmentServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class EnquipmentMainServlet
 */
@WebServlet("/enquipmentMainServlet")
public class EnquipmentMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(request, EnzhequipmentInfo.class);
		
		//ҵ���߼������
		EnquipmentService service = new EnquipmentServiceImpl();
		
		List<EnzhequipmentInfo> list = service.getAllEnzhequipmentInfo(eninfo);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_main.jsp").forward(request, response);
		
	}

}
