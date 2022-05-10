package com.globalin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

//액션클래스는 command=employee_list요청을 처리
public class EmployeeListAction  implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이 url은 요청후에 이동할 페이지주소
		String url="/employee/employeeList.jsp";
		//여기서 처리할일은 db에서 사원정보 모두 가져오고
		//request에 담아서 보낸다
		EmployeesDao dao=EmployeesDao.getInstance();
		
		List<Employees> list=dao.selectAllEmployees();
		
		req.setAttribute("elist", list);
		System.out.println(list);
		//request에"elist"라는 이름으로list를 담아서 보낸다
		//나중에 request에서 꺼내 쓸때도 "elist"라는 이름으로 꺼내 쓰면 된다
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
