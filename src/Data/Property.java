package Data;

public class Property {

	
	private int IDnekretnina;
	private String SifraNekretnine;
	private TypeOfProperty tipNekretnine;
	private TypeOfConstruction tipGradnje;
	private City grad;
	private String Adresa;
	private Location lokacija;
	private int Povrsina;
	private int Broj_soba;
	
	private int Broj_kupatila;
	private Furniture namestenost;
	private Heating grejanje;
	private String Status;
	
	private int IDevidencija_iznajmljivanja;
	
	
	public Property(int iDnekretnina, String sifraNekretnine, TypeOfProperty tipNekretnine, TypeOfConstruction tipGradnje,
			City grad, String adresa, Location lokacija, int povrsina, int broj_soba, int broj_kupatila,
			Furniture namestenost, Heating grejanje, String status) {
		
		IDnekretnina = iDnekretnina;
		SifraNekretnine = sifraNekretnine;
		this.tipNekretnine = tipNekretnine;
		this.tipGradnje = tipGradnje;
		this.grad = grad;
		Adresa = adresa;
		this.lokacija = lokacija;
		Povrsina = povrsina;
		Broj_soba = broj_soba;
		Broj_kupatila = broj_kupatila;
		this.namestenost = namestenost;
		this.grejanje = grejanje;
		Status = status;
	}
	
	public Property(int iDnekretnina, City grad, TypeOfProperty tipNekretnine, TypeOfConstruction tipGradnje,  Location lokacija, int povrsina,
			int broj_soba, int broj_kupatila, Furniture namestenost, Heating grejanje, String status) {
		
		this.IDnekretnina=iDnekretnina;
		this.tipNekretnine = tipNekretnine;
		this.tipGradnje = tipGradnje;
		this.grad = grad;
		this.lokacija = lokacija;
		this.Povrsina = povrsina;
		this.Broj_soba = broj_soba;
		this.Broj_kupatila = broj_kupatila;
		this.namestenost = namestenost;
		this.grejanje = grejanje;
		this.Status = status;
	}


	public int getIDevidencija_iznajmljivanja() {
		return IDevidencija_iznajmljivanja;
	}

	public void setIDevidencija_iznajmljivanja(int iDevidencija_iznajmljivanja) {
		IDevidencija_iznajmljivanja = iDevidencija_iznajmljivanja;
	}

	public int getIDnekretnina() {
		return IDnekretnina;
	}

	public void setIDnekretnina(int iDnekretnina) {
		IDnekretnina = iDnekretnina;
	}

	public String getSifraNekretnine() {
		return SifraNekretnine;
	}

	public void setSifraNekretnine(String sifraNekretnine) {
		SifraNekretnine = sifraNekretnine;
	}

	public TypeOfProperty getTipNekretnine() {
		return tipNekretnine;
	}

	public void setTipNekretnine(TypeOfProperty tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}

	public TypeOfConstruction getTipGradnje() {
		return tipGradnje;
	}

	public void setTipGradnje(TypeOfConstruction tipGradnje) {
		this.tipGradnje = tipGradnje;
	}

	public City getGrad() {
		return grad;
	}

	public void setGrad(City grad) {
		this.grad = grad;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public Location getLokacija() {
		return lokacija;
	}

	public void setLokacija(Location lokacija) {
		this.lokacija = lokacija;
	}

	public int getPovrsina() {
		return Povrsina;
	}

	public void setPovrsina(int povrsina) {
		Povrsina = povrsina;
	}

	public int getBroj_soba() {
		return Broj_soba;
	}

	public void setBroj_soba(int broj_soba) {
		Broj_soba = broj_soba;
	}

	public int getBroj_kupatila() {
		return Broj_kupatila;
	}

	public void setBroj_kupatila(int broj_kupatila) {
		Broj_kupatila = broj_kupatila;
	}

	public Furniture getNamestenost() {
		return namestenost;
	}

	public void setNamestenost(Furniture namestenost) {
		this.namestenost = namestenost;
	}

	public Heating getGrejanje() {
		return grejanje;
	}

	public void setGrejanje(Heating grejanje) {
		this.grejanje = grejanje;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return SifraNekretnine + Adresa;

	}
}
