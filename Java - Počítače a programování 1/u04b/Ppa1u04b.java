import java.util.*;

/**
 * Vazeny klouzavy prumer
 * @author DavidChromy
 * @version 2020-10-27
 */
public class Ppa1u04b {
	/**
	 * Vstupni bod programu
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		/*
		 * Nacitani hodnot/cisel
		 */
		double hodnoty = sc.nextDouble(); 
		int nCislo = 1;
		double prvniCislo = 0;
		double druheCislo = 0;
		double tretiCislo = 0;
		double ctvrteCislo = 0;
		/*
		 * Cyklus while
		 */
		while(hodnoty!=0) {
			/*
			 * Razeni hodnot
			 * Vypocet klouzaveho prumeru
			 */
			prvniCislo = druheCislo;
			druheCislo = tretiCislo;
			tretiCislo = ctvrteCislo;
			ctvrteCislo = hodnoty;
			double WMA = ((ctvrteCislo*4)+(tretiCislo*3)+(druheCislo*2)+prvniCislo)/10;
			/*
			 * Vypis ziskanych hodnot/cisel, nacitani hodnot 
			 */
			if(nCislo<=3) {
				System.out.printf(Locale.US, "%d;%.2f;\n", nCislo, hodnoty);
				hodnoty = sc.nextDouble();
			} else {
				System.out.printf(Locale.US, "%d;%.2f;%.2f\n", nCislo, hodnoty, WMA);
				hodnoty = sc.nextDouble();
			}
			nCislo++;
		}
	}
}
