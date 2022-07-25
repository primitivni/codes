import java.util.*;

/**
 * Vypocet bodu B a C obdelniku ABCD pomoci vektoru
 * @author DavidChromy
 * @version 2020-10-6
 */
public class Ppa1u02b {
	public static Scanner sc;
	/**
	 * Vstupni bod programu
	 * @param args parametry prikazove radky
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		double Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;
		/*
		 * Nacitani hodnot
		 */
		System.out.print("Zadej Ax: ");
		Ax = sc.nextDouble();
		System.out.print("Zadej Ay: ");
		Ay = sc.nextDouble();
		System.out.print("Zadej Dx: ");
		Dx = sc.nextDouble();
		System.out.print("Zadej Dy: ");
		Dy = sc.nextDouble();
		/*
		 * Vypocty
		 */
		double smerADx = Dx-Ax;
		double smerADy = Dy-Ay;
		double normalADx = smerADy*(-0.5);
		double normalADy = smerADx*(0.5);
		Bx = normalADx+Ax;
		By = normalADy+Ay;
		Cx = normalADx+Dx;
		Cy = normalADy+Dy;
		/*
		 * Vypis vypoctenych hodnot
		 */
		System.out.format("Bx = %4.3f%n", Bx);
		System.out.format("By = %4.3f%n", By);
		System.out.format("Cx = %4.3f%n", Cx);
		System.out.format("Cy = %4.3f%n", Cy);
	}

}
