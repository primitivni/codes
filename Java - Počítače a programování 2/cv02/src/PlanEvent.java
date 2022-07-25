import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

/**
 * Doucovane predmety
 * @author Libor Vasa !!! Garant predmetu doc. Vasa, ktery tvori kody na debugging a cviceni
 */
enum Subject {math, computers}

/**
 * Nabidka tutora na doucovani
 * @author Libor Vasa!!! Garant predmetu doc. Vasa, ktery tvori kody na debugging a cviceni
 */
public class PlanEvent {
	/** Jmeno tutora */
	public String tutor;
	/** Hodina pocatku doucovani (10 = 10:00 atd.) */
	public int start;
	/** Hodina konce doucovani (10 = 10:00 atd.) */
	public int end;
	/** Den tydne doucovani (0 = Pondeli, 1 = Utery atd.) */
	public int dayOfWeek;
	/** Doucovany predmet */
	public Subject subject;
	
	/**
	 * Vytvori novou nabidku tutora na doucovani
	 */
	
	public PlanEvent(String tutor, int start, int end, int dayOfWeek, Subject subject) { //ZMENA - chyba v datov m typu String, nutn  velk  S
		
		this.tutor = tutor;
		this.start = start;
		this.end = end;						//ZMENA - je potreba odlisit pomoci this promennou objektu od parametru
		this.dayOfWeek = dayOfWeek;
		this.subject = subject;				
		
	}
	
	/**
	 * Vrati true, pokud se tato udalost prekryva se zadanou udalosti, jinak vrati false
	 * @param other udalost, ktera se muze prekryvat s touto udalosti
	 * @return true, pokud se tato udalost prekryva se zadanou udalosti, jinak vrati false
	 */
	public boolean isInConflict(PlanEvent other) {
		if (this.dayOfWeek != other.dayOfWeek) {
			return false;
		}
		
		if (this.end <= other.start) { //ZMENA - pokud nastane >= neni to problem a neni duvod k false, nutn  oprava na <=
			
			return false;
		}
		
		if (other.end <= this.start) { //ZMENA - pokud nastane >= neni to problem a neni duvod k false, nutn  oprava na <=
			
			return false;
		}
		return true;
	}

	/**
	 * Metoda pro nacteni dat ze souboru z adresare
	 * @param nazevSouboru
	 * @return
	 * @throws IOException
	 */
	public static PlanEvent[] nacti(String nazevSouboru) throws IOException {
		Scanner sc1 = new Scanner(Paths.get(nazevSouboru));
		int delka = 0;
		while(sc1.hasNextLine()) {
			sc1.nextLine();
			delka++;
		}
		sc1.close();
		delka/=5;

		Scanner sc2 = new Scanner(Paths.get(nazevSouboru));
		PlanEvent[] nabidky = new PlanEvent[delka];
		int index = 0;
		while(sc2.hasNextLine()) {
			String tutor = sc2.nextLine();
			String predmet = sc2.nextLine();
			Subject subject;
			switch(predmet) {
				case "math":
					subject = Subject.math;
					break;
				case "computers":
					subject = Subject.computers;
					break;
				default:
					continue;
			}

			String dayOfWeekPom = sc2.nextLine();
			int dayOfWeek = Integer.parseInt(dayOfWeekPom);
			String startPom = sc2.nextLine();
			int start = Integer.parseInt(startPom);
			String endPom = sc2.nextLine();
			int end = Integer.parseInt(endPom);

			PlanEvent termin = new PlanEvent(tutor, start, end, dayOfWeek, subject);
			nabidky[index] = termin;

			index++;
		}
		sc2.close();

		return nabidky;
	}

	/**
	 * Metoda pro vytvoreni kombinaci predmetu v rozvrhu
	 */
	public static void kombinace() {
		try {
			int pocet = 0;
			String soubor = "ssc.txt";
			String nazevSoubor = soubor;
			PlanEvent[] rozvrh = nacti(nazevSoubor);
			for(int i = 0; i < rozvrh.length; i++) {
				for(int j = i + 1; j < rozvrh.length; j++) {
					for(int k = j + 1; k < rozvrh.length; k++) {
						for(int l = k + 1; l < rozvrh.length; l++) {
							for(int m = l + 1; m < rozvrh.length; m++) {
								Plan plan = new Plan(new PlanEvent[] {rozvrh[i], rozvrh[j], rozvrh[k], rozvrh[l], rozvrh[m]});
								if(!plan.isConflict() && plan.isOK()) {
									plan.vypis();
									pocet++;
								}
							}
						}
					}
				}
			}

			System.out.println("Pocet spravnych a bezkonfliktnich rozvrhu: " + pocet);
		} catch (IOException ex) {
			System.out.println("Nepodarilo se nacist soubor.");
		}
	}

	/**
	 * Metoda main programu
	 * @param args
	 */
	public static void main(String[] args) {
		PlanEvent event1 = new PlanEvent("Franti ek Von sek", 10, 13, 1, Subject.math);
		PlanEvent event2 = new PlanEvent(" en k Landsmann", 9, 12, 1, Subject.computers);
		PlanEvent event3 = new PlanEvent("Hubert Z mo n ", 11, 14, 2, Subject.math);
		PlanEvent event4 = new PlanEvent("Dobromila Musilov -W brov ", 9, 14, 1, Subject.computers);
		PlanEvent event5 = new PlanEvent("Sisoj Psoi  Rispolo enskyj", 11, 12, 3, Subject.math);
		PlanEvent event6 = new PlanEvent("Billy Blaze", 8, 10, 3, Subject.computers);
		PlanEvent event7 = new PlanEvent("Flynn Taggart", 13, 15, 4, Subject.math);
		
		Plan rozvrh = new Plan(new PlanEvent[] {event1, event2, event3, event4, event5, event6, event7});

		System.out.print("Prekryvaji se predmety v rozvrhu: ");
		System.out.print(rozvrh.isConflict());
		System.out.print("\nJe rozvrh ok: ");
		System.out.println(rozvrh.isOK());
		
		/*System.out.println(event1.isInConflict(event2));			
		System.out.println(event1.isInConflict(event3));
		System.out.println(event1.isInConflict(event4));
		System.out.println(event1.isInConflict(event5));
		System.out.println(event1.isInConflict(event6));
		System.out.println(event1.isInConflict(event7));*/
	}
}