/**
 * Postava vytvari charakter a jeji prislusne hodnoty
 * @author David Chromy
 * @version 2020-11-22
 */
public class Postava {
	public String jmeno;
	public int sila;
	public int hbitost;
	public int vitalita;
	public int puvodniVitalita;

	Zbran leva = null;
	Zbran prava = null;

	/**
	 * Naplneni jednotlivych promennych
	 * @param jmeno - jmeno
	 * @param sila - sila
	 * @param hbitost - reflexy
	 * @param vitalita - zivoty
	 * @param puvodniVitalita - puvodniZivoty
	 */
	public Postava(String jmeno, int sila, int hbitost, int vitalita) {
		this.jmeno = jmeno;
		this.sila = sila;
		this.hbitost = hbitost;
		this.vitalita = vitalita;
		this.puvodniVitalita = vitalita;
	}
	/**
	 * Nacteni zbrane do ruky prava/leva
	 * @param ruka 
	 * @param zbran
	 */
	public boolean vezmiZbran(Ruka ruka, Zbran zbran) {
		if (ruka == Ruka.LEVA) {
			if (leva == null) {
				leva = zbran;	
			} else {
				return false;
			}
		} else {
			if (prava == null) {
				prava = zbran;
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Simulace boje, utoku a klesani zivotu
	 * @param utok 
	 * @return vitalita - zraneni
	 */
	public int branSe(int utok) {
		int zraneni = getObrana() - utok;
		if (zraneni > 0) {
			zraneni = 0;
		}
		vitalita += zraneni;
		return Math.abs(zraneni);
	}
	
	/**
	 * Aktualni vitalita
	 * @return vitalita 
	 */
	public int getVitalita() 
	{
		return vitalita;
	}
	
	/**
	 * Celkova sila/utok
	 * @return utok 
	 */
	public int zautoc() 
	{
		return getUtok();
	}
	
	/**
	 * Zjisteni, zda postava zije
	 * @return true je ziva/false neni ziva
	 */
	public boolean jeZiva() {
		if(vitalita<=0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * String s hodnotami postavi
	 * @return string s hodnotami
	 */
	public String toString() {
		return jmeno + " ["+vitalita+"/" + puvodniVitalita + "] ("+ this.getUtok() 
		+"/" + this.getObrana() + ")";
	}
	
	/**
	 * Celkovy utok postavy
	 * @return soucet utoku
	 */
	public int getUtok() {
		int soucetUtoku = sila;

		if (leva == null) {
			
		} else {
			soucetUtoku = soucetUtoku + leva.getUtok();
		}
		if (prava == null) {
			
		} else {
			soucetUtoku = soucetUtoku + prava.getUtok();
		}
		return soucetUtoku;
	}
	
	/**
	 * Celkova obrana postavy
	 * @return soucet obrany
	 */
	public int getObrana() {
		int soucetObrany = hbitost;

		if (leva != null) {
			soucetObrany = soucetObrany + leva.getObrana();
		}
		if (prava != null) {
			soucetObrany = soucetObrany + prava.getObrana();
		}
		return soucetObrany;
	}
}
