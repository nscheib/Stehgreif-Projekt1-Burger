// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Bratling, dient zum verwalten der bestellten Zutaten, abspeichern in eine Bestellliste und deren Verarbeitung
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Bratlinge extends ZutatenErsteller{

	/**
	 * Der Konstruktor fuer das Broetchen setzt verschiedene Parameter fest
	 * @param breite setzt die Dicke des Bratlings fest
	 * @param preis setzt den Preis des Bratlings fest
	 * @param vegetarisch setzt fest, ob das Bratlings vegetarisch ist
	 * @param zubereitungsDauer setzt fest wie viel Zeit fuer die Zubereitung benoetigt wird
	 * @param geschmack setzt den Geschmal je nach dem welches Bratlings gewaehlt wurde fest
	 * @param name den Namen fuer den ausgewaehlte Bratlings fest
	 */
	public Bratlinge (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {

		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}// END Bratling

	/**
	 * Methode zur Ueberpruefung der Eingabe zur Dicke/Menge des Bratlings
	 */
	public void neueZutatBreite(){

		System.out.println("Wie dick sind die Bratlinge (in mm)?");		
		boolean korrekt = true;
		
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 30) {
				System.out.println("Extra Portionen können erst bei der Bestellung aufgegeben werden.");
			}else if (eingabe < 5) {
				System.out.println("So duenn ist doch kein Schwein");
			}else{
				System.out.println("Ein Bratling ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}// END neueZutatBreite

	/**
	 * Methode getter zum weiter geben der dicke des Bratlings
	 * @return breite, gibt die dicke des Bratlings weiter
	 */
	public int getBreiteBratling() {
		return breite;	
	}// END getBreiteBratling

}// END Bratling
