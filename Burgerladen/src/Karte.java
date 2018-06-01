// IMPORT --------------------------------------------//
import java.util.ArrayList;

import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Karte, dient zum ausgeben der Anleitung der Speisekarte und Eingabebefehlen
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Karte {

	private int anzahlDerBurger = 0;
	private Broetchen broetchenListe []= Zutaten.getBroetchenListe();
	private Bratlinge bratlingListe [] = Zutaten.getBratlingListe();
	private Gemuese gemueseListe [] = Zutaten.getGemueseListe();
	private Salate salatListe [] = Zutaten.getSalatListe();
	private Kaese kaeseListe [] = Zutaten.getKaeseListe();
	private Saucen saucenListe [] = Zutaten.getSaucenListe();
	private Zutaten bestellteBurger = new Zutaten();
	private Zubereitung inDieKueche;
	
	/**
	 * Methode gibt die Verschiedenen Eingabebefehlen mit der passenden Erklaerung aus
	 */
	public void ausgabe(){	
		String text1 = "Mit <menu> können Sie sich die vollständigen Zutaten anzeigen lassen.";
		String text2 = "Mit <bestellen> können Sie sich ihren eigenen Burger zusammenstellen, belegen und nach einer Wartezeit abholen lassen";
		String text3 = "Mit <zubereiten> können Sie ihre Bestellung zubereiten";
		String text4 = "Mit <mein burger> können Sie ihre derzeitige Burgerkreation abfragen";
		String text5 = "Mit <kasse> können Sie ihren Burger bezahlen und mitnehmen";
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);		
		System.out.println(text4);
		System.out.println(text5);
		String eingabe;
		do {
		eingabe = Abfrage.eingabe();	
		} while(verwaltung(eingabe));
	}

	/**
	 * Methode ruft unterschiedliche Funktionen auf, wie zb der aktuelle Status der Bestellung und gewaehlten Zutaten
	 * @param eingabe gibt den eingegeben Befehl an die Methode weiter
	 */
	public boolean verwaltung(String eingabe){
		boolean korrekt = true;
		
			if (eingabe.equals("menu")){		
				menu(broetchenListe);		
				menu(bratlingListe);	
				menu(gemueseListe);			
				menu(salatListe);
				menu(kaeseListe);
				menu(saucenListe);
				ausgabe();
			}else if (eingabe.equals("bestellung") || eingabe.equals("bestellen")){
				korrekt = false;
				bestellenDesBurgers();
				ausgabe();
			}else if ((eingabe.equals("zubereiten") || eingabe.equals("zubereitung")) && anzahlDerBurger != 0)	{							
				korrekt = false; 
				if (zubereitungDesBurgers(anzahlDerBurger) == true) {
					ausgabe();
				}
			}else if ((eingabe.equals("zubereiten") || eingabe.equals("zubereitung")) && anzahlDerBurger == 0)	{	
				System.out.println("Sie haben keinen Burger zum zubereiten... sad.");
			}else if (eingabe.equals("mein burger")){														// auflistung der bisherigen Bestellung
				burgerAnzeigen(false);
				ausgabe();
				korrekt = false;
			}else if (eingabe.equals("kasse") && anzahlDerBurger != 0){		
				if(inDieKueche == null) {
					System.out.println("Sie muessen den Burger erst noch zubereiten, bevor sie ihn bezahlen koennen.");
				}else {
					inDieKueche.essenVerpacken(anzahlDerBurger);
					System.out.println("Sie können nun ihren Burger nehmen und bezahlen.");
					korrekt = false;
				}
			}else if (eingabe.equals("kasse") && anzahlDerBurger == 0) {
				System.out.println("Sie haben keinen Burger zum bezahlen.");
			}
		return korrekt;
	}

	/**
	 * Methode zur Abfrage, ob eine weitere Bestellung getaetigt werden soll oder nicht
	 * @return antwort, gibt die eingegeben Antwort zurueck
	 */
	public boolean mehrBurger() {

		boolean antwort;
		System.out.println("\nWollen sie einen weiteren Burger Bestellen? <ja> oder <nein> oder geben Sie einen Befehl ein: ");
		String eingabeBestaetigung = StaticScanner.nextString();
		if (eingabeBestaetigung.equals("nein")){
			antwort = true;
		} else if(eingabeBestaetigung.equals("nope")) {
			antwort = true;
		} else if(eingabeBestaetigung.equals("ja")) {
			antwort = false;	
		} else {
			System.out.println("Das interpretieren wir als ein <ja>");
			antwort = false;
		}	
		return antwort;
	}

	/**
	 * Methode gibt die Zutaten mit Name, Preisen uvm. aus
	 * @param liste gibt die verschiedenen Zutaten an die Methode weiter
	 */
	private void menu (ZutatenErsteller liste[]) {
		
		for (int i = 0; i < liste.length - 1; i++) {
			System.out.print(liste[i].name);
			System.out.print("\t" + liste[i].preis + "\t");
			if (liste[i].vegetarisch == 0) {
				System.out.println();
			}else if(liste[i].vegetarisch == 1) {
				System.out.println("vegetarisch");
			}else if(liste[i].vegetarisch == 2) {
				System.out.println("vegan");
			}else{
				System.out.println("ERROR Karte: menu, vegetarisch");
			}
		}
		System.out.println("\n");	
	}

	private void burgerAnzeigen(boolean endAusgabe){		
		ArrayList<Burger> burgerListe = Zutaten.getBurger();
		int i = 0;
		for(Burger burger: burgerListe) {			
			ArrayList<ZutatenErsteller> zutaten = burgerListe.get(i).getZutatenListe();
			System.out.println(burgerListe.get(i).getName());
			for (ZutatenErsteller zutatenListe : zutaten) {
				System.out.println(zutatenListe.name);
			}		
			i++;
		}
	}
		

	/**
	 * Methode speichert die Zutaten eines Burger für die zubereitung ab
	 * @param anzahlDerBurger
	 */
	private boolean zubereitungDesBurgers(int anzahlDerBurger) {
		ArrayList<Burger> burgerListe = Zutaten.getBurger();
		inDieKueche = new Zubereitung(burgerListe);
		inDieKueche.zubereiten(anzahlDerBurger);
		return true;
	}
	
	/**
	 * Methode um einen Burger zu erstellen
	 */
	private void bestellenDesBurgers() {
		Bestellung bestellen = new Bestellung();
		anzahlDerBurger++;
		bestellen.bestellBeginn(anzahlDerBurger);		
		if (mehrBurger()== false) {
			bestellenDesBurgers();
		}
	}
}
