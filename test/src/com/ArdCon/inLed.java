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
import com.ArdModel.ledVO;
import com.google.gson.Gson;


@WebServlet("/inLed")
public class inLed extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아두이노한테 led 상태 정보 받아오는 서블릿
		SensorDAO dao = new SensorDAO();
		
		String ledonoff = "-";
		
		ledonoff =request.getParameter("ledonoff");
		
		if(!ledonoff.equals("-")) {
			System.out.println("값이 들어옴");
			System.out.println("서버로 들어온 값 : " + ledonoff);
			
			////이부분을 바꿔야함 SensorDAO에서. 아직 안 만듦.
			int cnt = dao.inLed(ledonoff, "910-1");
			
			if(cnt>0) {
				System.out.println("ledonoff insert 성공!");
			}else {
				System.out.println("ledonoff insert 실패!");
			}
			
		} else {
			System.out.println("inLed.java에서 값을 못 받아 오거나 없음");
		}
			
	
	}

}
