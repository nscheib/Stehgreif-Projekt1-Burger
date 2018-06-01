// IMPORT --------------------------------------------//
import java.util.ArrayList;

import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Salate, dient zum verwalten der verschiedenen Salatsorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Zubereitung {
	
	private boolean zubereitet = false;
	private ArrayList<Burger> bestellung;

	/**
	 *  Der Konstruktor fuer die Zubereitung setzt verschiedene Parameter fest
	 * @param bestellung setzt fest was alles in der Bestelltung enthalten ist
	 */
	public Zubereitung(ArrayList<Burger> bestellung){		
		this.bestellung = bestellung;				
	}
	
	/**
	 * Methode berechnet mithilfe der Zubereitungsdauer der Zutaten eine gesamte Zubereitungsdauer in Millisecounds
	 */
	public void zubereiten (int anzahlDerBurger) {
		//zeit preis breite
		long start = System.currentTimeMillis(), zubereitungsDauer = 0, fertig = System.currentTimeMillis();
		for (int i = 0; i < bestellung.size() - 1; i++) {
			if (bestellung.size() > 1) {
				if (bestellung.get(i).zubereitungsDauer > bestellung.get(i + 1).zubereitungsDauer) {
					zubereitungsDauer = bestellung.get(i).zubereitungsDauer;
				}else {
					zubereitungsDauer = bestellung.get(i + 1).zubereitungsDauer;
				}
			}
			bestellung.get(i).zubereitenDesBurgers();
			
		}
		System.out.println("Ihr Burger ist zubereitet");
		while ((fertig - start) > zubereitungsDauer){
		String eingabe = StaticScanner.nextString();
		if (eingabe.equals("Mach hinne")) {   //(eingabeBestaetigung.equals("nein")
			System.out.println("OK ok ist ja schon fertig");
			zubereitungsDauer = 0;
		}
			fertig = System.currentTimeMillis();
		}
		zubereitet = true;
	}

	/**
	 * Methode zum "verpacken" des Burgers und die damit verbundene Zeit
	 */
	public String essenVerpacken(int anzahlDerBurger) {					//ruf diese Methode auf Nick 
		if (zubereitet == true) {		
			for (int i = 0; i < bestellung.size(); i++) {
				ArrayList<ZutatenErsteller> zutatenListe = bestellung.get(i).getZutatenListe();
				for (int j = 0; j < zutatenListe.size(); j++) {				
					bestellung.get(i).breite += zutatenListe.get(j).breite;					
				}
				bestellung.get(i).setGeschmack(abfrageGeschmack (zutatenListe));
			}
			ausgabe();
			String fertig = "Essen ist fertig";
			return fertig;
		}else{
			 String error = "Das Essen muss noch zubereitet werden";
			 return error;
		}				
	}

	
	
	/**
	 * Methode zum ueberpruefen welche Geschmacksrichtungen pro Burger enthalten sind
	 * @param sorte setzt die benoetigte Geschmacksrichtung einer Zutat fest
	 * @param liste setzt die Zutat fest
	 */
	private String abfrageGeschmack (ArrayList<ZutatenErsteller> zutatenListe) {
		int anzahlDerZutaten = 0;
		int bitter = 0, fett = 0, sauer = 0, salzig = 0, scharf = 0, suess = 0, umami = 0, normal = 0;
		String endGeschmack = "Ein wahrlich Individueller Burger";
		while (anzahlDerZutaten < zutatenListe.size()) {
			String[] geschmack =  zutatenListe.get(anzahlDerZutaten).getGeschmack();		
			for (int i = 0; i < geschmack.length; i++) {
				switch (geschmack[i]) {
				case "Bitter":	
					bitter++;
					continue;
				case "Fett":
					fett++;
					continue;
				case "Sauer":
					sauer++;
					continue;
				case "Salzig":
					salzig++;
					continue;
				case "Scharf":
					scharf++;
					continue;
				case "Suess":
					suess++;
					continue;
				case "Umami":
					umami++;
					continue;
				case "Normal":
					normal++;
				}
			}
			anzahlDerZutaten++;
		}
		if (bitter >= 7) {	
			endGeschmack += "Ganz schoen bitter. ";
		}else if (fett >= 7){
			endGeschmack += "Der Burger ist mindestens so fettig wie du. ";
		}else if (sauer >= 7){ 
			endGeschmack += "Sauer ist er ja schon. ";
		}else if (salzig >= 7){
			endGeschmack += "Danach solltest du etwas trinken. ";
		}else if (suess >= 7){
			endGeschmack += "Das ist mehr eine Suessigkeit, als ein Burger. ";
		}else if (umami >= 7){ 
			endGeschmack += "Das ist ein Veganer Albtraum. ";
		}else if (scharf >= 7){ 
			endGeschmack += "Dir wird schwindelig und du kippst um rip. ";
		}else if (normal == 5){ 
			endGeschmack = "Dies ist ein klassischer Burger.";
		}
		return endGeschmack;
		
	}

	/**
	 * Methode um den Burger als typ zu deklarieren (vegan, vegetarisch oder fleisch)
	 * @param vegetarisch setzt den gewaehlten Burgertyp fest
	 * @param sorte setzt den benoetigten Typ fest
	 * @param liste setzt den Typ der Zutat fest
	 * @return vegetarisch, gibt zurueck welcher Typ Burger gewaehlt wurde
	 */
	private void ausgabe(){
		double gesamtPreis = 0;
		for (int i = 0; i < bestellung.size(); i++) {
			System.out.print(bestellung.get(i).name + "\t ist " + bestellung.get(i).breite + " breit\t und kostet:" + bestellung.get(i).preis + "\t");
			if (bestellung.get(i).vegetarisch == 2) {
				System.out.print("vegan");
			}else if(bestellung.get(i).vegetarisch == 1) {
				System.out.print("vegetarisch");
			}
			String endGeschmack = bestellung.get(i).getEndGeschmack();
			System.out.println(endGeschmack);
			gesamtPreis += bestellung.get(i).preis;
		}
		System.out.println("\t \t \t Das macht zusammen:" + gesamtPreis);
	}
	
}
/*

 * Name des Burgers individuell erstellbar
 * Geschmacksrichtung
 * vegan vegetarisch
 * Zutaten
 * EXTRA: Lieferung
 */

