package Ctrl;

import java.util.Observable;
import java.util.Observer;

import Model.Model;
import View.FrmChooseReport;

public class ChooseAReport implements Observer{
	private FrmChooseReport view;
	private Model model;

	public ChooseAReport(FrmChooseReport view, Model model) {
		this.view=view;
		this.model=model;
		model.getRentRealEstateReport();
		}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
