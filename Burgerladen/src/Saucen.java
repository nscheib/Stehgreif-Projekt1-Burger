/**
 *  Saucen, dient zum verwalten der verschiedenen Saucenorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Saucen extends ZutatenErsteller{

	/**
	 * Der Konstruktor fuer die Saucen setzt verschiedene Parameter fest
	 * @param preis setzt den Preis der ausgewaehlten Sauce fest
	 * @param vegetarisch setzt fest ob die Sauce vegetarisch ist
	 * @param zubereitungsDauer setzt fest wie viel Zeit fuer die Zubereitung benoetigt wird
	 * @param geschmack setzt den Geschmack der ausgewaehlten Sauce fest
	 * @param name setzt den Namen fuer die ausgewaehlte Sauce fest
	 */
	public Saucen (double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}// END Saucen
	
}// END Saucen
