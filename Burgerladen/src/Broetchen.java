import de.hsrm.mi.prog.util.StaticScanner;

public class Broetchen extends ZutatenErsteller{
	
	public Broetchen (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
		
	}

	public void neueZutatBreite(){
		System.out.println("Wie breit ist das Broetchen (in mm)?");
		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 100) {
				System.out.println("So dick ist kein Broetchen");
			}else if (eingabe < 5) {
				System.out.println("So duenn kann doch kein broetchen sein");
			}else{
				System.out.println("Das Broetchen ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}
	
}
