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
		int sensor_cnt = Counting.Count();
		int tmp =0;
		
		String sensor_value = "0";
		SensorDAO dao = new SensorDAO();
		//아두이노한테 받아오는 서블릿
		
		String moveSensor = "-";
		moveSensor = request.getParameter("moveSensor");
		if(moveSensor.equals("1")) {
			tmp = Counting.tmpCount();
		}
		String p_serialnum = request.getParameter("p_serialnum");
		//!moveSensor.equals("-");
		
//			System.out.println("값이 들어옴");
//			System.out.println("서버로 들어온 값 : " + moveSensor);
//			SensorDAO dao = new SensorDAO();
			
			
			if(sensor_cnt == 70) {
				Counting.CountZero();
				tmp = Counting.gettmp();
				if(tmp>=40) {
				sensor_value = "1" ;
				}
				dao.setSleepValue(sensor_value,p_serialnum); //데이터베이스에 값 입력하기
				sensor_value = "0";
				Counting.tmpZero();
			}
		
			
			//int cnt = dao.inMoveSensor(moveSensor,p_serialnum);
			
			
			
//		} else {
//			System.out.println("inputSensor.java에서 값을 못 받아 오거나 없음");
//		}
//		
//		System.out.println(sensor_cnt);
		
		
		
	}

}
