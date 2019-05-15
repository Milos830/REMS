package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.City;
import Data.Heating;
import Data.Location;
import Data.Furniture;
import Data.Property;
import Data.TypeOfConstruction;
import Data.TypeOfProperty;
import Model.Model;
import View.FrmSity;
import View.FrmHeating;
import View.FrmLocation;
import View.FrmFurniture;
import View.FrmProperty;
import View.FrmTypeOfConstruction;
import View.FrmTypeOfProperty;

public class PropertyCtrl implements Observer{
	private String[] zaglavlje = 
	{"ID","Sifra", "Tip nekretnine","Tip gradnje", "Grad", 
	"Adresa", "Lokacija", "Povrsina", "Broj soba", "Broj kupatila", "Namestenost", "Grejanje", "Status"};
	private FrmProperty view;
	private Model model;
	private Property nekretnina;
	
	public PropertyCtrl(FrmProperty view, Model model, Property NEK) {
		this.view=view;
		view.setSacuvajListener(new NekretninaListener("Sacuvaj"));
		this.model=model;
		model.addObserver(this);
		view.desniKlikIzmeni(new NekretninaListener("Izmeni"));
		view.setDodajTipNekretnineListener(new DodavanjeListener("TipNekretnine"));
		view.setDodajTipGradnjeListener(new DodavanjeListener("TipGradnje"));
		view.setDodajGradListener(new DodavanjeListener("Grad"));
		view.setDodajLokacijaListener(new DodavanjeListener("Lokacija"));
		view.setDodajNamestenostListener(new DodavanjeListener("Namestenost"));
		view.setDodajGrejanjeListener(new DodavanjeListener("Grejanje"));
		model.getTipNekretnine();
		model.getAllTypesOfConstruction();
		model.getAllCities();
		model.getAllLocation();
		model.getAllFurniture();
		model.getAllHeating();
		model.getAllRealEstate("");
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!((ArrayList<Object>)arg).isEmpty())
		{
		if(((ArrayList<Object>) arg).get(0) instanceof Property)
		{
	ArrayList<Property> lista = (ArrayList<Property>)arg;
	Object[][] podaci = new Object[lista.size()][zaglavlje.length];
	int i=0;
	for(Property red : lista)
	{
		podaci[i][0] = red.getIDnekretnina();
		podaci[i][1] = red;
		podaci[i][2] = red.getTipNekretnine();
		podaci[i][3] = red.getTipGradnje();
		podaci[i][4] = red.getGrad();
		podaci[i][5] = red.getAdresa();
		podaci[i][6] = red.getLokacija();
		podaci[i][7] = red.getPovrsina();
		podaci[i][8] = red.getBroj_soba();
		podaci[i][9] = red.getBroj_kupatila();
		podaci[i][10] = red.getNamestenost();
		podaci[i][11] = red.getGrejanje();
		podaci[i][12] = red.getStatus();
		i++;
		}
	view.setTableData(zaglavlje, podaci);
	}
		else if (((ArrayList<Object>)arg).get(0) instanceof TypeOfProperty)
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
			System.out.println("Osveze cb");
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
		else 
		{
			ArrayList<Heating> grej = (ArrayList<Heating>) arg;
			view.setGrejanjeCB(grej);
		}
		
	}
	}

	public class NekretninaListener implements ActionListener {
		private String izmeniSacuvaj;

		public NekretninaListener(String izmeniSacuvaj) {
			this.izmeniSacuvaj = izmeniSacuvaj;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (izmeniSacuvaj.equals("Sacuvaj")) {
				Property nekretnina = new Property (0, view.getSifraNekretnine(), (TypeOfProperty) view.getTipNekretnine(), 
						(TypeOfConstruction) view.getTipGradnje(), (City) view.getGrad(), view.getAdresa(), 
						(Location) view.getLokacija(),view.getPovrsina(), view.getBrojSoba(), 
						view.getBrojKupatila(), (Furniture) view.getNamestenost(), 
						(Heating) view.getGrejanje(), "Slobodno");
						model.SacuvajNekretnina(nekretnina);
						model.getAllRealEstate("");
						view.ClearFields();
					}
			else if (izmeniSacuvaj.equals("Izmeni")) {
				Property ne = view.getSelectedItemFromTable();
				view.setSifraNekretnine(ne.getSifraNekretnine());
				view.setTipNekretnine(ne.getTipNekretnine().getIDtip_nekretnine());
				view.setTipGradnje(ne.getTipGradnje().getIDTip_gradnje());
				view.setGrad(ne.getGrad().getIDgrad());
				view.setAdresa(ne.getAdresa());
				view.setLokacija(ne.getLokacija().getIDlokacija());
				view.setPovrsina(ne.getPovrsina());
				view.setBrojSoba(ne.getBroj_soba());
				view.setBrojKupatila(ne.getBroj_kupatila());
				view.setNamestenost(ne.getNamestenost().getIDnamestenost());
				view.setGrejanje(ne.getGrejanje().getIDgrejanje());
				view.setSacuvajListener(new NekretninaListener("SIZMENE"));
				nekretnina = ne;
				}
			else if(izmeniSacuvaj.equals("SIZMENE"))
				{
				nekretnina.setSifraNekretnine(view.getSifraNekretnine());
				nekretnina.setTipNekretnine((TypeOfProperty) view.getTipNekretnine());
				nekretnina.setTipGradnje((TypeOfConstruction)view.getTipGradnje());
				nekretnina.setGrad((City) view.getGrad());
				nekretnina.setAdresa(view.getAdresa());
				nekretnina.setLokacija((Location) view.getLokacija());
				nekretnina.setPovrsina(view.getPovrsina());
				nekretnina.setBroj_soba(view.getBrojSoba());
				nekretnina.setBroj_kupatila(view.getBrojKupatila());
				nekretnina.setNamestenost((Furniture) view.getNamestenost());
				nekretnina.setGrejanje((Heating) view.getGrejanje());
 				
				model.IzmeniNekretnina(nekretnina);
				nekretnina = null;
				view.setSacuvajListener(new NekretninaListener("Sacuvaj"));
				model.getAllRealEstate("");
			}
		}
	}
				
		public class DodavanjeListener implements ActionListener {
			private String KojeDugme;

			public DodavanjeListener(String KojeDugme) {
				this.KojeDugme = KojeDugme;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (KojeDugme.equals("TipNekretnine")) {
					FrmTypeOfProperty tipnek = new FrmTypeOfProperty("Dodaj nekretninu");
					Model model = new Model();
					TypeOfProperyCtrl ctrl = new TypeOfProperyCtrl(tipnek, model);
					tipnek.setVisible(true);
				} else if (KojeDugme.equals("TipGradnje")) {
					FrmTypeOfConstruction tipgr = new FrmTypeOfConstruction("Dodaj tip gradnje");
					Model model = new Model();
					TypeOfConstructionCtrl ctrl = new TypeOfConstructionCtrl(tipgr, model);
					tipgr.setVisible(true);
				}else if(KojeDugme.equals("Grad")) {
					FrmSity grad = new FrmSity("Dodaj grad");
					Model model = new Model();
					SityCtrl ctrl = new SityCtrl(grad, model);
					grad.setVisible(true);
				}else if(KojeDugme.equals("Lokacija")) {
					FrmLocation lok = new FrmLocation("Dodaj lokaciju");
					Model model = new Model();
					LocationCtrl ctrl = new  LocationCtrl(lok, model);
					lok.setVisible(true);
				}else if(KojeDugme.equals("Namestenost")) {
					FrmFurniture nam = new FrmFurniture("Dodaj tip namestenosti");
					Model model = new Model();
					FurnitureCtrl ctrl = new FurnitureCtrl(nam, model);
					nam.setVisible(true);
				}else if(KojeDugme.equals("Grejanje")) {
					FrmHeating gre = new FrmHeating("Dodaj tip grejanja");
					Model model = new Model();
					HeatingCtrl ctrl = new HeatingCtrl(gre, model);
					gre.setVisible(true);
				}
			}
		}
	}

