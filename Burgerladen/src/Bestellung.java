// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Bestellung, dient zum verwalten der bestellten Zutaten, abspeichern in eine Bestellliste und deren Verarbeitung
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Bestellung {
	
	private Broetchen broetchenListe [] = Zutaten.getBroetchenListe();
	private Bratlinge bratlingListe [] = Zutaten.getBratlingListe();
	private Gemuese gemueseListe [] = Zutaten.getGemueseListe();
	private Salate salatListe [] = Zutaten.getSalatListe();
	private Saucen saucenListe [] = Zutaten.getSaucenListe();
	private ZutatenErsteller[] zusammenstellung = new ZutatenErsteller [8];
	private Burger bestellterBurger = new Burger();
	private int countDown;
	

	/**
	 * Methode zum abfragen der Zutaten die auf dem Burger sollen und dem abspeichern der gewaehlten Zutaten in die Bestellliste
	 */
	public ZutatenErsteller[] bestellBeginn (int anzahlDerBurger) {

		int komponente = 0; 
		countDown = 7;
		ZutatenErsteller zutatenListe [];
		
		boolean ende = false;
		do {
			if (komponente == 0) {
				zutatenListe = broetchenListe;
				komponente = burger(komponente, zutatenListe, anzahlDerBurger);
				// einfügen einer equals. "ende"
			}else if(komponente == 1) {
				zutatenListe = bratlingListe;
				komponente = burger(komponente, zutatenListe, anzahlDerBurger);			
			}else if(komponente == 2) {
				zutatenListe = gemueseListe;
				komponente = burger(komponente, zutatenListe, anzahlDerBurger);				
			}else if(komponente == 3) {
				zutatenListe = salatListe;
				komponente = burger(komponente, zutatenListe, anzahlDerBurger);			
			}else if(komponente == 4) {
				zutatenListe = saucenListe;
				komponente = burger(komponente, zutatenListe, anzahlDerBurger);						
			}else {
				System.out.println("ERROR Bestellung start");
			}
			
			System.out.println("Sie koennen noch " + countDown + " Schichten waehlen.");
		}while (komponente < 5 && ende == false && countDown != 0); 	
		namensGebung();
		burgerSpeichern();
		return zusammenstellung;
		}

	private void namensGebung() {
		boolean eingabe;
		do {
			System.out.println("Wie wollen sie ihren Burger benennen?");
			String burgerName = StaticScanner.nextString();
			System.out.println("Sind sie mit '" + burgerName + "' einverstanden?");
			bestellterBurger.setName(burgerName);
			eingabe = bestaetigung();
		}while(eingabe);
	}

	/**
	 * Methode dient der Abfrage fuer die Anzahl an Zutanten die man auf seinem Burger moechte
	 */
	public int extraLage(int komponente) {

		System.out.println("Möchten Sie eine Extralarge?");
		boolean eingabe;
		eingabe = bestaetigung();
		if (eingabe == true) {
			komponente ++;
		}	
		return komponente;
	}

	/**
	 * Methode zum abfragen, ob eine Zutat gewaehlt, uebersprungen und ob diese Zutat hinzugefuegt werden soll
	 * @param zutatenListe gibt die Anzahl der gesamten Zutaten an die Methode weiter
	 * @return extra gibt den Wert der Anzahl an ausgewaehlten Zutaten zurueck
	 */
	private int burger(int komponente, ZutatenErsteller zutatenListe[], int anzahlDerBurger) {

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
			if (eingabe == 0 && komponente != 0) {											//ueberspringen einer Zutat
				System.out.println("Sie wollen diese Zutat überspringen? ");
				korrekt = bestaetigung();
				komponente ++;
			}else if (eingabe + 1 > zutatenListe.length || eingabe <= 0){					//ausherhalb der Liste gewaehlt
				System.out.println("Bitte wählen Sie eine Zutat aus der Liste aus\n ");
			}else if (eingabe + 1 < zutatenListe.length || eingabe > 0){					//bestaetigen einer erlaubten auswahl
				System.out.println("Wollen Sie " + zutatenListe[eingabe - 1].name + " zu Ihrer Bestellung hinzufügen? ");
				korrekt = bestaetigung();
				bestellterBurger.fuegeZutatHinzu(zutatenListe[eingabe - 1]);
				countDown--;
				if (komponente != 0) {
					komponente = extraLage(komponente);													//extra Wurst gefaellig?
				}else {
					komponente++;
				}
			}else {
				System.out.println("ERROR Bestellung: burger Zutaten abfrage ");
			}
		}while(korrekt);	
		return komponente;
	}

	/**
	 * Methode zum speichern der einzelnen Burger und speichern der Anzahl an Burgern
	 */
	public void burgerSpeichern() {
		Zutaten burger = new Zutaten();
		burger.setBurger(bestellterBurger);
	}
	
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
	}
	
}
