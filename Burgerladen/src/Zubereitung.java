
/**
 *  Salate, dient zum verwalten der verschiedenen Salatsorten und die dazugehoerigen Parameter
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Zubereitung {
	
	int [] bestellung;

	/**
	 *  Der Konstruktor fuer die Zubereitung setzt verschiedene Parameter fest
	 * @param bestellung setzt fest was alles in der Bestelltung enthalten ist
	 */
	public Zubereitung (int [] bestellung) {
		this.bestellung = bestellung;
	}

	/**
	 * Methode berechnet mithilfe der Zubereitungsdauer der Zutaten eine gesamte Zubereitungsdauer in Millisecounds
	 */
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

	/**
	 * Methode zum "verpacken" des Burgers und die damit verbundene Zeit                // ggf. Anzeige der gesamten Zutatenliste?//
	 */
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
