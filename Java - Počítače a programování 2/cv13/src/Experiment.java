import java.util.Random;

/**
 * Hlavni trida s haldou
 * @author Libor Vasa
 */
public class Experiment {	
	
	public static void main(String[] args) {
		Heap test = new Heap(100);
		test.add(new Interval(0, 0.1), 0.1);
		test.add(new Interval(0.1, 0.3), 0.2);
		test.add(new Interval(0.4, 0.5), 0.1);
		
		uloha2();
	}
	
	public static void uloha2() {
		Heap test = new Heap(100);
		int delka = 1000;
		int vysledek = 0;
		boolean vysledekBoolean;
		
		randInterval(test, delka);
		vysledek = testInterval(test, delka, vysledek);
		vysledekBoolean = vysledekInterval(vysledek);
		
		if(vysledekBoolean) {
			System.out.println("Test probehl v poradku.");
		} else {
			System.out.println("Test neprobehl v poradku.");
		}
	}
	
	public static void randInterval(Heap halda, int delka) {
		Random rand = new Random();
		double startInterval, konecInterval, pom;
		int hranice = 10000;
		for(int i = 0; i < delka; i++) {
			startInterval = rand.nextDouble() * hranice;
			konecInterval = rand.nextDouble() * hranice + startInterval + 1;
			pom = konecInterval - startInterval;
			halda.add(new Interval(startInterval, konecInterval), pom);
		}
	}
	
	public static int testInterval(Heap halda, int delka, int vysledek) {
		double maxPom, pom;
		maxPom = Double.MAX_VALUE;
		for(int i = 0; i < delka; i++) {
			Interval interval = halda.removeMax();
			pom = interval.end - interval.start;
			if(maxPom < pom) {
				vysledek++;
			}
			maxPom = pom;
		}
		return vysledek;
	}
	
	public static boolean vysledekInterval(int vysledek) {
		if(vysledek == 0) {
			return true;
		} else {
			return false;
		}
	}
}
