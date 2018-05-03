import de.hsrm.mi.prog.util.StaticScanner;

public class Bestellung {
	
	
	public void hamburger(Zutat zutat) {
		int zusammenstellung[] = new int [8];
		boolean korrekt = true;
		do {
			System.out.println("Bitte waehlen sie ein Broetchen, mittels der dahinterstehenden Zahl:");
			Broetchen broetchenListe [] = zutat.getBroetchenListe();
			for (int i = 0; i < broetchenListe.length - 1; i++) {
				System.out.println(broetchenListe[i].name +"\t <"+ (i+1)+">");		
			}					
			int eingabe = StaticScanner.nextInt();
			if (eingabe + 1 > broetchenListe.length || eingabe <= 0){
				System.out.println("Bitte nehmen sie ein Broetchen aus der Liste\n");
			}else{
				System.out.println("Wollen sie das " + broetchenListe[eingabe - 1].name + " haben?" );
				korrekt = bestaetigung();
				zusammenstellung[0] = eingabe;
			}
		}while(korrekt);
		
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
