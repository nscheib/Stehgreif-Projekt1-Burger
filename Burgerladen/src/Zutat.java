
/**
 *  Zutat, dient zum verwalten der verschiedenen Zutaten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Zutat {
	
	private static int anzahlBroetchenSorten = 5;
	private static int anzahlSalatSorten = 3;
	private static int anzahlSaucenSorten = 5;
	private static int anzahlBratlingSorten = 5;
	private static int anzahlGemueseSorten = 5;
	private static int burger1[][];
	private static int burger2[][];
	private static int burger3[][];
	private static int burger4[][];
	private static int burger5[][];
	private static int burger6[][];
	private static int burger7[][];
	private static int burger8[][];
	private static Broetchen [] broetchenListe = new Broetchen [anzahlBroetchenSorten];
	private static Bratlinge [] bratlingListe = new Bratlinge [anzahlBratlingSorten];
	private static Gemuese [] gemueseListe = new Gemuese [anzahlGemueseSorten];
	private static Salate [] salatListe = new Salate [anzahlSalatSorten];
	private static Saucen [] saucenListe = new Saucen [anzahlSaucenSorten];

	/**
	 * Methode enthaelt die verschiedenen Broetchensorten mit den speziefischen Eigenschaften, wie Geschmack. Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneBroetchen() {

		//bitter, fett, salzig, sauer, scharf, suess, umami, normal
		String [] geschmackHamburger = {"Fett", "Suess", "Normal"};
		String [] geschmackSesam = {"Fett", "Suess"};
		String [] geschmackVegan = {"Salzig"};
		String [] geschmackCiabatta = {"Fett"}; 
		//breite, preis, vegetarisch, geschmack, zubereitungsDauer, name
		Broetchen hamburgerBroetchen = new Broetchen (27, 0.85, 1, 90l, geschmackHamburger, "Hamburger Broetchen");
		Broetchen sesamBroetchen = new Broetchen (28, 0.95, 1, 90l, geschmackSesam, "Sesam Broetchen......");
		Broetchen veganesBroetchen = new Broetchen (34, 0.55, 2, 240l, geschmackVegan, "Veganer Broetchen");
		Broetchen ciabatta = new Broetchen (41, 0.45, 1, 330l, geschmackCiabatta, "Ciabatta Broetchen");
		broetchenListe[0] = hamburgerBroetchen;
		broetchenListe[1] = sesamBroetchen;
		broetchenListe[2] = veganesBroetchen;
		broetchenListe[3] = ciabatta;
	}// END vorgegebeneBroetchen

	/**
	 * Methode enthaelt die verschiedenen Salatsorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneSalate() {

		String [] geschmackEisberg = {"Normal"};
		String [] geschmackRucola = {"Sauer"};
		Salate eisbergSalat = new Salate (5, 0.18, 2, 5l, geschmackEisberg, "Eisbergsalat");
		Salate rucolaSalat = new Salate (3, 0.25, 2, 3l, geschmackRucola, "Rucolasalat");
		salatListe[0] = eisbergSalat;
		salatListe[1] = rucolaSalat;	
	}// END vorgegebeneSalate

	/**
	 * Methode enthaelt die verschiedenen Saucensorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneSaucen() {

		String [] geschmackKetchup = {"Suess", "Normal"}; 
		String [] geschmackSandwichSauce = {"Fett", "Suess"};
		String [] geschmackChiliSauce = {"Scharf"};
		String [] geschmackHonigSenfSauce = {"Scharf", "Suess"};
		Saucen ketchup = new Saucen (0.1, 2, 1l, geschmackKetchup, "Ketchup");
		Saucen sandwichSauce = new Saucen (0.15, 1, 1l, geschmackSandwichSauce,"Sandwich-Sauce");
		Saucen chiliSauce = new Saucen (0.25, 2, 1l, geschmackChiliSauce, "Chili-Sauce");
		Saucen honigSenfSauce = new Saucen (0.18, 1, 1l, geschmackHonigSenfSauce, "Honig-Senf-Sauce");
		saucenListe[0] = ketchup;
		saucenListe[1] = sandwichSauce;
		saucenListe[2] = chiliSauce;
		saucenListe[3] = honigSenfSauce;
	}// END vorgegebeneSaucen

	/**
	 * Methode enthaelt die verschiedenen Bratlingssorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneBratlinge() {

		String [] geschmackPferdefleisch = {"Fett", "Umami", "Normal"}; // Einkaufspreis 0.20
		String [] geschmackHaenchenfleisch = {"Umami"};
		String [] geschmackFalafel = {"Scharf", "Suess"};
		String [] geschmackGemueseBratling = {"Bitter", "Salzig", "Sauer"};
		Bratlinge pferdeFleisch = new Bratlinge (27, 1.85, 0, 270l, geschmackPferdefleisch, "Rindfleisch (original)");
		Bratlinge haenchenFleisch = new Bratlinge (11, 1.15, 0, 180l, geschmackHaenchenfleisch, "Haenchenfleisch gegrillt");
		Bratlinge falafel = new Bratlinge (21, 1.45, 2, 210l, geschmackFalafel,"Falafel-Bratling");
		Bratlinge gemuese = new Bratlinge (25, 1.75, 1, 240l, geschmackGemueseBratling, "Gemuese-Bratling");
		bratlingListe[0] = pferdeFleisch;
		bratlingListe[1] = haenchenFleisch;
		bratlingListe[2] = falafel;
		bratlingListe[3] = gemuese;	
	}// END vorgegebeneBratlinge

	/**
	 * Methode enthaelt die verschiedenen Gemuesesorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebenesGemuese() {

		//bitter, fett, sauer, scharf, suess, umami, normal
		String [] geschmackTomate = {"Sauer","Suess", "Normal"}; 
		String [] geschmackSalzGurke = {"Salzig"};  
		String [] geschmackZwiebelRinge = {"Sauer"};
		String [] geschmackJalapeno = {"Sauer", "Scharf"};
		Gemuese tomate = new Gemuese (3, 0.25, 2, 3l, geschmackTomate, "Tomate");
		Gemuese salzGurke = new Gemuese (2, 0.15, 2, 4l, geschmackSalzGurke, "Salzgurke");
		Gemuese zwiebelRinge = new Gemuese (2, 0.08, 2, 5l, geschmackZwiebelRinge, "Rote Zwiebelringe");
		Gemuese jalapeno = new Gemuese (2, 0.08, 2, 5l, geschmackJalapeno, "Jalapeno-Ringe");
		gemueseListe[0] = tomate;
		gemueseListe[1] = salzGurke;
		gemueseListe[2] = zwiebelRinge;
		gemueseListe[3] = jalapeno;	
	}// END vorgegebenesGemuse

	/**
	 * Methode zum zurueckgeben der Broetchensorten
	 * @return broetchenListe gibt die Namen der Broetchensorten zurueck
	 */
	public static Broetchen[] getBroetchenListe() {
		return broetchenListe;
	}// END getBroetchenListe

	/**
	 * Methode zum zurueckgeben der Bratlingssorten
	 * @return broetchenListe gibt die Namen der Bratlingssorten zurueck
	 */
	public static Bratlinge[] getBratlingListe() {
		return bratlingListe;
	}// END getBratlingListe

	/**
	 * Methode zum zurueckgeben der Gemuesesorten
	 * @return broetchenListe gibt die Namen der Gemuesesorten zurueck
	 */
	public static Gemuese[] getGemueseListe() {
		return gemueseListe;
	}// END getGemueseListe

	/**
	 * Methode zum zurueckgeben der Salatsorten
	 * @return broetchenListe gibt die Namen der Salatsorten zurueck
	 */
	public static Salate[] getSalatListe() {
		return salatListe;
	}// END getSalatListe

	/**
	 * Methode zum zurueckgeben der Saucensorten
	 * @return broetchenListe gibt die Namen der Saucensorten zurueck
	 */
	public static Saucen[] getSaucenListe() {
		return saucenListe;
	}// END getSaucenListe

	/**
	 * Methode setzt den ersten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger1 (int bestellung [][]) {
		burger1 = bestellung;		
	}// END setBurger1
	
	/**
	 * Methode zum zurueckgeben des ersten Burgers
	 * @return burger1 gibt den gespeicherten ersten Burger zurueck
	 */
	public int[][] getBurger1 () {
		return burger1;
	}// END getBurger1

	/**
	 * Methode setzt den zeiten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger2 (int bestellung [][]) {
		burger2 = bestellung;		
	}// END setBurger2
	
	/**
	 * Methode zum zurueckgeben des zweiten Burgers
	 * @return burger1 gibt den gespeicherten zweiten Burger zurueck
	 */
	public int[][] getBurger2 () {
		return burger2;
	}// END setBurger2

	/**
	 * Methode setzt den dritten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger3 (int bestellung [][]) {
		burger3 = bestellung;		
	}// END setBurger3
	
	/**
	 * Methode zum zurueckgeben des dritten Burgers
	 * @return burger1 gibt den gespeicherten dritten Burger zurueck
	 */
	public int[][] getBurger3 () {
		return burger3;
	}// END getBurger3

	/**
	 * Methode setzt den vierten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger4 (int bestellung [][]) {
		burger4 = bestellung;		
	}// END setBurger4
	
	/**
	 * Methode zum zurueckgeben des vierten Burgers
	 * @return burger1 gibt den gespeicherten vierten Burger zurueck
	 */
	public int[][] getBurger4 () {
		return burger4;
	}// END getBurger4

	/**
	 * Methode setzt den fuenften Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger5 (int bestellung [][]) {
		burger5 = bestellung;		
	}// END setBurger5
	
	/**
	 * Methode zum zurueckgeben des fuenften Burgers
	 * @return burger1 gibt den gespeicherten fuenften Burger zurueck
	 */
	public int[][] getBurger5 () {
		return burger5;
	}// END getBurger5

	/**
	 * Methode setzt den sechsten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger6 (int bestellung [][]) {
		burger6 = bestellung;		
	}// END setBurger6
	
	/**
	 * Methode zum zurueckgeben des sechsten Burgers
	 * @return burger1 gibt den gespeicherten sechsten Burger zurueck
	 */
	public int[][] getBurger6 () {
		return burger6;
	}// END getBurger6

	/**
	 * Methode setzt den siebten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger7 (int bestellung [][]) {
		burger7 = bestellung;		
	}// END setBurger7
	
	/**
	 * Methode zum zurueckgeben des siebten Burgers
	 * @return burger1 gibt den gespeicherten siebten Burger zurueck
	 */
	public int[][] getBurger7 () {
		return burger7;
	}// END getBurger7
	
	/**
	 * Methode setzt den achten Burger fest
	 * @param bestellung setzt die Parameter fuer die einzelen Bestellzutaten fest
	 */
	public void setBurger8 (int bestellung [][]) {
		burger8 = bestellung;		
	}// END setBurger8
	
	/**
	 * Methode zum zurueckgeben des achten Burgers
	 * @return burger1 gibt den gespeicherten achten Burger zurueck
	 */
	public int[][] getBurger8 () {
		return burger8;
	}// END getBurger8
	
}// END Zutat


