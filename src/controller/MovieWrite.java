package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import model.Movie;

/**
 * Servlet implementation class MovieWrite
 */

public class MovieWrite extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "movie/movieWrite.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Movie m = new Movie();
		m.setTitle(request.getParameter("title"));
		m.setPrice(Integer.parseInt(request.getParameter("price")));
//		m.setPoster(request.getParameter("poster"));
		m.setDirector(request.getParameter("director"));
		m.setSynopsis(request.getParameter("synopsis"));
		System.out.println(m.toString());

		Collection<Part> parts = request.getParts();

		for (Part part : parts) {
			System.out.println(part.getName());
			if (part.getHeader("Content-Disposition").contains("filename=")) {
				String fn = part.getSubmittedFileName();
				System.out.println(fn);

				String path = request.getServletContext().getRealPath("/images");
				if (part.getSize() > 0) {
					part.write(path + "/" + fn);
				}
				m.setPoster(fn);
				MovieDao.getInstance().insertMovie(m);
			}
		}
		response.sendRedirect("movieList.do");
	}

}
