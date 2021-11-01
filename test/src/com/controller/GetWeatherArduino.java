package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.WeatherArduinoDAO;
import com.model.WeatherArduinoVO;

@WebServlet("/GetWeatherArduino")
public class GetWeatherArduino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		WeatherArduinoDAO dao = new WeatherArduinoDAO(); 
		WeatherArduinoVO vo = dao.getWeatherInfo(); 
		String result = new Gson().toJson(vo); 
		PrintWriter out = response.getWriter(); 
		out.print(result);
		
		
		
	}

}
