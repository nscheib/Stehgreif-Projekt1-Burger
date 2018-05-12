import de.hsrm.mi.prog.util.StaticScanner;

public class Bratlinge extends ZutatenErsteller{

	public Bratlinge (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}
	
	public void neueZutatBreite(){
		System.out.println("Wie dick sind die Bratlinge (in mm)?");		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 30) {
				System.out.println("Extra Portionen koennen bei der Bestellung aufgegeben werden, hier bitte noch nicht.");
			}else if (eingabe < 5) {
				System.out.println("So duenn ist doch kein Schwein");
			}else{
				System.out.println("Ein Bratling ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}

}
