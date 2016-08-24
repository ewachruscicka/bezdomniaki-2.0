package pl.bezdomniaki.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.bezdomniaki.Pies;

public class PiesDAO {

	private JdbcTemplate jdbcTemplate;
	//private DataSource dataSource;
	
	//Connection conn;

	/*public void setCon(Connection con) {
		this.conn = con;
	}*/


	/*public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(Pies pies) throws SQLException {
		
	}

	public void update(Pies pies) throws SQLException {

	}

	public void delete(Pies pies) throws SQLException {
		
	}

	public List<Pies> listAll() throws SQLException {
		return null;
	}

	public List<Pies> findByCity(String city) throws SQLException {
		return null;
	}

	}
