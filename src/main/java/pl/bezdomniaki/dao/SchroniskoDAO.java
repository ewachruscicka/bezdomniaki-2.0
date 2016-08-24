package pl.bezdomniaki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.bezdomniaki.Schronisko;

public class SchroniskoDAO {
	private JdbcTemplate jdbcTemplate;
	/*Connection conn;
	

	public void setCon(Connection con) {
		this.conn = con;
	}*/

	public void create(Schronisko schronisko) throws SQLException {
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void update(Schronisko schronisko) throws SQLException{
		
	}

	public void delete(Schronisko schronisko) throws SQLException{
	
	}

	public List<Schronisko> listAll() throws SQLException {
		return null;
	}

}
