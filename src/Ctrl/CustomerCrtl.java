package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.Custommer;
import Model.Model;
import View.FrmCustommer;

public class CustomerCrtl implements Observer{
	private String [] zaglavlje = 
		{"ID", "Ime i prezime", "Licna karta", "Telefon", "Adresa", "E-mail"};
	private FrmCustommer view;
	private Model model;
	private Custommer kupac;

	public CustomerCrtl(FrmCustommer view, Model model) {
		this.view=view;
		this.model=model;
		view.setSacuvajKupac(new KupacListener("Sacuvaj"));
		view.setIzmeniKupac(new KupacListener("Izmeni"));
		model.addObserver(this);
		model.getAllCustomers();
		}

	@Override
	public void update(Observable o, Object arg) {

		ArrayList<Custommer> lista = (ArrayList<Custommer>) arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i = 0;
		for(Custommer red: lista) {
		podaci[i][0] = red.getIDkupac();
		podaci[i][1] = red;
		podaci[i][2] = red.getLKkupca();
		podaci[i][3] = red.getTelkupac();
		podaci[i][4] = red.getAdresakupac();
		podaci[i][5] = red.getEmailkupac();
		i++;
		}
		view.setTableData(zaglavlje, podaci);
	}
	
	public class KupacListener implements ActionListener {
		private String action;
		
		public KupacListener (String action)
		{
			this.action=action;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(action.equals("Sacuvaj")) {
			Custommer kupac = new Custommer(0, view.getImeIPrezime(), view.getBrLK(), 
					view.getTelefonKupac(), view.getAdresa(), view.getEmail());
			model.SacuvajKupac(kupac);
			model.getAllCustomers();
			view.ClearFields();
		}
			else if(action.equals("Izmeni"))
				{
				Custommer k = view.getSelectedItemFromTable();
				view.setImeIPrezime(k.getImeiprezimekupac());
				view.setBrojLK(k.getLKkupca());
				view.setTelefon(k.getTelkupac());
				view.setAdresa(k.getAdresakupac());
				view.setEmail(k.getEmailkupac());
				view.setSacuvajKupac(new KupacListener("IZMENE"));
				kupac = k;
				}
			else if (action.equals("IZMENE")) {
				kupac.setImeiprezimekupac(view.getImeIPrezime());
				kupac.setLKkupca(view.getBrLK());
				kupac.setTelkupac(view.getTelefonKupac());
				kupac.setAdresakupac(view.getAdresa());
				kupac.setEmailkupac(view.getEmail());
				model.IzmeniKupac(kupac);
				kupac = null;
				view.setSacuvajKupac(new KupacListener("Sacuvaj"));
				model.getAllCustomers();
				view.ClearFields();
			}
		}
		
	}
}