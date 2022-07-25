/**
 * Halda (s maximem v koreni) pro ulozeni intervalu
 * @author Libor Vasa
 */
class Heap {
	/** Hodnoty ulozene v halde */
	Interval[] values;
	/** Priority hodnot v halde */
	double[] priorities;
	/** Pocet hodnot v halde */
	int count = 0;

	/**
	 * Vytvori novou haldu se zadanou kapacitou
	 * @param capacity kapacita haldy
	 */
	public Heap(int capacity) {
		values = new Interval[capacity + 1];
		
		priorities = new double[capacity + 1]; //ZMENA - prirazeni/inicializace delky pole
		
	}		
	
	/**
	 * Prida novou hodnotu (interval) do haldy
	 * @param e pridavana hodnota (interval)
	 * @param priority priorita hodnoty
	 */
	void add(Interval e, double priority) {
		
		count++; //ZMENA - inkrementace promenne count
		
		if(count == priorities.length) {
			expandArrays();
		}
		values[count] = e;
		priorities[count] = priority;
		fixUp(count);
	}

	/**
	 * Prohodi hodnoty i priority na zadanych indexech
	 * @param x prvni index, na kterem se prohodi hodnoty a priority
	 * @param y druhy index, na kterem se prohodi hodnoty a priority
	 */
	void swap(int x, int y) {
		double tmp = priorities[x];
		priorities[x] = priorities[y];
		priorities[y] = tmp;

		Interval tmpInterval = values[x]; //ZMENA - v kodu nemuzou byt promenne stejneho nazvu a jineho datoveho typu
		
		values[x] = values[y];
		
		values[y] = tmpInterval; 		  //ZMENA - spravny nazev promenne
	}
	
	/**
	 * Opravi vlastnosti haldy smerem nahoru od zadaneho indexu
	 * @param index index, od ktereho se maji opravit vlastnosti haldy
	 */
	void fixUp(int index) {
		
		if(index == 1) {  //ZMENA - pokud fixUp bude kontrolovat koren, tak bude metoda zastavena
			return;
		} else {
			
			int pred = index / 2;
			if (priorities[pred] < priorities[index]) {			
				swap(pred, index);
				fixUp(pred);
			}
		}
	}
	
	//prednaska5 - podobnost expandArrays()
	void expandArrays() {
		Interval[] pomValues = new Interval[values.length * 2];
		for(int i = 0; i < values.length; i++) {
			pomValues[i] = values[i];
		}
		values = pomValues;
		
		double[] pomPriorities = new double[priorities.length * 2];
		for(int i = 0; i < priorities.length; i++) {
			pomPriorities[i] = priorities[i];
		}
		priorities = pomPriorities;
	}
	
	//prednaska12
	Interval removeMax() {
		Interval interval = values[1];
		priorities[1] = priorities[count];
		values[1] = values[count];
		count=count-1;
		fixDown(1);
		return interval;
	}
	
	//prednaska12
	void fixDown(int n) {
		if (2*n<=count) {
			int j = 2*n; // index leveho potomka
			if ((j+1)<=count) {
				if (priorities[j+1]>priorities[j]) {
					j = j+1; // j je ted index vetsiho potomka
				}
			}	
			if (priorities[n]>priorities[j]) {
					return; // Vlastnost 2 je ok
			} else {
				swap(j,n);
				fixDown(j);
			}
		}
	}
}
