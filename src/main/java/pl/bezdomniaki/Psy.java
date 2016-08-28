package pl.bezdomniaki;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.bezdomniaki.dao.PiesDAO;

public class Psy {

	static ApplicationContext context;
	protected static Pies[] psy = null;

	Pies[] getPsy(String miejscowosc) throws SQLException {
		context = new ClassPathXmlApplicationContext("file:src/main/resources/psy.xml");
		PiesDAO piesDAO = new PiesDAO();
		return piesDAO.findByCity(miejscowosc);
	}
}
