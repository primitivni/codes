/**
 * Binarni vyhledavaci strom se jmeny souboru
 * @author Libor Vasa
 */
class BinarySearchTree {
	/** Koren binarniho vyhledavaciho stromu */
	Node root;
	
	public int pocetVrcholu;
	public int pocetPrvku;
	
	/**
	 * Prida do BST prvek se zadanym klicem - jmenem souboru
	 * @param key klic - jmeno souboru
	 */
	void add(String key){
		
		if (root == null) { //ZMENA - chybejici "=" v pripade porovnavani
			root = new Node(key); //ZMENA - Node musi byt s velkym N, Java je keysensitive 
			
		}
		else {
			addUnder(root, key);
		}		
	}

	/**
	 * Vlozi pod zadany uzel novy uzel se zadanym klicem
	 * @param n uzel, pod ktery se ma novy uzel vlozit
	 * @param key klic noveho uzlu - nazev souboru
	 */
	void addUnder(Node n, String key) {
		if (key.compareToIgnoreCase(n.key) < 0) {
			// uzel patri doleva, je tam misto?
			if (n.left == null) {
				n.left = new Node(key);
			}      
			else { 
				
				addUnder(n.left, key); //ZMENA - n.left, jinak dochazi k preteceni
				
			}
		}
		else {
			// uzel patri doprava, je tam misto?
			if (n.right == null) {
				n.right = new Node(key);
			}
			else { 
				
				addUnder(n.right, key); //ZMENA - n.right, jinak dochazi k preteceni
				
			}
		}
	}
	
	boolean contains(String key) {
		return contains(root, key);
	}
	
	boolean contains(Node n, String key) {
		if(n == null) {
			return false;
		} else {
			if(key.compareToIgnoreCase(n.key) < 0) {
				return contains(n.left, key);
			} else if(key.compareToIgnoreCase(n.key) > 0){
				return contains(n.right, key);
			} else {
				return true;
			}
		}
	}
	
	void printSorted() {
		getSortedKeysR(root);
	}
	
	void getSortedKeysR(Node n) {
		if(n != null) {
			getSortedKeysR(n.left);
			System.out.println(n.key);
			getSortedKeysR(n.right);
		}
	}
	
	int printAllStartingWith(String prefix) {
		pocetVrcholu = 0;
		pocetPrvku = 0;
		printAllStartingWith(root, prefix);
		return pocetVrcholu; 
	}
	
	void printAllStartingWith(Node n, String prefix) {
		if(n == null) {
			return;
		} else {
			++pocetVrcholu;
			if(prefix.length() < n.key.length()) {
				if(prefix.compareToIgnoreCase(n.key.substring(0, prefix.length())) < 0) {
					printAllStartingWith(n.left, prefix);
				} else if(prefix.compareToIgnoreCase(n.key.substring(0, prefix.length())) > 0) {
					printAllStartingWith(n.right, prefix);
				} else {
					printAllStartingWith(n.left, prefix);
					System.out.println(n.key);
					++pocetPrvku;
					printAllStartingWith(n.right, prefix);
				}
			} else {
				if(prefix.equalsIgnoreCase(n.key)) {
					printAllStartingWith(n.left, prefix);
					System.out.println(n.key);
					++pocetPrvku;
					printAllStartingWith(n.right, prefix);
				} else if(prefix.compareToIgnoreCase(n.key) > 0) {
					printAllStartingWith(n.right, prefix);
				} else {
					printAllStartingWith(n.left, prefix);
				}
			}
		}
	}
	
	
	//REMOVE - prednaska09
	void remove(String key) {
		Node n = root; // uzel ktery chceme odebrat
		Node pred = null; // predek uzlu ktery chceme odebrat
		while(!key.equals(n.key)) {
			pred = n;
			if(key.compareTo(n.key)<0) {
				n = n.left;	
			} else {
				n = n.right;
			}
		}
		if((n.left == null) || (n.right==null)) {
			Node replacement = n.left;
			if(n.right != null) {
				replacement = n.right;
			} else if(pred == null) {
				root = replacement;
			} else if(pred.left == n) {
				pred.left = replacement;
			} else {
				pred.right = replacement;
			}
		} else {
			Node leftMax = n.left;
			Node leftMaxPred = n;
			while (leftMax.right!=null) {
				leftMaxPred = leftMax;
				leftMax = leftMax.right;
			}
			n.key = leftMax.key;
			if(leftMax != n.left) {
				leftMaxPred.right = leftMax.left;
			}
			else {
				n.left = leftMax.left;
			}
		}
	}
}
