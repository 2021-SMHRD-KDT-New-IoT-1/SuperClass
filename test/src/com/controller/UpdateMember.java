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

import com.model.MemberVO;

@WebServlet("/UpdateMember")
public class UpdateMember extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Connection conn = null;
		PreparedStatement psmt = null;
		MemberVO vo = (MemberVO)session.getAttribute("member");
		String m_name = request.getParameter("name");
		String m_pw = request.getParameter("password");
		String m_id = vo.getId();
		
		if(m_name.equals("")) {
			m_name = vo.getName();
		}
		if(m_pw.equals("")) {
			m_pw = vo.getPw();
		}
		
		
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3. Oracle�� ���� DBID, DBPW�� ����
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("���Ἲ��");
			}else {
				System.out.println("�������");
			}
			
			//4. SQL�� �غ�
			String sql = "update members set m_pw=?, m_name=? where m_id=? ";
			psmt	= conn.prepareStatement(sql);
			
			
			
			psmt.setString(1, m_pw);
			psmt.setString(2, m_name);
			psmt.setString(3, m_id);
			
			
			//5. SQL�� ��� �� ó��
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("��������");
				response.sendRedirect("Anzzi/Main.jsp");
				
			}else {
				System.out.println("��������");
				response.sendRedirect("Anzzi/Main.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//1. ��������
			//2. ����ó��
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
