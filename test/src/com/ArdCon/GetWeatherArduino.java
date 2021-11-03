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
		
		//�Ƶ��̳밡 ���� �޾ƿ����� �� ������ �;���. (�ٵ� �Ƶ��̳밡 ���� �ø���ѹ��� ���� ������ �;����� ���� ������ �� �� �ִ�.)
		
		WeatherArduinoDAO dao = new WeatherArduinoDAO(); 
		WeatherArduinoVO avo = dao.getWeatherInfo("910-1"); 
		String result = new Gson().toJson(avo); 
		PrintWriter out = response.getWriter(); 
		out.print(result);
	
	}

}
