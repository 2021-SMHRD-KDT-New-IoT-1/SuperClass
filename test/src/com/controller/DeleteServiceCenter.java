package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.ServiceCenterDAO;

@WebServlet("/DeleteServiceCenter")
public class DeleteServiceCenter extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		//ȸ������ ��� ȣ��
		//���� �Ϸ� -> �����Ϸ� ! �ܼ�â�� ���
		//���� �̿Ϸ� -> ��������! �ܼ�â�� ���
		ServiceCenterDAO dao = new ServiceCenterDAO();
		int cnt = dao.deleteServiceCenter(board_num);
		if(cnt > 0) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
		}
		response.sendRedirect("Anzzi/ServiceCenter.jsp");
		
	
	}

}
