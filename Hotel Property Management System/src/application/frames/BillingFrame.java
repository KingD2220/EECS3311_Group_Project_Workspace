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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillingFrame implements ActionListener {
	private JFrame frame = new JFrame("Billing");
	private JTable table;
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
	private JButton btnClose;
	private JButton btnCheckOut;
	private JButton btnRemove;
	private JButton btnPost;
	CheckInCheckOutController ctrl = new CheckInCheckOutController();
	
	public BillingFrame(String resNum, JTable table) {
		this.resNum = resNum;
		this.table = table;
		window();
		table();
		topPanel();
		buttons();
	}
	
	private void window() {
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setAlwaysOnTop(true);
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
		scroll.setSize(466, 347);
		scroll.setLocation(10, 76);
		frame.getContentPane().add(scroll);	
	}
	
	private void topPanel() {
		topPanel = new JPanel();
		topPanel.setBounds(10, 11, 466, 61);
		topPanel.setLayout(null);
		topPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(topPanel);
	
		inputName = new JTextField();
		inputName.setHorizontalAlignment(SwingConstants.LEFT);
		inputName.setEditable(false);
		inputName.setColumns(10);
		inputName.setBounds(62, 35, 104, 24);
		topPanel.add(inputName);
		
		labels();
		setRoomInfoFields();
		setDatesFields();
		setResInfoOnWindow();
	}
	
	//-----------------Labels and fields-----------------
	private void labels() {
		lblArrivalDate = new JLabel("Arrival");
		lblArrivalDate.setBounds(333, 9, 40, 14);
		topPanel.add(lblArrivalDate);
		
		lblDepart = new JLabel("Depart");
		lblDepart.setBounds(333, 40, 40, 14);
		topPanel.add(lblDepart);
		
		lblRoomRate = new JLabel("Rate");
		lblRoomRate.setBounds(180, 9, 28, 14);
		topPanel.add(lblRoomRate);
		
		lblRoomType = new JLabel("Type");
		lblRoomType.setBounds(180, 40, 28, 14);
		topPanel.add(lblRoomType);
		
		lblName = new JLabel("Name");
		lblName.setBounds(21, 40, 34, 14);
		topPanel.add(lblName);
		
		lblRoomNumber = new JLabel("Room");
		lblRoomNumber.setBounds(21, 9, 34, 14);
		topPanel.add(lblRoomNumber);
	}
	
	private void setRoomInfoFields() {
		inputRoomRate = new JTextField();
		inputRoomRate.setHorizontalAlignment(SwingConstants.CENTER);
		inputRoomRate.setEditable(false);
		inputRoomRate.setColumns(10);
		inputRoomRate.setBounds(218, 4, 75, 24);
		topPanel.add(inputRoomRate);
		
		inputRoomType = new JTextField();
		inputRoomType.setText((String) null);
		inputRoomType.setHorizontalAlignment(SwingConstants.LEFT);
		inputRoomType.setEditable(false);
		inputRoomType.setColumns(10);
		inputRoomType.setBounds(218, 33, 96, 24);
		topPanel.add(inputRoomType);
		
		inputRoomNum = new JTextField();
		inputRoomNum.setHorizontalAlignment(SwingConstants.CENTER);
		inputRoomNum.setEditable(false);
		inputRoomNum.setColumns(10);
		inputRoomNum.setBounds(62, 4, 60, 24);
		topPanel.add(inputRoomNum);
	}
	
	private void setDatesFields() {
		inputArrival = new JTextField();
		inputArrival.setHorizontalAlignment(SwingConstants.CENTER);
		inputArrival.setEditable(false);
		inputArrival.setBounds(373, 4, 83, 24);
		topPanel.add(inputArrival);
		inputArrival.setColumns(10);
		
		inputDepart = new JTextField();
		inputDepart.setHorizontalAlignment(SwingConstants.CENTER);
		inputDepart.setEditable(false);
		inputDepart.setColumns(10);
		inputDepart.setBounds(373, 35, 83, 24);
		topPanel.add(inputDepart);
	}
	//-----------------End of labels and fields-----------------
	
	private void buttons() {
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setBounds(375, 428, 89, 23);
		frame.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheckOut.setBounds(282, 429, 89, 23);
		frame.getContentPane().add(btnCheckOut);
		btnCheckOut.addActionListener(this);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemove.setBounds(187, 429, 89, 23);
		frame.getContentPane().add(btnRemove);
		btnRemove.addActionListener(this);
		
		btnPost = new JButton("Post");
		btnPost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPost.setBounds(94, 429, 89, 23);
		frame.getContentPane().add(btnPost);
		btnPost.addActionListener(this);
	}
	
	private void setResInfoOnWindow() {
		Reservation res = ctrl.getResInfo(resNum);
		inputRoomNum.setText(res.getRoomNum());
		inputName.setText(res.customer.getLast_name() + ", " + res.customer.getFirst_name());
		inputArrival.setText(res.getArrival_date());
		inputDepart.setText(res.getDeparture_date());
//----------inputRoomRate.setText(String.format("%.2f", res.getRoom().getRate()));
		inputRoomType.setText(res.getRoomType());
		
		ctrl.displayCharges(res);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			frame.dispose();
		}
		if (e.getSource() == btnCheckOut) {
			Reservation res = ctrl.getResInfo(resNum);
			int selectedRow = table.getSelectedRow();
			boolean checkOutGood = ctrl.updateResStatus(resNum, res.getRoomNum(), "Check Out");
			if (checkOutGood) {
				JOptionPane.showMessageDialog(frame, "Check-Out successful!");
				CheckInCheckOutFrame.model.removeRow(selectedRow);
			} else {
				JOptionPane.showMessageDialog(frame, "Check-Out not successful!");
			}
		}
	}
		
}
