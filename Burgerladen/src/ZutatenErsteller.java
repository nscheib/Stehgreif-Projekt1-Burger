import de.hsrm.mi.prog.util.StaticScanner;

public class ZutatenErsteller {

	protected double preis = 0; 
	protected int vegetarisch = 0;
	protected long zubereitungsDauer = 0;
	protected String name;
	protected int breite = 0;
	protected int anzahlGeschmaecker = 0;
	protected String [] geschmack = new String [anzahlGeschmaecker];
	
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
	
	public String[] getGeschmack() {
		return geschmack;
	}
	
	public int getVegetarisch() {
		return vegetarisch;		
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
