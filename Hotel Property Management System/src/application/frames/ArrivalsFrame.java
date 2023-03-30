package application.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ArrivalsFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private JTable table;
	public static DefaultTableModel model;
	private JTextField lastNameInput;
	private JTextField firstNameInput;
	private JDateChooser checkInChooser;
	private JDateChooser checkOutChooser;
    SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd");
    JButton logOutButton;
    JButton checkInButton;
    JButton cxlButton;
    JButton searchButton;
    
	
	public ArrivalsFrame() {
		window();
		queryPanel();
		arrivalsDisplay();
		buttonsPanel();
	}
	
	private void window() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Arrivals");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeader.setBounds(25, 11, 55, 24);
		frame.getContentPane().add(lblHeader);
		
		logOutButton = new JButton("Logout");
		logOutButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		logOutButton.setBounds(605, 11, 68, 18);
		logOutButton.setFocusable(false);
		logOutButton.addActionListener(this);
		frame.getContentPane().add(logOutButton);
	}
	
	private void queryPanel() {
		JPanel queryPanel = new JPanel();
		queryPanel.setBounds(10, 38, 568, 178);
		queryPanel.setLayout(null);
		queryPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(queryPanel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(19, 21, 62, 20);
		queryPanel.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lastNameInput = new JTextField();
		lastNameInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastNameInput.setBounds(88, 21, 110, 26);
		queryPanel.add(lastNameInput);
		lastNameInput.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(271, 21, 62, 20);
		queryPanel.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		firstNameInput = new JTextField();
		firstNameInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameInput.setBounds(343, 21, 110, 26);
		queryPanel.add(firstNameInput);
		firstNameInput.setColumns(10);
				
		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArrivalDate.setBounds(19, 71, 62, 20);
		queryPanel.add(lblArrivalDate);
		
		checkInChooser = new JDateChooser();
		checkInChooser.setBounds(344, 71, 150, 26);
		checkInChooser.setDate(new Date());
		queryPanel.add(checkInChooser);
		
		JLabel lblDepartureDate = new JLabel("Departure Date");
		lblDepartureDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartureDate.setBounds(254, 71, 90, 20);
		queryPanel.add(lblDepartureDate);
		
		checkOutChooser = new JDateChooser();
		checkOutChooser.setBounds(88, 71, 150, 26);
		checkOutChooser.setDate(new Date());
		queryPanel.add(checkOutChooser);

	}
	
	private void arrivalsDisplay() {
		Object[] columnHeaders = {"Name", "Arrival Date", "Departure Date", "Reserv. Status", "Room Number", "Room Type"};
		model = new DefaultTableModel() { 
			@Override
			public boolean isCellEditable(int row, int column) {	
				return false;
			}
		};
		model.setColumnIdentifiers(columnHeaders);
		
		table = new JTable(model);
		table.setBounds(10, 288, 663, 264);
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,218,568,334);
		frame.getContentPane().add(scroll);
	}
	
	private void buttonsPanel() {		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(581, 38, 92, 514);
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(buttonsPanel);
		
		checkInButton = new JButton("Check In");
		checkInButton.setBounds(0, 212, 92, 23);
		checkInButton.setFocusable(false);
		buttonsPanel.add(checkInButton);
		
		cxlButton = new JButton("Cancel");
		cxlButton.setBounds(0, 241, 92, 23);
		cxlButton.setFocusable(false);
		buttonsPanel.add(cxlButton);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(0, 21, 92, 23);
		searchButton.setFocusable(false);
		buttonsPanel.add(searchButton);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
