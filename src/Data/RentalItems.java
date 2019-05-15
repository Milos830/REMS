package Data;

public class RentalItems {

	private int IDstavkeIznajmljivanja;
	private Renting iznajmljivanje;
	private Property nekretnina;
	private long Datum_pocetak;
	private long Datum_kraj;
	private double Cena;
	private Double DatumRazlika;
	/////////////////////////////////////
	private Employed zaposleni;
	private String UkupanBrojDanaIznajmljivanja;
	private String Zarada;
	private String Provizija;

	public Employed getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Employed zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getUkupanBrojDanaIznajmljivanja() {
		return UkupanBrojDanaIznajmljivanja;
	}

	public void setUkupanBrojDanaIznajmljivanja(String ukupanBrojDanaIznajmljivanja) {
		UkupanBrojDanaIznajmljivanja = ukupanBrojDanaIznajmljivanja;
	}

	public String getZarada() {
		return Zarada;
	}

	public void setZarada(String zarada) {
		Zarada = zarada;
	}

	public String getProvizija() {
		return Provizija;
	}

	public void setProvizija(String provizija) {
		Provizija = provizija;
	}

	public Double getDatumRazlika() {
		return DatumRazlika;
	}
	
	public RentalItems(Employed zaposleni, Property nekretnina, long datum_pocetak, long datum_kraj, 
			 String ukupanBrojDanaIznajmljivanja, double cena, String zarada, String provizija) {
			this.zaposleni = zaposleni;
			this.nekretnina = nekretnina;
			this.Datum_pocetak = datum_pocetak;
			this.Datum_kraj = datum_kraj;
			this.Cena = cena;
			this.UkupanBrojDanaIznajmljivanja = ukupanBrojDanaIznajmljivanja;
			this.Zarada = zarada;
			this.Provizija = provizija;
	}

	public RentalItems(Property nekretnina, long datum_pocetak, long datum_kraj, double cena,
		Employed zaposleni, String zarada, String provizija) {
	
			this.nekretnina = nekretnina;
			Datum_pocetak = datum_pocetak;
			Datum_kraj = datum_kraj;
			Cena = cena;
			this.zaposleni = zaposleni;
			Zarada = zarada;
			Provizija = provizija;
}

///////////////////////////////////////////////////////////////////////////////////////////////////
	public RentalItems(int iDstavkeIznajmljivanja, Renting iznajmljivanje, Property nekretnina,
			long datum_pocetak, long datum_kraj, double cena) {
		
			IDstavkeIznajmljivanja = iDstavkeIznajmljivanja;
			this.iznajmljivanje = iznajmljivanje;
			this.nekretnina = nekretnina;
			Datum_pocetak = datum_pocetak;
			Datum_kraj = datum_kraj;
			Cena = cena;
	}
	public RentalItems(long datum_pocetak) {
		this.Datum_pocetak = datum_pocetak;
	}
	public int getIDstavkeIznajmljivanja() {
		return IDstavkeIznajmljivanja;
	}

	public void setIDstavkeIznajmljivanja(int iDstavkeIznajmljivanja) {
		IDstavkeIznajmljivanja = iDstavkeIznajmljivanja;
	}

	public Renting getIznajmljivanje() {
		return iznajmljivanje;
	}

	public void setIznajmljivanje(Renting iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}

	public Property getNekretnina() {
		return nekretnina;
	}

	public void setNekretnina(Property nekretnina) {
		this.nekretnina = nekretnina;
	}

	public long getDatum_pocetak() {
		return Datum_pocetak;
	}

	public void setDatum_pocetak(long datum_pocetak) {
		Datum_pocetak = datum_pocetak;
	}

	public long getDatum_kraj() {
		return Datum_kraj;
	}

	public void setDatum_kraj(long datum_kraj) {
		Datum_kraj = datum_kraj;
	}

	public double getCena() {
		return Cena;
	}

	public void setCena(double cena) {
		Cena = cena;
	}

	@Override
	public String toString() {
		return String.valueOf(nekretnina);
	}

	public double GetBrojDanaIznajmljivanja1()
	{
		if(Datum_kraj >0)
		{
			int diff_in_millis = (int) ( Datum_kraj - Datum_pocetak) ;
			double diff_in_days =  Math.abs((diff_in_millis) / (10.0  * 360.0 * 24.0)) / 30.0;
			return (int)diff_in_days;
		}
		return 0;
	}

	public void setDatumRazlika(Double datumRazlika) {
		DatumRazlika = datumRazlika;
	}

}
