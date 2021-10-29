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
		System.out.println(start);
		String end = request.getParameter("end");
		String allday = request.getParameter("allday");
		
		CalendarVO Cvo = new CalendarVO(calendar_op,start,end,allday);
		




		// 2021-10-29
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	     java.util.Date strDate = null;
		try {
			strDate = sdf.parse(Cvo.makeS_date(start));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long date = strDate.getTime();
		System.out.println(date);
		Date s_date = new Date(date);
		System.out.println(s_date);
		
		System.out.println(calendar_op);
		System.out.println(start);
		System.out.println(end);
		System.out.println(allday);
		
		String[] arr = Cvo.getarr();
		Cvo.makeS_date(start);
		//java.sql.Date d=  java.sql.Date.valueOf(arr[0]+"-"+arr[1]+"-"+arr[2]);
		java.sql.Date d=  java.sql.Date.valueOf(Cvo.makeS_date(start));
		//페이지에서 스케줄 등록하면 달력에 등록한 스케줄이 출력되는 기능
		response.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(calendar_op);
		
		CalendarDAO dao = new CalendarDAO();
		
		
		
		//제품선택홈페이지에서 name 이름 p_serialnum 가져와야한다.
		//String p_serialnum = request.getParameter("p_serialnum");
		
		//임시 시리얼넘버
		String p_serialnum = "910-1";
		dao.inSchedule(d, calendar_op,p_serialnum, m_id);
		

		
		
		//calendar_op = URLDecoder.decode(calendar_op, "euc-kr");

		//HttpSession session = request.getSession();
		//session.setAttribute("i", i);
		//System.out.println("캘린더서비스:" + i);
		
		//현진쌤: 여기서 DB 저장
		
		
	}
}
