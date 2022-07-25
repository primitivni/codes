/**
 * Trida pro vyhledavani prvku v poli
 * @author Libor Vasa !!! Garant predmetu doc. Vasa, ktery tvori kody na debugging a cviceni
 */
public class Zadani1_uloha1 {
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

	public static void main(String[] args) {
		int[] data = new int[] {1, 3, 5, 41, 48, 52, 63, 71};
		long start = System.nanoTime();
		boolean found = intervalSubdivision(data, 41);
		long stop = System.nanoTime();
		System.out.println("Interval subdivision finished in " + (stop - start) + " ns");
		System.out.println("Number found: " + found);
	}
}
