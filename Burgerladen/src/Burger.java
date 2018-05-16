/**
 *  Burger, dient zum verwalten eines Burgers und den verschiedenen Zutaten
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Burger {
	
	private Broetchen broetchen;
	private Bratlinge bratling;
	private Gemuese gemuese;
	private Salate salat;
	private Saucen sauce;
	private int preis = 0;
	
	public void setBroetchen (Broetchen broetchen){
		this.broetchen = broetchen;
	}// END setBroetchen
	
	public void setBratlinge (Bratlinge bratling){
		this.bratling = bratling;
	}// END setBratling
	
	public void setGemuese (Gemuese gemuese){
		this.gemuese = gemuese;
	}// END setGemuese
	
	public void setSalate (Salate salate){
		this.salat = salat;
	}// END setSalate
	
	public void setSaucen (Saucen sauce){
		this.sauce = sauce;
	}// END setSaucen

	
}// END Burger

	/*	
	max. 8 Zutaten 
	max. 10 bestellbar
	Vegan/ vegetarisch 
	Preis
	vorgefertigte burger
	*/
