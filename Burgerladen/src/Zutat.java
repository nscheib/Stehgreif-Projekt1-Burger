import de.hsrm.mi.prog.util.StaticScanner;


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
	private static Broetchen [] broetchenListe = new Broetchen [anzahlBroetchenSorten];
	private static Salate [] salatListe = new Salate [anzahlSalatSorten];
	private static Saucen [] saucenListe = new Saucen [anzahlSaucenSorten];
	private static Bratlinge [] bratlingListe = new Bratlinge [anzahlBratlingSorten];
	private static Gemuese [] gemueseListe = new Gemuese [anzahlGemueseSorten];


	/**
	 * Methode enthaelt die verschiedenen Broetchensorten mit den speziefischen Eigenschaften, wie Geschmack. Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneBroetchen() {
		//bitter, fett, salzig, sauer, scharf, suess, umami, normal
		String [] geschmackHamburger = {null, "Fett", null, null, null, null, "Suess", null, "normal"};
		String [] geschmackSesam = {null, "Fett", null, null, null, null, "Suess", null, null};
		String [] geschmackVegan = {null, null, "Salzig", null, null, null, null, null, null};
		String [] geschmackCiabatta = {null, "Fett", null, null, null, null, null, null, null}; 
		//breite, preis, vegetarisch, geschmack, zubereitungsDauer, name
		Broetchen hamburgerBroetchen = new Broetchen (27, 0.85, 2, 90l, geschmackHamburger, "Hamburger Broetchen");
		Broetchen sesamBroetchen = new Broetchen (28, 0.95, 2, 90l, geschmackSesam, "Sesam Broetchen......");
		Broetchen veganesBroetchen = new Broetchen (34, 0.55, 2, 240l, geschmackVegan, "Veganer Broetchen");
		Broetchen ciabatta = new Broetchen (41, 0.45, 2, 330l, geschmackCiabatta, "Ciabatta Broetchen");
		broetchenListe[0] = hamburgerBroetchen;
		broetchenListe[1] = sesamBroetchen;
		broetchenListe[2] = veganesBroetchen;
		broetchenListe[3] = ciabatta;
	}

	/**
	 * Methode enthaelt die verschiedenen Salatsorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneSalate() {
		String [] geschmackEisberg = {null, null, null, null, null, null, null, null, "normal"};
		String [] geschmackRucola = {null, null, null, null, null, null, null, null, "normal"};
		Salate eisbergSalat = new Salate (5, 0.18, 2, 5l, geschmackEisberg, "Eisbergsalat");
		Salate rucolaSalat = new Salate (3, 0.25, 2, 3l, geschmackRucola, "Rucolasalat");
		salatListe[0] = eisbergSalat;
		salatListe[1] = rucolaSalat;	
	}

	/**
	 * Methode enthaelt die verschiedenen Saucensorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneSaucen() {
		String [] geschmackKetchup = {null, null, null, null, null, "suess", null, "normal"}; 
		String [] geschmackSandwichSauce = {null, "fett", null, null, null, "suess", null, null};
		String [] geschmackChiliSauce = {null, null, null, null, "scharf", null, null, null};
		String [] geschmackHonigSenfSauce = {null, null, null, null, "scharf", "suess", null, null};
		Saucen ketchup = new Saucen (0.1, 2, 1l, geschmackKetchup, "Ketchup");
		Saucen sandwichSauce = new Saucen (0.15, 1, 1l, geschmackSandwichSauce,"Sandwich-Sauce");
		Saucen chiliSauce = new Saucen (0.25, 2, 1l, geschmackChiliSauce, "Chili-Sauce");
		Saucen honigSenfSauce = new Saucen (0.18, 1, 1l, geschmackHonigSenfSauce, "Honig-Senf-Sauce");
		saucenListe[0] = ketchup;
		saucenListe[1] = sandwichSauce;
		saucenListe[2] = chiliSauce;
		saucenListe[3] = honigSenfSauce;
	}

	/**
	 * Methode enthaelt die verschiedenen Bratlingssorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebeneBratlinge() {
		String [] geschmackPferdefleisch = {null, "fett", null, null, null, null, "umami", "normal"}; // Einkaufspreis 0.20
		String [] geschmackHaenchenfleisch = {null, null, null, null, null, null, "umami", null};
		String [] geschmackFalafel = {null, null, null, null, "scharf", "suess", null, null};
		String [] geschmackGemueseBratling = {"bitter", null, "salzig", "sauer", null, null, null, null};
		Bratlinge pferdeFleisch = new Bratlinge (27, 1.85, 0, 270l, geschmackPferdefleisch, "Rindfleisch (original)");
		Bratlinge haenchenFleisch = new Bratlinge (11, 1.15, 0, 180l, geschmackHaenchenfleisch, "Haenchenfleisch gegrillt");
		Bratlinge falafel = new Bratlinge (21, 1.45, 2, 210l, geschmackFalafel,"Falafel-Bratling");
		Bratlinge gemuese = new Bratlinge (25, 1.75, 1, 240l, geschmackGemueseBratling, "Gemuese-Bratling");
		bratlingListe[0] = pferdeFleisch;
		bratlingListe[1] = haenchenFleisch;
		bratlingListe[2] = falafel;
		bratlingListe[3] = gemuese;	
	}

	/**
	 * Methode enthaelt die verschiedenen Gemuesesorten mit den speziefischen Eigenschaften, wie Geschmack, Zubereitungsdauer, Preis uvm.
	 */
	public void vorgegebenesGemuese() {
								//bitter, fett, sauer, scharf, suess, umami, normal
		String [] geschmackTomate = {null, null, null, "sauer", null, "suess", null, "normal"}; 
		String [] geschmackSalzGurke = {null, null, "salzig", null, null, null, null, "normal"};  
		String [] geschmackZwiebelRinge = {null, null, null, "sauer", null, null, null, "normal"};
		String [] geschmackJalapeno = {null, null, null, "sauer", "scharf", null, null, null};
		Gemuese tomate = new Gemuese (3, 0.25, 2, 3l, geschmackTomate, "Tomate");
		Gemuese salzGurke = new Gemuese (2, 0.15, 2, 4l, geschmackSalzGurke, "Salzgurke");
		Gemuese zwiebelRinge = new Gemuese (2, 0.08, 2, 5l, geschmackZwiebelRinge, "Rote Zwiebelringe");
		Gemuese jalapeno = new Gemuese (2, 0.08, 2, 5l, geschmackJalapeno, "Jalapeno-Ringe");
		gemueseListe[0] = tomate;
		gemueseListe[1] = salzGurke;
		gemueseListe[2] = zwiebelRinge;
		gemueseListe[3] = jalapeno;	
	}

	/**
	 * Methode zum zurueckgeben der Broetchensorten
	 * @return broetchenListe gibt die Namen der Broetchensorten zurueck
	 */
	public static Broetchen[] getBroetchenListe() {
		return broetchenListe;
	}

	/**
	 * Methode zum zurueckgeben der Bratlingssorten
	 * @return broetchenListe gibt die Namen der Bratlingssorten zurueck
	 */
	public static Bratlinge[] getBratlingListe() {
		return bratlingListe;
	}

	/**
	 * Methode zum zurueckgeben der Gemuesesorten
	 * @return broetchenListe gibt die Namen der Gemuesesorten zurueck
	 */
	public static Gemuese[] getGemueseListe() {
		return gemueseListe;
	}

	/**
	 * Methode zum zurueckgeben der Salatsorten
	 * @return broetchenListe gibt die Namen der Salatsorten zurueck
	 */
	public static Salate[] getSalatListe() {
		return salatListe;
	}

	/**
	 * Methode zum zurueckgeben der Saucensorten
	 * @return broetchenListe gibt die Namen der Saucensorten zurueck
	 */
	public static Saucen[] getSaucenListe() {
		return saucenListe;
	}

}
