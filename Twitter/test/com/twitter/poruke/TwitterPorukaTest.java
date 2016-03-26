package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testToString() {
		tp.setKorisnik("Edis Sarda");
		tp.setPoruka("#programiranje2 #dodatnaNastava");
		
		String ocekivano = "KORISNIK:" + "Edis Sarda" + " PORUKA:" + "#programiranje2 #dodatnaNastava";
		
		assertEquals(ocekivano, tp.toString());
	}

	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Edis Sarda");
		
		assertEquals("Edis Sarda", tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("      ");
	}

	
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Twitter poruka");
		
		assertEquals("Twitter poruka", tp.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaStringDuziOd140Karaktera() {
		String tekst = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book. "
				+ "It has survived not only five centuries, but also the leap into electronic typesetting, "
				+ "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, "
				+ "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		
		tp.setPoruka(tekst);
	}

}
