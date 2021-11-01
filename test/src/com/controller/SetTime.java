package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberVO;
import com.model.ProductVO;
import com.model.TimeDAO;
import com.model.TimeVO;

@WebServlet("/SetTime")
public class SetTime extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("euc-kr");
	      HttpSession session = request.getSession();
	      TimeDAO dao = new TimeDAO();
	      MemberVO Mvo = (MemberVO)session.getAttribute("member"); 
	      
	      //일단 임시 (시리얼넘버 가져오는 세션 생길 때까지만)
	      String p_serialnum = "910-1";
	      
	      String wake_time = request.getParameter("wake_time");
	      String dayofs = request.getParameter("dayofs");
	      String sound = request.getParameter("sound");
	      String weather_sound = request.getParameter("weather_sound");
	      String schedule = request.getParameter("schedule");
	      String pattern = request.getParameter("pattern");
	      String fade_in = request.getParameter("fade_in");
	      
	      System.out.println(wake_time);
	      System.out.println(dayofs);
	      System.out.println(sound);
	      System.out.println(weather_sound);
	      System.out.println(schedule);
	      System.out.println(pattern);
	      System.out.println(fade_in);
	      
	      int cnt = dao.inTime(p_serialnum, wake_time, dayofs, fade_in, sound, weather_sound, schedule, pattern);
	      
	      if(cnt>0) {
	         TimeVO vo2 = new TimeVO(wake_time, dayofs, fade_in, sound, weather_sound, schedule, pattern);
	         
	         System.out.println("ㅅㄱ");
	         response.sendRedirect("Anzzi/Time.jsp");
	      }else {
	    	  
	         System.out.println("ㅅㅍ");
	         response.sendRedirect("Anzzi/Time.jsp");
	      }
	      

	}

}
