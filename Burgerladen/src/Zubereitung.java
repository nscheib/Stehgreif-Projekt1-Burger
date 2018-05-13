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
	private int [][] bestellung;
	private Broetchen broetchenListe [] = Zutat.getBroetchenListe();
	private int breiteBroetchen;
	private Bratlinge bratlingListe [] = Zutat.getBratlingListe();
	private int breiteBratling;
	private Gemuese gemueseListe [] = Zutat.getGemueseListe();
	private Salate salatListe [] = Zutat.getSalatListe();
	private Saucen saucenListe [] = Zutat.getSaucenListe();
	private final int EXTRALAGE = 2;
	private final int BROETCHENSORTE = 0;
	private final int BRATLINGSORTE = 1;
	private final int GEMUESESORTE = 2;
	private final int SALATSORTE = 3;
	private final int SAUCENSORTE = 4; 
	private int bitter = 0;
	private int fett = 0;
	private int sauer = 0;
	private int salzig = 0;
	private int scharf = 0;
	private int suess = 0;
	private int umami = 0;
	private int normal = 0;
	double preis;
	int breite;
	int vegetarisch = 1;

	/**
	 *  Der Konstruktor fuer die Zubereitung setzt verschiedene Parameter fest
	 * @param bestellung setzt fest was alles in der Bestelltung enthalten ist
	 */
	public Zubereitung (int [][] bestellung) {
		this.bestellung = bestellung;
		
	}

	/**
	 * Methode berechnet mithilfe der Zubereitungsdauer der Zutaten eine gesamte Zubereitungsdauer in Millisecounds
	 */
	public void zubereiten () {
		//zeit preis breite
		long start = System.currentTimeMillis();
		long zeitBratlinge, zeitBroetchen, zeitGemuese, zeitSalat, fertig = start;	
		zeitBroetchen = broetchenListe[bestellung[BROETCHENSORTE][0]].zubereitungsDauer;
		if(bestellung[BRATLINGSORTE][0] == 0) {			
			zeitBratlinge = bratlingListe[bestellung[BRATLINGSORTE][0]].zubereitungsDauer;
		}else{
			zeitBratlinge = 0;
		}
		breiteBroetchen += (int) (zeitBroetchen / 60) * ((breiteBroetchen / 100) * 2);
		breiteBratling -= (int) (zeitBratlinge / 60) * ((breiteBratling /100) * 3.5);
		zeitGemuese = abfrageZubereitungsdauer (GEMUESESORTE, gemueseListe);
		zeitSalat = abfrageZubereitungsdauer (SALATSORTE, salatListe);
		
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
	public String essenVerpacken() {
		
		
		String endGeschmack = "Ein wahrlich Individueller Burger";
		
		if (zubereitet == true) {
			preis = abfragePreis(BROETCHENSORTE, broetchenListe);
			preis += abfragePreis(BRATLINGSORTE, bratlingListe);
			preis += abfragePreis(GEMUESESORTE, gemueseListe);
			preis += abfragePreis(SALATSORTE, salatListe);
			preis += abfragePreis(SAUCENSORTE, saucenListe);
			breite = breiteBroetchen;					//Broetchengeht beim backen um 2% auf
			if (bestellung [1][1] == 2) {
				breite += breiteBratling;
			}
			breite += breiteBratling;
			breite += abfrageBreite(GEMUESESORTE, gemueseListe);
			breite += abfrageBreite(SALATSORTE, salatListe);
			breite += abfrageBreite(SAUCENSORTE, saucenListe);
			abfrageGeschmack (BROETCHENSORTE, broetchenListe);
			abfrageGeschmack (BRATLINGSORTE, bratlingListe);
			abfrageGeschmack (GEMUESESORTE, gemueseListe);			
			abfrageGeschmack (SALATSORTE, salatListe);
			abfrageGeschmack (SAUCENSORTE, saucenListe);
			if (bitter >= 4) {	
				endGeschmack = "Ganz schoen bitter.";
			}else if (fett >= 5){
				endGeschmack = "Der Burger ist mindestens so fettig wie du.";
			}else if (sauer >= 3){ 
				endGeschmack = "Sauer ist er ja schon.";
			}else if (salzig >= 3){
				endGeschmack = "Danach solltest du etwas trinken.";
			}else if (scharf >= 4){ 
				endGeschmack = "Dir wird schwindelig und du kippst um rip.";
			}else if (suess >= 3){
				endGeschmack= "Das ist mehr eine Suessigkeit, als ein Burger.";
			}else if (umami >= 5){ 
				endGeschmack = "Das ist ein Veganer Albtraum.";
			}else if (normal == 5){ 
				endGeschmack = "Dies ist ein klassischer Burger.";
			}
			
			abfrageVegetarisch (vegetarisch, BROETCHENSORTE, broetchenListe);
			abfrageVegetarisch (vegetarisch, BRATLINGSORTE, bratlingListe);
			abfrageVegetarisch (vegetarisch, GEMUESESORTE, gemueseListe);			
			abfrageVegetarisch (vegetarisch, SALATSORTE, salatListe);
			abfrageVegetarisch (vegetarisch, SAUCENSORTE, saucenListe);
			
			return endGeschmack;
		}else{
			 String error = "Das Essen muss noch zubereitet werden";
			 return error;
		}
		
		
	}

	/**
	 * Methode zum berechnen der Zubereitungsdauer je Burger
	 * @param sorte setzt die benoetigte Zubereitungsdauer einer Zutat fest
	 * @param liste setzt die Zutat fest
	 * @return wert, gibt den berechneten Wert fuer die Dauer der Zubereitung zurueck
	 */
	private long abfrageZubereitungsdauer(int sorte, ZutatenErsteller [] liste) {	
		long wert = 0;
		if(bestellung[sorte][0] == 0 && bestellung [sorte][1] == EXTRALAGE) {		
			wert = (liste[bestellung[sorte][0]].zubereitungsDauer) * 2;
		}else if ((bestellung[sorte][0] == 0)){
			wert = liste[bestellung[sorte][0]].zubereitungsDauer;
		}else {
			wert = 0;
		}	
		return wert;
	}

	/**
	 * Methode zum berechnen des Preises je Burger
	 * @param sorte setzt den benoetigte Preis einer Zutat fest
	 * @param liste setzt die Zutat fest
	 * @return wert, gibt den berechneten Wert fuer die Gesamtkosten pro Burger zurueck
	 */
	private double abfragePreis(int sorte, ZutatenErsteller [] liste) {	
		double wert = 0;
		if(bestellung[sorte][0] == 0 && bestellung [sorte][1] == EXTRALAGE) {		
			wert = (liste[bestellung[sorte][0]].preis) * 2;
		}else if ((bestellung[sorte][0] == 0)){
			wert = liste[bestellung[sorte][0]].preis;
		}else {
			wert = 0;
		}	
		return wert;
	}

	/**
	 * Methode zum berechnen der Dicke je Burger
	 * @param sorte setzt die benoetigte Dicke einer Zutat fest
	 * @param liste setzt die Zutat fest
	 * @return wert, gibt den berechneten Wert fuer die Gesamtdicke pro Burger zurueck
	 */
	private int abfrageBreite(int sorte, ZutatenErsteller [] liste) {	
		int wert = 0;
		if(bestellung[sorte][0] == 0 && bestellung [sorte][1] == EXTRALAGE) {		
			wert = (liste[bestellung[sorte][0]].breite) * 2;
		}else if ((bestellung[sorte][0] == 0)){
			wert = liste[bestellung[sorte][0]].breite;
		}else {
			wert = 0;
		}	
		return wert;
	}

	/**
	 * Methode zum ueberpruefen welche Geschmacksrichtungen pro Burger enthalten sind
	 * @param sorte setzt die benoetigte Geschmacksrichtung einer Zutat fest
	 * @param liste setzt die Zutat fest
	 */
	private void abfrageGeschmack (int sorte, ZutatenErsteller liste[]) {
		String geschmack [] =  liste[bestellung[sorte][0]].getGeschmack();
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
	}

	/**
	 * Methode um den Burger als typ zu deklarieren (vegan, vegetarisch oder fleisch)
	 * @param vegetarisch setzt den gewaehlten Burgertyp fest
	 * @param sorte setzt den benoetigten Typ fest
	 * @param liste setzt den Typ der Zutat fest
	 * @return vegetarisch, gibt zurueck welcher Typ Burger gewaehlt wurde
	 */
	private int abfrageVegetarisch (int vegetarisch, int sorte, ZutatenErsteller [] liste) {
		if (vegetarisch < liste[bestellung[sorte][0]].getVegetarisch()) {
		vegetarisch = liste[bestellung[sorte][0]].getVegetarisch();
		}
		return vegetarisch;
	}
	
}
/*

 * Name des Burgers individuell erstellbar
 * Geschmacksrichtung
 * vegan vegetarisch
 * Zutaten
 * EXTRA: Lieferung
 */

