package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.SensorDAO;
import com.model.SensorVO;

@WebServlet("/InputSensor")
public class InputSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int moveSensor = 999;
		moveSensor = Integer.parseInt(request.getParameter("moveSensor"));
		
		if(moveSensor != 999 ) {
			System.out.println("값이 들어옴");
			System.out.println("서버로 들어온 값 : " + moveSensor);
			SensorDAO dao = new SensorDAO();
			SensorVO vo = dao.insert(moveSensor);
			PrintWriter out = response.getWriter();
			String result = new Gson().toJson(vo);
			out.print(result);
		} else {
			System.out.println("null");
		}
		
		
		
		
	}

}
