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

public class MovieUpdate extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "movie/movieUpdate.jsp";

		int code = Integer.parseInt(req.getParameter("code"));

		MovieDao dao = MovieDao.getInstance();

		Movie movie = dao.getMovie(code);

		req.setAttribute("movie", movie);
		req.getRequestDispatcher(url).forward(req, resp);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");

		Movie movie = new Movie();

		movie.setTitle(req.getParameter("title"));

		movie.setDirector(req.getParameter("director"));

		movie.setPrice(Integer.parseInt(req.getParameter("price")));
		movie.setCode(Integer.parseInt(req.getParameter("code")));
		movie.setSynopsis(req.getParameter("synopsis"));

		Collection<Part> parts = req.getParts();

		for (Part part : parts) {
			if (part.getHeader("Content-Disposition").contains("filename=")) {
				String fn = part.getSubmittedFileName();

				if (part.getSize() > 0) {
					String path = req.getServletContext().getRealPath("/images");
					part.write(path + "/" + fn);
					movie.setPoster(fn);
				}
			}
		}
		MovieDao.getInstance().updateMovie(movie);
		resp.sendRedirect("movieList.do");

	}

}
