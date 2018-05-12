import de.hsrm.mi.prog.util.StaticScanner;

public class Karte {

	public void ausgabe(){
		String text1 = "Willkommen beim Burgermeister.\r\nBitte geben Sie Ihre Bestellung fuer Ihre Lieblingsburger ein.";
		String text2 = "Mit <menu> koennen Sie sich die vollstaendigen Zutaten anzeigen lassen.";
		String text3 = "Mit <zutat> und der jeweiligen Nummer koennen Sie eine Zutat auswaehlen.";
		String text4 = "Mit <bestellung> koennen sie sich ihren eigenen Burger zusammenstellen und zur abholung bestellen";
		String text5 = "Mit <ok> koennen sie ihre Bestellung bestaetigen";
		String text6 = "Mit <meine Burger> koennen sie ihre Kreation derzeitige abfragen";
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
		System.out.println(text4);
		System.out.println(text5);		
		System.out.println(text6);
		String eingabe = Abfrage.eingabe();
		verwaltung(eingabe);
	}
	
	public void verwaltung(String eingabe){
		
		if (eingabe.equals("menu")){
			//auflistung der Zutaten
		}else if (eingabe.equals("bestellung")){
			
			Bestellung eins = new Bestellung();
			Zubereitung inDieKueche1 = new Zubereitung (eins.bestellBeginn());
			inDieKueche1.zubereiten();
			System.out.println(inDieKueche1.essenVerpacken());
			
		}else if (eingabe.equals("meine Burger")){
			// auflistung der bisherigen Bestellung
		}
		
	}
	
	public static boolean mehrBurger() {
		boolean antwort;
		System.out.println("Wollen sie einen weiteren Burger Bestellen? <ja> oder <nein>");
		String eingabeBestaetigung = StaticScanner.nextString();
		if (eingabeBestaetigung.equals("nein")){
			antwort = true;
		}else if(eingabeBestaetigung.equals("nope")) {
			antwort = true;
		}else if(eingabeBestaetigung.equals("ja")) {
			antwort = false;	
		}else {
			System.out.println("das nehme ich jetzt mal als ein <ja>");
			antwort = false;
		}	
		return antwort;
	}
	/*
	 * Speisekarte
	 * Preise 
	 * zur bestellung
	 */
	
	
}
