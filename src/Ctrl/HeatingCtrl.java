package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;
import Data.Heating;
import Model.Model;
import View.FrmHeating;
import javafx.beans.Observable;

public class HeatingCtrl implements Observer{
	private String[] zaglavlje = {"ID", "Tip grejanja"};
	private FrmHeating view;
	private Model model;

	public HeatingCtrl(FrmHeating view, Model model) {
		this.view=view;
		this.model=model;
		model.addObserver(this);
		model.getAllHeating();
		view.SacuvajLsn(new GrejanjeListener());
	}

	@Override
	public void update(java.util.Observable o, Object arg) {

		ArrayList<Heating> lista = (ArrayList<Heating>) arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i =0;
		for(Heating red : lista)
		{
			podaci[i][0] = red.getIDgrejanje();
			podaci[i][1] = red.getNaziv();
			i++;
		}
		view.setTableData(zaglavlje, podaci);
	}
	
	public class GrejanjeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Heating grejanje = new Heating(0, view.getNazivTipaGrejanje());
			model.SacuvajGrejanje(grejanje);
			model.getAllHeating();
			view.ClearFields();
		}
		
	}
}
