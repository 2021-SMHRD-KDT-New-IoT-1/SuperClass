package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ProductDAO;

@WebServlet("/GetWeather")
public class GetWeather extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String p_serialnum = request.getParameter("p_serialnum");
		
		Connection conn = null;
		PreparedStatement psmt	= null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			String sql = "Select p_location from phistory where p_serialnum = ? ";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String p_location = rs.getString(1);
				String weather_url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + p_location;
				ProductDAO dao = new ProductDAO();
				String weather = dao.getWeather(weather_url);
			}else {
				System.out.println("실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//1. 지역변수
			//2. 예외처리
			try {
				if(rs != null) {
					rs.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
