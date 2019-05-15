package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.Employed;
import Model.Model;
import View.FrmEmployed;

public class EmployedCtrl implements Observer {
	private String[] zaglavlje = {"ID", "Sifra", "Ime i prezime", "Telefon"};
	private FrmEmployed view;
	private Model model;
	public EmployedCtrl( FrmEmployed view, Model model) {
		
		this.view=view;
		this.model=model;
		view.setSacuvajZaposleni(new ZaposleniListener());
		model.addObserver(this);
		model.getAllEmmployers();
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		ArrayList<Employed> lista = (ArrayList<Employed>) arg1;
		Object [][] podaci = new Object[lista.size()][zaglavlje.length];
		int i=0;
		for(Employed red: lista)
		{
			podaci[i][0] = red.getIDzaposleni();
			podaci[i][1] = red.getSifrazaposleni();
			podaci[i][2] = red.getImeIPrezimezaposleni();
			podaci[i][3] = red.getTelefonzaposleni();
			i++;
		}
		view.setTableData(zaglavlje, podaci);
	}
	
	public class ZaposleniListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Employed zaposleni = new Employed(0, view.getSifra(), view.getImeIPrezime(), view.getTelefon());
			model.SacuvajZaposleni(zaposleni);
			model.getAllEmmployers();
			view.ClearFields();
		}
	}
}
