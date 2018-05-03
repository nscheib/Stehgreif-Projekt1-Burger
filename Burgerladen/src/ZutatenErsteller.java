import de.hsrm.mi.prog.util.StaticScanner;

public class ZutatenErsteller {

	protected double preis = 0; 
	protected int vegetarisch = 0;
	protected long zubereitungsDauer = 0;
	protected String name;
	protected int breite = 0;
	protected String [] geschmack = new String [8];
	
	public void neueZutatPreis(){
		boolean korrekt = false;
		do {
			System.out.println("Wieviel kostet die neue Zutat dem Kunden?");
			double eingabe = StaticScanner.nextDouble();
			System.out.println("Die Zutat kostet " + eingabe); 
			korrekt = bestaetigung();
			preis = eingabe;
		}while(korrekt);
	}
	
	public void neueZutatVegetarisch() {
		System.out.println("Ist die neue Zutat <vegan>, <vegetarisch> oder enthaelt sie <fleisch>?");
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
	}
	
	public void neueZutatZeit() {		
		boolean korrekt = false;
		do {
			System.out.println("Wie lange brauchen Sie fuer die Zutat (in sec)?");
			long eingabe = StaticScanner.nextLong();
			System.out.println("Die Zutat braucht " + eingabe + "zu fertigstellung."); 
			korrekt = bestaetigung();
			zubereitungsDauer = (eingabe / 100) * 80;									//Profibonus
		}while(korrekt);
		
	}
	
	public void neueZutatGeschmack() {		
		boolean korrekt = false;
		do {
			System.out.println("Welche Geschmackssinne Stimuliert ihre Zutat?");
			System.out.println("<bitter>, <fett>, <sauer>, <salzig>, <scharf>, <suess>, <umami>, <normal>");
			String eingabe = StaticScanner.nextString();			
			switch(eingabe) {
			case "bitter":	
				geschmack [0] = "Bitter";
			case "fett":
				geschmack [1] = "Fett";
			case "sauer":
				geschmack [2] = "Sauer";
			case "salzig":
				geschmack [3] = "Salzig";
			case "scharf":
				geschmack [4] = "Scharf";
			case "suess":
				geschmack [5] = "suess";
			case "umami":
				geschmack [6] = "umami";
			case "normal":
				geschmack [7] = "normal";
			}
			System.out.print("Der Geschmack ihrer Zutat ist: ");
			for (int i = 0; i < geschmack.length; i++) {				
				if (geschmack [i] != null) {
					System.out.print(geschmack[i]);
				}				
			}			
			korrekt = bestaetigung();		
		}while(korrekt);	
	}
	
	public void neueZutatName() {
		boolean korrekt = false;
		do {
			System.out.println("Letzte Frage: Wie heisst ihre Zutat?");
			String eingabe = StaticScanner.nextString();
			System.out.println("Ihre Zutat heisst: " + eingabe); 
			korrekt = bestaetigung();
			name = eingabe;
		}while(korrekt);
		
	
	}
	
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
	} 
	
	/*
	 * EXTRA
	 * Zuteilung ob Broetchen oder Gemuese usw.
	 * Zutatenname
	 * vegan/vegetarisch
	 * Menge
	 * zubereitungs dauer und masse verlust (groesser kleiner)
	 * 
	 * breite
	 * preis
	 */
}
