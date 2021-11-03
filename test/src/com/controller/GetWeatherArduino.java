package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.model.MemberVO;
import com.model.ProductVO;
import com.model.WeatherArduinoDAO;
import com.model.WeatherArduinoVO;

@WebServlet("/GetWeatherArduino")
public class GetWeatherArduino extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
//		MemberVO mvo = (MemberVO)session.getAttribute("member");
//		String m_id = mvo.getId();
		ProductVO pvo = (ProductVO)session.getAttribute("PVO");
		String p_serialnum = pvo.getP_serialnum();
		
		
		WeatherArduinoDAO dao = new WeatherArduinoDAO(); 
		WeatherArduinoVO avo = dao.getWeatherInfo("910-1"); 
		String result = new Gson().toJson(avo); 
		PrintWriter out = response.getWriter(); 
		out.print(result);
	
	}

}
