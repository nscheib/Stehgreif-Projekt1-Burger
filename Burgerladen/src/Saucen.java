import de.hsrm.mi.prog.util.StaticScanner;

public class Saucen extends ZutatenErsteller{

	public Saucen (double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}
	
}
