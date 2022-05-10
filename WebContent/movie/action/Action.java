package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
//ACTION이라는 인터페이스는
	//SERVLET이 처리할 요청을 나눠서 정으
	//만약 EMPLOYEES를 삽입하는 요청이 왓다
	//그요청을EMPLOYEESWRITEACTION이라고이름을 지어줌
	//EMPLOYEESWRITEACTION은 요청을 받아서 db에 사원정보를 삽입해주는 역활을함
	//우리가 기존에 contexpath/requesturi로 경로를 잘라서 처리했던
	//else-if분기하나를 action하나로 처리하는 것처럼 동작
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
