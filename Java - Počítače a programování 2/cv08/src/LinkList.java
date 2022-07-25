/**
 * Spojovy seznam znaku
 * @author Libor Vasa
 */
public class LinkList {
	/** Prvni prvek seznamu */
	Link first;
}
/*{
	

	/** Aktualni prvek seznamu 
	Link current;

	/**
	 * Vlozi novy znak do seznamu
	 * @param letter znak, ktery se vlozi do seznamu 
	 
	void insert(char letter) {
		Link newLink = new Link();
		newLink.data = letter;
		if (current == null) {
			newLink.next = first;
			first = newLink;
		}
		else {
			
			newLink.next = current.next; // ZMENA - nutne prohodit, jinak bychom prirazovali newLink.next = newLink;
			current.next = newLink;		 //
			
		}
	}

	/**
	 * Posune aktualni prvek na dalsi v seznamu
	 * @throws Exception pokud zadny dalsi prvek neni
	 
	void next() throws Exception {
		if (first == null) {
			throw new Exception();
		}
		if (current == null) {
			current = first;
		}
		else {
			current = current.next;
			if (current == null) {
				throw new Exception();
			}
		}
	}
	
	/**
	 * Zmeni aktualni prvek na prvni prvek seznamu
	 
	void moveToFirst() {
		current = null;
	}

	/**
	 * Vrati znak v aktualnim prvku seznamu
	 * @return znak v aktualnim prvku seznamu
	 
	
	char get() throws Exception { //ZMENA - doplneni vyjimky
		
		if (first == null) {
			throw new Exception();
		}
		if (current == null) {
			return first.data;
		}
		if (current.next != null) {
			return current.next.data;
		}
		else {
			throw new Exception();
		}
	}

	/**
	 * Vraci true, pokud existuje nasledujici prvek seznamu
	 * @return true, pokud existuje nasledujici prvek seznamu
	 
	boolean hasNext() {
		if (current == null) {
			if (first != null) {
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
}*/
