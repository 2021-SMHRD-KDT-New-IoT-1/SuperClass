package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		
		CalendarVO Cvo = new CalendarVO(calendar_op,start,end,allday);
		

		System.out.println(start);



		// 2021-10-29
		
	
	


		
		System.out.println(calendar_op);
		System.out.println(start);
		System.out.println(end);
		System.out.println(allday);
		
		
		String s_date = Cvo.makeS_date(start);
		String e_date = Cvo.makeS_date(end);
		
		//String[] arr = Cvo.getarr();
		//java.sql.Date d=  java.sql.Date.valueOf(arr[0]+"-"+arr[1]+"-"+arr[2]);
		
		
		//DB�� ������ sql date �������� �ٲ��ִ� �۾�
		java.sql.Date start_date =  java.sql.Date.valueOf(s_date);
		java.sql.Date end_date =  java.sql.Date.valueOf(e_date);
		//java.
		
		//System.out.println(s_date);
		//���������� ������ ����ϸ� �޷¿� ����� �������� ��µǴ� ���
		response.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(calendar_op);
		
		CalendarDAO dao = new CalendarDAO();
		
		
		
		//��ǰ����Ȩ���������� name �̸� p_serialnum �����;��Ѵ�.
		//String p_serialnum = request.getParameter("p_serialnum");
		
		//�ӽ� �ø���ѹ�
		String p_serialnum = "910-1";
		
		//p_serialnum�� ��� �������� �����غ�����. m_id�� ���ǿ��� ������.
		dao.inSchedule(start_date, end_date, calendar_op,p_serialnum, m_id);
		

		
		
		//calendar_op = URLDecoder.decode(calendar_op, "euc-kr");

		//HttpSession session = request.getSession();
		//session.setAttribute("i", i);
		//System.out.println("Ķ��������:" + i);
		
		//������: ���⼭ DB ����
		
		
	}
}
