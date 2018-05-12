import de.hsrm.mi.prog.util.StaticScanner;

/**
 *  Broetchen, dient zum verwalten der verschiedenen Broetchensorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Broetchen extends ZutatenErsteller{

	/**
	 * Der Konstruktor fuer das Broetchen setzt verschiedene Parameter fest
	 * @param breite setzt die Dicke des Broetchen fest
	 * @param preis setzt den Preis des Broetchen fest
	 * @param vegetarisch setzt fest, ob das Broetchen vegetarisch ist
	 * @param zubereitungsDauer setzt fest wie viel Zeit fuer die Zubereitung benoetigt wird
	 * @param geschmack setzt den Geschmal je nach dem welches Broetchen gewaehlt wurde fest
	 * @param name setzt den Namen fuer den ausgewaehlte Broetchen fest
	 */
	public Broetchen (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
		
	}

	/**
	 * Methode zur Ueberpruefung der Eingabe zur Dicke/Menge des Broetchens
	 */
	public void neueZutatBreite(){
		System.out.println("Wie breit ist das Broetchen (in mm)?");
		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 100) {
				System.out.println("So dick ist kein Broetchen");
			}else if (eingabe < 5) {
				System.out.println("So duenn kann doch kein broetchen sein");
			}else{
				System.out.println("Das Broetchen ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}
	
}
