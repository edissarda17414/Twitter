package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter t;
	private LinkedList<TwitterPoruka> porukeTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		porukeTest = new LinkedList<>();
		
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Pera");
		tp1.setPoruka("Ovo je Perina poruka.");
		
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Zika");
		tp2.setPoruka("Ovo je Zikina poruka.");
		
		TwitterPoruka tp3 = new TwitterPoruka();
		tp3.setKorisnik("Mika");
		tp3.setPoruka("Ovo je Mikina poruka.");
		
		porukeTest.addLast(tp1);
		porukeTest.addLast(tp2);
		porukeTest.addLast(tp3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiSvePoruke() {
		
		t.unesi("Pera", "Ovo je Perina poruka.");
		t.unesi("Zika", "Ovo je Zikina poruka.");
		t.unesi("Mika", "Ovo je Mikina poruka.");
		
		for (int i = 0; i < porukeTest.size(); i++) {
			assertEquals(porukeTest.get(i), t.vratiSvePoruke().get(i));
		}
	}

	
	@Test
	public void testUnesi() {
		t.unesi("Pera", "Ovo je Perina poruka.");
		t.unesi("Zika", "Ovo je Zikina poruka.");
		t.unesi("Mika", "Ovo je Mikina poruka.");
		
		for (int i = 0; i < porukeTest.size(); i++) {
			assertEquals(porukeTest.get(i), t.vratiSvePoruke().get(i));
		}
		
	}

	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(100, " ");
	}
	
	@Test
	public void testVratiPorukeSveOk() {
		TwitterPoruka [] nizPorukaTest = new TwitterPoruka[3];
		for (int i = 0; i < 3; i++) {
			nizPorukaTest[i] = porukeTest.get(i);
		}
		
		t.unesi("Pera", "Ovo je Perina poruka.");
		t.unesi("Zika", "Ovo je Zikina poruka.");
		t.unesi("Mika", "Ovo je Mikina poruka.");
		t.unesi("Korisnik 1", "14423534535");
		t.unesi("Korisnik 2", "asdfghjkl");
		
		
		TwitterPoruka [] nizPoruka = t.vratiPoruke(3, "poruka");
		
		assertArrayEquals(nizPorukaTest, nizPoruka);
	}
	
	
	
	@Test
	public void testVratiPorukeMaxUMinusu() {
		TwitterPoruka [] nizPorukaTest = new TwitterPoruka[100];
		for (int i = 0; i < 3; i++) {
			nizPorukaTest[i] = porukeTest.get(i);
		}
		
		t.unesi("Pera", "Ovo je Perina poruka.");
		t.unesi("Zika", "Ovo je Zikina poruka.");
		t.unesi("Mika", "Ovo je Mikina poruka.");
		t.unesi("Korisnik 1", "14423534535");
		t.unesi("Korisnik 2", "asdfghjkl");
		
		TwitterPoruka [] nizPoruka = t.vratiPoruke(-3, "poruka");
		
		assertArrayEquals(nizPorukaTest, nizPoruka);
	}

}
