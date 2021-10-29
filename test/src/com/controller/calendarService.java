package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CalendarDAO;
import com.model.CalendarVO;
import com.model.MemberVO;

@WebServlet("/calendarService")
public class calendarService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("member");
		String m_id = vo.getId();
		
		String calendar_op = request.getParameter("calendar_op");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String allday = request.getParameter("allday");
		
		CalendarVO calendar = new CalendarVO(calendar_op,start,end,allday);

		String s_date = calendar.makeS_date(start); //s_date ����
		
		System.out.println(calendar_op);
		System.out.println(start);
		System.out.println(end);
		System.out.println(allday);
		
		//���������� ������ ����ϸ� �޷¿� ����� �������� ��µǴ� ���
		response.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(calendar_op);
		
		CalendarDAO dao = new CalendarDAO();
		
		//�ӽ� �ø���ѹ�
		
		
		dao.inSchedule(s_date, calendar_op, m_id);
		

		
		
		//calendar_op = URLDecoder.decode(calendar_op, "euc-kr");

		//HttpSession session = request.getSession();
		//session.setAttribute("i", i);
		//System.out.println("Ķ��������:" + i);
		
		//������: ���⼭ DB ����
		
		
	}
}
