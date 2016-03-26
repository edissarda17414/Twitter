package com.twitter.poruke;


/**
 * Klasa predstavlja twitter poruku.
 * 
 * @author Edis Šarda
 * @version 0.1
 *
 */
public class TwitterPoruka {

	/**
	 * Atribut koji predstavlja ime korisnika koji je poslao poruku
	 */
	private String korisnik;
	
	/**
	 * Atribut koji predstavlja twitter poruku 
	 */
	private String poruka;

	
	/**
	 * Redefinisana metoda 'toString'.
	 * 
	 * @return ime korisnika i twitter poruku u zadatom formatu.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}	
	
	
	/**
	 * Metoda vraca ime korisnika koji je poslao poruku
	 * 
	 * @return ime korisnika koji je poslao poruku
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja vrednost atributa 'korisnik' na vrednost zadatog parametra
	 * 
	 * @param korisnik ime korisnika
	 * @throws java.lang.RuntimeException ako je vrednost unetog parametra null ili prazan string
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.trim().isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	
	/**
	 * Metoda vraca twitter poruku
	 * 
	 * @return twitter poruku
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja vrednost atributa 'poruka' na zadatu vrednost
	 * 
	 * @param poruka sadrzaj poruke
	 * @throws java.lang.RuntimeException ako je vrednost unetog parametra null ili je duzina parametra veca od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}



}
