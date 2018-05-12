import de.hsrm.mi.prog.util.StaticScanner;

public class Start {

	public static void main(String[] args) {
		
		/*Karte speiseKarte = new Karte();
		speiseKarte.ausgabe();		 
		 
		SesamBroetchen essen = new SesamBroetchen();
		essen.ausgabe();
		*/
		Zutat zutat = new Zutat();
		zutat.vorgegebeneBroetchen();
		zutat.vorgegebeneBratlinge();
		zutat.vorgegebenesGemuese();
		zutat.vorgegebeneSalate();
		zutat.vorgegebeneSaucen();		
		Karte willkommen = new Karte();
		willkommen.ausgabe();

	}

}
