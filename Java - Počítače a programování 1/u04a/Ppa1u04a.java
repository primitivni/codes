import java.util.*;

/**
 * Lokalni extremy z uzavreneho intervalu <x1;x2> funkce f
 * @author DavidChromy
 * @version 2020-10-20
 */
public class Ppa1u04a {
	public static Scanner sc;
	/**
	 * Vstupni bod programu
	 * @param args
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		double min = 0;
		double max = 0;
		double funkce = 0;
		double funkce1 = 0;
		double funkce2 = 0;
		final double DEL = 1.0/1024;
		/*
		 * Nacitani hodnot z klavesnice
		 */
		System.out.print("Zadej a: ");
		double a = sc.nextDouble();
		System.out.print("Zadej b: ");
		double b = sc.nextDouble();
		System.out.print("Zadej c: ");
		double c = sc.nextDouble();
		System.out.print("Zadej x1: ");
		double x1 = sc.nextDouble();
		System.out.print("Zadej x2: ");
		double x2 = sc.nextDouble();
		/*
		 * Vypocty/Cyklus for
		 */
		for(double i = x1; i<=x2;i+=DEL) {
			funkce = Math.cos(i)+a*Math.cos(b*i+c);
			funkce1 = Math.cos(i-DEL)+a*Math.cos(b*(i-DEL)+c);
			funkce2 = Math.cos(i+DEL)+a*Math.cos(b*(i+DEL)+c); 
			if(funkce1-funkce<=0 && funkce-funkce2>=0) {
				max++;
			} else if(funkce1-funkce>=0 && funkce-funkce2<=0) {
				min++;
			}
		}
		/*
		 * Vypis ziskanych hodnot
		 */
		System.out.printf("min: %.0f\n", min);
		System.out.printf("max: %.0f\n", max);
	}
}
