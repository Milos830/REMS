package Data;

public class City {

	
	private int IDgrad;
	private String Naziv;
	
	public int getIDgrad() {
		return IDgrad;
	}
	public void setIDgrad(int iDgrad) {
		IDgrad = iDgrad;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public City(int iDgrad, String naziv) {
		
		IDgrad = iDgrad;
		Naziv = naziv;
	}
	
	@Override
	public String toString() {
		return Naziv;
	}
}
