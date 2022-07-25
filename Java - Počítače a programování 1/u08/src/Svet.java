/**
 * Modelace sveta
 * @author David Chromy
 * @version 2020-11-29
 */
public class Svet {
    private char[][] svet;
    private int vyska,sirka;
    
    /**
     * Naplneni promennych pro vytvoreni sveta
     * @param sirka 
     * @param vyska 
     * @param data
     */
    public Svet(int sirka , int vyska , char[] data) {
        this.setSvet(new char[sirka][vyska]);
        this.setVyska(vyska);
        this.setSirka(sirka);
        for (int i = 0; i < vyska; i++) {
            for (int j = 0; j < sirka; j++) {
                getSvet()[j][i] = data[(i*sirka)+j];
            }
        }
    }
    
    /**
     * Vraci znak na pozici x a y 
     * @param x 
     * @param y 
     * @return char
     */
    public char uzemi(int x, int y) {
        if((x>=0 && x<sirka) && (y>=0 && y < vyska)) {
            return svet[x][y];
        } else {
            return (int)0;
        }
    }
    
    /**
     * Vykresli svet/zavolani GUI
     * @param gui 
     */
    public void vykresli(GUI gui) {
        for (int i = 0; i < getVyska(); i++) {
            for (int j = 0; j < getSirka(); j++) {
                gui.zapis(j, i, getSvet()[j][i]);
            }
        }
    }
    
    /**
     * @return vraci svet
     */
    public char[][] getSvet() {
        return svet;
    }
    
    /** 
     * @param svet
     */
    public void setSvet(char[][] svet) {
        this.svet = svet;
    }
    
    /**
     * Nastaveni vysky sveta
     * @param vyska 
     */
    public void setVyska(int vyska) {
        this.vyska = vyska;
    }
    
    /**
     * Ziskani vysky sveta
     * @return vraci
     */
    public int getVyska() {
        return vyska;
    }
     
    /**
	 * Nastaveni sirky sveta
	 * @param sirka 
	 */
	public void setSirka(int sirka) {
		this.sirka = sirka;
	}
	
    /**
     * Ziskani sirky sveta
     * @return sirka 
     */
    public int getSirka() {
		return sirka;
	}
}
