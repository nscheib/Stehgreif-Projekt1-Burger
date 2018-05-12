
/**
 *  Karte, dient zum ausgeben der Anleitung der Speisekarte und Eingabebefehlen
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Karte {

	/**
	 * Methode gibt die Verschiedenen Eingabebefehlen mit der passenden Erklaerung aus
	 */
	public void ausgabe(){
		String text1 = "Willkommen beim Burgermeister.\r\nBitte geben Sie Ihre Bestellung fuer Ihre Lieblingsburger ein.";
		String text2 = "Mit <menu> koennen Sie sich die vollstaendigen Zutaten anzeigen lassen.";
		String text3 = "Mit <zutat> und der jeweiligen Nummer koennen Sie eine Zutat auswaehlen.";
		String text4 = "Mit <bestellung> koennen sie sich ihren eigenen Burger zusammenstellen und zur abholung bestellen";
		String text5 = "Mit <ok> koennen sie ihre Bestellung bestaetigen";
		String text6 = "Mit <meine Burger> koennen sie jederzeit ihre Kreation abfragen";
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
			//auflistung der Zutaten
		}else if (eingabe.equals("bestellung")){
			
			//bestell uebersicht
		}else if (eingabe.equals("meine Burger")){
			// auflistung der bisherigen Bestellung
		}
		
	}
	/*
	 * Speisekarte
	 * Preise 
	 * zur bestellung
	 */
	
	
}
