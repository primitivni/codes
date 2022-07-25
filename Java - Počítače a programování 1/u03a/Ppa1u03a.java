import java.util.*;

/**
 * Reseni kvadraticke rovnice v danem intervalu
 * @author DavidChromy
 * @version 2020-10-17
 */
public class Ppa1u03a {
	/**
	 * Vstupni bod programu
	 * @param args parametry prikazove radky
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * Nacitani hodnot
		 */
		System.out.print("Zadej koeficient a: ");
		double a = sc.nextDouble();
		System.out.print("Zadej koeficient b: ");
		double b = sc.nextDouble();
		System.out.print("Zadej koeficient c: ");
		double c = sc.nextDouble();
		System.out.print("Zadej pocatek intervalu x1: ");
		double x1 = sc.nextDouble();
		System.out.print("Zadej konec intervalu x2: ");
		double x2 = sc.nextDouble();
		int pocet = 0;
		/*
		 * Vypocty/Porovnani
		 */
		double D = Math.pow(b, 2) - 4*a*c;
		double reseniX1 = (-b+Math.sqrt(D))/(2*a);
		double reseniX2 = (-b-Math.sqrt(D))/(2*a);
		if(a==0 && b==0) {
			pocet = -1;
		} else if(reseniX1==reseniX2) {
				if(reseniX1>x1 && reseniX1<x2) {
					pocet = 0;
				} else {
					pocet--;
				}
		} else if(reseniX1<x1) {
			pocet--;
			if(reseniX2<x1) {
				pocet--;
			} else if(reseniX2>x1 && reseniX2<x2) {
					pocet++;
			} else if(reseniX2>x2) {
				pocet--;
			}
		} else if(reseniX1>x1 && reseniX1<x2) {
			pocet++;
			if(reseniX2<x1) {
				pocet--;
			} else if(reseniX2>x1 && reseniX2<x2) {
					pocet++;
			} else if(reseniX2>x2) {
				pocet--;
			}
		} else if(reseniX1>x2) {
			pocet--;
			if(reseniX2<x1) {
				pocet--;
			} else if(reseniX2>x1 && reseniX2<x2) {
					pocet++;
			} else if(reseniX2>x2) {
				pocet--;
			}
		}
		/*
		 * Vypis hodnot
		 */
		if(pocet<0) {
			System.out.println("reseni: neexistuje");
		} else if(pocet==0) {
			System.out.println("reseni: existuje jedno");
		} else if(pocet>0) {
			System.out.println("reseni: existuji dve");
		}
		System.out.println(reseniX1);
		System.out.println(reseniX2);
		System.out.println(pocet);
	}

}
