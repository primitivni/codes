import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Zadani1_uloha3 {
	
	public static Random rand = new Random();
	public static Scanner sc1, sc2;
	
	/**
	 * Metoda rozhoduje, zda se predana hodnota x nachazi v predanem serazenem poli
	 * @param data vstupni pole serazenych hodnot od nejmensi po nejvetsi
	 * @param x hledana hodnota
	 * @return true, kdyz se x nachazi v poli data, jinak false
	 */	
	static boolean intervalSubdivision(int[] data, int x) {
		int left = 0; //leva hranice intervalu
		
		int right = data.length-1; //prava hranice intervalu //ZMENA - upravena prava hranice intervalu, bez osetreni -1 se dostaneme mimo delku pole pri praci cyklu while
		
		int mid = (left + right) / 2; //index uprostred intervalu
		while (data[mid] != x) {
			if (left >= right) { //ZMENA - upraven vztah mezi left a right, upraveno znamenko na >=, protoze left == right nemuze nastat
				return false;
			}
			//nyni zmensime interval	
			if (data[mid] > x) {
				right = mid - 1;		
			}
			else {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		return true; 
	}

	/**
	 * Metoda pro sekvencni hledani prvku x z pole data
	 * @param data
	 * @param x
	 * @return true/false zda se nachazi prvek v poli
	 */
	static boolean sequentialSearch(int[] data, int x) {
		for(int i = 0; i < data.length; i++) { //cyklus pro pohyb v poli
			if(data[i]==x) { //podminka pro overeni, zda je prvek v posloupnosti
				return true;
			}
		}
		return false;
	}

	/**
	 * Metoda pro generovani posloupnosti o delce L
	 * @param L
	 * @return vygenerovana posloupnost
	 */
	static int[] generovani(int L) {
		int[] posloupnost = new int[L]; //posloupnosti o velikosti parametru L
		posloupnost[0] = rand.nextInt(50);
		for(int i = 1; i < L; i++) {
			posloupnost[i] = posloupnost[i-1] + 1 + rand.nextInt(50); //naplneni posloupnosti cisly
		}
		return posloupnost;
	}

	/**
	 * Metoda pro overeni pole posloupnosti
	 * @param pole
	 */
	static void overeni(int[] pole){
		for(int i = 0; i < 1000; i++){
			int cislo = rand.nextInt(pole[pole.length-1]);
			if(sequentialSearch(pole, cislo) != intervalSubdivision(pole, cislo)) {
				System.out.println("Chyba!");
			}
		}
	}

	/**
	 * Metoda pro nacitani dat ze souboru
	 * @param soubor, vstupni soubor z adresare
	 * @return posloupnost nactena ze souboru
	 * @throws IOException
	 */
	static int[] nacitani(String soubor) throws IOException {
		sc1 = new Scanner(Paths.get(soubor));
		int delka = 0;
		while(sc1.hasNextInt()) {
			sc1.nextInt();
			delka++;
		}
		sc2 = new Scanner(Paths.get(soubor));
		int[] pole = new int[delka];
		for(int i = 0; i < delka; i++) {
		    int pom = sc2.nextInt();
			pole[i] = pom;
		}
		sc1.close();
		sc2.close();
		return pole;
	}

	/**
	 * Metoda pro overeni zda je posloupnost serazena
	 * @param data posloupnost
	 * @return true/false zda je serazene
	 */
	static boolean isSorted(int[] data) {
		for(int i = 1; i < data.length; i++) {
			if(data[i-1] > data[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Metoda pro vypocet casove narocnosti programu, prohledani posloupnosti
	 */
	static void cas() {
		int L, cislo;
		long casInterval = 0, casSequential = 0;
		for(int j = 0; j < 1000; j++) {
			L = rand.nextInt(89999) + 10001; //generovani cisla v intervalu (10 000; 100 000)
			int[] pole = generovani(L);
			overeni(pole);
			
			for(int i = 0; i < 1000; i++) {
				cislo = rand.nextInt(pole[pole.length-1]); //generovani cisla s rozsahem vygenerovane posloupnosti
				
				long casIntervalSubStart = System.nanoTime();
				intervalSubdivision(pole, cislo);
				long casIntervalSubStop = System.nanoTime();
				casInterval += casIntervalSubStop - casIntervalSubStart; 
				
				long casSequentialSearchStart = System.nanoTime();
				sequentialSearch(pole, cislo);
				long casSequentialSearchStop = System.nanoTime();
				casSequential += casSequentialSearchStop - casSequentialSearchStart;
			}
		}
		System.out.println("Interval subdivision finished in " + (casInterval) + " ns");
		System.out.println("Sequential search finished in " + (casSequential) + " ns");
	}

	/**
	 * Metoda pro
	 * @param pole
	 */
	static void mereni(int[] pole) {
		long casInterval = 0, casSequential = 0;
		overeni(pole);
		for(int i = 0; i < 10000; i++) {
			int cislo = rand.nextInt(pole[pole.length-1]);
			
			long casIntervalSubStart = System.nanoTime();
			intervalSubdivision(pole, cislo);
			long casIntervalSubStop = System.nanoTime();
			casInterval += casIntervalSubStop - casIntervalSubStart; 
			
			long casSequentialSearchStart = System.nanoTime();
			sequentialSearch(pole, cislo);
			long casSequentialSearchStop = System.nanoTime();
			casSequential += casSequentialSearchStop - casSequentialSearchStart;
		}
		System.out.println("Interval subdivision finished in " + (casInterval) + " ns");
		System.out.println("Sequential search finished in " + (casSequential) + " ns");
		double pomer = (double)casSequential/casInterval; 
		System.out.printf("Puleni intervalu je %.2fx (-krat) rychlejsi nez sekvencni.\n", pomer);
	}

	/**
	 * Metoda main programu
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			for(int i = 1; i <= 10; i++) {
			String nazev = "seq"+i+".txt";
			int[] pole = nacitani(nazev);
			if(isSorted(pole)) {
				System.out.println(nazev);
				System.out.println("Pocet prvku: "+pole.length);
				mereni(pole);
				System.out.println();
				}
			else {
				System.out.println("Soubor: "+nazev+" neni serazen.\n");
			}
		  }	
		} catch (IOException ex) {
			System.out.println("Nepodarilo se nacist soubor.");
			}
	}
}
