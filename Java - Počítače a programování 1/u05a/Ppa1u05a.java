import java.util.*;

/**
 * Program na vizualizaci funkce dvou promennych v case t
 * @author DavidChromy
 *
 */
public class Ppa1u05a {
	/**
	 * Vstupni bod programu
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		/*
		 * Nacitani hodnot z klavesnice
		 */
		System.out.print("x1: ");
		double x1 = sc.nextDouble();
		System.out.print("x2: ");
		double x2 = sc.nextDouble();
		System.out.print("Xs: ");
		double Xs = sc.nextDouble();
		System.out.print("y1: ");
		double y1 = sc.nextDouble();
		System.out.print("y2: ");
		double y2 = sc.nextDouble();
		System.out.print("Ys: ");
		double Ys = sc.nextDouble();
		System.out.print("Ts: ");
		double Ts = sc.nextDouble();
		/*
		 * Vypis hodnot/Vypocet hodnot funkce
		 */
		System.out.println("x, y, z, t");
		double cas = 1/Ts;
        double xX = (x2-x1)/(Xs-1);
        double yY = (y2-y1)/(Ys-1);
        if(Xs == 1) {
        	xX = (x2-x1)/(Xs);
        } else if(Ys == 1) {
        	yY = (y2-y1)/(Ys);
        }
        for(int i1 = 0; i1<Ts; i1++) {
            double t = i1*cas;
            for(int i2 = 0; i2<Ys; i2++) {
                double y = i2*yY+y1;
                for(int i3 = 0; i3<Xs; i3++) {
                    double x = i3*xX+x1;
                    double z = Math.sin(Math.sqrt((x*x)+(y*y))-2*Math.PI*t);
                    System.out.printf("%.6f, %.6f, %.6f, %.6f\n", x, y, z, t);
                }
            }
        }
	}
}
