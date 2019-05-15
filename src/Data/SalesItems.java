package Data;

public class SalesItems {

	
		private int IDstavke_nekretnine;
		private Sale prodaja;
		private Employed zaposleni;
		private Property nekretnina;
		private double cena_po_kvadratu;
		private int povrsina;
		private String ukupno;
		private String provizija;
		private String provizijaZaposlenog;
		
		public String getProvizijaZaposlenog() {
			return provizijaZaposlenog;
		}
		public void setProvizijaZaposlenog(String provizijaZaposlenog) {
			this.provizijaZaposlenog = provizijaZaposlenog;
		}
		public String getUkupno() {
			return ukupno;
		}
		public void setUkupno(String ukupno) {
			this.ukupno = ukupno;
		}
		public String getProvizija() {
			return provizija;
		}
		public void setProvizija(String provizija) {
			this.provizija = provizija;
		}
		public Employed getZaposleni() {
			return zaposleni;
		}
		public void setZaposleni(Employed zaposleni) {
			this.zaposleni = zaposleni;
		}
		public int getPovrsina() {
			return povrsina;
		}
		public void setPovrsina(int povrsina) {
			this.povrsina = povrsina;
		}
		
		public int getIDstavke_nekretnine() {
			return IDstavke_nekretnine;
		}
		public void setIDstavke_nekretnine(int iDstavke_nekretnine) {
			IDstavke_nekretnine = iDstavke_nekretnine;
		}
		public Sale getProdaja() {
			return prodaja;
		}
		public void setProdaja(Sale prodaja) {
			this.prodaja = prodaja;
		}
		
		public Property getNekretnina() {
			return nekretnina;
		}
		public void setNekretnina(Property nekretnina) {
			this.nekretnina = nekretnina;
		}
		public double getCena_po_kvadratu() {
			return cena_po_kvadratu;
		}
		public void setCena_po_kvadratu(double cena_po_kvadratu) {
			this.cena_po_kvadratu = cena_po_kvadratu;
		}
		
		public SalesItems(int iDstavke_nekretnine, Sale prodaja, Property nekretnina, double cena_po_kvadratu) {
			
			IDstavke_nekretnine = iDstavke_nekretnine;
			this.prodaja = prodaja;
			this.nekretnina = nekretnina;
			this.cena_po_kvadratu = cena_po_kvadratu;
		}
		public SalesItems(Property nekretnina, int povrsina, double cena_po_kvadratu, String ukupno, String provizija) {
			this.nekretnina = nekretnina;
			this.povrsina=povrsina;
			this.cena_po_kvadratu=cena_po_kvadratu;
			this.ukupno=ukupno;
			this.provizija=provizija;
			
		}
				
		public SalesItems(Employed zaposleni, Property nekretnina, double cena_po_kvadratu, int povrsina,
				String ukupno, String provizija, String provizijaZaposlenog) {
			
			this.zaposleni = zaposleni;
			this.nekretnina = nekretnina;
			this.cena_po_kvadratu = cena_po_kvadratu;
			this.povrsina = povrsina;
			this.ukupno = ukupno;
			this.provizija = provizija;
			this.provizijaZaposlenog = provizijaZaposlenog;
		}

		@Override
		public String toString() {
			return "IDstavke_nekretnine + IDProdaje + nekretnina + cena_po_kvadratu";
		}
	}
