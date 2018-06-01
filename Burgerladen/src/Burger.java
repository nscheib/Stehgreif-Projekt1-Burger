import java.util.ArrayList;

/**
 *  Burger, um die einzelnen Bestandteile eines Burgers zu erhalten
 *  @author Felix, Luca, Nick
 *  @version 0.9
 */
public class Burger extends ZutatenErsteller{
	
	
	private String endGeschmack;
	private ArrayList<ZutatenErsteller> zutatenListe = new ArrayList<ZutatenErsteller>(); 
	
	/**
	 * Methode
	 * @param breite
	 */
	public void setBreite(int breite) {
		this.breite = breite;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getName() {
		return name;	
	}
	
	public ArrayList<ZutatenErsteller> getZutatenListe() {
		return zutatenListe;
	}
	
	public void setGeschmack(String geschmack) {
		this.endGeschmack = geschmack;
	}
	
	public String getEndGeschmack() {
		return endGeschmack;
	}
	
	public void fuegeZutatHinzu (ZutatenErsteller zutat) {		
		this.preis += zutat.preis;
		this.zubereitungsDauer += zutat.zubereitungsDauer;
		this.vegetarisch = bestimmeVegetarisch(zutat.vegetarisch);
		zutatenListe.add(zutat);
	}
	
	public void entnehmeZutaten(ZutatenErsteller zutat) {
		this.preis -= zutat.preis;	
		this.breite -= zutat.breite;
		this.zubereitungsDauer -= zutat.zubereitungsDauer;
		this.vegetarisch = bestimmeVegetarisch(zutat.vegetarisch);   //funktioniert so nicht
		zutatenListe.remove(zutat);
	}
	
	private int bestimmeVegetarisch(int vegetarisch) {
		if(vegetarisch < this.vegetarisch) {
			return vegetarisch;
		}else {
			return this.vegetarisch;
		}		
	}
	
	public void zubereitenDesBurgers() {
		for (int j = 0; j < zutatenListe.size(); j++) {				
			if (zutatenListe.get(j) instanceof Bratlinge) {
				Bratlinge bratling = (Bratlinge) zutatenListe.get(j);
				bratling.eingehen();			
			}else if (zutatenListe.get(j) instanceof Broetchen) {
				Broetchen brot = (Broetchen) zutatenListe.get(j);
				brot.aufgehen();
			}
		}	
	}
	
}
