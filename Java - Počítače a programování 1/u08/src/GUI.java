import java.util.*;

/**
 * Gui slouzi k vykresleni/obnoveni bludiste
 * @author David Chromy
 * @version 2020-11-29
 */
public class GUI {
	char[][] platno;
	Scanner sc; 
	int sirka,vyska;
	
	/**
	 * Naplneni promennych pro souradnice 
	 * @param sirka sirka sveta
	 * @param vyska vyska sveta
	 * @param sc zanadi z terminalu
	 */
	public GUI(int sirka , int vyska , Scanner sc) {
		platno = new char[sirka][vyska];
		this.sc = sc;
		this.vyska=vyska;
		this.sirka=sirka;
	}
	
	/**
	 * Smazani platna/pole
	 */
	public void smaz() {
		for (int i = 0; i < sirka; i++) {
			for (int j = 0; j < vyska; j++) {
				platno[i][j] = ' ';
			}
		}
	}
			
	/**
	 * Zapis znaku na urcitou pozici
	 * @param x 
	 * @param y 
	 * @param znak
	 */
	public void zapis(int x,int y,char znak) {
		platno[x][y]=znak;
	}
	
	/**
	 * Vykresli bludiste na terminal
	 */
	public void vykresli() {
		for (int i = 0; i < vyska; i++) {
			for (int j = 0; j < sirka; j++) {
				System.out.print(platno[j][i]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Posouvani po bludisti pomoci cislic/smeru
	 * @return smer
	 */
	public Smer nactiAkci() {
		System.out.println("");
		System.out.println("Kam dal? ");
		int smer = Integer.parseInt(sc.nextLine());
		switch(smer) {
			case 2:
				return Smer.JIH;
			case 4:
				return Smer.ZAPAD;
			case 6:
				return Smer.VYCHOD;
			case 8:
				return Smer.SEVER;
			default:
				return null;
		}	
	}	
}
