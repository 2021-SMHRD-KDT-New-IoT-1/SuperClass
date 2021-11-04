package com.ArdCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ArdModel.SensorDAO;
import com.ArdModel.SensorVO;
import com.google.gson.Gson;

@WebServlet("/InputSensor")
public class InputSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//아두이노한테 받아오는 서블릿
		
		String moveSensor = "-";
		moveSensor = request.getParameter("moveSensor");
		String p_serialnum = request.getParameter("p_serialnum");
		
		if(!moveSensor.equals("-")) {
			System.out.println("값이 들어옴");
			System.out.println("서버로 들어온 값 : " + moveSensor);
			SensorDAO dao = new SensorDAO();
			
			int cnt = dao.inMoveSensor(moveSensor,p_serialnum);
			
			if(cnt>0) {
				System.out.println("moveSensor insert 성공!");
			}else {
				System.out.println("moveSensor insert 실패!");
			}
			
		} else {
			System.out.println("inputSensor.java에서 값을 못 받아 오거나 없음");
		}
		
		
		
		
	}

}
