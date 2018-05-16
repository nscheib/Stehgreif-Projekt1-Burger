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
		
		/*Karte speiseKarte = new Karte();
		speiseKarte.ausgabe();

		SesamBroetchen essen = new SesamBroetchen();
		essen.ausgabe();
		*/

		Zutat zutat = new Zutat();
		zutat.vorgegebeneBroetchen();
		zutat.vorgegebeneBratlinge();
		zutat.vorgegebenesGemuese();
		zutat.vorgegebeneSalate();
		zutat.vorgegebeneSaucen();		
		String text1 = "Willkommen beim Burgermeister.\r\nBitte geben Sie Ihre Bestellung für Ihren Lieblingsburger ein.";
		System.out.println(text1);
		Karte willkommen = new Karte();
		willkommen.ausgabe();
		System.out.println("Wir wünschen ihnen einen guten Appetit.");
	}

}
