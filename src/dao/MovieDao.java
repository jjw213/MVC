package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;
import utill.DBManager;

public class MovieDao {
	public MovieDao() {

	}

	private static MovieDao instance = new MovieDao();

	public static MovieDao getInstance() {
		return instance;
	}

	public Movie getMovie(int code) {
		Movie result = null;
		// ���ᰴü
		Connection conn = null;
		// sql�� ���� ��ü
		PreparedStatement pstmt = null;
		// select�� ó���� ���� ��� ��ü
		ResultSet rs = null;
		// ������ sql��
		String sql = "select * from movie where code=?";
		// ���ᰡ������
		try {
			conn = utill.DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			// ��������
			rs = pstmt.executeQuery();
			// ���ó��
			if (rs.next()) {
				result = new Movie();
				result.setCode(rs.getInt("code"));
				result.setTitle(rs.getString("title"));
				result.setPrice(rs.getInt("price"));
				result.setDirector(rs.getString("director"));
				result.setPoster(rs.getString("poster"));
				result.setSynopsis(rs.getString("synopsis"));
				// rs.getDate("enter");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<Movie> selectAllMoives() {
		List<Movie> result = new ArrayList<Movie>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from movie order by code desc";
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// ���ó��
			while (rs.next()) {
				Movie m = new Movie();
				m.setCode(rs.getInt("code"));
				m.setTitle(rs.getString("title"));
				m.setPrice(rs.getInt("price"));
				m.setDirector(rs.getString("director"));
				m.setPoster(rs.getString("poster"));
				m.setSynopsis(rs.getString("synopsis"));
				result.add(m);
				// rs.getDate("enter");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}

	public int insertMovie(Movie movie) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into movie values(movie_seq.nextval, ?,?,?,?,?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getPoster());
			pstmt.setString(5, movie.getSynopsis());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}

	public int updateMovie(Movie movie) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update movie set title=?,price=?,director=?, poster=?, synopsis=? where code=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getPoster());
			pstmt.setString(5, movie.getSynopsis());
			pstmt.setInt(6, movie.getCode());

			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}

	public int deleteMovie(int code) {
		// ������
		int result = -1;
		// ���ᰴü
		Connection conn = null;
		// sql���ఴü
		PreparedStatement pstmt = null;
		// ������ sql��
		String sql = "delete from movie where code=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}
}
