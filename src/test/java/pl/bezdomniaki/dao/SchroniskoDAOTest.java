package pl.bezdomniaki.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	@BeforeClass
	public static void zainicjujTesty() {
		context = new ClassPathXmlApplicationContext("file:src/main/resources/psy.xml");
	}


	@Test
	public void testGetBean() throws Exception{
	Schronisko schronisko = (Schronisko)context.getBean("schroniskoDebicckie");
	System.out.println(schronisko);
	assertTrue(schronisko.getListaPsow().size()==2);
	}
}



