import de.hsrm.mi.prog.util.StaticScanner;

public class Bestellung {
	private int zusammenstellung[][] = new int [5][2];
	private Zutat zutat = new Zutat();
	private Broetchen broetchenListe [] = zutat.getBroetchenListe();
	private Bratlinge bratlingListe [] = zutat.getBratlingListe();
	private Gemuese gemueseListe [] = zutat.getGemueseListe();
	private Salate salatListe [] = zutat.getSalatListe();
	private Saucen saucenListe [] = zutat.getSaucenListe();
	private int burgerNummer = 0;
	

	public int [][] bestellBeginn () {
		int komponente = 0;
		ZutatenErsteller zutatenListe [];

		do {
			if (komponente == 0) {
				zutatenListe = broetchenListe;
				komponente = burger(komponente, zutatenListe);
			}else if(komponente == 1) {
				zutatenListe = bratlingListe;
				komponente = burger(komponente, zutatenListe);			
			}else if(komponente == 2) {
				zutatenListe = gemueseListe;
				komponente = burger(komponente, zutatenListe);				
			}else if(komponente == 3) {
				zutatenListe = salatListe;
				komponente = burger(komponente, zutatenListe);			
			}else if(komponente == 4) {
				zutatenListe = saucenListe;
				komponente = burger(komponente, zutatenListe);						
			}else {
				System.out.println("ERROR Bestellung start");
			}
		}while (komponente != 5); 		
		burgerSpeichern();
		return zusammenstellung;
		//System.out.println("Ende?"); 														//Zubereiten
	}
	
	public void extraLage(int komponente) {
		System.out.println("Wollen sie eine Extra Lage haben?");		
		boolean eingabe;
		eingabe = bestaetigung();	
		if (eingabe == true) {
			zusammenstellung[komponente][1] = 1;
		}else{
			zusammenstellung[komponente][1] = 2;
		}	
	}
		
	public int burger(int komponente, ZutatenErsteller zutatenListe[]) {
		boolean korrekt = true;	
		int eingabe = 0;
		do {
			System.out.println("Bitte waehlen sie eine Zutat, mittels der dahinterstehenden Zahl:");		
			if (komponente > 0) {
				System.out.println("Die <0> steht fuer das ueberspringen der Zutat");
			}
			for (int i = 0; i < zutatenListe.length - 1; i++) {
				System.out.println(zutatenListe[i].name +"\t <"+ (i+1)+">");		
			}			
			do {
				System.out.println("Bitte geben sie eine passende Zahl ein.");
				eingabe = StaticScanner.nextInt();
			}while (eingabe > 8 );
			if (eingabe == 0 && komponente != 0) {											//ueberspringen einer Zutat
				System.out.println("Sie wollen diese Zutat ueberspringen?");
				korrekt = bestaetigung();
				zusammenstellung[komponente][1] = 0;
			}else if (eingabe + 1 > zutatenListe.length || eingabe <= 0){					//ausherhalb der Liste gewaehlt
				System.out.println("Bitte nehmen sie eine Zutat aus der Liste\n");
			}else if (eingabe + 1 < zutatenListe.length || eingabe > 0){					//bestaetigen einer erlaubten auswahl
				System.out.println("Wollen sie das " + zutatenListe[eingabe - 1].name + " haben?" );
				korrekt = bestaetigung();
				zusammenstellung[komponente][0] = eingabe - 1;
				if (komponente != 0) {
					extraLage(komponente);													//extra Wurst gefaellig?
				}
			}else {
				System.out.println("ERROR Bestellung: burger Zutaten abfrage");
			}
		}while(korrekt);	
		komponente++;
		return komponente;
	}

	public void burgerSpeichern() {
		Zutat burger = new Zutat();
		switch (burgerNummer) {
		case 0: 
			burger.setBurger1(zusammenstellung);
			burgerNummer++;
			break;
		case 1: 
			burger.setBurger2(zusammenstellung);
			burgerNummer++;
			break;
		case 2: 
			burger.setBurger3(zusammenstellung);
			burgerNummer++;
			break;
		case 3: 
			burger.setBurger4(zusammenstellung);
			burgerNummer++;
			break;
		case 4: 
			burger.setBurger5(zusammenstellung);
			burgerNummer++;
			break;
		case 5: 
			burger.setBurger6(zusammenstellung);
			burgerNummer++;
			break;
		case 6: 
			burger.setBurger7(zusammenstellung);
			burgerNummer++;
			break;
		}
	}
	
	private int abfrage () {
		int eingabe = 0;
		boolean korrekt = false;
		do {
			try {
				eingabe = StaticScanner.nextInt();
				
			}catch(NumberFormatException ex) {
				System.out.println("Sie muessen eine Zahl eingeben");
				continue;
			}
			korrekt = true;
		}while(korrekt);
		return eingabe;
	}
	
 	private boolean bestaetigung() {
		boolean antwort;
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
	
}
