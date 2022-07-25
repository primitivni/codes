import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Trida pro doplnovani textu na zaklade historie
 * @author Libor Vasa
 */
public class Autocomplete {
	public static void main(String[] args) {
		try {
			uloha3();
		} catch(Exception e) {
			System.out.println("Chyba pri praci se souborem.");
		}
		
		
		/*BinarySearchTree bst = new BinarySearchTree();
		bst.add("http://portal.zcu.cz");
		bst.add("http://courseware.zcu.cz");
		bst.add("http://amazon.com");
		bst.add("http://amazon.com.org");
		bst.add("http://amazon.com.org.uk");
		bst.add("http://alexa.com");
		
		///////////// Uloha 2
		
		///////////// contains() zkouska
		System.out.print("Contains http://portal.zcu.cz: ");
		System.out.println(bst.contains("http://portal.zcu.cz"));
		System.out.print("Contains http://courseware.zcu.cz: ");
		System.out.println(bst.contains("http://courseware.zcu.cz"));
		System.out.print("Contains http://amazon.com: ");
		System.out.println(bst.contains("http://amazon.com"));
		System.out.print("Contains http://seznam.cz: ");
		System.out.println(bst.contains("http://seznam.cz"));	
		
		///////////// printSorted() zkouska
		System.out.println("\nSorted:");
		bst.printSorted();
		System.out.println();
		
		///////////// printAllStartingWith() zkouska
		String prefix = "http://amazon.com.";
		System.out.println("Prefix: "+ prefix);
		System.out.println("Pocet prohledanych vrcholu: "+ bst.printAllStartingWith(prefix) +".");*/
	}

	/**
	 * Metoda pro realizaci ulohy cislo 3
	 * @throws IOException
	 */
	public static void uloha3() throws IOException {
		Scanner sc = new Scanner(Paths.get("requests.txt"));
		BinarySearchTree bst = new BinarySearchTree();
		String[] pole;
		int pocetSoucasny = 0, pocetVrcholu;
		while(sc.hasNext()) {
			String data = sc.nextLine();
			pole = data.split(" ");
			if(pole[0].equals("A")) {
				bst.add(pole[1]);
				++pocetSoucasny;
			} else if(pole[0].equals("R")) {
				bst.remove(pole[1]);
				--pocetSoucasny;
			} else if(pole[0].equals("P")) {
				pocetVrcholu = bst.printAllStartingWith(pole[1]);
				System.out.println(pocetSoucasny +"/"+ pocetVrcholu +"/"+ bst.pocetPrvku);
			}	
		}
	}
}
