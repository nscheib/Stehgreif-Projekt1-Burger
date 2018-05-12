import de.hsrm.mi.prog.util.StaticScanner;


/**
 *  Bestellung, dient zum verwalten der bestellten Zutaten, abspeichern in eine Bestellliste und deren Verarbeitung
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Bestellung {

	private int zusammenstellung[] = new int [8];
	private Zutat zutat = new Zutat();
	private Broetchen broetchenListe [] = zutat.getBroetchenListe();
	private Bratlinge bratlingListe [] = zutat.getBratlingListe();
	private Gemuese gemueseListe [] = zutat.getGemueseListe();
	private Salate salatListe [] = zutat.getSalatListe();
	private Saucen saucenListe [] = zutat.getSaucenListe();
	private int komponente = 0;

	/**
	 * Methode zum abfragen der Zutaten die auf dem Burger sollen und dem abspeichern der gewaehlten Zutaten in die Bestellliste
	 */
	public void bestellBeginn () {
		int extra = 0;
		ZutatenErsteller [] zutatenListe;
		do {
			if (komponente == 0) {
				zutatenListe = broetchenListe;
				extra = burger(extra, zutatenListe);
			}else if(komponente == 1) {
				zutatenListe = bratlingListe;
				extra = burger(extra, zutatenListe);			
			}else if(komponente == 2) {
				zutatenListe = gemueseListe;
				extra = burger(extra, zutatenListe);				
			}else if(komponente == 3) {
				zutatenListe = salatListe;
				extra = burger(extra, zutatenListe);			
			}else if(komponente == 4) {
				zutatenListe = saucenListe;
				extra = burger(extra, zutatenListe);						
			}else {
				System.out.println("ERROR Bestellung start");
			}
		}while ((komponente + extra) <= 8 || komponente != 5);
		System.out.println("Ende?");
	}

	/**
	 * Methode dient der Abfrage fuer die Anzahl an Zutanten die man auf seinem Burger moechte
	 * @param extra ist der Wert, der fuer die aktuelle Anzahl an gewaehlten Zutaten steht
	 * @return extra gibt den Wert fuer die Anzahl der gewaehlten Zutaten zurueck
	 */
	public int extraLage(int extra) {
		System.out.println("Wieviel wollen sie haben? ");
		int eingabe = 0;
		boolean korrekt = true;
		do {
			eingabe = StaticScanner.nextInt();
			if(((extra + komponente) + eingabe) <= 8) {
				
				System.out.println("Sie wollen " + eingabe + " Lagen haben?");
				korrekt = bestaetigung();	
			}else if (((extra + komponente) + eingabe) > 8){
				System.out.println("Das ist zuviel!!!");
				
			}else {
				System.out.println("ERROR Extra Lage");
				korrekt = false;
			}
		}while(korrekt);
		extra += eingabe;
		return extra;	
	}

	/**
	 * Methode zum abfragen, ob eine Zutat gewaehlt, uebersprungen und ob diese Zutat hinzugefuegt werden soll
	 * @param extra gibt die zuvor ausgewaehlte Anzahl der Zutaten an die Methode weiter
	 * @param zutatenListe gibt die Anzahl der gesamten Zutaten an die Methode weiter
	 * @return extra gibt den Wert der Anzahl an ausgewaehlten Zutaten zurueck
	 */
	public int burger(int extra, ZutatenErsteller zutatenListe[]) {
		boolean korrekt = true;		
		do {
			System.out.println("Bitte waehlen sie eine Zutat, mittels der dahinterstehenden Zahl:");		
			if (komponente > 0) {
				System.out.println("Die <0> steht fuer das ueberspringen der Zutat");
			}
			for (int i = 0; i < zutatenListe.length - 1; i++) {
				System.out.println(zutatenListe[i].name +"\t <"+ (i+1)+">");		
			}					
			int eingabe = StaticScanner.nextInt();
			if (eingabe == 0 && komponente != 0) {
				System.out.println("Sie wollen diese Zutat ueberspringen?");
				korrekt = bestaetigung();
				extra --;
			}else if (eingabe + 1 > zutatenListe.length || eingabe <= 0){
				System.out.println("Bitte nehmen sie eine Zutat aus der Liste\n");
			}else{
				System.out.println("Wollen sie das " + zutatenListe[eingabe - 1].name + " haben?" );
				korrekt = bestaetigung();
				zusammenstellung[komponente] = eingabe;
				if (komponente > 0) {
					extra = extraLage(extra);
				}
			}
		}while(korrekt);	
		komponente++;
		return extra;
	}

	/**
	 * Methode zur Ueberpruefung der Eingabe, ob die Zutat gewaehlt werden moechte
	 * @return
	 */
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
			System.out.println("das nehme ich jetzt mal als ein <ja>");
			antwort = false;
		}	
		return antwort;
	}
	
	
}
