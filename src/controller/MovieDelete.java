package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

/**
 * Servlet implementation class MovieDelete
 */
@WebServlet("/moviedelete.do")
public class MovieDelete extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int code = Integer.parseInt(req.getParameter("code"));

		MovieDao dao = MovieDao.getInstance();

		dao.deleteMovie(code);

		resp.sendRedirect("movieList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
