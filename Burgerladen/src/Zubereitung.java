
public class Zubereitung {
	
	int [] bestellung;
	
	public Zubereitung (int [] bestellung) {
		this.bestellung = bestellung;
		
	}
	
	private void zubereiten () {
		//zeit preis breite
		Broetchen broetchenListe [] = Zutat.getBroetchenListe();
		//Bratlinge bratlingListe [] = Zutat.getBratlingListe();
		long start = System.currentTimeMillis();
		long fertig = start;
		long zeitBroetchen = broetchenListe[bestellung[0]].zubereitungsDauer;
		//long zeitBratlinge = bratlingListe[bestellung[1]].zubereitungsDauer;
		System.out.println("Bitte haben sie einen augenblick gedult");
		while ((fertig - start) > zeitBroetchen /*&& (fertig - start) > zeitBratlinge*/){
			fertig = System.currentTimeMillis();
			if ((fertig - start) > zeitBroetchen) {
				System.out.println("Ihr Broetchen ist fertig. Jetzt dauert es nicht mehr lange.");
			}else if ((fertig - start) > zeitBroetchen /*&& (fertig - start) > zeitBratlinge*/){
				System.out.println("Ihr Bratling ist fertig. Nur noch ein paar Minuten bitte");
			}
		}
		essensVerpackung();
	}
	
	public void essensVerpackung() {
		
		
		
	}
	
	
	
	/*
 * berechnen der Zubereitungs dauer 
 * Ausgabe des Gesamtpreises
 * breite information 
 * broetchen wird breiter durch das backen
 * Bratlinge verlieren an groesse
 * Name des Burgers individuell erstellbar
 * Geschmacksrichtung
 * vegan vegetarisch
 * Zutaten
 * EXTRA: Lieferung
 * EXTRA: Ein Burger gratis Besonderheit: extrem Scharf
 */
}
