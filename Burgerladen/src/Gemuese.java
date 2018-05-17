// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Gemuese, dient zum verwalten der verschiedenen Gemuesesorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Gemuese extends ZutatenErsteller{

	/**
	 * Der Konstruktor fuer das Gemuese setzt verschiedene Parameter fest
	 * @param breite setzt die Dicke des Gemueses fest
	 * @param preis setzt den Preis für den gewaehlten Gemuesetyp fest
	 * @param vegetarisch setzt fest, ob das Gemuese vegetarisch ist
	 * @param zubereitungsDauer setzt fest wie viel Zeit fuer die Zubereitung benoetigt wird
	 * @param geschmack setzt den Geschmack fuer die unterschiedliche Gemuesesorten fest
	 * @param name setzt den Namen fuer den ausgewaehlte Gemuese fest
	 */
	public Gemuese (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {

		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}

	/**
	 * Methode zur Ueberpruefung der Eingabe zur Dicke/Menge des Gemueses
	 */
	public void neueZutatBreite(){

		System.out.println("Wie breit ist das Gemuese (in mm, je Scheibe/Ring)?");		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 10) {
				System.out.println("So dick sollte keine Scheibe sein.");
			}else if (eingabe < 1) {
				System.out.println("Das waere ein wenig zu sparsam.");
			}else{
				System.out.println("Eine Scheibe ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}
	
	
	/*	Tomate Gurke Jalapenos Zwiebel
	 * 	Anzahl der scheiben/ringe
	 * Preis
	 * breite
	 * zubereitungs dauer
	 * 
	 */
}
