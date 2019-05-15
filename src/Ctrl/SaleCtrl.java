package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import Data.Sale;
import Data.SalesItems;
import Model.Model;
import View.FrmSale;
import Data.Custommer;
import Data.Employed;
import Data.Property;


public class SaleCtrl implements Observer {

	private String[] zaglavlje = {"ID", "ID prodaje","Nekretnina", "Cena po kvadratu"};
	private FrmSale view;
	private Model model;
	private Sale prodaja;
	private SalesItems stavkeprodaje;
	private Property nekretnina;
	private String status;
	
	
	public SaleCtrl(FrmSale view, Model model, String status) {
		this.view=view;
		this.model=model;
		view.setSacuvajLsn(new ProdajaListener("sacuvaj"));
		view.setStavkeLsn(new ProdajaListener("stavke"));
		view.setZavrsiLsn(new ProdajaListener("zavrsi"));
		model.addObserver(this);
		model.getStavkeProdaje();
		model.getAllEmmployers();
		model.getAllCustomers();
		model.getAllRealEstate("Slobodno");
		}
	@Override
	public void update(Observable o, Object arg) 	{
		
		if(!((ArrayList<Object>)arg).isEmpty()) 
			{	
			if(((ArrayList<Object>)arg).get(0) instanceof SalesItems)
			{
			ArrayList<SalesItems> lista = (ArrayList<SalesItems>)arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i = 0;
		for (SalesItems red : lista)
			{	
				podaci[i][0] = red.getIDstavke_nekretnine();
				podaci[i][1] = red.getProdaja().getIDevidencija_prodaje();
				podaci[i][2] = red.getNekretnina();
				podaci[i][3] = red.getCena_po_kvadratu();
				i++;	
		}
		view.setTableData(zaglavlje, podaci);
	}
		else if (((ArrayList<Object>)arg).get(0) instanceof Custommer)
		{
			ArrayList<Custommer> kup = (ArrayList<Custommer>) arg;
			view.setKupacCB(kup);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Employed)
		{
			ArrayList<Employed> zap = (ArrayList<Employed>) arg;
			view.setZaposleniCB(zap);
		}
		else 
		{
			ArrayList<Property> nek = (ArrayList<Property>) arg;
			view.setNekretninaCB(nek);
		}
	}
}
	
	public class ProdajaListener implements ActionListener {
		private String action;
		public ProdajaListener(String action)
		{
			this.action=action;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(action.equals("sacuvaj"))
			{
			prodaja = new Sale(0, view.getDate(), view.getBrojProdaje(),  (Custommer) view.getKupac(), (Employed) view.getZaposleni());
			model.SacuvajProdaja(prodaja);
			view.EnableStavke();
		}
			else if (action.equals("stavke")) {
				SalesItems stavke = new SalesItems(0, prodaja, (Property) view.getNekretnina(), view.getCena());
				((Property) view.getNekretnina()).setStatus("Prodato");
				model.SacuvajStavke(stavke);
				model.IzmeniSTATUSnekretninePRODAJA((Property)view.getNekretnina());
				model.getStavkeProdaje();	
				view.ClearFilds();
			}
			else if(action.equals("zavrsi")) {
			}
	}
	
	public String getDate(long timeStamp)
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date time = new Date((long) timeStamp*1000);
		return df.format(time);
		}
	}
}
