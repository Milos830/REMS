package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Model.Model;
import View.FrmRenting;
import View.FrmMainMenu;
import View.FrmSity;
import View.FrmHeating;
import View.FrmChooseReport;
import View.FrmCustommer;
import View.FrmLocation;
import View.FrmFurniture;
import View.FrmProperty;
import View.FrmSale;
import View.FrmTypeOfConstruction;
import View.FrmTypeOfProperty;
import View.FrmEmployed;
import Ctrl.RentingCtrl;
import Data.City;
import Data.Heating;
import Data.Renting;
import Data.Location;
import Data.Furniture;
import Data.Property;
import Data.TypeOfConstruction;
import Data.TypeOfProperty;

public class MainMenuCtrl implements Observer{
	private FrmMainMenu view;
	private Model model;
	
	public MainMenuCtrl(FrmMainMenu view, Model model) {
		
		this.view=view;
		this.model=model;
		model.addObserver(this);
		view.setNekretninaListener(new GlavniMeniListener("Nekretnina"));
		view.setKupacListener(new GlavniMeniListener("Kupac"));
		view.setZaposleniListener(new GlavniMeniListener("Zaposleni"));
		view.setProdajaListener(new GlavniMeniListener("Prodaja"));
		view.setIznajmljivanjeListener(new GlavniMeniListener("Iznajmljivanje"));
		view.setIzvestajListener(new GlavniMeniListener("Izvestaji"));
		model.getAllRealEstate("Slobodno");
		model.getAllFurniture();
		model.getAllLocation();
		model.getTipNekretnine();
		model.getAllTypesOfConstruction();
		model.getAllHeating();
		model.getAllCities();
		}

	@Override
	public void update(Observable o, Object arg) {

		if(!((ArrayList<Object>)arg).isEmpty())
		{
		 if (((ArrayList<Object>)arg).get(0) instanceof TypeOfProperty)
		{
			ArrayList<TypeOfProperty> tipovi = (ArrayList<TypeOfProperty>) arg;
			view.setTipNekretnineCB(tipovi);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof TypeOfConstruction)
		{
			ArrayList<TypeOfConstruction> tipG = (ArrayList<TypeOfConstruction>) arg;
			view.setTipGradnjeCB(tipG);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof City)
		{
			ArrayList<City> gradovi = (ArrayList<City>) arg;
			view.setGradCB(gradovi);
		}
		
		else if (((ArrayList<Object>)arg).get(0) instanceof Location)
		{
			ArrayList<Location> lok = (ArrayList<Location>) arg;
			view.setLokacijaCB(lok);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Furniture) 
		{
			ArrayList<Furniture> namestaj = (ArrayList<Furniture>) arg;
			view.setNamestenostCB(namestaj);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Heating) 
		{
			ArrayList<Heating> grej = (ArrayList<Heating>) arg;
			view.setGrejanjeCB(grej);
		}

		}
	}
	
	public class GlavniMeniListener implements ActionListener {
		private String KojeDugme;

		public GlavniMeniListener(String KojeDugme) {
			this.KojeDugme = KojeDugme;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (KojeDugme.equals("Nekretnina")) {
				FrmProperty view = new FrmProperty("Dodaj novu nekretninu");
				Model model = new Model();
				PropertyCtrl ctrl = new PropertyCtrl(view, model, view.getSelectedItemFromTable());
				view.setVisible(true);
			} else if (KojeDugme.equals("Kupac")) {
				FrmCustommer view = new FrmCustommer("Dodaj kupca");
				Model model = new Model();
				CustomerCrtl ctrl = new CustomerCrtl(view, model);
				view.setVisible(true);
			}else if(KojeDugme.equals("Zaposleni")) {
				FrmEmployed view = new FrmEmployed("Dodaj zaposlenog");
				Model model = new Model();
				EmployedCtrl crtl = new EmployedCtrl(view, model);
				view.setVisible(true);
			}else if(KojeDugme.equals("Prodaja")) {
				FrmSale view = new FrmSale("PRODAJ NEKRETNINU MACKO");
				Model model = new Model();
				SaleCtrl ctrl = new SaleCtrl(view, model, "Slobodno");
				view.setVisible(true);
			}else if(KojeDugme.equals("Iznajmljivanje")) {
				FrmRenting view = new FrmRenting("Dzordz whyyy");
				Model model = new Model();
				RentingCtrl ctrl = new RentingCtrl(view, model, "Slobodno");
				view.setVisible(true);
			}else if(KojeDugme.equals("Izvestaji")) {
				FrmChooseReport view = new FrmChooseReport("Izaberi izvestaj");
				Model model = new Model();
				ChooseAReport ctrl = new ChooseAReport(view,model);
				view.setVisible(true);
			}
		}
				
	}
}
	