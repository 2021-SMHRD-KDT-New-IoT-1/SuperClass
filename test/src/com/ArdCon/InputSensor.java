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
		
		
		//�Ƶ��̳����� �޾ƿ��� ����
		
		String moveSensor = "-";
		moveSensor = request.getParameter("moveSensor");
		String p_serialnum = request.getParameter("p_serialnum");
		//!moveSensor.equals("-");
		if(true) {
//			System.out.println("���� ����");
//			System.out.println("������ ���� �� : " + moveSensor);
//			SensorDAO dao = new SensorDAO();
			
			
			if(sensor_cnt == 10) {
				Counting.CountZero();
			}
			//int cnt = dao.inMoveSensor(moveSensor,p_serialnum);
			
//			if(cnt>0) {
//				System.out.println("moveSensor insert ����!");
//			}else {
//				System.out.println("moveSensor insert ����!");
//			}
			
		} else {
			System.out.println("inputSensor.java���� ���� �� �޾� ���ų� ����");
		}
		
		System.out.println(sensor_cnt);
		
		
	}

}
