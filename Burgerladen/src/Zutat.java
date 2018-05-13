import de.hsrm.mi.prog.util.StaticScanner;

public class Zutat {
	
	private static int anzahlBroetchenSorten = 5;
	private static int anzahlSalatSorten = 3;
	private static int anzahlSaucenSorten = 5;
	private static int anzahlBratlingSorten = 5;
	private static int anzahlGemueseSorten = 5;
	private int burger1[][];
	private int burger2[][];
	private int burger3[][];
	private int burger4[][];
	private int burger5[][];
	private int burger6[][];
	private int burger7[][];
	private static Broetchen [] broetchenListe = new Broetchen [anzahlBroetchenSorten];
	private static Bratlinge [] bratlingListe = new Bratlinge [anzahlBratlingSorten];
	private static Gemuese [] gemueseListe = new Gemuese [anzahlGemueseSorten];
	private static Salate [] salatListe = new Salate [anzahlSalatSorten];
	private static Saucen [] saucenListe = new Saucen [anzahlSaucenSorten];

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
	}
	
	public void vorgegebeneSalate() {
		String [] geschmackEisberg = {"Normal"};
		String [] geschmackRucola = {"Sauer"};
		Salate eisbergSalat = new Salate (5, 0.18, 2, 5l, geschmackEisberg, "Eisbergsalat");
		Salate rucolaSalat = new Salate (3, 0.25, 2, 3l, geschmackRucola, "Rucolasalat");
		salatListe[0] = eisbergSalat;
		salatListe[1] = rucolaSalat;	
	}
	
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
	}
	
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
	}
	
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
	}
	
	public static Broetchen[] getBroetchenListe() {
		return broetchenListe;
	}
	
	public static Bratlinge[] getBratlingListe() {
		return bratlingListe;
	}
	
	public static Gemuese[] getGemueseListe() {
		return gemueseListe;
	}
	
	public static Salate[] getSalatListe() {
		return salatListe;
	}
	
	public static Saucen[] getSaucenListe() {
		return saucenListe;
	}

	public void setBurger1 (int bestellung [][]) {
		burger1 = bestellung;		
	}
	
	public void setBurger2 (int bestellung [][]) {
		burger2 = bestellung;		
	}
	
	public void setBurger3 (int bestellung [][]) {
		burger3 = bestellung;		
	}
	
	public void setBurger4 (int bestellung [][]) {
		burger4 = bestellung;		
	}
	
	public void setBurger5 (int bestellung [][]) {
		burger5 = bestellung;		
	}
	
	public void setBurger6 (int bestellung [][]) {
		burger6 = bestellung;		
	}
	
	public void setBurger7 (int bestellung [][]) {
		burger7 = bestellung;		
	}
	
}
