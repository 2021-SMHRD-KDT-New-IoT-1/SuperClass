package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CalendarDAO;
import com.model.ServiceCenterDAO;


@WebServlet("/CalendarDelete")
public class CalendarDelete extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start_date = request.getParameter("start_date");
	    System.out.println(start_date);

		HttpSession session = request.getSession();

		CalendarDAO dao = new CalendarDAO();
		
		//�ӽ� �ø��� �ѹ� (��ǰ�������������� ���� ���������� �װ� ���  �ٴϸ� ��)
		String p_serialnum = "910-1";
		int cnt = dao.delectSchedule(p_serialnum, start_date);
		System.out.println(cnt);
		if(cnt > 0) {
			System.out.println("�����ٻ�������");
		}else {
			System.out.println("�����ٻ�������");
		}
		response.sendRedirect("Anzzi/Calender.jsp");
		

		
	}

}
