package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

public class EmployeeViewAction implements Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse rsp)
			throws SecurityException, ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");

		Employees emp = EmployeesDao.getInstance().getMember(id);

		String url = "employee/employeeView.jsp";

		req.setAttribute("employee", emp);

		req.getRequestDispatcher(url).forward(req, rsp);
	}

}
