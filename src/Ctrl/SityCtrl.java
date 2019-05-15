package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Data.City;
import Model.Model;
import View.FrmSity;

public class SityCtrl implements Observer{
	private String[] zaglavlje= {"ID", "Naziv grada"};
	private FrmSity view;
	private Model model;

	public SityCtrl(FrmSity view, Model model) {
		this.view=view;
		this.model=model;
		model.addObserver(this);
		this.model.getAllCities();
		view.setSacuvajListener(new GradListener());
	}

	@Override
	public void update(Observable o, Object arg) {
		ArrayList<City> lista = (ArrayList<City>) arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i =0;
		for (City red : lista) {
			podaci[i][0] = red.getIDgrad();
			podaci[i][1] = red.getNaziv();
			i++;
		}
		view.setTableData(zaglavlje, podaci);
		}

	public class GradListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			City grad = new City(0, view.getNazivGrada());
			model.SacuvajGrad(grad);
			model.getAllCities();
			view.ClearFields();
		}
		
	}
}
