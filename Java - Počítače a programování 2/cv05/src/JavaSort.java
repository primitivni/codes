import java.util.Arrays;

public class JavaSort implements ISortingAlgorithm{

	@Override
	public void sort(int[] data) {
		Arrays.sort(data);
	}
	
	@Override
	public void onlySort(int[] data) {
		Arrays.sort(data);
	}

	@Override
	public int comparesInLastSort() {
		return 0;
	}	
}