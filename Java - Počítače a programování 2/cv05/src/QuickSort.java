class QuickSort implements ISortingAlgorithm{
	/** Pocet porovani v poslednim provedenem razeni */	
	int compares = 0;
	
	/**
	 * Vrati true, pokud je prvek na indexu i vetsi nez v, jinak false
	 * Inkrementuje citac porovnani.
	 * @return true, pokud je prvek na indexu i vetsi nez v, jinak false 
	 */
	public boolean greaterThan(int value1, int value2) {
		compares++;
		return value1 > value2;
	}
	
	public void quickSort(int[] data, int start, int end) {
		if(end<=start) return;
		int i = split(data, start, end);
		quickSort(data, start, i-1);
		quickSort(data, i+1, end);
	}
	
	public int split(int[] data, int left, int right) {		
		int pivot = data[right];
		while(true) {
			while(greaterThan(pivot, data[left])&&(left<right)) { 
				left++;
			}
			if (left<right) {
				data[right] = data[left];
				right--;
			} else break;
			while(greaterThan(data[right], pivot)&&(left<right)) {
				right--;
			}
			if (left<right) {
				data[left]=data[right];
				left++;
			} else break;
		}
		data[left]=pivot;
		return (left);
	}
	
	@Override
	public void sort(int[] data) {	
		compares = 0;
		quickSort(data, 0, data.length -1);		 
	}

	@Override
	public int comparesInLastSort() {
		return compares;
	}
	
	@Override
	public void onlySort(int[] data) {
		quickSort(data, 0, data.length -1);
	}
}
