package Data;



public class Renting {

		
		private int IDevidencija_iznajmljivanja;
		private Property nekretnina;
		private String Broj_iznajmljivanja;
		private Custommer kupac;
		private Employed zaposleni;
		private RentalItems stavkeIznajmljivanja;
		
		
		public String getBroj_iznajmljivanja() {
			return Broj_iznajmljivanja;
		}
		public void setBroj_iznajmljivanja(String broj_iznajmljivanja) {
			Broj_iznajmljivanja = broj_iznajmljivanja;
		}
		public int getIDevidencija_iznajmljivanja() {
			return IDevidencija_iznajmljivanja;
		}
		public void setIDevidencija_iznajmljivanja(int iDevidencija_iznajmljivanja) {
			IDevidencija_iznajmljivanja = iDevidencija_iznajmljivanja;
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

		public Renting(int iDevidencija_iznajmljivanja, String broj_iznajmljivanja, Custommer kupac,
				Employed zaposleni) {
			
			IDevidencija_iznajmljivanja = iDevidencija_iznajmljivanja;
			Broj_iznajmljivanja = broj_iznajmljivanja;
			this.kupac = kupac;
			this.zaposleni = zaposleni;
		}
		@Override
		public String toString() {
			return Broj_iznajmljivanja;
		}
}
