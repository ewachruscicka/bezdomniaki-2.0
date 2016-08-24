package pl.bezdomniaki.dao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.bezdomniaki.Pies;

public class PiesDAOTest {
	//static Connection conn;
	static PiesDAO piesDAO;
	static ApplicationContext context;
	
	
	@BeforeClass
	public static void zainicjujTesty() throws Exception {
		context = new ClassPathXmlApplicationContext("file:src/main/resources/psy.xml"); //domyœlnie wtedy utworzy³y siê beany
		PiesDAO piesDAO = (PiesDAO)context.getBean("piesDAO");
		System.out.println("Po³¹czenie z BD nawi¹zane!\n");
				
		/*try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
			"jdbc:sqlserver://127.0.0.1:1433;databaseName=psy","ewa","haslo");
			System.out.println("Po³¹czenie z BD nawi¹zane!\n");

			}
		catch(SQLException ec) {ec.printStackTrace();}
		catch(ClassNotFoundException ex) {ex.printStackTrace();}
				piesDAO = new PiesDAO();
		piesDAO.setCon(conn);*/
	}
		
	@Test
		public void testGetBean() throws Exception{
		Pies pies2 = (Pies)context.getBean("pies1");
		System.out.println(pies2);
		assertTrue(pies2.getImie().equals("Azor"));
	}
	
	@Test
		public void testCreate() throws SQLException{
		System.out.println("\nTEST METODY CREATE\n");
		Pies nowyPies = (Pies)context.getBean("piesAzor");
		piesDAO.create(nowyPies);
		System.out.println("Zapisano psa:" + nowyPies +"\n");
	}
	
}
