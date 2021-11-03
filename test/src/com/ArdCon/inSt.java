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

@WebServlet("/inSt")
public class inSt extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아두이노한테 취침시간 (버튼 눌렸을 때) 받아오는 서블릿. 버튼 눌리면 취침시간이 DB에 담겨야함. 아직 안만듦
	
		SensorDAO dao = new SensorDAO();
		
		String sleep_time = "-";
		sleep_time =request.getParameter("sleep_time");
		
		if(!sleep_time.equals("-")) {
			System.out.println("값이 들어옴");
			System.out.println("서버로 들어온 값 : " + sleep_time);
			
			////이부분을 바꿔야함 SensorDAO에서. 아직 안 만듦.
			int cnt = dao.inSt(sleep_time, "910-1");
			
			if(cnt>0) {
				System.out.println("sleep_time insert 성공!");
			}else {
				System.out.println("sleep_time insert 실패!");
			}
			
		} else {
			System.out.println("inSt.java에서 값을 못 받아 오거나 없음");
		}
			
		
	}

}
