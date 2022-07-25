import java.util.Random; //ZMENA - neni importovan java.util.Random
import java.util.Scanner;
import java.util.Stack;

/**
 * Asistent omezujici prokrastinaci
 * @author Libor Vasa
 */
class ProcrastinationAssistant {
  public static void main(String[] args) {
	  
    //IStringStack stack = new StackArray(); //ZMENA - java je keysensitive, musime opravit s na S
    
    //stack.add("Naucit se hrat na ukulele");
    
    //stack.add(randomString()); //ZMENA - je nutne dopsat z�vorky, protoze volame metodu

    //uloha2();
  }

	/**
	 * Metoda na realizaci zadani ulohy cislo 2
	 */
	public static void uloha2() {
	  IStringStack stack1 = new StackArray();
	  IStringStack stack2 = new StackArrayNext();
	  
	  long casStart1 = System.nanoTime();
	  testStack(stack1);
	  long casStop1 = System.nanoTime();
	  double cas1 = (double)(casStop1 - casStart1)/1000000000;
	  System.out.printf("Cas zmereny v pripade zvetsovani *2: %.4f s\n", cas1);
	  
	  long casStart2 = System.nanoTime();
	  testStack(stack2);
	  long casStop2 = System.nanoTime();
	  double cas2 = (double)(casStop2 - casStart2)/1000000000;
	  System.out.printf("Cas zmereny v pripade zvetsovani o +10: %.3f s\n", cas2);
  }

  /**
   * Vygeneruje a vrati nahodny retezec 
   * @return nahodny retezec velkych pismen nahodne delky (5 az 24 znaku)
   */
  public static String randomString() {
    StringBuilder sb = new StringBuilder();
    Random r = new Random();
    
    for (int i = 0; i < (5 + r.nextInt(20)); i++) { //ZMENA - absence jedne zavorky
    	
      sb.append((char) (r.nextInt(24) + 65)); //ZMENA - absence jedne zavorky
      
    }
    return(sb.toString());
  }

	/**
	 * Metoda na otestovani prazdneho zasobniku
	 * @param stack
	 */
	public static void testStack(IStringStack stack) {
	  int delka = 100000;
	  String[] zasobnik = new String[delka];
	  for(int i = 0; i < delka; i++) {
		  zasobnik[i] = randomString();
		  stack.add(zasobnik[i]);
	  }
	  
	  String[] zasobnikPom = new String[delka];
	  for(int i = delka - 1; i >= 0; i--) {
		  zasobnikPom[i] = stack.get();
		  stack.removeLast();
	  }
	  
	  boolean test = true;
	  for(int i = 0; i < delka; i++) {
		  if(zasobnik[i].equals(zasobnikPom[i])) {
			  
		  } else {
			  test = false;
		  }
	  }
	  
	  if(test) {
		  System.out.println("Test byl uspesny, prvky jsou shodne.");
	  } else {
		  System.out.println("Test byl neuspesny, prvky nejsou shodne.");
	  }
  }
  
} //ZMENA - absence jedne slozene zavorky na uzavreni tela tridy
