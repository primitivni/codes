public class MyIterator {
	/** Aktualni prvek seznamu */
	Link current;
	//
	LinkList linklist;

	/**
	 * Vlozi novy znak do seznamu
	 * @param letter znak, ktery se vlozi do seznamu 
	 */
	void insert(char letter) {
		Link newLink = new Link();
		newLink.data = letter;
		if (current == null) {
			newLink.next = linklist.first;
			linklist.first = newLink;
		}
		else {
			newLink.next = current.next; 
			current.next = newLink;
		}
	}

	/**
	 * Posune aktualni prvek na dalsi v seznamu
	 * @throws Exception pokud zadny dalsi prvek neni
	 */
	void next() throws Exception {
		if (linklist.first == null) {
			throw new Exception();
		}
		if (current == null) {
			current = linklist.first;
		}
		else {
			current = current.next;
			if (current == null) {
				throw new Exception();
			}
		}
	}

	/**
	 * Vrati znak v aktualnim prvku seznamu
	 * @return znak v aktualnim prvku seznamu
	 */
	char get() throws Exception {
		if (linklist.first == null) {
			throw new Exception();
		}
		if (current == null) {
			return linklist.first.data;
		}
		if (current.next != null) {
			return current.next.data;
		}
		else {
			throw new Exception();
		}
	}
	
	/**
	 * Zmeni aktualni prvek na prvni prvek seznamu
	 */
	void moveToFirst() {
		current = null;
	}

	/**
	 * Vraci true, pokud existuje nasledujici prvek seznamu
	 * @return true, pokud existuje nasledujici prvek seznamu
	 */
	boolean hasNext() {
		if (current == null) {
			if (linklist.first != null) {
				return true;
			}
			else { 
				return false;
			}
		}
		if (current.next != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public MyIterator(LinkList linklist) {
		this.linklist = linklist;
		this.current = null;
	}
	
	void printList() {
		moveToFirst();
		while(hasNext()) {
			try {
				System.out.print(get());
				next();
			} catch (Exception e) {
				System.out.println("Chyba!");
			}
		}
		System.out.println();
	}
	
	void remove() throws Exception {
		if(linklist.first == null) {
			throw new Exception();
		} else if(current == null) {
			linklist.first = linklist.first.next;
		} else if(current.next == null) {
			throw new Exception();
		}  else {
			current.next = current.next.next;	
		}
	}
}
