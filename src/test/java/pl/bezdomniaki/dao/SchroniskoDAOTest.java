package pl.bezdomniaki.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.bezdomniaki.Pies;
import pl.bezdomniaki.Schronisko;

public class SchroniskoDAOTest {

	static SchroniskoDAO schroniskoDAO;
	static Connection conn;
	static ApplicationContext context;
	static String currentDate;
	static Date myDate;
	
	@BeforeClass
	public static void zainicjujTesty() {
		context = new ClassPathXmlApplicationContext("file:src/main/resources/psy.xml");
		schroniskoDAO = (SchroniskoDAO)context.getBean("schroniskoDAO");
		System.out.println("* * *  Po³¹czenie z BD nawi¹zane!  * * *\n");
		myDate = new Date();
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd:HH-mm-ss");
		currentDate = fdf.format(myDate);
		System.out.println(currentDate);
	}

	@Test
	public void testGetBean() throws Exception{
	Schronisko schronisko = (Schronisko)context.getBean("schroniskoDebicckie");
	System.out.println(schronisko);
	assertTrue(schronisko.getListaPsow().size()==2);
	}
	
	@Test
	public void testCreate() throws Exception{
		System.out.println("TEST METODY CREATE\n");
		Schronisko noweSchronisko = (Schronisko)context.getBean("schroniskoTworzone");
		System.out.println(noweSchronisko);
		schroniskoDAO.create(noweSchronisko);
		System.out.println("Utworzono nowe schronisko:" + noweSchronisko +"\n");
	}
	
	@Test
	public void testUpdate() throws Exception{
		Schronisko zmienioneSchronisko = (Schronisko)context.getBean("schroniskoZmienione");
		schroniskoDAO.update(zmienioneSchronisko);
		System.out.println("Schronisko po edycji: " + zmienioneSchronisko + "\n");
	}
	
}



