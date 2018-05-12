import de.hsrm.mi.prog.util.StaticScanner;

public class Gemuese extends ZutatenErsteller{


	public Gemuese (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}
	
	public void neueZutatBreite(){
		System.out.println("Wie breit ist das Gemuese (in mm, je Scheibe/Ring)?");		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 10) {
				System.out.println("So dick sollte keine Scheibe sein.");
			}else if (eingabe < 1) {
				System.out.println("Das waere ein wenig zu sparsam.");
			}else{
				System.out.println("Eine Scheibe ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}
	
	
	/*	Tomate Gurke Jalapenos Zwiebel
	 * 	Anzahl der scheiben/ringe
	 * Preis
	 * breite
	 * zubereitungs dauer
	 * 
	 */
}
