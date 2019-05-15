package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.TypeOfProperty;
import Model.Model;
import View.FrmTypeOfProperty;

public class TypeOfProperyCtrl  implements Observer 
	{
	private String[] zaglavlje = {"ID", "Naziv nekretnine"};
	private FrmTypeOfProperty view;
	private Model model;

	public TypeOfProperyCtrl(FrmTypeOfProperty view, Model model) {
		
		this.view=view;
		this.model=model;
		model.addObserver(this);
		model.getTipNekretnine();
		view.setSacuvajListener(new TipNListener());
	}

	@Override
	public void update(Observable o, Object arg) {

		ArrayList<TypeOfProperty> lista = (ArrayList<TypeOfProperty>)arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i=0;
		for (TypeOfProperty tipN : lista) {
			podaci[i][0] = tipN.getIDtip_nekretnine();
			podaci[i][1] = tipN.getNaziv();
			i++;
		}
		view.setTableData(zaglavlje, podaci);
	}
	public class TipNListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			TypeOfProperty tipn = new TypeOfProperty(0, view.getNazivTipNek());
			model.SacuvajTipNekretnine(tipn);
			model.getTipNekretnine();
			view.ClearFields();
		}
	}
}
