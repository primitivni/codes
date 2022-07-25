import java.util.*;

/**
 * Spusteni programu
 * @author David Chromy
 * @version 2020-11-29
 */
public class Ppa1u08 {
	
	/**
	 * Nekonecny cyklus pro pohyb postavy a zavolani GUI, SVET, POSTAVA
	 * @param gui 	
	 * @param svet
	 * @param postava 
	 * @return true/false
	 */
	public static boolean spust(GUI gui , Svet svet , Postava postava) {
		gui.smaz();
		do {
			svet.vykresli(gui);
			postava.vykresli(gui);
			gui.vykresli();
			if(postava.jeDoma()) {
				return true;
			}
			Smer smer = gui.nactiAkci();
			if(smer==null) {
				return false;
			}
			if(postava.jdi(smer) == false) {
				return false;
			}
		} while(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GUI gui = new GUI(7,5,sc);
		Svet svet = new Svet(7, 5, new char[]{
						'#','#','#','#','#','#','#',
						'#',' ','#',' ',' ',' ','#',
						'#',' ','#',' ',' ',' ','#',
						'#',' ',' ',' ','#',' ','#',
						'#','#','#','#','#','#','#',
				});
		Postava hrac = new Postava(svet,2,3,3,2);
		if(spust(gui,svet,hrac)) {
			System.out.println("");
			System.out.println("Konecne doma...");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Asi jsem se ztratil...");
			System.out.println("");
		}
		sc.close();
	}
}
