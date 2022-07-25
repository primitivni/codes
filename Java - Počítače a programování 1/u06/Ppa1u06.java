import java.util.*;

/**
 * Program na rozlozeni prirozenych cisel na soucet prvocisel
 * @author DavidChromy
 * @version 2020-11-4
 */
public class Ppa1u06 {
	public static Scanner sc = new Scanner(System.in);;
	public static int cislo = 0, deleni;
	/**
	 * Nacteni prirozene cisla z klavesni v intervalu (0;2 147 483 647)
	 * @param sc
	 * @return cislo
	 */
	public static int nactiPrirozeneCislo(Scanner sc) {
		do {
			System.out.print("Zadej prirozene cislo: ");
			cislo = sc.nextInt();
		} while(cislo<=0);
		return cislo;
	}
	/**
	 * Zjisti, zda zadane cislo je prvocislem nebo ne
	 * @param cislo
	 * @return true, false
	 */
	public static boolean jePrvocislo(int cislo) {
		for(int i=1; i<=cislo; i++) {
			if(cislo%i==0) {
				deleni++;
			}
		}
		if(deleni==2) {
			deleni = 0;
			return true;
		} else {
			deleni = 0;
			return false;
		}
	}
	/**
	 * Rozlozi prirozene cislo na soucet dvou prvocisel a vypise na terminal
	 * @param cislo
	 * @return 0, 1;
	 */
	public static int jeSoucetPrvocisel(int cislo) {
		for(int i =cislo; i>=1; i--) {
			if(jePrvocislo(i)) {
				int pom = cislo - i;
				if(jePrvocislo(pom)) {
					System.out.printf("Lze rozlozit: %d + %d", pom, i);
					return i;
				}
			}
		}
		return 0;
	}
	/**
	 * Vstupni bod programu
	 * @param args
	 */
	public static void main(String[] args) {
		cislo = nactiPrirozeneCislo(sc);
		if(jePrvocislo(cislo))
		{
			System.out.println("Nelze rozlozit.");
		}
		else
		{
			jeSoucetPrvocisel(cislo);
		}
	}
}
