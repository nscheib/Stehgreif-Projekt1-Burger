// IMPORT --------------------------------------------//
import de.hsrm.mi.prog.util.StaticScanner;
// IMPORT --------------------------------------------//

/**
 *  ZutatenErsteller, mithilfe dieser Methode ist es möglich neue Zutaten zu erstellen, mit Preis, Geschmack uvm.
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class ZutatenErsteller {

	protected double preis = 0; 
	protected int vegetarisch = 0;
	protected long zubereitungsDauer = 0;
	protected String name;
	protected int breite = 0;
	protected int anzahlGeschmaecker = 0;
	protected String [] geschmack = new String [anzahlGeschmaecker];

	/**
	 * Methode zum abragen und speichern des Preises
	 */
	public void neueZutatPreis(){

		boolean korrekt = false;
		do {
			System.out.println("Wieviel kostet die neue Zutat?");
			double eingabe = StaticScanner.nextDouble();
			System.out.println("Die Zutat kostet " + eingabe); 
			korrekt = bestaetigung();
			preis = eingabe;
		}while(korrekt);
	}// END neueZutatPreis

	/**
	 * Methode zum speichern, ob die Zutat eine vegetarische, vegane oder fleischhaltige Zutat ist
	 */
	public void neueZutatVegetarisch() {

		System.out.println("Ist die neue Zutat <vegan>, <vegetarisch> oder enthält sie <Fleisch>?");
		boolean korrekt = true;
		do {
			String eingabe = StaticScanner.nextString();
			if (eingabe.equals("vegan")) {
				System.out.println("Die Zutat ist vegan");
				korrekt = bestaetigung();
				vegetarisch = 1;
			}else if (eingabe.equals("vegetarisch")) {
				System.out.println("Die Zutat ist vegetarisch");
				korrekt = bestaetigung();
				vegetarisch = 2;
			}else if (eingabe.equals("fleisch")) {
				System.out.println("Die Zutat ist mit Fleisch");
				korrekt = bestaetigung();
				vegetarisch = 3;
			}
		}while(korrekt);
	}// END neueZutatVegetarisch

	/**
	 * Methode zum eingeben und speichern der Dauer, wie die lange die Zubereitungsdauer ist
	 */
	public void neueZutatZeit() {

		boolean korrekt = false;
		do {
			System.out.println("Wie lange brauchen Sie fuer die Zutat (in sec)?");
			long eingabe = StaticScanner.nextLong();
			System.out.println("Die Zutat braucht " + eingabe + "zu fertigstellung."); 
			korrekt = bestaetigung();
			zubereitungsDauer = (eingabe / 100) * 80;									//Profibonus
		}while(korrekt);
	}// END neueZutatZeit

	/**
	 * Methode um die Geschmacksrichtung festzulegen, ueberpruefen und diese zu speichern zu koennen
	 */
	public void neueZutatGeschmack() {

		boolean korrekt = false;
		do {
			System.out.println("Welche Geschmackssinne Stimuliert ihre Zutat?");
			System.out.println("<bitter>, <fett>, <sauer>, <salzig>, <scharf>, <suess>, <umami>, <normal>");
			String eingabe = StaticScanner.nextString();
			int anzahlGeschmaecker = 0;
			switch (eingabe) {
			case "bitter":	
				geschmack [anzahlGeschmaecker] = "Bitter";
				anzahlGeschmaecker++;
			case "fett":
				geschmack [anzahlGeschmaecker] = "Fett";
				anzahlGeschmaecker++;
			case "sauer":
				geschmack [anzahlGeschmaecker] = "Sauer";
				anzahlGeschmaecker++;
			case "salzig":
				geschmack [anzahlGeschmaecker] = "Salzig";
				anzahlGeschmaecker++;
			case "scharf":
				geschmack [anzahlGeschmaecker] = "Scharf";
				anzahlGeschmaecker++;
			case "suess":
				geschmack [anzahlGeschmaecker] = "suess";
				anzahlGeschmaecker++;
			case "umami":
				geschmack [anzahlGeschmaecker] = "umami";
				anzahlGeschmaecker++;
			case "normal":
				geschmack [anzahlGeschmaecker] = "normal";
				anzahlGeschmaecker++;
			}
			System.out.print("Der Geschmack ihrer Zutat ist: ");
			for (int j = 0; j < geschmack.length; j++) {				
				if (geschmack [j] != null) {
					System.out.print(geschmack[j]);
				}				
			}			
			korrekt = bestaetigung();		
		}while(korrekt);	
	}// END neueZutatGeschmack

	/**
	 * Methode zum festlegen und speichern des Zutatnamens
	 */
	public void neueZutatName() {

		boolean korrekt = false;
		do {
			System.out.println("Letzte Frage: Wie heisst ihre Zutat?");
			String eingabe = StaticScanner.nextString();
			System.out.println("Ihre Zutat heisst: " + eingabe); 
			korrekt = bestaetigung();
			name = eingabe;
		}while(korrekt);
	}// END neueZutatName

	/**
	 * Methode zum abrufen des Geschmacks
	 * @return geschmack gibt den Geschmack zurueck
	 */
	public String[] getGeschmack() {
		return geschmack;
	}// END getGeschmack

	/**
	 * Methode zum abrufen des Burgertyps
	 * @return gibt den Burgertyp zurueck
	 */
	public int getVegetarisch() {
		return vegetarisch;		
	}// END getVegetarisch

	/**
	 * Methode um die Eingaben zu bestaetigen
	 * @return antwort gibt ein true oder false zurueck, je nach dem, ob die Eingabe bestaetigt wurde oder nicht
	 */
	protected boolean bestaetigung() {

		boolean antwort;
		System.out.println("Sind sie damit einverstanden <ja> oder <nein> ?");
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
	} // END bestaetigung
	
}// END 



	/*
	 * EXTRA
	 * Zuteilung ob Broetchen oder Gemuese usw.
	 * Zutatenname
	 * vegan/vegetarisch
	 * Menge
	 * zubereitungs dauer und masse verlust (groesser kleiner)
	 * breite
	 * preis
	 */
