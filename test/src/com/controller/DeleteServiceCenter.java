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
		
		//회원삭제 기능 호출
		//삭제 완료 -> 삭제완료 ! 콘솔창에 출력
		//삭제 미완료 -> 삭제실패! 콘솔창에 출력
		ServiceCenterDAO dao = new ServiceCenterDAO();
		int cnt = dao.deleteServiceCenter(board_num);
		if(cnt > 0) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		response.sendRedirect("Anzzi/ServiceCenter.jsp");
		
	
	}

}
