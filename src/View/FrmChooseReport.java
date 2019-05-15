package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Ctrl.ReportAllRentsCtrl;
import Ctrl.ReportAllSalesCtrl;
import Ctrl.ReportAllRentsByAgentsCtrl;
import Ctrl.ReportAllSalesByAgentsCtrl;
import Model.Model;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;

public class FrmChooseReport extends JFrame {
	private JRadioButton rbSveProdateNekretnine;
	private JRadioButton rbProdajaPoAgentima;
	private JRadioButton rbSveIznajmljeneNekretnine;
	private JRadioButton rbIznajmljenePoAgentima;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private FrmReportAllRents view;

	
	public FrmChooseReport(String title)  {
		super(title);
		setTitle("Izvestaji");
		initialize();
		
	
	}
	
	private void initialize()
	{
		setBounds(100,200,242,304);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		rbSveProdateNekretnine = new JRadioButton("Sve prodate nekretnine");
		rbSveProdateNekretnine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmReportAllSales view = new FrmReportAllSales("Sve prodate nekretnine");
				Model model = new Model();
				ReportAllSalesCtrl ctrl = new ReportAllSalesCtrl(model, view);
				view.setVisible(true);
				
			}
		});
		buttonGroup.add(rbSveProdateNekretnine);
		
		rbProdajaPoAgentima = new JRadioButton("Prodaja po agentima");
		rbProdajaPoAgentima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmReportAllSalesByAgents view = new FrmReportAllSalesByAgents("Prodate");
				Model model = new Model();
				ReportAllSalesByAgentsCtrl ctrl = new ReportAllSalesByAgentsCtrl(model, view);
				view.setVisible(true);
				
			}
		});
		buttonGroup.add(rbProdajaPoAgentima);
		
		rbSveIznajmljeneNekretnine = new JRadioButton("Sve iznajmljene nekretnine");
		rbSveIznajmljeneNekretnine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmReportAllRents view = new FrmReportAllRents("Iznajmljene");
				Model model = new Model();
				ReportAllRentsCtrl ctrl = new ReportAllRentsCtrl(model, view);
				view.setVisible(true);
			}
		});
		buttonGroup.add(rbSveIznajmljeneNekretnine);
		
		rbIznajmljenePoAgentima = new JRadioButton("Iznajmljene po agentima");
		rbIznajmljenePoAgentima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReportAllRentalsByAgents view = new FrmReportAllRentalsByAgents("Izvestaj iznajmljenih nekretnina po agentima");
				Model model = new Model();
				ReportAllRentsByAgentsCtrl ctrl = new ReportAllRentsByAgentsCtrl(model, view);
				view.setVisible(true);
			}
		});
		buttonGroup.add(rbIznajmljenePoAgentima);
		
		JLabel lblProdaja = new JLabel("Prodaja");
		lblProdaja.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblIznajmljivanje = new JLabel("Iznajmljivanje");
		lblIznajmljivanje.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addComponent(lblProdaja))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rbSveProdateNekretnine)
								.addComponent(rbProdajaPoAgentima)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGap(39)
										.addComponent(lblIznajmljivanje)
										.addPreferredGap(ComponentPlacement.RELATED, 12, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rbSveIznajmljeneNekretnine)
										.addComponent(rbIznajmljenePoAgentima))))))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblProdaja)
					.addGap(18)
					.addComponent(rbSveProdateNekretnine)
					.addGap(18)
					.addComponent(rbProdajaPoAgentima)
					.addGap(18)
					.addComponent(lblIznajmljivanje)
					.addGap(18)
					.addComponent(rbSveIznajmljeneNekretnine)
					.addGap(18)
					.addComponent(rbIznajmljenePoAgentima)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	
	

	
}
