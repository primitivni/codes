import java.util.*;

/**
 * Ppa1u07 nacteni postav, zbrani a boj
 * @author David Chromy
 * @version 2020-11-22
 */
public class Ppa1u07 {
	/**
	 * Nacteni hodnot postavy pomoci z terminalu
	 * @param sc
	 * @return Postava - hodnoty postavy
	 */
	public static Postava nactiPostavu(Scanner sc){
		System.out.print("Zadejte jmeno postavy:");
		String jmeno = sc.nextLine();
		System.out.print("Zadejte silu postavy:");
		int sila = Integer.parseInt(sc.nextLine());
		System.out.print("Zadejte hbitost postavy:");
		int hbitost = Integer.parseInt(sc.nextLine());
		System.out.print("Zadejte vitalitu postavy:");
		int vitalita = Integer.parseInt(sc.nextLine());

		return new Postava(jmeno, sila, hbitost, vitalita);
	}
	/**
	 * Nacteni hodnot zbrane pomoci z terminalu
	 * @param sc 
	 * @return Zbran - hodnoty zbrane
	 */
	public static Zbran nactiZbran(Scanner sc) {
		System.out.print("Zadejte nazev zbrane:");
		String nazev = sc.nextLine();
		if (nazev.length() != 0) {
			System.out.print("Zadejte utocnou silu zbrane:");
			int silaZbrane = Integer.parseInt(sc.nextLine());
			System.out.print("Zadejte obrannou silu zbrane:");
			int obranaZbrane = Integer.parseInt(sc.nextLine());

			return new Zbran(nazev, silaZbrane, obranaZbrane);
		} else {
		return null;
		}
	}
	/**
	 * Vyzbrojeni postavy
	 * @param postava
	 * @param leva
	 * @param prava
	 */
	public static void vyzbrojPostavu(Postava postava, Zbran leva, Zbran prava) {
		if (leva != null) {
			postava.vezmiZbran(Ruka.LEVA, leva);
		}
		if (prava != null) {
			postava.vezmiZbran(Ruka.PRAVA, prava);
		}
	}
	/**
	 * Souboj postav
	 * @param postava1
	 * @param postava2
	 * @return vitez souboje
	 */
	public static Postava souboj(Postava postava1, Postava postava2) 
	{
		int i = 0;
		while (true) {
			if (postava1.getVitalita() < 1) {
				return postava2;
			} else if (postava2.getVitalita() < 1) {
				return postava1;
			} else if (i%2 == 0) {
				System.out.println("utoci " + postava1.toString() + " a dava " + Math.abs(postava2.branSe(postava1.zautoc())) + " zraneni");
			} else {
				System.out.println("utoci " + postava2.toString() + " a dava " + Math.abs(postava1.branSe(postava2.zautoc())) + " zraneni");
			}
			i++;
			}
		}
	/**
	 * Nacteni vlastnosti postav a zbrani
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Postava bojovnik1 = nactiPostavu(sc);
		vyzbrojPostavu(bojovnik1, nactiZbran(sc), nactiZbran(sc));
		Postava bojovnik2 = nactiPostavu(sc);
		vyzbrojPostavu(bojovnik2, nactiZbran(sc), nactiZbran(sc));

		System.out.println("Vitez: " + souboj(bojovnik1, bojovnik2).toString());
	}
}



