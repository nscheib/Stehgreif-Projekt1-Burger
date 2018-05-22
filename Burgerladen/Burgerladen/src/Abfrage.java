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
			}else if (eingegeben.equals("mein burger")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("bestellen")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("bestellung")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("zubereitung")) {
				eingabeControlle = false;
			}else if (eingegeben.equals("zubereiten")) {
				eingabeControlle = false;
			}else {
				System.out.println("Keine gültiger Befehl. Bitte geben Sie einen korrekten Befehl ein ein!");
			}
		}
		while(eingabeControlle);
		return eingegeben;
	}
	
}
