// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Karte, dient zum ausgeben der Anleitung der Speisekarte und Eingabebefehlen
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Karte {

	private int anzahlDerBurger = 1;
	private Broetchen broetchenListe []= Zutat.getBroetchenListe();
	private Bratlinge bratlingListe [] = Zutat.getBratlingListe();
	private Gemuese gemueseListe [] = Zutat.getGemueseListe();
	private Salate salatListe [] = Zutat.getSalatListe();
	private Saucen saucenListe [] = Zutat.getSaucenListe(); 
	private ZutatenErsteller [][] bisherigeBurger;
	private Zubereitung inDieKueche;
	/**
	 * Methode gibt die Verschiedenen Eingabebefehlen mit der passenden Erklaerung aus
	 */
	public void ausgabe(){	
		String text1 = "Mit <menu> können Sie sich die vollständigen Zutaten anzeigen lassen.";
		String text2 = "Mit <bestellen> können Sie sich ihren eigenen Burger zusammenstellen, belegen und nach einer Wartezeit abholen lassen";
		String text3 = "Mit <zubereiten> können Sie ihre Bestellung zubereiten";
		String text4 = "Mit <mein burger> können Sie ihre derzeitige Burgerkreation abfragen";
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);		
		System.out.println(text4);
		String eingabe = Abfrage.eingabe();
		verwaltung(eingabe);
	}

	/**
	 * Methode ruft unterschiedliche Funktionen auf, wie zb der aktuelle Status der Bestellung und gewaehlten Zutaten
	 * @param eingabe gibt den eingegeben Befehl an die Methode weiter
	 */
	public void verwaltung(String eingabe){
		
		if (eingabe.equals("menu")){		
			menu(broetchenListe);		
			menu(bratlingListe);	
			menu(gemueseListe);			
			menu(salatListe);		
			menu(saucenListe);
			ausgabe();
		}else if (eingabe.equals("bestellung") || eingabe.equals("bestellen")){
			bestellenDesBurgers();
			ausgabe();
		}else if (eingabe.equals("zubereiten") || eingabe.equals("zubereitung")) {
			zubereitungDesBurgers();		
		}else if(eingabe.equals("mein burger")){														// auflistung der bisherigen Bestellung
			burgerAnzeigen(false);
			ausgabe();
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
		Zutat bestellteBurger = new Zutat();
		ZutatenErsteller[][] burger = bestellteBurger.getBurger();
		boolean mengeDerZutaten = false;
		
		for(int i = 0; i < anzahlDerBurger; i++) {
			while (mengeDerZutaten) {
				int j = 0;
				if (burger[i][j] == null) {
					mengeDerZutaten = true;
				}else {
				System.out.print(burger[i][j].name);
				j++;
				}
			}
			mengeDerZutaten = false;
		}
		
	}
	
	private void zubereitungDesBurgers(int anzahlDerBurger) {
		
			
		
			
		
		//burgerAnzeigen(true);
		//double preis = 
		//System.out.println("Alles zusammen kostet dich: " + preis);
	}
	
	private void bestellenDesBurgers() {
		
			Bestellung zusammensteller = new Bestellung();
			ZutatenErsteller burger[] = new ZutatenErsteller [8] ;
			burger = zusammensteller.bestellBeginn(burger, anzahlDerBurger); 
			anzahlDerBurger ++;
			if (mehrBurger()== true) {
				bestellenDesBurgers();
			}
	}
}
