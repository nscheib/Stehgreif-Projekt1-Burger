// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Abfrage, dient der Abfrage der Benutzereingabe, ob diese erlaubt ist
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Abfrage {

	/**
	 * Methode vergleicht die Benutzereingabe mit den erlaubten und vorhanden Begriffen zum navigieren
	 * @return eingegeben, gibt den eingegeben String zurueck
	 */
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
