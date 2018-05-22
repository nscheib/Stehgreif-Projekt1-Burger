// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  Salate, dient zum verwalten der verschiedenen Salatsorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Zubereitung {
	
	private boolean zubereitet = false;
	private ZutatenErsteller [][] bestellung;
	private final int MENGEANZUTATEN = 8;
	private double preis = 0;
	private int breite = 0;
	

	/**
	 *  Der Konstruktor fuer die Zubereitung setzt verschiedene Parameter fest
	 * @param bestellung setzt fest was alles in der Bestelltung enthalten ist
	 */
	public Zubereitung (ZutatenErsteller [][] bestellung) {
		this.bestellung = bestellung;
	}
	
	public double berechnePreis(int anzahlDerBurger) {
		for(int zutat = 0; zutat < 8; zutat++) {
		this.preis += bestellung[anzahlDerBurger][zutat].preis;
		}
		return preis;
	}	
	
	/**
	 * Methode berechnet mithilfe der Zubereitungsdauer der Zutaten eine gesamte Zubereitungsdauer in Millisecounds
	 */
	public void zubereiten (int anzahlDerBurger) {
		//zeit preis breite
		long start = System.currentTimeMillis();
		long zeitBratlinge = 0, zeitBroetchen = 0, zeitGemuese = 0, zeitSalat = 0, fertig = start;	
		for (int i = 0; i <= anzahlDerBurger; i++) {
			zeitBroetchen += bestellung[i][0].zubereitungsDauer;
			for (int j = 1; j < MENGEANZUTATEN; j++) {
				
				if (bestellung[i][j] instanceof Bratlinge) {
					zeitBratlinge += bestellung[i][j].zubereitungsDauer;
					bestellung[i][j].breite -= (int) ((bestellung[i][j].zubereitungsDauer / 60) * ((bestellung[i][j].breite /100) * 3.5));
				}else if (bestellung[i][j] instanceof Gemuese) {
					zeitGemuese += bestellung[i][j].zubereitungsDauer;
				}else if (bestellung[i][j] instanceof Salate) {
					zeitSalat += bestellung[i][j].zubereitungsDauer;
				}else{
					System.out.println("ERROR Zubereitung keine Klasse");
				}
				
			}	
			bestellung[i][0].breite += (int) ((bestellung[i][0].zubereitungsDauer / 60) * ((bestellung[i][0].breite / 100) * 2));
		}
		System.out.println("Bitte haben sie einen Augenblick gedult");
		while ((fertig - start) > zeitBroetchen && (fertig - start) > zeitBratlinge){
			fertig = System.currentTimeMillis();
			if ((fertig - start) > zeitBroetchen) {
				System.out.println("Ihr Broetchen ist fertig. Jetzt sollte es nicht mehr lange dauern.");
			}
			if ((fertig - start) > zeitBratlinge){
				System.out.println("Ihr Bratling ist fertig. Nur noch ein paar Minuten bitte");
			}
			if ((fertig - start) < zeitGemuese){
				System.out.println("Ihr Gemuese ist noch nicht mal fertig, ich bitte um ein wenig Gedult!!");
			}
			if ((fertig - start) < zeitSalat){
				System.out.println("Nicht einmal McDoofhalt haette so schnell einen 'Salat' zubereitet");
			}
			String eingabe = StaticScanner.nextString();
			if (eingabe.equals("Mach hinne")) {   //(eingabeBestaetigung.equals("nein")
				System.out.println("OK ok ist ja schon fertig");
				zeitBroetchen = 0;
				zeitBratlinge = 0;
				zeitGemuese = 0;
				zeitSalat = 0;
			}
			fertig = System.currentTimeMillis();
		}
		zubereitet = true;
	}

	/**
	 * Methode zum "verpacken" des Burgers und die damit verbundene Zeit
	 */
	
	public String essenVerpacken(int anzahlDerBurger) {
		Burger [] inDieTuete = new Burger[anzahlDerBurger]; 
		
		
		if (zubereitet == true) {		
			
			for (int i = 0; i <= bestellung.length; i++) {
				Burger endBurger = new Burger();
				int vegetarisch = 2;
				int j = 0;
				while ((bestellung[i][j] != null) || (j < 8)) {					
					endBurger.breite += bestellung[i][j].breite;
					endBurger.vegetarisch = abfrageVegetarisch (vegetarisch, i, j);
					endBurger.preis += bestellung[i][j].preis;
					j++;
				}
				endBurger.setGeschmack(abfrageGeschmack (i, j));
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

	private String abfrageName(int anzahlDerBurger, int zutaten) {
		boolean korrekt = false;
		String name;
		do {
			System.out.println("Wie wollen sie ihren Burger nennen?");
		name = StaticScanner.nextString();
		System.out.println("Wollen sie ihren Burger mit ");
		for (int i = 0; i < zutaten; i++) { 
			System.out.print(bestellung [anzahlDerBurger][i].name + "\t");
		}
		System.out.println("\n" + name + " nennen?");
		korrekt = bestaetigung();
		}while(korrekt);
		return name;
	}
	
	
	/**
	 * Methode zum ueberpruefen welche Geschmacksrichtungen pro Burger enthalten sind
	 * @param sorte setzt die benoetigte Geschmacksrichtung einer Zutat fest
	 * @param liste setzt die Zutat fest
	 */
	
	private String abfrageGeschmack (int anzahlDerBurger, int zutaten) {
		int anzahlDerZutaten = 0;
		String geschmack [] =  bestellung[anzahlDerBurger][zutaten].getGeschmack();
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
	
	private int abfrageVegetarisch (int vegetarisch, int i, int j) {
		if (vegetarisch > bestellung[i][j].getVegetarisch()) {
		vegetarisch = bestellung[i][j].getVegetarisch();
		}
		return vegetarisch;
	}
	
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
	
	public int getBreite() {
		return breite;
	}
	
	public double getPreis() {
		return preis;
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

