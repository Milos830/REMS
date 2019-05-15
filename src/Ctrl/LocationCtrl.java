package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.Location;
import Model.Model;
import View.FrmLocation;

public class LocationCtrl implements Observer{
	private String[] zaglavlje = {"ID", "Naziv lokacije"};
	private FrmLocation view;
	private Model model;

	public LocationCtrl(FrmLocation view, Model model) {
	
			this.view=view;
			this.model=model;
			model.addObserver(this);
			model.getAllLocation();
			view.SacuvajLsn(new LokacijaListener());
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		ArrayList<Location> lista = (ArrayList<Location>)arg1;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i = 0;
		for (Location lok : lista) {
			podaci[i][0] = lok.getIDlokacija();
			podaci[i][1] = lok.getNaziv();
			i++;
			}
		view.setTableData(zaglavlje, podaci);
	}

	public class LokacijaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Location l = new Location(0, view.getNazivLokacije());
			 model.SacuvajLokacija(l);
			 model.getAllLocation();
			 view.ClearFields();
		}
	}
}
