// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Karte, dient zum ausgeben der Anleitung der Speisekarte und Eingabebefehlen
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Karte {

	private int anzahlDerBurger = 0;
	private double preis8, preis7, preis6, preis5, preis4, preis3, preis2, preis1;
	private Broetchen broetchenListe []= Zutat.getBroetchenListe();
	private Bratlinge bratlingListe [] = Zutat.getBratlingListe();
	private Gemuese gemueseListe [] = Zutat.getGemueseListe();
	private Salate salatListe [] = Zutat.getSalatListe();
	private Saucen saucenListe [] = Zutat.getSaucenListe(); 	
	private Zubereitung inDieKueche1;
	private Zubereitung inDieKueche2;
	private Zubereitung inDieKueche3;
	private Zubereitung inDieKueche4;
	private Zubereitung inDieKueche5;
	private Zubereitung inDieKueche6;
	private Zubereitung inDieKueche7;
	private Zubereitung inDieKueche8;
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
		Zutat bestellterBurger = new Zutat();
		
		if (anzahlDerBurger == 0) {
			System.out.println("Sie haben noch keinen Burger zusammengestellt");
		}else if((anzahlDerBurger > 0) && anzahlDerBurger < 9){
			
			switch (anzahlDerBurger) {	
			case 8: 		
				int burger8[][] = bestellterBurger.getBurger8();
				System.out.print(broetchenListe[burger8[0][0]].name);
				extra(bratlingListe, burger8, 1);
				extra(gemueseListe, burger8, 2);
				extra(salatListe, burger8, 3);
				extra(saucenListe, burger8, 4);
				preis8 = (burger8[5][0]) / 100;
				System.out.println("Preis: " + preis8);
				if(endAusgabe == true) {
				System.out.println(inDieKueche8.getBreite() + inDieKueche8.getVegetarisch());
				
				}
			case 7:
				int burger7[][] = bestellterBurger.getBurger7();
				System.out.print(broetchenListe[burger7[0][0]].name);
				extra(bratlingListe, burger7, 1);
				extra(gemueseListe, burger7, 2);
				extra(salatListe, burger7, 3);
				extra(saucenListe, burger7, 4);
				preis7 = (burger7[5][0]) / 100.0;
				System.out.println("Preis: " + preis7);
			case 6:
				int burger6[][] = bestellterBurger.getBurger6();
				System.out.print(broetchenListe[burger6[0][0]].name);
				extra(bratlingListe, burger6, 1);
				extra(gemueseListe, burger6, 2);
				extra(salatListe, burger6, 3);
				extra(saucenListe, burger6, 4);
				preis6 = (burger6[5][0]) / 100.0;
				System.out.println("Preis: " + preis6);
			case 5:
				int burger5[][] = bestellterBurger.getBurger5();
				System.out.print(broetchenListe[burger5[0][0]].name);
				extra(bratlingListe, burger5, 1);
				extra(gemueseListe, burger5, 2);
				extra(salatListe, burger5, 3);
				extra(saucenListe, burger5, 4);
				preis5 = (burger5[5][0]) / 100.0;
				System.out.println("Preis: " + preis5);
			case 4:
				int burger4[][] = bestellterBurger.getBurger4();
				System.out.print(broetchenListe[burger4[0][0]].name);
				extra(bratlingListe, burger4, 1);
				extra(gemueseListe, burger4, 2);
				extra(salatListe, burger4, 3);
				extra(saucenListe, burger4, 4);
				preis4 = (burger4[5][0]) / 100;
				System.out.println("Preis: " + preis4);
			case 3: 
				int burger3[][] = bestellterBurger.getBurger3();
				System.out.print(broetchenListe[burger3[0][0]].name);
				extra(bratlingListe, burger3, 1);
				extra(gemueseListe, burger3, 2);
				extra(salatListe, burger3, 3);
				extra(saucenListe, burger3, 4);
				preis3 = (burger3[5][0]) / 100;
				System.out.println("Preis: " + preis3);
			case 2: 
				int burger2[][] = bestellterBurger.getBurger2();
				System.out.print(broetchenListe[burger2[0][0]].name);
				extra(bratlingListe, burger2, 1);
				extra(gemueseListe, burger2, 2);
				extra(salatListe, burger2, 3);
				extra(saucenListe, burger2, 4);
				preis2 = (burger2[5][0]) / 100;
				System.out.println("Preis: " + preis2);
			case 1:
				int burger1[][] = bestellterBurger.getBurger1();	
				System.out.print(broetchenListe[burger1[0][0]].name);
				extra(bratlingListe, burger1, 1);
				extra(gemueseListe, burger1, 2);
				extra(salatListe, burger1, 3);
				extra(saucenListe, burger1, 4);
				preis1 = (burger1[5][0]) / 100.0;
				System.out.println("Preis: " + preis1);
			}	
		}else {
			System.out.println("ERROR Karte bestellte Burger ausgabe");
		}
	}
	
	private void zubereitungDesBurgers() {
		
		switch (anzahlDerBurger) {
		case 8:
			inDieKueche8.zubereiten();
			System.out.println(inDieKueche8.essenVerpacken());
		case 7:
			inDieKueche7.zubereiten();
			System.out.println(inDieKueche7.essenVerpacken());
		case 6:
			inDieKueche6.zubereiten();
			System.out.println(inDieKueche6.essenVerpacken());
		case 5:
			inDieKueche5.zubereiten();
			System.out.println(inDieKueche5.essenVerpacken());
		case 4:
			inDieKueche4.zubereiten();
			System.out.println(inDieKueche4.essenVerpacken());
		case 3:
			inDieKueche3.zubereiten();
			System.out.println(inDieKueche3.essenVerpacken());
		case 2:
			inDieKueche2.zubereiten();
			System.out.println(inDieKueche2.essenVerpacken());
		case 1:
			inDieKueche1.zubereiten();
			System.out.println(inDieKueche1.essenVerpacken());
			break;
		case 0:
			System.out.println("Sie haben noch keine Burger zum zubereiten bestellt");
			ausgabe();
		}
		burgerAnzeigen(true);
		double preis = preis8 + preis7 + preis6 + preis5 + preis4 + preis3 + preis2 + preis1;
		System.out.println("Alles zusammen kostet dich: " + preis);
	}
	
	private void bestellenDesBurgers() {
		
		switch (anzahlDerBurger) {
		case 0: 		
			Bestellung zusammensteller1 = new Bestellung();
			inDieKueche1 = new Zubereitung (zusammensteller1.bestellBeginn());
			anzahlDerBurger = 1;
			if (mehrBurger()== true) {
				break;
			}
		case 1:
			Bestellung zusammensteller2 = new Bestellung();
			inDieKueche2 = new Zubereitung (zusammensteller2.bestellBeginn());
			anzahlDerBurger = 2;
			if (mehrBurger()== true) {
				break;	
			}
		case 2:
			Bestellung zusammensteller3 = new Bestellung();
			inDieKueche3 = new Zubereitung (zusammensteller3.bestellBeginn());
			anzahlDerBurger = 3;
			if (mehrBurger()== true) {
				break;	
			}
		case 3:		
			Bestellung zusammensteller4 = new Bestellung();
			inDieKueche4 = new Zubereitung (zusammensteller4.bestellBeginn());
			anzahlDerBurger = 4;
			if (mehrBurger()== true) {
				break;
			}
		case 4:
			Bestellung zusammensteller5 = new Bestellung();
			inDieKueche5 = new Zubereitung (zusammensteller5.bestellBeginn());
			anzahlDerBurger = 5;
			if (mehrBurger()== true) {
				break;
			}
		case 5:
			Bestellung zusammensteller6 = new Bestellung();
			inDieKueche6 = new Zubereitung (zusammensteller6.bestellBeginn());
			anzahlDerBurger  = 6;
			if (mehrBurger()== true) {
				break;
			}
		case 6:
			Bestellung zusammensteller7 = new Bestellung();
			inDieKueche7 = new Zubereitung (zusammensteller7.bestellBeginn());
			anzahlDerBurger  = 7;
			if (mehrBurger()== true) {
				break;
			}
		case 7:
			Bestellung zusammensteller8 = new Bestellung();
			inDieKueche8 = new Zubereitung (zusammensteller8.bestellBeginn());
			anzahlDerBurger = 8;
		}
		
	}
	
	private void extra(ZutatenErsteller zutatenliste [], int liste[][], int lage) {
		
		if (liste[lage][1] == 2) {
			System.out.print(zutatenliste[liste[1][0]].name);
			System.out.print(" plus Extralage"+ "\t");
		}else if(liste[lage][1] == 0) {
			System.out.print("\t  -  \t ");
		}else if(liste[lage][1] == 1) {
			System.out.print(zutatenliste[liste[1][0]].name);
		}else {
			System.out.println("ERROR Karte ausgabe extra");
		}
		
	}
}
