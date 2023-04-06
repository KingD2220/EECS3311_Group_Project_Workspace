package application.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	private JLabel lblTotal;
	private JLabel lblCreditCard;
	private JTextField inputArrival;
	private JTextField inputDepart;
	private String resNum = "";
	private String creditCard = "";
	private double total;
	private JTextField inputRoomRate;
	private JTextField inputRoomType;
	private JTextField inputRoomNum;
	private JTextField inputName;
	private JButton btnClose;
	private JButton btnCheckOut;
	private JButton btnRemove;
	private JButton btnPost;
	private JButton btnPayment;
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
		model = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model.setColumnIdentifiers(columnHeader);
		JTable table = new JTable();
		table.setBounds(10, 28, 250, 250);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(250);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(466, 328);
		scroll.setLocation(10, 95);
		frame.getContentPane().add(scroll);	
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(2).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);
		renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
	}
	
	private void topPanel() {
		topPanel = new JPanel();
		topPanel.setBounds(10, 11, 466, 67);
		topPanel.setLayout(null);
		topPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(topPanel);
	
		inputName = new JTextField();
		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		inputName.setEditable(false);
		inputName.setColumns(10);
		inputName.setBounds(62, 35, 113, 24);
		topPanel.add(inputName);
		
		labels();
		setRoomInfoFields();
		setDatesFields();
		setResInfoOnWindow();
		setCreditCardLabel();
	}
	
	//-----------------Labels and textfields-----------------
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
		
		lblTotal = new JLabel();
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(364, 80, 100, 15);
		frame.getContentPane().add(lblTotal);		
	}
	
	private void setCreditCardLabel() {
		lblCreditCard = new JLabel("");
		lblCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreditCard.setBounds(10, 81, 154, 15);
		frame.getContentPane().add(lblCreditCard);
		Reservation res = ctrl.getResInfo(resNum);
		creditCard = res.customer.getCredit_card();
		creditCard = creditCard.substring(0, 4) + "XXXXXXXX" + creditCard.substring(11, 15);
		lblCreditCard.setText(creditCard);
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
		inputRoomType.setHorizontalAlignment(SwingConstants.CENTER);
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
	//-----------------End of labels and textfields-----------------
	
	private void buttons() {
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setBounds(387, 429, 89, 23);
		frame.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheckOut.setBounds(292, 429, 89, 23);
		frame.getContentPane().add(btnCheckOut);
		btnCheckOut.addActionListener(this);
		btnCheckOut.setEnabled(false);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemove.setBounds(101, 429, 89, 23);
		frame.getContentPane().add(btnRemove);
		btnRemove.addActionListener(this);
		btnRemove.setEnabled(false);
		
		btnPost = new JButton("Post");
		btnPost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPost.setBounds(10, 429, 89, 23);
		frame.getContentPane().add(btnPost);
		btnPost.addActionListener(this);
		btnPost.setEnabled(false);
		
		btnPayment = new JButton("Payment");
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPayment.setBounds(200, 429, 89, 23);
		frame.getContentPane().add(btnPayment);
		btnPayment.addActionListener(this);
	}
	
	//display reservation information on window
	private void setResInfoOnWindow() {
		Reservation res = ctrl.getResInfo(resNum);
		inputRoomNum.setText(res.getRoomNum());
		inputName.setText(res.customer.getLast_name() + ", " + res.customer.getFirst_name());
		inputArrival.setText(res.getArrival_date());
		inputDepart.setText(res.getDeparture_date());
		inputRoomRate.setText(ctrl.getRoomRate(resNum));
		inputRoomType.setText(res.getRoomType());
		total = ctrl.displayCharges(res);
		lblTotal.setText("$" + String.format("%.2f", total));
	}

	/**
	 * All action methods for buttons
	 */
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
				btnPayment.setEnabled(false);
				btnCheckOut.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(frame, "Check-Out not successful!");
			}
		}
		if (e.getSource() == btnPayment) {
			DateFormat resDateFormat = new SimpleDateFormat("yy-MM-dd");
			String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd"));
			creditCard = creditCard.substring(8, 16);
			model.addRow(new Object[] {date, "Payment " + creditCard, "($" + String.format("%.2f", total) + ")"});
			lblTotal.setText("$0.00");
			btnCheckOut.setEnabled(true);
		}
	}

}
