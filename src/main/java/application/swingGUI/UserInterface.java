package application.swingGUI;

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
	// layout components

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

	JButton confirmA = new JButton("Invoeren");
	JButton confirmB = new JButton("Invoeren");
	JButton confirmC = new JButton("Invoeren");

	static CardLayout cl = new CardLayout();

	JTextField txtwidth = new JTextField();
	JTextField txtlength = new JTextField();
	JTextField txtcapacity = new JTextField();
	JTextField txtdatescanned = new JTextField();
	JLabel lblinsertbottledata = new JLabel("Voer Flesgegevens in");
	JTextField txtdrinktype = new JTextField();
	JTextField txtdrinkname = new JTextField();
	JTextField txtdatefounded = new JTextField();
	JLabel lblinsertdrinkdata = new JLabel("Voer Drankgegevens in");
	JTextField txtneigname;
	JTextField txtneigcity;
	JTextField txtneigdescr;
	JLabel lblinsertneighbdata = new JLabel("Voer Buurtgegevens in");
	JRadioButton rdbtnBeschikbaar = new JRadioButton("Beschikbaar");

	public UserInterface() {

		// build the frontend using the components
		panelCont.setLayout(cl);

		newDrink.setPreferredSize(new Dimension(200, 40));
		newBottle.setPreferredSize(new Dimension(200, 40));
		newNeighbourhood.setPreferredSize(new Dimension(200, 40));

		// menu elements
		panelMenu
				.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
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

		// actionlisteners to open new menus
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

		// Frame properties
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setVisible(true);
		frame.setSize(500, 500);

		panelMenu.setSize(50, 50);

		// GUI element properties
		txtdatescanned.setText("Datum gescand");
		txtdatescanned.setBounds(189, 156, 112, 20);
		txtdatescanned.setColumns(10);
		txtcapacity.setText("Capaciteit");
		txtcapacity.setBounds(189, 125, 112, 20);
		txtcapacity.setColumns(10);
		txtlength.setText("Lengte");
		txtlength.setBounds(189, 63, 112, 20);
		txtlength.setColumns(10);
		txtwidth.setBounds(189, 94, 112, 20);
		txtwidth.setText("Breedte");
		txtwidth.setColumns(10);

		panelBottle.setSize(50, 50);
		panelBottle.setLayout(null);
		panelBottle.add(txtlength);
		panelBottle.add(txtcapacity);
		panelBottle.add(txtdatescanned);
		panelBottle.add(txtwidth);

		lblinsertbottledata.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblinsertbottledata.setHorizontalAlignment(SwingConstants.CENTER);
		lblinsertbottledata.setBounds(146, 11, 192, 31);
		
		panelBottle.add(lblinsertbottledata);
		panelBottle.add(backA);
		panelBottle.add(confirmA);
		
		
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

		lblinsertneighbdata.setBounds(153, 11, 173, 19);
		lblinsertneighbdata.setHorizontalAlignment(SwingConstants.CENTER);
		lblinsertneighbdata.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panelNeighbourhood.add(lblinsertneighbdata);
		panelNeighbourhood.add(backB);
		panelNeighbourhood.add(confirmB);

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

		lblinsertdrinkdata.setHorizontalAlignment(SwingConstants.CENTER);
		lblinsertdrinkdata.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblinsertdrinkdata.setBounds(146, 11, 192, 31);
		panelDrink.add(lblinsertdrinkdata);
		panelDrink.add(backC);
		panelDrink.add(confirmC);

		rdbtnBeschikbaar.setBounds(189, 174, 112, 23);
		panelDrink.add(rdbtnBeschikbaar);

		backA.setLocation(189, 201);
		backA.setSize(112, 44);
		backA.setPreferredSize(new Dimension(200, 20));
		backA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}

		});

		backB.setLocation(189, 201);
		backB.setSize(112, 44);
		backB.setPreferredSize(new Dimension(200, 20));
		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}

		});

		backC.setLocation(189, 201);
		backC.setSize(112, 44);
		backC.setPreferredSize(new Dimension(200, 20));
		backC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}

		});
		
		confirmA.setLocation(189, 256);
		confirmA.setSize(112, 44);
		confirmA.setPreferredSize(new Dimension(200, 20));
		confirmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String capacity = txtcapacity.getText();
				String width = txtwidth.getText();
				String length = txtlength.getText();
				String datescanned = txtdatescanned.getText();
				Transactions.addBottle(capacity, width, length, datescanned);
			}
		});
		
		confirmB.setLocation(189, 256);
		confirmB.setSize(112, 44);
		confirmB.setPreferredSize(new Dimension(200, 20));
		confirmB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String capacity = txtcapacity.getText();
				String width = txtwidth.getText();
				String length = txtlength.getText();
				String datescanned = txtdatescanned.getText();
				Transactions.addBottle(capacity, width, length, datescanned);
			}
		});
		
		confirmC.setLocation(189, 256);
		confirmC.setSize(112, 44);
		confirmC.setPreferredSize(new Dimension(200, 20));
		confirmC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String capacity = txtcapacity.getText();
				String width = txtwidth.getText();
				String length = txtlength.getText();
				String datescanned = txtdatescanned.getText();
				Transactions.addBottle(capacity, width, length, datescanned);
			}
		});

	}
}
