package com.ArdCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ArdModel.WeatherArduinoDAO;
import com.ArdModel.WeatherArduinoVO;
import com.google.gson.Gson;
import com.model.MemberVO;
import com.model.ProductVO;

@WebServlet("/GetWeatherArduino")
public class GetWeatherArduino extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//아두이노가 값을 받아오려면 이 서블릿에 와야함. (근데 아두이노가 본인 시리얼넘버를 같이 가지고 와야지만 값을 가지고 갈 수 있다.)
		
		WeatherArduinoDAO dao = new WeatherArduinoDAO(); 
		WeatherArduinoVO avo = dao.getWeatherInfo("910-1"); 
		String result = new Gson().toJson(avo); 
		PrintWriter out = response.getWriter(); 
		out.print(result);
	
	}

}
