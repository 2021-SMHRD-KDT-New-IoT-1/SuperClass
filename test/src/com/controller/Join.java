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

@WebServlet("/Join")
public class Join extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC
		//1. ojdbc6.jar ��������(WEB-INF -> lib)
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//2. OracleDriver.class �����ε�
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
			String sql = "insert into members values(?,?,?)";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, "m_id");
			psmt.setString(2, "m_pw");
			psmt.setString(3, "m_name");
			
			//5. SQL�� ��� �� ó��
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("���Լ���");
			}else {
				System.out.println("���Խ���");
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
