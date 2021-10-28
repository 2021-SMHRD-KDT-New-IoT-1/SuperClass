package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calendarService")
public class calendarService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		
		String i = request.getParameter("i");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String allday = request.getParameter("allday");

		System.out.println(i);
		System.out.println(start);
		System.out.println(end);
		System.out.println(allday);
		i = URLDecoder.decode(i, "euc-kr");

		//HttpSession session = request.getSession();
		//session.setAttribute("i", i);
		//System.out.println("캘린더서비스:" + i);
		
		// 여기서 DB 저장
		response.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(i);
		
		
	}
}
