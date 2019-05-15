package Data;

public class Sale {

	
		private int IDevidencija_prodaje;
		private String Broj_prodaje;
		private long Datum_prodaje;
		private Custommer kupac;
		private Employed zaposleni;
		private Property nekretnina;
		
		
		public String getBroj_prodaje() {
			return Broj_prodaje;
		}
		public void setBroj_prodaje(String broj_prodaje) {
			Broj_prodaje = broj_prodaje;
		}
		public int getIDevidencija_prodaje() {
			return IDevidencija_prodaje;
		}
		public void setIDevidencija_prodaje(int iDevidencija_prodaje) {
			IDevidencija_prodaje = iDevidencija_prodaje;
		}
		public long getDatum_prodaje() {
			return Datum_prodaje;
		}
		public void setDatum_prodaje(long datum_prodaje) {
			Datum_prodaje = datum_prodaje;
		}
		public Custommer getKupac() {
			return kupac;
		}
		public void setKupac(Custommer kupac) {
			this.kupac = kupac;
		}
		public Employed getZaposleni() {
			return zaposleni;
		}
		public void setZaposleni(Employed zaposleni) {
			this.zaposleni = zaposleni;
		}
		public Property getNekretnina() {
			return nekretnina;
		}
		public void setNekretnina(Property nekretnina) {
			this.nekretnina = nekretnina;
		}
		
		public Sale(int iDevidencija_prodaje, long datum_prodaje, String broj_prodaje,  Custommer kupac,
				Employed zaposleni) {
			
			IDevidencija_prodaje = iDevidencija_prodaje;
			Broj_prodaje = broj_prodaje;
			Datum_prodaje = datum_prodaje;
			this.kupac = kupac;
			this.zaposleni = zaposleni;
		}
		
		public Sale(Employed zaposleni, Property nekretnina)
		{
			this.zaposleni=zaposleni;
			this.nekretnina=nekretnina;
		}
		@Override
		public String toString() {
			return "IDevidencija_prodaje + Broj_prodaje + Datum_prodaje + kupac + zaposleni";
		}
}
