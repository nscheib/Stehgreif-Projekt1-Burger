
public class Burger {
	
	private Broetchen broetchen;
	private Bratlinge bratling;
	private Gemuese gemuese;
	private Salate salat;
	private Saucen sauce;
	private int preis = 0;
	
	public void setBroetchen (Broetchen broetchen){
		this.broetchen = broetchen;
	}
	public void setBratlinge (Bratlinge bratling){
		this.bratling = bratling;
	}
	public void setGemuese (Gemuese gemuese){
		this.gemuese = gemuese;
	}
	public void setSalate (Salate salate){
		this.salat = salat;
	}	
	public void setSaucen (Saucen sauce){
		this.sauce = sauce;
	}
	/*	 max. 8 Zutaten 
	max. 10 bestellbar
	Vegan/ vegetarisch 
	Preis
	vorgefertigte burger
*/
}
