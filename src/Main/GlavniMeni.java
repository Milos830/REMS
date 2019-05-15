package Main;

import Ctrl.MainMenuCtrl;
import Ctrl.CustomerCrtl;
import Model.Model;
import View.FrmMainMenu;
import View.FrmCustommer;

public class GlavniMeni {

	public static void main(String[] args) {

		
		FrmMainMenu meni = new FrmMainMenu("Prodaja i iznajmljivanje nekretnina - glavni meni");
		Model model = new Model();
		MainMenuCtrl ctrl = new MainMenuCtrl(meni, model);
		meni.setVisible(true);
	}

}


