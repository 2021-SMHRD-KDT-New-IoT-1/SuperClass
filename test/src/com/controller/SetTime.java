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
	      ProductVO Pvo = (ProductVO)session.getAttribute("PVO");
	      String p_serialnum = Pvo.getP_serialnum();
	      
	      
	      String wake_time = request.getParameter("wake_time");
	      String[] ex_dayofs = request.getParameterValues("selectDay");
	      String sound = request.getParameter("sound");
	      String weather_sound = request.getParameter("weather_sound");
	      String schedule = request.getParameter("schedule");
	      String pattern = request.getParameter("pattern");
	      String fade_in = request.getParameter("fade_in");
	      
	    
	      String dayOfs = "";
	      for(int i = 0; i<ex_dayofs.length; i++) {
	    	  dayOfs += ex_dayofs[i];
	    	  if(i < ex_dayofs.length-1) {
	    		  dayOfs += "#";
	    	  }
	      }
	      
	      
	      System.out.println(wake_time);
	      System.out.println(dayOfs);
	      System.out.println(sound);
	      System.out.println(weather_sound);
	      System.out.println(schedule);
	      System.out.println(pattern);
	      System.out.println(fade_in);

	      int cnt = dao.inWakeUp(p_serialnum, wake_time, dayOfs, fade_in, sound, weather_sound, schedule, pattern);
	      
	      if(cnt>0) {
	         System.out.println("WakeUp테이블에 업데이트 성공");
	         response.sendRedirect("Anzzi/Time.jsp");
	      }else {
	    	  
	         System.out.println("WakeUp테이블에 업데이트 실패");
	         response.sendRedirect("Anzzi/Time.jsp");
	      }
	      

	}

}
