// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;

import java.awt.*;
// IMPORT --------------------------------------------//

/**
 *  Karte, dient zum ausgeben der Anleitung der Speisekarte und Eingabebefehlen
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Karte {
	
	private int anzahlDerBurger = 0;

	private int [][] bestellung;
	private Broetchen broetchenListe [] = Zutat.getBroetchenListe();
	private String eingabe;

	/**
	 * Methode gibt die Verschiedenen Eingabebefehlen mit der passenden Erklaerung aus
	 */
	public void ausgabe(){
		
		String text1 = "Willkommen beim Burgermeister.\r\nBitte geben Sie Ihre Bestellung für Ihren Lieblingsburger ein.";
		String text2 = "Mit <menu> können Sie sich die vollständigen Zutaten anzeigen lassen.";
		String text3 = "Mit <zutat> und der jeweiligen Nummer können Sie eine Zutat auswählen.";
		String text4 = "Mit <bestellen> können Sie sich ihren eigenen Burger zusammenstellen, belegen und nach einer Wartezeit abholen lassen";
		String text5 = "Mit <ok> können Sie ihre Bestellung bestätigen";
		String text6 = "Mit <mein burger> können Sie ihre derzeitige Burgerkreation abfragen";
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
		System.out.println(text4);
		System.out.println(text5);		
		System.out.println(text6);
		String eingabe = Abfrage.eingabe();
		verwaltung(eingabe);
	}

	/**
	 * Methode ruft unterschiedliche Funktionen auf, wie zb der aktuelle Status der Bestellung und gewaehlten Zutaten
	 * @param eingabe gibt den eingegeben Befehl an die Methode weiter
	 */
	public void verwaltung(String eingabe){
		
		if (eingabe.equals("menu")){
			Broetchen broetchenListe []= Zutat.getBroetchenListe();
			menu(broetchenListe);
			Bratlinge bratlingListe [] = Zutat.getBratlingListe();
			menu(bratlingListe);
			Gemuese gemueseListe [] = Zutat.getGemueseListe();
			menu(gemueseListe);
			Salate salatListe [] = Zutat.getSalatListe();
			menu(salatListe);
			Saucen saucenListe [] = Zutat.getSaucenListe(); 	
			menu(saucenListe);

		}else if (eingabe.equals("bestellung") || eingabe.equals("bestellen")){
			Bestellung zusammensteller = new Bestellung();
			Zubereitung inDieKueche1 = new Zubereitung (zusammensteller.bestellBeginn());
			inDieKueche1.zubereiten();
			System.out.println(inDieKueche1.essenVerpacken());
			if (mehrBurger()== false) {
				Zubereitung inDieKueche2 = new Zubereitung (zusammensteller.bestellBeginn());
				inDieKueche2.zubereiten();
				System.out.println(inDieKueche2.essenVerpacken());
				if (mehrBurger()== false) {	
					Zubereitung inDieKueche3 = new Zubereitung (zusammensteller.bestellBeginn());
					inDieKueche3.zubereiten();
					System.out.println(inDieKueche3.essenVerpacken());
					if (mehrBurger()== false) {
						Zubereitung inDieKueche4 = new Zubereitung (zusammensteller.bestellBeginn());
						inDieKueche4.zubereiten();
						System.out.println(inDieKueche4.essenVerpacken());
						if (mehrBurger()== false) {
							Zubereitung inDieKueche5 = new Zubereitung (zusammensteller.bestellBeginn());
							inDieKueche5.zubereiten();
							System.out.println(inDieKueche5.essenVerpacken());
							if (mehrBurger()== false) {
								Zubereitung inDieKueche6 = new Zubereitung (zusammensteller.bestellBeginn());
								inDieKueche6.zubereiten();
								System.out.println(inDieKueche6.essenVerpacken());
								if (mehrBurger()== false) {				
									Zubereitung inDieKueche7 = new Zubereitung (zusammensteller.bestellBeginn());
									inDieKueche7.zubereiten();
									System.out.println(inDieKueche7.essenVerpacken());
									if (mehrBurger()== false) {
										Zubereitung inDieKueche8 = new Zubereitung (zusammensteller.bestellBeginn());
										inDieKueche8.zubereiten();
										System.out.println(inDieKueche8.essenVerpacken());
									}
								}	
							}
						}
					}
				}
			}
		}else if (eingabe.equals("mein burger")){
			// auflistung der bisherigen Bestellung
			//Broetchen karte1 = broetchenListe[bestellung[1][0]];
			//System.out.println(karte1);
		}
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
		anzahlDerBurger++;
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
}
