package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import dao.MovieDao;
import model.Movie;

public class DaoTest {
	// 테스트 수행
	MovieDao dao;

	@Test
	public void daoTest() throws ClassNotFoundException, SQLException {
		dao = new MovieDao();

		for (int i = 0; i < 1; i++) {
			Movie board = new Movie();
			board.setTitle("손오공");
			board.setPrice(10000);
			board.setPoster("movie.jpg");
			board.setDirector("주성치");
			board.setSynopsis("우끼끼끼끾");
			// int result = dao.insertMovie(board);
			// assertEquals(i, result);
			board.setTitle("서유기");
			board.setCode(1);
			int result = dao.updateMovie(board);
			assertEquals(2, result);
		}

		Movie board = new Movie();
		// 우리가 기대한 값: 1
		// 실제값 : result

	}

}
