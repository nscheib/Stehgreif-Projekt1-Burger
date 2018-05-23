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
	private final int MENGEANZUTATEN = 8;
	private double preis = 0;
	

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
		for (int i = 0; i <= bestellung.size()-1; i++) {
			if (bestellung.get(i).zubereitungsDauer > bestellung.get(i + 1).zubereitungsDauer) {
				zubereitungsDauer = bestellung.get(i).zubereitungsDauer;
			}		
			ArrayList<ZutatenErsteller> zutatenListe = new ArrayList <ZutatenErsteller> (bestellung.get(i).getZutatenListe()); 
			for (int j = 1; j < zutatenListe.size(); j++) {
				
				if (zutatenListe.get(j) instanceof Bratlinge) {
					zutatenListe.get(j).breite -= ((zutatenListe.get(j).zubereitungsDauer / 60) * ((zutatenListe.get(j).breite /100) * 3.5));				
				}else if (zutatenListe.get(j) instanceof Broetchen) {
					zutatenListe.get(j).breite += ((zutatenListe.get(j).zubereitungsDauer / 60) * ((zutatenListe.get(j).breite / 100) * 2));
				}else{
					System.out.println("ERROR Zubereitung keine Klasse");
				}
			}	
		}
		System.out.println("Bitte haben sie einen Augenblick gedult");
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
		Burger [] inDieTuete = new Burger[anzahlDerBurger]; 
		if (zubereitet == true) {		
			for (int i = 0; i <= bestellung.size(); i++) {
				ArrayList<ZutatenErsteller> zutatenListe = new ArrayList <ZutatenErsteller> (bestellung.get(i).getZutatenListe());
				for (int j = 0; j <= zutatenListe.size(); j++) {				
					bestellung.get(i).breite += zutatenListe.get(j).breite;
					
				}
				bestellung.get(i).setGeschmack(abfrageGeschmack (zutatenListe));
				endBurger.name = abfrageName(i, j);
				inDieTuete[i] = endBurger; 
			}
			ausgabe(inDieTuete);
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
		ArrayList<String> geschmack =  zutatenListe.getGeschmack();
		String endGeschmack = "Ein wahrlich Individueller Burger";
		int bitter = 0, fett = 0, sauer = 0, salzig = 0, scharf = 0, suess = 0, umami = 0, normal = 0;
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
		if (bitter >= 7) {	
			endGeschmack = "Ganz schoen bitter.";
		}else if (fett >= 7){
			endGeschmack = "Der Burger ist mindestens so fettig wie du.";
		}else if (sauer >= 7){ 
			endGeschmack = "Sauer ist er ja schon.";
		}else if (salzig >= 7){
			endGeschmack = "Danach solltest du etwas trinken.";
		}else if (scharf >= 7){ 
			endGeschmack = "Dir wird schwindelig und du kippst um rip.";
		}else if (suess >= 7){
			endGeschmack= "Das ist mehr eine Suessigkeit, als ein Burger.";
		}else if (umami >= 7){ 
			endGeschmack = "Das ist ein Veganer Albtraum.";
		}else if (normal == 5){ 
			endGeschmack = "Dies ist ein klassischer Burger.";
		}
		if(zutaten >= anzahlDerZutaten) {
			return abfrageGeschmack(anzahlDerBurger, zutaten - 1);
		}else {
			return endGeschmack;
		}
	}

	/**
	 * Methode um den Burger als typ zu deklarieren (vegan, vegetarisch oder fleisch)
	 * @param vegetarisch setzt den gewaehlten Burgertyp fest
	 * @param sorte setzt den benoetigten Typ fest
	 * @param liste setzt den Typ der Zutat fest
	 * @return vegetarisch, gibt zurueck welcher Typ Burger gewaehlt wurde
	 */
	
	public void ausgabe(Burger inDieTuete[]){
		double gesamtPreis = 0;
		for (int i = 0; i <= inDieTuete.length; i++) {
			System.out.print(inDieTuete[i].name + "\t" + inDieTuete[i].breite + "\t" + inDieTuete[i].preis + "\t");
			if (inDieTuete[i].vegetarisch == 2) {
				System.out.println("vegan");
			}else if(inDieTuete[i].vegetarisch == 1) {
				System.out.println("vegetarisch");
			}
			gesamtPreis = inDieTuete[i].preis;
		}
		System.out.println("\t \t \t Das macht zusammen:" + preis);
	}
	
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
/*

 * Name des Burgers individuell erstellbar
 * Geschmacksrichtung
 * vegan vegetarisch
 * Zutaten
 * EXTRA: Lieferung
 */

