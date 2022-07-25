import java.util.Scanner;

public class Uloha3 {
	public static Scanner sc = new Scanner(System.in);
	public static IStringStack stack3 = new StackArray();
	public static IStringStack stack4 = new StackArray();

	final static String HOTOVO = "H";
	final static String ROZDELIT = "R";
	final static String PRAZDNO = "";

	public static String ukol = null;
	public static String pom1 = null;
	public static int pom2 = 0;
	
	public static void main(String[] args) {
		zacatek();
	}
	
	public static void zacatek() {
		System.out.println("Co je treba udelat?"); 
		String ukol = sc.nextLine();
		stack3.add(ukol);
		System.out.println("Aktualni ukol: " + stack3.get());
		coSukolem();
	 }
	
	public static void coSukolem() {
		System.out.println("Co s ukolem? (H = Hotovo, R = Rozdelit)");
		String odpoved = sc.nextLine();
		if(odpoved.equals(HOTOVO)) {
			pokracovani();
		} else if(odpoved.equals(ROZDELIT)) {
			System.out.println("Prosim zadej podukoly, ukoncene prazdnym retezcem.");
			rozdeleni();			
		}
	}
	
	public static void rozdeleni() {
		try {
			pom2 = 0;
			do {
				ukol = sc.nextLine();
				pom1 = ukol;
				if(pom1.equals(PRAZDNO)) {
					//
				} else {
					stack3.add(ukol);
					pom2++;
				}
			} while(!(pom1.equals(PRAZDNO)));
		
			for(int i = 0; i < pom2; i++) {
				stack4.add(stack3.get());
				stack3.removeLast();
			}
		
			pokracovani();
		} catch (StackOverflowError e) {
			System.out.println("Chyba zasobniku!");
		}
	}
	
	public static void pokracovani() {
		if(stack4.get() == null) {
			System.out.println("Hlavni ukol " + stack3.get() + " byl splnen.");	
		} else {
			System.out.println("Aktualni ukol: " + stack4.get());
			stack4.removeLast();
			coSukolem();
		}	
	}
}
