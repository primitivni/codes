import java.util.*;
/**
 * Vypocet cen vstupenek
 * @author DavidChromy
 * @version 2020-10-6
 */
public class Ppa1u02a {
	public static Scanner sc;
	/**
	 * Vstupni bod programu
	 * @param args parametry prikazove radky 	 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //
		sc.useLocale(Locale.US);
		double cenaVstupenky, cenaKarty, sleva, cenaSleva, akce1, akce2, akce3;
		/*
		 * Nacitani hodnot
		 */
		System.out.print("Zadej cenu vstupenky [Kc]: ");
		cenaVstupenky = sc.nextDouble();
		System.out.print("Zadej cenu klubove karty [Kc]: ");
		cenaKarty = sc.nextDouble();
		System.out.print("Zadej slevu [%]: ");
		sleva = sc.nextDouble();
		/*
		 * Vypocty
		 */
		cenaSleva = cenaVstupenky*((100-sleva)/100);
		akce1 = cenaSleva+cenaKarty;
		akce2 = cenaSleva+(cenaKarty/2);
		akce3 = cenaSleva+(cenaKarty/3);
		/*
		 * Vypis vypoctenych hodnot
		 */
		System.out.println("cena vstupenky: "+cenaVstupenky);
		System.out.format(Locale.US, "klubova cena: %4.1f%n", cenaSleva);
		System.out.format(Locale.US, "1 akce: %4.1f%n", akce1);
		System.out.format(Locale.US, "2 akce: %4.1f%n", akce2);
		System.out.format(Locale.US, "3 akce: %4.1f%n", akce3);
	}
}

