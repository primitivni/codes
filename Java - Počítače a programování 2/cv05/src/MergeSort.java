class MergeSort implements ISortingAlgorithm{
	/** Pocet porovani v poslednim provedenem razeni */	
	int compares = 0;

	public void mergeSort(int [] data, int start, int end) {
		if (start == end) 
			return;
		int mid = (start + end)/2;
		mergeSort(data, start, mid);
		mergeSort(data, mid+1, end);
		int[] temp = bitonic(data, start, mid, end);
		mergeBitonic(data, start, temp);
	}
	
	@Override
	public void sort(int[] data) {
		compares = 0;
		mergeSort(data, 0, data.length - 1);		
	}
	
	public boolean greaterThan(int value1, int value2) {
		compares++;
		return value1 > value2;
	}
	
	public int[] bitonic(int [] data, int start, int mid, int end) {
		int[] result = new int[end-start+1];
		for (int i = start; i <= mid; i++)
			result[i - start] = data[i];
		for (int i = mid+1; i <= end; i++)
			result[end - start + mid + 1 - i] = data[i];
		return result;
	}
	
	public void mergeBitonic(int[] data, int start, int[] bitonic) {
		int i = 0;
		int j = bitonic.length-1;
		for (int k = 0; k < bitonic.length; k++)
			data[start + k] = greaterThan(bitonic[j], bitonic[i])?
					bitonic[i++]:bitonic[j--];
	}
	
	@Override
	public int comparesInLastSort() {
		return compares;
	}

	@Override
	public void onlySort(int[] data) {
		mergeSort(data, 0, data.length - 1);
	}
}
