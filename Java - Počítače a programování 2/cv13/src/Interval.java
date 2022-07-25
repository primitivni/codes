/**
 * Interval mezi dvema merenimi
 * @author Libor Vasa
 */
class Interval {
	/** Zacatek intervalu */
	double start; 
	/** Konec intervalu */
	double end;  
  
	/**
	 * Vytvori novy interval mezi dvema merenimi
	 * @param start zacatek intervalu
	 * @param end konec intervalu
	 */
	public Interval(double start, double end) {
		this.start = start;
		this.end = end;
	}		
}