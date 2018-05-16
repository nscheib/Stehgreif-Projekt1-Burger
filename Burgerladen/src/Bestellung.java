// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Bestellung, dient zum verwalten der bestellten Zutaten, abspeichern in eine Bestellliste und deren Verarbeitung
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Bestellung {

	private int zusammenstellung[][] = new int [5][2];
	private Broetchen broetchenListe [] = Zutat.getBroetchenListe();
	private Bratlinge bratlingListe [] = Zutat.getBratlingListe();
	private Gemuese gemueseListe [] = Zutat.getGemueseListe();
	private Salate salatListe [] = Zutat.getSalatListe();
	private Saucen saucenListe [] = Zutat.getSaucenListe();
	private int burgerNummer = 0;

	/**
	 * Methode zum abfragen der Zutaten die auf dem Burger sollen und dem abspeichern der gewaehlten Zutaten in die Bestellliste
	 */
	public int [][] bestellBeginn () {

		int komponente = 0;
		ZutatenErsteller zutatenListe [];
		do {
			if (komponente == 0) {
				zutatenListe = broetchenListe;
				komponente = burger(komponente, zutatenListe);
			}else if(komponente == 1) {
				zutatenListe = bratlingListe;
				komponente = burger(komponente, zutatenListe);			
			}else if(komponente == 2) {
				zutatenListe = gemueseListe;
				komponente = burger(komponente, zutatenListe);				
			}else if(komponente == 3) {
				zutatenListe = salatListe;
				komponente = burger(komponente, zutatenListe);			
			}else if(komponente == 4) {
				zutatenListe = saucenListe;
				komponente = burger(komponente, zutatenListe);						
			}else {
				System.out.println("ERROR Bestellung start");
			}
		}while (komponente != 5); 		
		burgerSpeichern();
		return zusammenstellung;								//Zubereiten
	}// END bestellBeginn

	/**
	 * Methode dient der Abfrage fuer die Anzahl an Zutanten die man auf seinem Burger moechte
	 */
	public void extraLage(int komponente) {

		System.out.println("Möchten Sie eine Extralarge?");
		boolean eingabe;
		eingabe = bestaetigung();
		if (eingabe == true) {
			zusammenstellung[komponente][1] = 1;
		}else{
			zusammenstellung[komponente][1] = 2;
		}	
	}// END extraLage

	/**
	 * Methode zum abfragen, ob eine Zutat gewaehlt, uebersprungen und ob diese Zutat hinzugefuegt werden soll
	 * @param zutatenListe gibt die Anzahl der gesamten Zutaten an die Methode weiter
	 * @return extra gibt den Wert der Anzahl an ausgewaehlten Zutaten zurueck
	 */
	public int burger(int komponente, ZutatenErsteller zutatenListe[]) {

		boolean korrekt = true;	
		int eingabe = 0;
		do {
			System.out.println("\nBitte wählen Sie eine Zutat, durch die dahinter stehende Zahl: ");
			if (komponente > 0) {
				System.out.println("Die <0> steht für das überspringen der Zutat... ");
			}
			for (int i = 0; i < zutatenListe.length - 1; i++) {
				System.out.println(zutatenListe[i].name +"\t <"+ (i+1)+">");		
			}			
			do {
				System.out.print("\nBitte geben Sie für die gewünschte Zutat die passende Zahl ein: ");
				eingabe = StaticScanner.nextInt();
			}while (eingabe > 8 );
			if (eingabe == 0 && komponente != 0) {								//ueberspringen einer Zutat
				System.out.println("Sie wollen diese Zutat überspringen? ");
				korrekt = bestaetigung();
				zusammenstellung[komponente][1] = 0;
			}else if (eingabe + 1 > zutatenListe.length || eingabe <= 0){					//ausherhalb der Liste gewaehlt
				System.out.println("Bitte wählen Sie eine Zutat aus der Liste aus\n ");
			}else if (eingabe + 1 < zutatenListe.length || eingabe > 0){					//bestaetigen einer erlaubten auswahl
				System.out.println("Wollen Sie " + zutatenListe[eingabe - 1].name + " zu Ihrer Bestellung hinzufügen? ");
				korrekt = bestaetigung();
				zusammenstellung[komponente][0] = eingabe - 1;
				if (komponente != 0) {
					extraLage(komponente);								//extra Wurst gefaellig?
				}
			}else {
				System.out.println("ERROR Bestellung: burger Zutaten abfrage ");
			}
		}while(korrekt);	
		komponente++;
		return komponente;
	}// END burger

	/**
	 * Methode zum speichern der einzelnen Burger und speichern der Anzahl an Burgern
	 */
	public void burgerSpeichern() {

		Zutat burger = new Zutat();
		switch (burgerNummer) {
		case 0:
			burger.setBurger1(zusammenstellung);
			burgerNummer++;
			break;
		case 1:
			burger.setBurger2(zusammenstellung);
			burgerNummer++;
			break;
		case 2:
			burger.setBurger3(zusammenstellung);
			burgerNummer++;
			break;
		case 3:
			burger.setBurger4(zusammenstellung);
			burgerNummer++;
			break;
		case 4:
			burger.setBurger5(zusammenstellung);
			burgerNummer++;
			break;
		case 5:
			burger.setBurger6(zusammenstellung);
			burgerNummer++;
			break;
		case 6:
			burger.setBurger7(zusammenstellung);
			burgerNummer++;
			break;
		}
	}// END burgerSpeichern
	
	/**
	 * Methode zur Ueberpruefung der Eingabe, ob die Zutat gewaehlt werden moechte
	 * @return antwort gibt die eingegebene Antwort zurueck
	 */
 	private boolean bestaetigung() {

		boolean antwort;
		String eingabeBestaetigung = StaticScanner.nextString();
		if (eingabeBestaetigung.equals("nein")){
			antwort = true;
		}else if(eingabeBestaetigung.equals("nope")) {
			antwort = true;
		}else if(eingabeBestaetigung.equals("ja")) {
			antwort = false;	
		}else {
			System.out.println("Das interpretieren wir als ein <ja>");
			antwort = false;
		}	
		return antwort;
	}// END bestaetigen
	
}// END Bestellung
