/**
 * Razeni vkladanim (insertion sort)
 * @author Libor Vasa 
 */
class InsertSort implements ISortingAlgorithm {
	/** Pocet porovani v poslednim provedenem razeni */	
	int compares = 0;

	/**
	 * Vrati true, pokud je prvek na indexu i vetsi nez v, jinak false
	 * Inkrementuje citac porovnani.
	 * @param data razene pole
	 * @param i index prvku, ktery se ma porovnat
	 * @param v hodnota, se kterou se ma prvek porovnat
	 * @return true, pokud je prvek na indexu i vetsi nez v, jinak false 
	 */
	boolean greaterThan(int[] data, int i, int v) {
		compares++;
		return data[i] > v;
	}
	
	@Override
	public void sort(int[] data) {		
		compares = 0; //ZMENA - nutne prizazeni hodnoty 0, z duvodu opetovneho volani sortu
		for (int i = 1; i < data.length; i++) {
			int v = data[i];
			int j = i - 1;
			
			while((j >= 0) && (greaterThan(data, j, v))) { //ZMENA - muze byt j ==	0, jelikoz reprezentuje index v poli, takze muze nabyvat hodnoty 0
														   //ZMENA - do parametru greaterThan() musi byt jako druhy parametr index, ktery ale reprezentuje promenna j, nikoli i
				
				data[j + 1] = data[j];				
				j--;
			}		
			data[j + 1] = v;
		}
	}	

	@Override	
	public int comparesInLastSort() {
		return compares;
	}
	
	@Override
	public void onlySort(int[] data) {
		sort(data);
		
	}
}
