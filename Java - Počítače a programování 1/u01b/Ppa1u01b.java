/**
* Pravitko na sirku a vysku naseho displeje, nativni rozliseni
* @author David Chromy
* @version 2020-09-29
*/
public class Ppa1u01b {
	/**
	* Vstupni bod programu
	* @param args parametry prikazove radky
	*/
	public static void main (String [] args) {
		final double hSize=514; //velikost delky
		final double vSize=401;	//velikost vysky
		final double hResolution=1920;	//velikost nativniho rozliseni hResolution	
		final double vResolution=1080;	//velikost nativniho rozliseni vResolution
		final double inch = 25.4; //velikost palce
		double hPPI = hResolution / (hSize/inch); //vypocet hPPI
		double vPPI = vResolution / (vSize/inch); //vypocet vPPI
		double rPPI = hPPI/vPPI; //vypocet rPPI
		double dSize = Math.sqrt(Math.pow(hSize,2)+Math.pow(vSize,2)); //vypocet dSize
		double dResolution = Math.sqrt(Math.pow(hResolution,2)+Math.pow(vResolution,2)); //vypocet hPPI
		double pitch = dSize/dResolution; //vypocet pitch
		double width = (200/hResolution)*hSize; //vypocet width
		double height = (100/vResolution)*vSize; //vypocet height
		/*
			Vypis zadanych hodnot
		*/
		System.out.println("hSize [mm]= "+hSize);
		System.out.println("vSize [mm]= "+vSize);
		System.out.println("hResolution [pixels]= "+hResolution);
		System.out.println("vResolution [pixels]= "+vResolution);
		System.out.println("------"); //oddelovaci cara pro editaci vypisu
		/*
			Vypis vypoctu
		*/
		System.out.println("hPPI = "+hPPI);
		System.out.println("vPPI = "+vPPI);
		System.out.println("rPPI = "+rPPI);
		System.out.println("pitch [mm] = "+pitch);
		System.out.println("width [mm] = "+width);
		System.out.println("height [mm] = "+height);
		System.out.println("display = Samsung S22D390");
		System.out.println("url = https://www.game-debate.com/monitor/index.php?mon_id=2674&monitor=Samsung%20S22D390%2021.5inch");
		
	}
}