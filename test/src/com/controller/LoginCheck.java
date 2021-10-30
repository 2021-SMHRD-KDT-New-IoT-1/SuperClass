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

import com.model.MemberVO;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		Connection conn = null;
		PreparedStatement psmt	= null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			String sql = "Select * from MEMBERS where m_id = ? and m_pw = ?";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, m_id);
			psmt.setString(2, m_pw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String get_id = rs.getString(1);
				String get_pw = rs.getString(2);
				String get_name = rs.getString(3);
				
				vo = new MemberVO(get_id,get_pw,get_name);
				
				HttpSession session = request.getSession();
				
				session.setAttribute("member", vo);
				
				response.sendRedirect("Anzzi/Main.jsp");
			}else {
				response.sendRedirect("Anzzi/Main.jsp");
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
