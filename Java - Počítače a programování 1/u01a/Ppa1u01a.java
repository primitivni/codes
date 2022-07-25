/**
* Vypocet povrchu a delek hran kvadru
* @author David Chromy
* @version 2020-09-29
*/
public class Ppa1u01a {
	/**
	* Vstupni bod programu
	* @param args parametry prikazove radky
	*/
	public static void main (String [] args) {
		final int h=4; //pocet hran kvadru
		final int a=10;	//velikost strany a
		final int b=20;	//velikost strany b	
		final int c=30;	//velikost strany c
		int d = h*a+h*b+h*c; //vypočet delky kvadru
		int s = 2*(a*b+b*c+a*c);	//vypočet povrch kvadru
		/*
			Vypis zadanych hodnot
		*/
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		System.out.println("------"); //oddelovaci cara pro vypis
		/*
			Vypis vypoctu
		*/
		System.out.println("s = "+s);
		System.out.println("d = "+d);
	}
}