package pl.bezdomniaki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import pl.bezdomniaki.Pies;

public class PiesDAO {

	private JdbcTemplate jdbcTemplate;
	Pies wczytanyPies;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(Pies pies) throws SQLException {
		getJdbcTemplate().update(
				"INSERT INTO Pies (imie, data_przyjecia, id_schroniska, nr_chipa) VALUES (?, ?, ?, ? )",
				new Object[] { pies.getImie(), pies.getDataPrzyjecia(), pies.getIdSchroniska(), pies.getNrChipa() });
	}
	/*
	 * PreparedStatement stmt = conn.prepareStatement(
	 * "INSERT INTO Pies (imie, data_przyjecia, id_schroniska, nr_chipa) VALUES (?, ?, ?, ? )"
	 * , Statement.RETURN_GENERATED_KEYS);
	 * 
	 * stmt.setString(1, pies.getImie()); // SimpleDateFormat df = new
	 * SimpleDateFormat("yyyy-MM-dd"); java.sql.Date sqlDate = new
	 * java.sql.Date(pies.getDataPrzyjecia().getYear(),
	 * pies.getDataPrzyjecia().getMonth(), pies.getDataPrzyjecia().getDay());
	 * //try{ stmt.setDate(2, sqlDate); stmt.setInt(3, pies.getIdSchroniska());
	 * stmt.setString(4, pies.getNrChipa()); stmt.execute(); }
	 */

	public void update(Pies pies) throws SQLException {

		/*getJdbcTemplate().query("SELECT TOP 1 * FROM Pies", 
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						wczytanyPies = new Pies();
						wczytanyPies.setId(rs.getInt("id"));
						wczytanyPies.setImie(rs.getString("imie"));
						wczytanyPies.setDataPrzyjecia(rs.getDate("data_przyjecia"));
						wczytanyPies.setIdSchroniska(rs.getInt("id_schroniska"));
						wczytanyPies.setNrChipa(rs.getString("nr_chipa"));
						System.out.println("Pies przed zmianą: " + wczytanyPies);
			}
		});*/

		getJdbcTemplate().update(
				"UPDATE Pies SET imie = ?, data_przyjecia = ?, id_schroniska = ?, nr_chipa = ? WHERE id = ?",
				new Object[] { pies.getImie(), pies.getDataPrzyjecia(), pies.getIdSchroniska(), pies.getNrChipa(),
						pies.getId() });
	}
	/*
	 * PreparedStatement stmt = conn.prepareStatement(
	 * "UPDATE Pies SET imie = ?, data_przyjecia = ?, id_schroniska = ?, nr_chipa = ? WHERE id = ?"
	 * ); stmt.setString(1, pies.getImie()); java.sql.Date sqlDate = new
	 * java.sql.Date(pies.getDataPrzyjecia().getYear(),
	 * pies.getDataPrzyjecia().getMonth(), pies.getDataPrzyjecia().getDay());
	 * stmt.setDate(2, sqlDate); stmt.setInt(3, pies.getIdSchroniska());
	 * stmt.setString(4, pies.getNrChipa()); stmt.setInt(5, pies.getId());
	 * stmt.execute(); stmt.close();
	 */

	public void delete(Pies pies) throws SQLException {

	}
	/*
	 * PreparedStatement stmt = conn.prepareStatement(
	 * "DELETE FROM Pies WHERE id = ?"); stmt.setInt(1, pies.getId());
	 * System.out.println(pies.getId()); stmt.execute(); stmt.close();
	 */

	public List<Pies> listAll() {
		List<Pies> listaPsow = getJdbcTemplate().query("SELECT * FROM Pies", 
			new RowMapper<Pies>() {
			public Pies mapRow(ResultSet rs, int no) throws SQLException {
					Pies pies1 = new Pies();
					pies1.setId(rs.getInt("id"));
					pies1.setImie(rs.getString("imie"));
					pies1.setDataPrzyjecia(rs.getDate("data_przyjecia"));
					pies1.setIdSchroniska(rs.getInt("id_schroniska"));
					pies1.setNrChipa(rs.getString("nr_chipa"));
					return pies1;
			}

		});
		return listaPsow;
	}

		/*
		 * ArrayList<Pies> listaPsow = new ArrayList<Pies>(); Statement stmt =
		 * conn.createStatement(); ResultSet rs = stmt.executeQuery(
		 * "SELECT * FROM Pies"); while (rs.next()) { Pies pies1 = new Pies();
		 * 
		 * pies1.setId(rs.getInt("id")); // w getIn mozna nr kolumny albo jej
		 * "nazwe" pies1.setImie(rs.getString("imie"));
		 * pies1.setDataPrzyjecia(rs.getDate("data_przyjecia"));
		 * pies1.setIdSchroniska(rs.getInt("id_schroniska"));
		 * pies1.setNrChipa(rs.getString("nr_chipa")); listaPsow.add(pies1); }
		 * rs.close(); stmt.close();
		 * 
		 * return listaPsow;
		 */


	public List<Pies> findByCity(final String city) throws SQLException {
		List<Pies> listaPsow = getJdbcTemplate().query(

				 new PreparedStatementCreator() {
		             public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		                 PreparedStatement ps = connection.prepareStatement(
		                		 "SELECT p.imie, p.data_przyjecia, p.nr_chipa, p.id, p.id_schroniska, s.nazwa, s.miejscowosc"
		                					+ " FROM Pies as p JOIN Schronisko AS s ON s.id = p.id_schroniska"
		                					+ " WHERE s.miejscowosc = ?");
		                 ps.setString(1, city);
		                 return ps;
		             }
				 },
				
				new RowMapper<Pies>() {
				public Pies mapRow(ResultSet rs, int no) throws SQLException {
						Pies pies1 = new Pies();
						pies1.setId(rs.getInt("id"));
						pies1.setImie(rs.getString("imie"));
						pies1.setDataPrzyjecia(rs.getDate("data_przyjecia"));
						pies1.setIdSchroniska(rs.getInt("id_schroniska"));
						pies1.setNrChipa(rs.getString("nr_chipa"));
						return pies1;
				}
			});
			System.out.println("Psy w schornisku w miejscowości: " + city);
			return listaPsow;
	}

}
