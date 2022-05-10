package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사원정보 추가하는form을 가진 페이지로 이동만 해주면 된다
		String url="/employee/employeewrite.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
	

}
