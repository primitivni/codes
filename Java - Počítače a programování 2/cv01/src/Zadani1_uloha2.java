import java.util.Random;

/**
 * Serazeni posloupnosti int[]
 * @author David Chromy
 * @version 2021
 */
public class Zadani1_uloha2 {
	
	public static Random rand = new Random();
	
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
	 * Metoda main programu
	 * @param args
	 */
	public static void main(String[] args) {
		int L, cislo;
		long casInterval = 0, casSequential = 0;
		for(int j = 0; j < 1000; j++) {
			L = rand.nextInt(100000-10000) + 10001; //generovani cisla v intervalu (10 000; 100 000)
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
}
