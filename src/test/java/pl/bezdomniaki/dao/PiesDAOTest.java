package pl.bezdomniaki.dao;

import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import pl.bezdomniaki.Pies;

public class PiesDAOTest {
	//static Connection conn;
	static PiesDAO piesDAO;
	static ApplicationContext context;
	static String currentDate;
	static Date myDate;
	static JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@BeforeClass
	public static void zainicjujTesty() throws Exception {
		context = new ClassPathXmlApplicationContext("file:src/main/resources/psy.xml"); //domy�lnie wtedy utworzy�y si� beany
		piesDAO = (PiesDAO)context.getBean("piesDAO");
		System.out.println("* * *  Po��czenie z BD nawi�zane!  * * *\n");
		myDate = new Date();
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd:HH-mm-ss");
		currentDate = fdf.format(myDate);
		System.out.println(currentDate);
		
		/*try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
			"jdbc:sqlserver://127.0.0.1:1433;databaseName=psy","ewa","haslo");
			System.out.println("Po��czenie z BD nawi�zane!\n");

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
		Pies nowyPies = (Pies)context.getBean("piesTworzony");
		nowyPies.setDataPrzyjecia(myDate);
		piesDAO.create(nowyPies);
		System.out.println("Zapisano psa:" + nowyPies +"\n");
	}
	
	@Test
	public void testUpdate() throws Exception{
		List <Pies> listaPsow = piesDAO.listAll();
		Pies wczytanyPies = listaPsow.get(0);
		System.out.println("Pies wczytany: " + wczytanyPies + "\n");
		Pies zmienionyPies = (Pies)context.getBean("piesZmieniony");
		zmienionyPies.setId(wczytanyPies.getId());
		zmienionyPies.setDataPrzyjecia(myDate);
		piesDAO.update(zmienionyPies);
		System.out.println("Pies po edycji: " + zmienionyPies + "\n");
	}
	
	@Test
	public void testDelete() throws Exception{
		System.out.println("TEST METODY DELETE\n");
		List <Pies> listaPsow = piesDAO.listAll();
		System.out.println("Lista ps�w przed usuni�ciem pozycji: ");
		for (Pies p : listaPsow) {
			System.out.println(p);
		System.out.println("Ilo�� ps�w przed usuni�ciem pozycji: " + listaPsow.size());
		}
		Pies pies = listaPsow.get(0);
		piesDAO.delete(pies);
		System.out.println("Lista ps�w po usuni�ciu pozycji: ");
		List <Pies> listaPsowNowa = piesDAO.listAll();
		for (Pies p : listaPsowNowa) {
			System.out.println(p);
		}
		System.out.println("Ilo�� ps�w po usuni�ciu pozycji: " + listaPsowNowa.size() + "\n");
	}
	
	@Test
	public void testListAll() throws Exception{
		System.out.println("TEST METODY LISTALL\n");
		List <Pies> listaPsow = piesDAO.listAll();
		assertTrue(listaPsow.size() > 0);
		for (Pies pies : listaPsow) {
			System.out.println(pies);
			System.out.println();
		}
	}
	
	@Test
	public void findByCity() throws SQLException{
		System.out.println("TEST METODY FINDBYCITY\n");
		List <Pies> listaWybranychPsow = piesDAO.findByCity("Krak�w");
		assertTrue(listaWybranychPsow.size() > 0);
		for (Pies pies : listaWybranychPsow) {
			System.out.println(pies);
			System.out.println();
		}
	}
}
