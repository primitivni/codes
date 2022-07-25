/**
 * Uzel binarniho vyhledavaciho stromu (BST) se jmeny souboru
 * @author Libor Vasa
 */
class Node {
	/** Klic - jmeno souboru */
	public String key;
	/** Levy potomek */   
	public Node left;
	/** Pravy potomek */ 
	public Node right;
  
	/**
	 * Vytvori novy uzel binarniho vyhledavaciho stromu
	 * @param key klic - jmeno souboru
	 */
	public Node(String key) {
		this.key = key;
	}	
}
