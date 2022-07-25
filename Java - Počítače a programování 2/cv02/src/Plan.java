/**
 * Rozvrh doucovacich hodin
 * @author David Chromy
 * @version 2021
 */
public class Plan {
	public PlanEvent[] rozvrh;
	
	public Plan(PlanEvent[] rozvrh) {
		this.rozvrh = rozvrh;
	}

	/**
	 * Metoda pro urceni zda se vyucovaci hodiny prekryvaji
	 * @return true/false zda se prekryvaji hodiny v rozvrhu
	 */
	public boolean isConflict() {
		for(int i = 0; i < rozvrh.length; i++) {
			for(int j = i+1; j < rozvrh.length; j++) {
				if(rozvrh[i].isInConflict(rozvrh[j]) ) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Metoda pro urceni zda se vyucovaci hodiny neprekryvaji
	 * @return true/false zda se neprekryvaji hodiny v rozvrhu
	 */
	public boolean isOK() {
		int matika = 0;
		int pocitace = 0;
		
		for(int i = 0; i < rozvrh.length; i++) {
			if(rozvrh[i].subject == Subject.math) {
				for(int j = i+1; j < rozvrh.length; j++) {
					if(rozvrh[j].subject == Subject.math) {
						if(rozvrh[i].dayOfWeek == rozvrh[j].dayOfWeek) {
							return false;
						}
					}
				}
				matika++;
			}
		}
			
		for(int i = 0; i < rozvrh.length; i++) {
			if(rozvrh[i].subject == Subject.computers) {
				for(int j = i+1; j < rozvrh.length; j++) {
					if(rozvrh[j].subject == Subject.computers) {
						if(rozvrh[i].dayOfWeek == rozvrh[j].dayOfWeek) {
							return false;
						}
					}
				}
				pocitace++;
			}
		}

		if(matika >= 3 && pocitace >= 2) {
			return true;
		}
		
		return false;
	}

	/**
	 * Metoda pro vypis rozvrhu
	 */
	public void vypis() {
		System.out.println("Rozvrh:");
		for(int i = 0; i < rozvrh.length; i++) {
			System.out.printf("%30s | %2s | %2s | %1s | %10s \n", rozvrh[i].tutor, rozvrh[i].start, rozvrh[i].end, rozvrh[i].dayOfWeek, rozvrh[i].subject);
		}
		System.out.println();
	}
}
