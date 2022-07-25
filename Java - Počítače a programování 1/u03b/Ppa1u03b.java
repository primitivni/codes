import java.util.*;
/**
 * Kino
 * @author DavidChromy
 * @version 2020-10-17
 */
public class Ppa1u03b {

	/**
	 * Vstupni bod programu
	 * @param args parametry prikazove radky
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * Nacitani hodnot
		 */
		System.out.println("zacatek filmu A: ");
		System.out.print("hodina: ");
		int zacatekHA = sc.nextInt();
		System.out.print("minuta: ");
		int zacatekMA = sc.nextInt();
		System.out.println("delka filmu A: ");
		System.out.print("hodina: ");
		int delkaHA = sc.nextInt();
		System.out.print("minuta: ");
		int delkaMA = sc.nextInt();
		System.out.println("zacatek filmu B: ");
		System.out.print("hodina: ");
		int zacatekHB = sc.nextInt();
		System.out.print("minuta: ");
		int zacatekMB = sc.nextInt();
		System.out.println("delka filmu B: ");
		System.out.print("hodina: ");
		int delkaHB = sc.nextInt();
		System.out.print("minuta: ");
		int delkaMB = sc.nextInt();
		/*
		 * Vypocty
		 */
		int rozdil = 0;
		int delkaA = 0;
		int delkaB = 0;
		if(zacatekHA>=0 && zacatekHA<=3) {
			zacatekHA = zacatekHA+24;
		} else if(zacatekHB>=0 && zacatekHB<=3) {
			zacatekHB = zacatekHB+24;
		}
		int konecHA = zacatekHA + delkaHA;
		int konecMA = zacatekMA + delkaMA;
		int konecHB = zacatekHB + delkaHB;
		int konecMB = zacatekMB + delkaMB;
		rozdil = ((konecHA*60)+konecMA)-((zacatekHB*60)+zacatekMB);
		delkaA = (delkaHA*60)+delkaMA;
		delkaB = (delkaHB*60)+delkaMB;
		/*
		 * Vypis ziskanych hodnot
		 */
		if(rozdil<0) {
			System.out.println("doporuceni: v pohode");
		} else if(rozdil>0 && rozdil<delkaB) {
			System.out.printf("doporuceni: neuvidis %d minut", rozdil);
		} else if(rozdil>=delkaB) {
			if(rozdil>delkaA) {
				System.out.println("doporuceni: v pohode");
			} else {
				System.out.println("doporuceni: to nedas");
			}	
		}	
	}
}
