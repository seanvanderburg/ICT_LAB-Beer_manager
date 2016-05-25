package application;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInterface {
	//layout components

	JFrame frame = new JFrame("BottleScanner ManagementApp");
	static JPanel panelCont = new JPanel();
	JPanel panelMenu = new JPanel();
	JPanel panelBottle = new JPanel();
	JPanel panelNeighbourhood = new JPanel();
	JPanel panelDrink = new JPanel();
	JButton newDrink = new JButton("voeg drank toe");
	JButton newBottle = new JButton("voeg fles toe");
	JButton newNeighbourhood = new JButton("voeg buurt toe");
	
	JButton backA = new JButton("Terug");
	JButton backB = new JButton("Terug");
	JButton backC = new JButton("Terug");


	static CardLayout cl = new CardLayout();

	private final JTextField txtMerk = new JTextField();
	private final JTextField txtLengte = new JTextField();
	private final JTextField txtCapaciteit = new JTextField();
	private final JTextField txtDatumGescand = new JTextField();
	private final JLabel lblVoerFlesgegevensIn = new JLabel("Voer Flesgegevens in");
	private final JTextField txtdrinktype = new JTextField();
	private final JTextField txtdrinkname = new JTextField();
	private final JTextField txtdatefounded = new JTextField();
	private final JLabel lblVoerDrankgegevensIn = new JLabel("Voer Drankgegevens in");
	private final JTextField txtneigname;
	private final JTextField txtneigcity;
	private final JTextField txtneigdescr;
	private final JLabel lblVoerBuurtgegevensIn = new JLabel("Voer Buurtgegevens in");
	private final JRadioButton rdbtnBeschikbaar = new JRadioButton("Beschikbaar");

	

	public UserInterface() {
		txtDatumGescand.setText("Datum gescand");
		txtDatumGescand.setBounds(189, 156, 112, 20);
		txtDatumGescand.setColumns(10);
		txtCapaciteit.setText("Capaciteit");
		txtCapaciteit.setBounds(189, 125, 112, 20);
		txtCapaciteit.setColumns(10);
		txtLengte.setText("Lengte");
		txtLengte.setBounds(189, 63, 112, 20);
		txtLengte.setColumns(10);
		txtMerk.setBounds(189, 94, 112, 20);
		txtMerk.setText("Breedte");
		txtMerk.setColumns(10);
		
		
		//build the frontend using the components
		panelCont.setLayout(cl);
		
		newDrink.setPreferredSize(new Dimension(200, 40));
		newBottle.setPreferredSize(new Dimension(200, 40));
		newNeighbourhood.setPreferredSize(new Dimension(200, 40));

		// menu elements
		panelMenu.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panelMenu.add(newDrink);
		panelMenu.add(newBottle);
		panelMenu.add(newNeighbourhood);
		
		// main container
		panelCont.add(panelMenu, "1");
		panelCont.add(panelBottle, "2");
		panelCont.add(panelDrink, "3");
		panelCont.add(panelNeighbourhood, "4");

		cl.show(panelCont, "1");
	
		newNeighbourhood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});
		
		//actionlisteners to react on user input
		newDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "3");
			}
		});
		
		newBottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "2");
			}
		});
		
		//Frame properties
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 300));
		frame.setVisible(true);
		frame.setSize(500, 500);

		panelMenu.setSize(50, 50);
		
		//GUI element properties
		
		panelBottle.setSize(50, 50);
		panelBottle.setLayout(null);
		panelBottle.add(txtLengte);
		panelBottle.add(txtCapaciteit);
		panelBottle.add(txtDatumGescand);
		panelBottle.add(txtMerk);

		lblVoerFlesgegevensIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoerFlesgegevensIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoerFlesgegevensIn.setBounds(146, 11, 192, 31);
		panelBottle.add(lblVoerFlesgegevensIn);
		panelBottle.add(backA);
		
		backA.setLocation(189, 201);
		backA.setSize(112, 44);
		backA.setPreferredSize(new Dimension(200,20));
		backA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
			
		});
		
		backB.setLocation(189, 201);
		backB.setSize(112, 44);
		backB.setPreferredSize(new Dimension(200,20));
		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
			
		});
		
		backC.setLocation(189, 201);
		backC.setSize(112, 44);
		backC.setPreferredSize(new Dimension(200,20));
		backC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
			
		});

		panelNeighbourhood.setSize(50, 50);
		panelNeighbourhood.setLayout(null);
		
		txtneigname = new JTextField();
		txtneigname.setBounds(201, 41, 86, 20);
		txtneigname.setText("Naam");
		txtneigname.setColumns(10);
		panelNeighbourhood.add(txtneigname);
		
		txtneigcity = new JTextField();
		txtneigcity.setBounds(201, 72, 86, 20);
		txtneigcity.setText("Stad");
		txtneigcity.setColumns(10);
		panelNeighbourhood.add(txtneigcity);
		
		txtneigdescr = new JTextField();
		txtneigdescr.setBounds(201, 103, 86, 20);
		txtneigdescr.setText("Beschrijving");
		txtneigdescr.setColumns(10);
		panelNeighbourhood.add(txtneigdescr);
		
		lblVoerBuurtgegevensIn.setBounds(153, 11, 173, 19);
		lblVoerBuurtgegevensIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoerBuurtgegevensIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelNeighbourhood.add(lblVoerBuurtgegevensIn);
		panelNeighbourhood.add(backB);
		
		panelDrink.setSize(50, 50);
		panelDrink.setLayout(null);
		txtdrinktype.setText("Type");
		txtdrinktype.setColumns(10);
		txtdrinktype.setBounds(189, 63, 112, 20);
		panelDrink.add(txtdrinktype);
		
		txtdrinkname.setText("Naam");
		txtdrinkname.setColumns(10);
		txtdrinkname.setBounds(189, 94, 112, 20);
		panelDrink.add(txtdrinkname);
		
		txtdatefounded.setText("Datum gelanceerd");
		txtdatefounded.setColumns(10);
		txtdatefounded.setBounds(189, 125, 112, 20);
		panelDrink.add(txtdatefounded);
		
		lblVoerDrankgegevensIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoerDrankgegevensIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoerDrankgegevensIn.setBounds(146, 11, 192, 31);
		panelDrink.add(lblVoerDrankgegevensIn);		
		panelDrink.add(backC);
		
		rdbtnBeschikbaar.setBounds(189, 174, 112, 23);
		panelDrink.add(rdbtnBeschikbaar);	
		
	}
}


