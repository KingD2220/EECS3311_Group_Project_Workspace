package application.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import application.controllers.CheckInCheckOutController;
import domain_objects_Rooms.Reservation;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BillingFrame {
	private JFrame frame = new JFrame("Billing");
	public static DefaultTableModel model;
	private JPanel topPanel;
	private JLabel lblArrivalDate;
	private JLabel lblDepart;
	private JLabel lblRoomRate;
	private JLabel lblRoomType;
	private JLabel lblName;
	private JLabel lblRoomNumber;
	private JTextField inputArrival;
	private JTextField inputDepart;
	public String resNum = "";
	private JTextField inputRoomRate;
	private JTextField inputRoomType;
	private JTextField inputRoomNum;
	private JTextField inputName;
	
	public BillingFrame(String resNum) {
		this.resNum = resNum;
		window();
		table();
		topPanel();
	}
	
	private void window() {
		frame.setVisible(true);
		frame.setSize(450, 450);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	private void table() {
		String[] columnHeader = new String[] {"Date", "Description", "Amount"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnHeader);
		JTable table = new JTable();
		table.setBounds(10, 28, 250, 250);
		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(416, 290);
		scroll.setLocation(10, 76);
		frame.getContentPane().add(scroll);	
	}
	
	private void topPanel() {
		topPanel = new JPanel();
		topPanel.setBounds(10, 11, 416, 61);
		topPanel.setLayout(null);
		topPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(topPanel);
	
		inputName = new JTextField();
		inputName.setHorizontalAlignment(SwingConstants.LEFT);
		inputName.setEditable(false);
		inputName.setColumns(10);
		inputName.setBounds(45, 35, 104, 24);
		topPanel.add(inputName);
		
		labels();
		setRoomInfoFields();
		setDatesFields();
		setResInfo();
	}
	
	private void labels() {
		lblArrivalDate = new JLabel("Arrival");
		lblArrivalDate.setBounds(283, 9, 40, 14);
		topPanel.add(lblArrivalDate);
		
		lblDepart = new JLabel("Depart");
		lblDepart.setBounds(283, 40, 40, 14);
		topPanel.add(lblDepart);
		
		lblRoomRate = new JLabel("Rate");
		lblRoomRate.setBounds(159, 9, 28, 14);
		topPanel.add(lblRoomRate);
		
		lblRoomType = new JLabel("Type");
		lblRoomType.setBounds(159, 40, 28, 14);
		topPanel.add(lblRoomType);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 40, 34, 14);
		topPanel.add(lblName);
		
		lblRoomNumber = new JLabel("Room");
		lblRoomNumber.setBounds(10, 9, 34, 14);
		topPanel.add(lblRoomNumber);
	}
	
	private void setRoomInfoFields() {
		inputRoomRate = new JTextField();
		inputRoomRate.setHorizontalAlignment(SwingConstants.CENTER);
		inputRoomRate.setEditable(false);
		inputRoomRate.setColumns(10);
		inputRoomRate.setBounds(187, 4, 75, 24);
		topPanel.add(inputRoomRate);
		
		inputRoomType = new JTextField();
		inputRoomType.setText((String) null);
		inputRoomType.setHorizontalAlignment(SwingConstants.LEFT);
		inputRoomType.setEditable(false);
		inputRoomType.setColumns(10);
		inputRoomType.setBounds(187, 33, 96, 24);
		topPanel.add(inputRoomType);
		
		inputRoomNum = new JTextField();
		inputRoomNum.setHorizontalAlignment(SwingConstants.CENTER);
		inputRoomNum.setEditable(false);
		inputRoomNum.setColumns(10);
		inputRoomNum.setBounds(45, 4, 60, 24);
		topPanel.add(inputRoomNum);
	}
	
	private void setDatesFields() {
		inputArrival = new JTextField();
		inputArrival.setHorizontalAlignment(SwingConstants.CENTER);
		inputArrival.setEditable(false);
		inputArrival.setBounds(323, 4, 83, 24);
		topPanel.add(inputArrival);
		inputArrival.setColumns(10);
		
		inputDepart = new JTextField();
		inputDepart.setHorizontalAlignment(SwingConstants.CENTER);
		inputDepart.setEditable(false);
		inputDepart.setColumns(10);
		inputDepart.setBounds(323, 35, 83, 24);
		topPanel.add(inputDepart);
	}
	
	private void setResInfo() {
		CheckInCheckOutController ctrl = new CheckInCheckOutController();
		Reservation res = ctrl.getResInfo(resNum);
//--------NEED TO UNCOMMENT ONCE CHECKIN AND ROOM ASSIGNMENT IS DONE--inputRoomNum.setText(res.getRoom().getRoomNum());
		inputName.setText(res.customer.getLast_name() + ", " + res.customer.getFirst_name());
		inputArrival.setText(res.getArrival_date());
		inputDepart.setText(res.getDeparture_date());
//--------inputRoomRate.setText(String.format("%.2f", res.getRoom().getRate()));
		inputRoomType.setText(res.getRoomType());
	}
	
	// main method - delete later
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if("Nimbus".equals(info.getName()))
						 UIManager.setLookAndFeel(info.getClassName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				new BillingFrame(new String("3"));
			}
		});
	}
}
