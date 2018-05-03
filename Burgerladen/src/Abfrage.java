import de.hsrm.mi.prog.util.StaticScanner;

public class Abfrage {

	public static String eingabe () {
		String eingegeben;
		boolean eingabeControlle = true;
		do {
			eingegeben = StaticScanner.nextString();
			if (eingegeben.equals("menu")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("Menu")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("meine burger")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("ok")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("Ok")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("OK")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("zutat")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("Zutat")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("bestellung")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("Bestellung")) {
				eingabeControlle = false;
			}else {
				System.out.println("Keine gueltige eingabe. Bitte geben sie eine korrekte Eingabe ein");				
			}
		
		}
		while(eingabeControlle);
		return eingegeben;
	}
	
}
