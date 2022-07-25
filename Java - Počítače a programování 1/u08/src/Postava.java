/**
 * Postava vytvori postavu na danych souradnicich
 * @author David Chromy
 * @version 2020-11-22
 */
public class Postava {
	int x,y;
	int startX, startY;
    private Svet svet;
    
    /**
     * Naplneni promennych
     * @param svet 
     * @param startyX 
     * @param startyY 
     * @param startX 
     * @param startY 
     */
    public Postava(Svet svet,int startyX, int startyY, int startX, int startY) {
    	this.svet = svet;
        this.x = startyX;
        this.y = startyY;
        this.startX = startX;
        this.startY = startY;
    } 
    
    /**
     * Nastaveni souradnice x
     * @param x souradnice x
     */
    public void setX(int x) {
    	this.x = x;
    }
    
    /**
     * Vraci souradnice x
     * @return x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Nastaveni souradnice y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Vraci souradnici y
     * @return y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Nastavi startovni souradnici X
     * @param startX
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }
    
    /**
     * Vraci startovni souradnici X
     * @return startX
     */
    public int getStartX() {
        return startX;
    }
    
    /**
     * Nastavi startovni souradnici Y
     * @param startY
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }
    
    /**
     * Vraci startovni souradnici Y
     * @return startY
     */
    public int getStartY() {
        return startY;
    }
    
    /**
     * Pohyb po bludisti/mape
     * @param smer 
     * @return true/false
     */
    public boolean jdi(Smer smer){
        switch(smer) {
            case SEVER:
            	y=y-1;
            	if(svet.uzemi(x,y) == '#' || svet.uzemi(x,y) == 0 ) {
            		return false;
            	} else {
            		return true;
            	}   
        
            case JIH:
            	y=y+1;
            	if(svet.uzemi(x,y) == '#' ||  svet.uzemi(x,y) == 0 ) {
            		return false;
            	} else {
            		return true;
            	}      
            
            case ZAPAD:
            	x=x-1;
            	if(svet.uzemi(x,y) == '#' || svet.uzemi(x,y) == 0 ) {
                    return false;
                } else {
                    return true;
                }  
            
            case VYCHOD:
            	x=x+1;
            	if(svet.uzemi(x,y) == '#' ||  svet.uzemi(x,y) == 0 ) {
            		return false;
            	} else {
            		return true;
            	}
            default: 
            	return false;
        }
    }
    
    /**
     * Zjisteni zda je postava doma (souradnice domova)
     * @return true/false
     */
    public boolean jeDoma() {
        if(x==startX && y==startY) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vykresleni mapy, domovu a postavy
     * @param gui 
     */
    public void vykresli(GUI gui) {
        gui.zapis(startX, startY, '^');
        gui.zapis(x, y, '@');
    }
}