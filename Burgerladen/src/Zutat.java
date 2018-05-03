import de.hsrm.mi.prog.util.StaticScanner;

public class Zutat {
	
	private static int anzahlBroetchenSorten = 5;
	private int anzahlSalatSorten = 3;
	private int anzahlSaucenSorten = 5;
	private int anzahlBratlingSorten = 5;
	private int anzahlGemueseSorten = 5;
	private static Broetchen [] broetchenListe = new Broetchen [anzahlBroetchenSorten];
	private Salate [] salatListe = new Salate [anzahlSalatSorten];
	private Saucen [] saucenListe = new Saucen [anzahlSaucenSorten];
	private Bratlinge [] bratlingListe = new Bratlinge [anzahlBratlingSorten];
	private Gemuese [] gemueseListe = new Gemuese [anzahlGemueseSorten];
	
	
	public void vorgegebeneBroetchen() {			
		//bitter, fett, sauer, scharf, suess, umami, normal
		String [] geschmackHamburger = {null, "Fett", null, null, null, "Suess", null, "normal"};
		String [] geschmackSesam = {null, "Fett", null, null, null, "Suess", null, "normal"};
		String [] geschmackVegan = {null, null, null, null, null, null, null, "normal"};
		String [] geschmackCiabatta = {null, null, null, null, null, null, null, "normal"}; 
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
	
	public void vorgegebeneSalate() {
		String [] geschmackEisberg = {null, null, null, null, null, null, null, "normal"};
		String [] geschmackRucola = {null, null, null, null, null, null, null, "normal"};
		Salate eisbergSalat = new Salate (5, 0.18, 2, 5l, geschmackEisberg, "Eisbergsalat");
		Salate rucolaSalat = new Salate (3, 0.25, 2, 3l, geschmackRucola, "Rucolasalat");
		salatListe[0] = eisbergSalat;
		salatListe[1] = rucolaSalat;
	
	}
	
	public void vorgegebeneSaucen() {
		//bitter, fett, sauer, scharf, suess, umami, normal
		String [] geschmackKetchup = {null, null, null, null, "suess", null, "normal"}; 
		String [] geschmackSandwichSauce = {null, "fett", null, null, "suess", null, null};
		String [] geschmackChiliSauce = {null, null, null, "scharf", null, null, null};
	
	}
	
	public void vorgegebeneBratlinge() {
		
	}
	
	public void vorgegebenesGemuese() {
		
	}
	public static Broetchen[] getBroetchenListe () {
		return broetchenListe;
	}
	
}
