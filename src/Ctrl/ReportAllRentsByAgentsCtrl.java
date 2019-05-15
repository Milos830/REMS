package Ctrl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Data.RentalItems;
import Data.Employed;
import Model.Model;
import View.FrmReportAllRentalsByAgents;

public class ReportAllRentsByAgentsCtrl implements Observer{
	private Model model;
	private FrmReportAllRentalsByAgents view;
	private String [] zaglavlje1 = {"ID", "Sifra", "Ime i prezime", "Telefon"};
	private String[] zaglavlje = {"Zaposleni", "Nekretnina", "Datum pocetak", "Datum kraj", "Cena", "Broj meseci", "Zarada", "Provizija"};

	public ReportAllRentsByAgentsCtrl(Model model, FrmReportAllRentalsByAgents view) {
		this.model=model;
		this.view=view;
		model.addObserver(this);
		
		model.getAllEmmployers();
		view.AddSelectionListener(new KlikListener());
	}

	public class KlikListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			ArrayList<RentalItems> st = model.getRentsByAgents(view.getSelectedItemFromTable().getIDzaposleni());
			Object[][] podaci = new Object[st.size()][zaglavlje.length];
			int i = 0;
			for(RentalItems red : st)
			{
				podaci[i][0] = red.getZaposleni();
				podaci[i][1] = red.getNekretnina();
				podaci[i][2] = getDate(red.getDatum_pocetak());
				podaci[i][3] = getDate(red.getDatum_kraj());
				podaci[i][5] = red.GetBrojDanaIznajmljivanja1();
				podaci[i][4] = red.getCena();
				podaci[i][6] = getRound2(red.getZarada());
				podaci[i][7] = red.getProvizija();
				i++;
			}
			view.setTableData(zaglavlje, podaci);
			double sumaZ=0;
			double sumaP=0;

			for(RentalItems stavke :st) {
				sumaZ=sumaZ+Double.valueOf(getRound2(stavke.getZarada()));
				sumaP=sumaP+Double.valueOf(stavke.getProvizija());
			}
			view.setProvizija(sumaP);
			view.setZarada(sumaZ);
			}
		}
	
	@Override
	public void update(Observable arg0, Object arg1) {

		if(((ArrayList<Object>)arg1).get(0) instanceof Employed)
		{
			ArrayList<Employed> lista = (ArrayList<Employed>) arg1;
			Object [][] podaci1 = new Object[lista.size()][zaglavlje1.length];
			int i=0;
			for(Employed red: lista)
			{
				podaci1[i][0] = red.getIDzaposleni();
				podaci1[i][1] = red.getSifrazaposleni();
				podaci1[i][2] = red;
				podaci1[i][3] = red.getTelefonzaposleni();
				i++;
			}
			view.setTableZaposleni(zaglavlje1, podaci1);
		}
		
	} 
	
	public String getDate(long timeStamp)
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date time = new Date((long) timeStamp*1000);
		return df.format(time);
	}
	
	public  Double getRound2(String val) {
	    return new BigDecimal(val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
			}
	}
	