package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

public class EmployeeWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//employee객체하나만들어서
		Employees emp=new Employees();
		//각 필드를 파라미터 가져와서 채워주고
		emp.setId(req.getParameter("id"));
		emp.setPass(req.getParameter("pass"));
		emp.setName(req.getParameter("name"));
		emp.setLev(req.getParameter("lev"));
		emp.setGender(Integer.parseInt(req.getParameter("gender")));
		emp.setPhone(req.getParameter("phone"));
		
		//dao실행해서 db에 삽입 해주면 됩니다
		int result = EmployeesDao.getInstance().insertMember(emp);
		//EmployeesDao dao=EmployeesDao.getInstance();
		//dao.insertMember(emp);
		
		//삽입하고 나서 list페이지로 이동
		new EmployeeListAction().execute(req, resp);
		
	}

}
