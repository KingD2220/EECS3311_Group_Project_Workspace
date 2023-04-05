package application.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import application.controllers.CheckInCheckOutController;
import application.controllers.HousekeepingController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckInCheckOutFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private JTable table;
	public static DefaultTableModel model;
	private JPanel queryPanel;
	private JPanel buttonsPanel;
	private JTextField resNumInput;
	private JTextField roomNumInput;
	private JTextField dateField;
    private JRadioButton rdbtnArr;
    private JRadioButton rdbtnDep;
    private JButton returnButton;
    private JButton btnCheckIn;
    private JButton btnCheckOut;
    private JButton btnSearch;
    private JButton btnCancel;
	
	public CheckInCheckOutFrame() {
		window();
		queryPanel();
		reservationsDisplay();
		buttonsPanel();
	}
	
	/**
	 * Launch basic window
	 */
	private void window() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Arrivals/Departures");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeader.setBounds(25, 11, 120, 24);
		frame.getContentPane().add(lblHeader);
		
		returnButton = new JButton("<<");
		returnButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		returnButton.setBounds(605, 11, 68, 18);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);
		frame.getContentPane().add(returnButton);
	}
	
	//-------------------labels and textfields----------------------
	private void queryPanel() {
		//create panel
		queryPanel = new JPanel();
		queryPanel.setBounds(10, 38, 560, 178);
		queryPanel.setLayout(null);
		queryPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(queryPanel);
		resInputComponents();
		roomInputComponents();
		dateOutput();
		radioButtons();

	}
	
	private void resInputComponents() {
		JLabel lblResNum = new JLabel("Reservation No.");
		lblResNum.setBounds(22, 25, 97, 20);
		queryPanel.add(lblResNum);
		lblResNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		resNumInput = new JTextField();
		resNumInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		resNumInput.setBounds(129, 25, 99, 24);
		queryPanel.add(resNumInput);
		resNumInput.setColumns(10);
	}
	
	private void roomInputComponents() {
		JLabel lblRoomNum = new JLabel("Room No.");
		lblRoomNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRoomNum.setBounds(57, 80, 59, 20);
		queryPanel.add(lblRoomNum);
		
		roomNumInput = new JTextField();
		roomNumInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		roomNumInput.setColumns(10);
		roomNumInput.setBounds(129, 79, 99, 24);
		queryPanel.add(roomNumInput);
	}
	
	private void dateOutput() {
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(78, 134, 38, 20);
		queryPanel.add(lblDate);
		
		dateField = new JTextField();
		dateField.setHorizontalAlignment(SwingConstants.CENTER);
		dateField.setEditable(false);
		dateField.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateField.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		dateField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		dateField.setColumns(10);
		dateField.setBounds(126, 134, 86, 20);
		queryPanel.add(dateField);
	}
	//------------------End of labels and textfields-----------------
	
	/**
	 * Set radio buttons
	 * Selecting one or the other will disable certain features in window.
	 */
	private void radioButtons() {
		rdbtnArr = new JRadioButton("Arrivals");
		rdbtnArr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					resNumInput.setEditable(true);
					btnCheckIn.setEnabled(true);
					btnCheckOut.setEnabled(false);
					btnCancel.setEnabled(true);
					roomNumInput.setEditable(false);
					roomNumInput.setText("");
					model.setNumRows(0);
				}
			}
		});
		rdbtnArr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnArr.setBounds(326, 25, 111, 23);
		rdbtnArr.setFocusable(false);
		queryPanel.add(rdbtnArr);
		
		rdbtnDep = new JRadioButton("Departures");
		rdbtnDep.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					roomNumInput.setEditable(true);
					btnCheckOut.setEnabled(true);
					btnCheckIn.setEnabled(false);
					btnCancel.setEnabled(false);
					resNumInput.setEditable(false);
					resNumInput.setText("");
					model.setNumRows(0);
				}
			}
		});
		rdbtnDep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDep.setBounds(326, 77, 111, 23);
		rdbtnDep.setFocusable(false);
		queryPanel.add(rdbtnDep);
		
		// place radio buttons in group so only one or the other can be selected;
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnArr);
		buttonGroup.add(rdbtnDep);
	}
	//------------------------End of radio buttons------------------------
	
	/**
	 * Set reservations display
	 */
	private void reservationsDisplay() {
		Object[] columnHeaders = {"Name", "Arrival", "Departure", "Room Type", "Room No.", "Reserv. No."};
		model = new DefaultTableModel() { 
			@Override
			public boolean isCellEditable(int row, int column) {
				if (rdbtnArr.isSelected()) {
					return column == 4;
				} else {
					return false;
				}
			}
		};
		model.setColumnIdentifiers(columnHeaders);
		
		table = new JTable(model) {
			public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                //create a custom cell editor for the second column
                if (modelColumn == 4 && rdbtnArr.isSelected()) {
                    return (TableCellEditor) new DefaultCellEditor(createComboBox());
                } else {
                    return super.getCellEditor(row, column);
                }
            }
        };;
		table.setBounds(10, 288, 663, 264);
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);			
		table.setRowSelectionAllowed(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,218,560,334);
		frame.getContentPane().add(scroll);
		
		//center-align table cell values
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
	 * reservationDisplay() helper method
	 * @return dropdown menu of rooms ready for check-in based on room type
	 */
	private JComboBox<String> createComboBox() {
		HousekeepingController hskpController = new HousekeepingController("100", "509", false, false, true, false, true);
		int selectedRow = table.getSelectedRow();
		String[] rooms = hskpController.getAvailableRooms(table.getValueAt(selectedRow, 3).toString());
		JComboBox<String> roomSelectBox = new JComboBox<>(rooms);
		roomSelectBox.setEditable(false);
		roomSelectBox.setOpaque(false);
		return roomSelectBox;
	}	
	//-----------------------End of reservations display----------------------------
	
	/**
	 * Set buttons panel
	 */
	private void buttonsPanel() {		
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(572, 38, 101, 514);
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(buttonsPanel);
		
		btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(4, 213, 95, 23);
		btnCheckIn.setFocusable(false);
		btnCheckIn.addActionListener(this);
		buttonsPanel.add(btnCheckIn);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(4, 247, 95, 23);
		btnCheckOut.setFocusable(false);
		btnCheckOut.addActionListener(this);
		buttonsPanel.add(btnCheckOut);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(4, 21, 95, 23);
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(this);
		buttonsPanel.add(btnSearch);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFocusable(false);
		btnCancel.setBounds(4, 281, 95, 23);
		btnCancel.addActionListener(this);
		buttonsPanel.add(btnCancel);
	}
	//---------------End of buttons-----------------
	
	//user alert method
	private void alertMsg(String msg) {
		JOptionPane.showMessageDialog(frame, msg);
	}
	
	//common method used in search button action implementation alerting user
	private void checkNullAddRow(Object[] row, String msg) {
		if (row != null) {
			model.addRow(row);
		} else {
			this.alertMsg(msg);
		}
	}

	//all action performed methods to action listeners for this class
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnButton) {
			frame.dispose();
			NavigationFrame.showNav();
		}
		
		//search button clicked w/ empty fields and no selections alerts user
		if (e.getSource() == btnSearch) {	
			CheckInCheckOutController ctrl = new CheckInCheckOutController();
			boolean resNumIsEmpty = resNumInput.getText().isEmpty();
			boolean roomNumIsEmpty = roomNumInput.getText().isEmpty();
			
			if ( !rdbtnArr.isSelected() && !rdbtnDep.isSelected() ) {	//when user doesn't select Arrivals or Departures
				this.alertMsg("Please select Arrivals or Departures!");
			}
			if (rdbtnArr.isSelected() && !resNumIsEmpty) {		//when user searches for a specific arrival w/ reservation number
				model.setRowCount(0);	
				try {
					int n = Integer.parseInt(resNumInput.getText());
					resNumInput.setText("");
				} catch (NumberFormatException e1) {
					alertMsg("Invalid reservation number!");
					resNumInput.setText("");
				}
				Object[] row = ctrl.getResByResNum(resNumInput.getText());
				this.checkNullAddRow(row, "The reservation number does not match today's arrivals");
				resNumInput.setText("");
			}
			if (rdbtnDep.isSelected() && !roomNumIsEmpty) {		//when user searches for a specific departure w/ room number
				model.setRowCount(0);
				try {	//ensure room number input is in the range of the hotel's room numbers, otherwise notify user
					int i = Integer.parseInt(roomNumInput.getText());
					if (100 < i && i < 509) {
						Object[] row = ctrl.getResByRoomNum(roomNumInput.getText());
						model.addRow(row);
						resNumInput.setText("");
					}
				} catch (NumberFormatException e1) {
					alertMsg("Invalid room number!");
					resNumInput.setText("");
				}
			}
			if (rdbtnArr.isSelected() && resNumIsEmpty) {		//when user searches for all arrivals
				model.setRowCount(0);
				boolean flag = ctrl.getResByDate("Arrivals");
				if (flag == false) this.alertMsg("There are no arrivals for today!");
				
			}
			if (rdbtnDep.isSelected() && roomNumIsEmpty) {		//when user searches for all departures
				model.setRowCount(0);
				boolean flag = ctrl.getResByDate("Departures");
				if (flag == false) this.alertMsg("There are no departures for today!");
			}
		}
		
		//check-in button gets selected row/reservation and calls controller to update database 
		if (e.getSource() == btnCheckIn) {
			if (table.getSelectionModel().isSelectionEmpty()) {
				this.alertMsg("Please select a reservation to check-in!");
			}
			else {
				int selectedRow = table.getSelectedRow();
				String roomNum = table.getValueAt(selectedRow, 4).toString();
				String resNum = table.getValueAt(selectedRow, 5).toString();
				
				if (!roomNum.equals("") && roomNum!= null) {
					CheckInCheckOutController ctrl = new CheckInCheckOutController();			
					boolean checkInGood = ctrl.updateResStatus(resNum, roomNum, "Check In");
					if (checkInGood) {
						model.removeRow(selectedRow);
						this.alertMsg("Check-In is successful!");
					} else {
						this.alertMsg("Check-In not sucessful!!");
					}
				} 
				else {
					this.alertMsg("Please ensure a room number has been selected!");
				}
			}
		}
		
		//check-out button gets selected row/reservation and calls controller to update database
		if (e.getSource() == btnCheckOut) {
			if (!table.getSelectionModel().isSelectionEmpty()) {
				int column = 5;
				int row = table.getSelectedRow();
				String resNum = table.getValueAt(row, column).toString();
				BillingFrame billingFrame = new BillingFrame(resNum, table);
			}
			else {
				this.alertMsg("Please select a reservation!");
			}
		}
		
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
				new CheckInCheckOutFrame();
			}
		});
	}
}
