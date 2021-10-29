package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberVO;

@WebServlet("/WriteServiceCenter")
public class WriteServiceCenter extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("member");
		String board_contents = request.getParameter("board_contents");
		GregorianCalendar now = new GregorianCalendar();
		now.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		String board_date = now.get(Calendar.YEAR) +"-"+ (now.get(Calendar.MONTH)+1) + "-"+now.get(Calendar.DATE);
		String board_title = request.getParameter("board_title");
		String m_id = vo.getId();
		int cnt = 1;
		Connection conn = null;
		PreparedStatement psmt	= null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			String sql = "select board_num from servicecenter";
			psmt	= conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				cnt = Integer.parseInt(rs.getString(1))+1;
			}
			
			sql = "insert into servicecenter values(?,?,?,?,?)";
			psmt	= conn.prepareStatement(sql);
			
			psmt.setInt(1, cnt);
			psmt.setString(2, board_title);
			psmt.setString(3, board_contents);
			psmt.setString(4, board_date);
			psmt.setString(5, m_id);
		
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("등록성공");
				response.sendRedirect("Anzzi/ServiceCenter.jsp");
			}else {
				System.out.println("등록실패");
				response.sendRedirect("Anzzi/ServiceCenter.jsp");
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

