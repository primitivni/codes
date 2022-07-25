import java.util.*;

/**
 * Program na generaci cisel A a B pro zadane cele cislo C, nesoudelna cisla
 * @author DavidChromy
 *
 */
public class Ppa1u05b {
	/**
	 * Vstupni bod programu
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * Nacitani hodnoty C ze vstupu/Deklarace promenych
		 */
		System.out.print("c: ");
		int c = sc.nextInt();
		int b = 0;
		int a = 0;
		/*
		 * Cyklus pro generaci nesoudelnych cysel/Vystup
		 */
		if(c==0) {
			System.out.println("Reseni neexistuje.");
			
		}
		for(int i=1; i<c; i++) {
			for(int j=1; j<c; j++) {
				if(c==Math.sqrt(Math.pow(j, 2)+Math.pow(i, 2))) {
					a = j;
					b = i;
				}
			}
		}
		/*
		 * Vypis hodnot
		 */
		for(int del = 2; del<=c; del++) {
			if(a%del==0 && b%del==0 || a%del==0 && c%del==0) {
				System.out.println("Reseni neexistuje."); break;
			} else {
				System.out.printf("%d^2 + %d^2 = %d^2", a, b, c); break;
			}	
		}	
	}
}
