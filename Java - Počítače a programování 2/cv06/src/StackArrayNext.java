/**
 * Trida zvetsi delku pole o 10 a prenese data z pole do pole noveho a vetsiho
 * @author David Chromy
 * @version 2021
 */
public class StackArrayNext extends StackArray {
	public void expandArray() {
		String[] dataPom = new String[data.length+10];
		  for (int i = 0; i < data.length; i++) {
			dataPom[i] = data[i];
		  }
		  data = dataPom;
	}
}
