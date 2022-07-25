import java.util.Arrays;
import java.util.Random;

/**
 * Testovani razeni
 * @author Libor Vasa 
 */
public class SortingTest {

	/**
	 * Otestuje pocty porovani zadaneho razeni
	 * @param algorithm testovany algoritmus razeni 
	 */
	private static void testCounts(ISortingAlgorithm algorithm) {
		int MIN_LENGTH = 100;
		int MAX_LENGTH = 100000;
		int TEST_COUNT = 100;
		int pom = 0;
		for (int length = MIN_LENGTH; length < MAX_LENGTH; length *= 2) {
			int minComp1 = Integer.MAX_VALUE;
			int maxComp1 = 0;
			for (int test = 0; test < TEST_COUNT; test++) {
				int[] data = generateData(length);
				
				try {
					algorithm.sort(data);;
				} catch (StackOverflowError e) {
					System.out.println("!Chyba, continuing.");
					break;
				}
				
				if (algorithm.comparesInLastSort() > maxComp1) {
					maxComp1 = algorithm.comparesInLastSort();
				}
				
				if (algorithm.comparesInLastSort() < minComp1) {
					minComp1 = algorithm.comparesInLastSort();
				}
			}	
			System.out.println("\t Length: " + length + ", Min:" + minComp1 + ", Max:" + maxComp1 + ", OnlySort Time: " + cas(algorithm, length) + " s");
			
			int[] data2 = generateDataSorted(length);
				
			try {
				algorithm.sort(data2);;
			} catch (StackOverflowError e) {
				System.out.println("!Chyba, continuing.");
				break;
			}	
			pom = algorithm.comparesInLastSort();
			System.out.println("Sorted: Length: " + length + ", Min:" + pom + ", Max:" + pom + ", Count: " + pom + ", OnlySort Time: " + casSorted(algorithm, length) + " s");
		}
	}
	
	private static int[] generateDataSorted(int c) {
		int[] result = new int[c];
		Random rnd = new Random();
		result[0] = rnd.nextInt(c);
		for (int i = 1; i < c; i++) {
			result[i] = result[i-1] + 1 + rnd.nextInt(c);
		}
		return result;
	}
	
	/**
	 * Otestuje spravnost zadaneho razeni
	 * @param algorithm testovany algoritmus razeni
	 */
	private static boolean testCorrectness(ISortingAlgorithm algorithm) {
		for (int i = 0; i < 100; i++) {
			int[] data = generateData(100);
			int[] dataCopy = new int[data.length];
			for (int j = 0; j < data.length; j++) {
				dataCopy[j] = data[j];
			}
			algorithm.sort(data);
			Arrays.sort(dataCopy);
			for (int j = 0; j < data.length; j++) {
				
				if (data[j] != dataCopy[j]) { //ZMENA - zmena promenne i za j, chceme otestovat zda se razeni provedlo spravne
					
					System.out.println("Algorithm failed, terminating.");
					return false;
				}
			}			
		}
		System.out.println("Algorithm passed test, continuing.");
		return true;
	}

	/**
	 * Vygeneruje pole o zadane velikosti c nahodnych cisel z intervalu <0; c)
	 * @param c velikost vygenerovaneho pole a horni hranice generovanych hodnot
	 * @return vygenerovane pole nahodnych cisel
	 */
	private static int[] generateData(int c) {
		int[] result = new int[c];
		Random rnd = new Random();
		for (int i = 0; i < c; i++) {
			result[i] = rnd.nextInt(c);
		}
		return result;
	}

	/**
	 * Metoda na zmereni casu serazeni pole
	 * @param algorithm
	 * @param c
	 * @return
	 */
	private static double cas(ISortingAlgorithm algorithm, int c) {
		int prevod = 1000000000;
		long casStart = System.nanoTime();
		algorithm.onlySort(generateData(c));
		long casStop = System.nanoTime();
		double cas = (double)(casStop - casStart)/prevod;
		return cas;
	}

	/**
	 * Metoda na zmereni casu serazeni pole
	 * @param algorithm
	 * @param c
	 * @return
	 */
	private static double casSorted(ISortingAlgorithm algorithm, int c) {
		int prevod = 1000000000;
		long casStart = System.nanoTime();
		algorithm.onlySort(generateDataSorted(c));
		long casStop = System.nanoTime();
		double cas = (double)(casStop - casStart)/prevod;
		return cas;
	}

	/**
	 * Metoda main programu
	 * @param args
	 */
	public static void main(String[] args) {
		ISortingAlgorithm algorithm1 = new InsertSort();
		ISortingAlgorithm algorithm2 = new QuickSort();
		ISortingAlgorithm algorithm3 = new MergeSort();
		ISortingAlgorithm algorithm4 = new JavaSort();

		if (testCorrectness(algorithm1)) {
			testCounts(algorithm1);
		}
		if (testCorrectness(algorithm2)) {
			testCounts(algorithm2);
		}
		if (testCorrectness(algorithm3)) {
			testCounts(algorithm3);
		}
		if (testCorrectness(algorithm4)) {
			testCounts(algorithm4);
		}
	}
}