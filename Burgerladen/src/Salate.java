import de.hsrm.mi.prog.util.StaticScanner;

public class Salate extends ZutatenErsteller{

	public Salate (int breite, double preis, int vegetarisch, long zubereitungsDauer, String [] geschmack, String name) {
		this.breite = breite;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
		this.zubereitungsDauer = zubereitungsDauer;
		this.geschmack = geschmack;
		this.name = name;
	}
	
	public void neueZutatBreite(){
		System.out.println("Wie viel von diesem Salat soll auf den Burger (in mm)?");		
		boolean korrekt = true;
		do {
			int eingabe = StaticScanner.nextInt();
			if (eingabe > 30) {
				System.out.println("Extra Portionen koennen bei der Bestellung aufgegeben werden, hier bitte noch nicht.");
			}else if (eingabe < 1) {
				System.out.println("Du halbierst das Blatt noch der laenge nach durch?!?");
			}else{
				System.out.println("Eine Schicht Salat ist " + eingabe + "dick.");
				korrekt = bestaetigung();
			}			
		}while (korrekt);
	}

}
