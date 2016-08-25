package pl.bezdomniaki.dao;

import java.sql.ResultSet;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

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

		getJdbcTemplate().query("SELECT TOP 1 * FROM Pies", new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				wczytanyPies = new Pies();
				wczytanyPies.setId(rs.getInt("id"));
				wczytanyPies.setImie(rs.getString("imie"));
				wczytanyPies.setDataPrzyjecia(rs.getDate("data_przyjecia"));
				wczytanyPies.setIdSchroniska(rs.getInt("id_schroniska"));
				wczytanyPies.setNrChipa(rs.getString("nr_chipa"));
				System.out.println("Pies przed zmian¹: " + wczytanyPies);
			}
		});

		getJdbcTemplate().update(
				"UPDATE Pies SET imie = ?, data_przyjecia = ?, id_schroniska = ?, nr_chipa = ? WHERE id = ?",
				new Object[] { pies.getImie(), pies.getDataPrzyjecia(), pies.getIdSchroniska(), pies.getNrChipa(),
						wczytanyPies.getId() });
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
		final List<Pies> listaPsow = getJdbcTemplate().query("SELECT * FROM Pies", 
			new RowMapper() {
			public void mapRow(ResultSet rs, int no) throws SQLException {
					Pies pies1 = new Pies();
					pies1.setId(rs.getInt("id"));
					pies1.setImie(rs.getString("imie"));
					pies1.setDataPrzyjecia(rs.getDate("data_przyjecia"));
					pies1.setIdSchroniska(rs.getInt("id_schroniska"));
					pies1.setNrChipa(rs.getString("nr_chipa"));
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


	public List<Pies> findByCity(String city) throws SQLException {
		return null;
	}

}
