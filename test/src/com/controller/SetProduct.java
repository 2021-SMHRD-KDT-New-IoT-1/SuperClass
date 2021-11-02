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

@WebServlet("/SetProduct")
public class SetProduct extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("member");
		String p_location = request.getParameter("p_location");
		String p_serialnum = request.getParameter("p_serialnum");
		String p_locationdetail = request.getParameter("p_locationdetail");
		String m_id = vo.getId();
		System.out.println(p_location);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
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
			String sql = "update phistory set p_location=?, detail_location=?,m_id=? where p_serialnum=?";
			psmt	= conn.prepareStatement(sql);
			
			psmt.setString(1, p_location);
			psmt.setString(2, p_locationdetail);
			psmt.setString(3, m_id);
			psmt.setString(4, p_serialnum);
			
			//5. SQL�� ��� �� ó��
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("�߰�����");
				response.sendRedirect("Anzzi/SelectAnzzi.jsp");
				
			}else {
				System.out.println("�߰�����");
				response.sendRedirect("Anzzi/SelectAnzzi.jsp");
				
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
