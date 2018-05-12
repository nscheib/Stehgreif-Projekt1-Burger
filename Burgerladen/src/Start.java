//import de.hsrm.mi.prog.util.StaticScanner;

/**
 * Das Programm bietet eine Liste an Zutaten um sich einen individuellen Burger zusammen zustellen.
 * Es ist moeglich zwischen mehreren Zutatenkategorien zu waehlen. Hier bei koennen maximal 8 Zutaten gewaehlt werden.
 * Die aktuell gewaehlten Zutaten koennen jeder Zeit aufgerufen und angezeigt werden.
 *
 * Die Start.class ist die erste die das Programm ausführt.
 *
 * @author Felix, Luca, Nick
 * @version 0.9
 */
public class Start {

	/**
	 * Hauptprogramm
	 * Die Main Methode ruf die unterschiedlichen Zutatenbestandteile für die Auswahl des Burgers auf
	 * @param args ist ein String Array und gibt ggf. Inhalte aus, wenn dies inizialisiert und instanziert wurde.
	 */
	public static void main(String[] args) {

		Karte speiseKarte = new Karte();
		speiseKarte.ausgabe();		 
		 
		//SesamBroetchen essen = new SesamBroetchen();
		//essen.ausgabe();

		Zutat zutat = new Zutat();
		zutat.vorgegebeneBroetchen();
		zutat.vorgegebeneBratlinge();
		zutat.vorgegebenesGemuese();
		zutat.vorgegebeneSalate();
		zutat.vorgegebeneSaucen();

		Bestellung eins = new Bestellung();
		eins.bestellBeginn();
	}

}
