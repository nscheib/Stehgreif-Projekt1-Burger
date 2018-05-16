// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Salate, dient zum verwalten der verschiedenen Salatsorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Salate extends ZutatenErsteller{

	/**
	 * Der Konstruktor fuer den Salat setzt verschiedene Parameter fest
	 * @param breite setzt fest wie dick der Salat wird
	 * @param preis setzt fest wie viel der Salat kosten wird
	 * @param vegetarisch setzt fest ob der Salat vegetarisch ist
	 * @param zubereitungsDauer setzt fest wie viel Zeit fuer die Zubereitung benoetigt wird
	 * @param geschmack setzt die Geschmacksnuancen fuer den Salat fest
	 * @param name setzt den Namen fuer den ausgewaehlten Salat fest
	 */
	public Salate (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {

		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}// END Salate

	/**
	 * Methode zur Ueberpruefung der Eingabe zur Dicke/Menge des Salates
	 */
	public void neueZutatBreite(){

		System.out.println("Wie viel von diesem Salat soll auf den Burger (in mm)?");		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 30) {
				System.out.println("Extra Portionen können später zur Bestellung hinzugefügt werden.");
			}else if (eingabe < 1) {
				System.out.println("Wollen Sie durch das Blatt durchschauen können??");
			}else{
				System.out.println("Eine Schicht Salat ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}// END neueZutatBreite

}// END Salate
