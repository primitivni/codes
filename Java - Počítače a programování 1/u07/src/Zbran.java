/**
 * Postava vytvari charakter a jeji prislusne hodnoty
 * @author David Chromy
 * @version 2020-11-22
 */
public class Zbran {
	public String nazev;
	public int utok;
	public int obrana;

	/**
	 * Naplneni jednotlivych promennych
	 * @param nazev
	 * @param utok 
	 * @param obrana
	 */
	public Zbran(String nazev, int utok, int obrana) {
		this.nazev = nazev;
		this.utok = utok;
		this.obrana = obrana;
	}
	
	/**
	 * Utocna sila zbrane
	 * @return utok
	 */
	public int getUtok() {
		return utok;
	}
	
	/**
	 * Obrana sila zbrane
	 * @return obrana
	 */
	public int getObrana() {
		return obrana;
	}
	
	/**
	 * String s hodnotami zbrane
	 * @return string s hodnotami
	 */
	public String toString() {
		return nazev + " (" + utok + "/" + obrana + ")";
	}
}
