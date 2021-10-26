package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SetLocation")
public class SetLocation extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		String p_location = request.getParameter("admCd");
		String detail_location = request.getParameter("addrDetail");
		String m_id = (String)session.getAttribute("m_id");
		
		
		PreparedStatement psmt	= null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
			String sql = "UPDATE phistory SET p_location = ? , detail_location = ? WHERE p_id = ?";
			
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setString(1, p_location);
			psmt.setString(2, detail_location);
			psmt.setNString(3, m_id);
			
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
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
