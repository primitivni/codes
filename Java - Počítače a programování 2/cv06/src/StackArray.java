/**
 * Implementace zasobniku retezcu pomoci pole
 * @author Libor Vasa
 */
class StackArray implements IStringStack {
  /** Data v zasobniku */
  public String[] data;
  /** Index pozice, na kterou se vlozi novy prvek */
  public int freeIndex;

  /**
   * Vytvori novy prazdny zasobnik
   */
  public StackArray() {
	data = new String[5]; //ZMENA - nutne String[5], jelikoz data jsou datoveho typu String nikoli int
    freeIndex = 0;
  }
  
  public void add(String s) {
	if(freeIndex == data.length) {
		expandArray();
	}
	data[freeIndex] = s;
    freeIndex++;
  }
  
  public String get() { //ZMENA - nutne public, abychom pridali viditelnost metode
	
	  if(freeIndex == 0) {
		  return null;
	  }
	  else {
		  return data[freeIndex-1];
	  }
  }

  public void removeLast() {  //ZMENA - nutne public, abychom pridali viditelnost metode
	  
	  if(freeIndex == 0) {
		  data[freeIndex] = null;
	  }
	  else {
		  freeIndex--;
		  data[freeIndex] = null;
	  }
  }
  
  public void expandArray() {
	  String[] dataPom = new String[data.length*2];
	  for (int i = 0; i < data.length; i++) {
		dataPom[i] = data[i];
	  }
	  data = dataPom;
  }
}
