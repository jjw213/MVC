package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import model.Movie;

@WebServlet("/movieList.do")
public class MovieList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doAction(req, resp);

		MovieDao dao = MovieDao.getInstance();

		List<Movie> list = dao.selectAllMoives();

		String url = "movie/movieList.jsp";

		req.setAttribute("list", list);

		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// command�Ķ���� ��������

//		req.setCharacterEncoding("UTF-8");
//		String command = req.getParameter("command");
//		System.out.println(command);
//		// ��û�� ó������ action��ü�� ���� �����ϱ�
//		// 1.action ���丮 �����
//		ActionFactory af = ActionFactory.getInstance();
//		// 2.action���丮�� getAction(command)�޼ҵ� ȣ���ؼ�
//		// command�� �´� action��ü����
//		Action action = af.getAction(command);
//		// 3.action��ü�� excute()�޼ҵ� ����
//
//		if (action != null) {
//			action.execute(req, resp);
//		}
	}

}
