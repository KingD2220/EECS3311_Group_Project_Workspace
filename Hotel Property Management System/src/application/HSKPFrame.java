package application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Checkbox;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HSKPFrame implements ActionListener {
	private JFrame frame =new JFrame();
	private JTable table;
	DefaultTableModel model;
	JButton logOutButton;
	JButton searchButton;
	JButton selectAllButton;
	JButton clearAllButton;
	
	public HSKPFrame() {
		window();
		roomsDisplay();
		checkBoxSelection();
		roomRangeSelection();
		buttons();
	}
	
	/**
	 * Initialize basic frame
	 */
	private void window() {		
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Room Status");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeader.setBounds(21, 11, 98, 26);
		frame.getContentPane().add(lblHeader);
	}
	
	/**
	 * Display of room numbers, status, conditions, etc. 
	 */
	private void roomsDisplay() {
		Object[] columnHeaders = {"Room Number", "Room Status", "Room Type", "Reserv. Status", "Arrival Date", "Departure Date"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnHeaders);
		
		table = new JTable(model);
		table.setBounds(10, 288, 663, 264);
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,218,663,334);
		frame.getContentPane().add(scroll);
		
		Object[] row = new Object[6];
	}
	
	/**
	 * Checkboxes for filtering search.
	 */
	private void checkBoxSelection() {
		JPanel checkPanel = new JPanel();
		checkPanel.setBounds(10, 36, 246, 171);
		checkPanel.setLayout(null);
		checkPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(checkPanel);
		
		Checkbox checkDirty = new Checkbox("Dirty");
		checkDirty.setBounds(29, 21, 56, 33);
		checkPanel.add(checkDirty);
		checkDirty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		Checkbox checkClean = new Checkbox("Clean");
		checkClean.setBounds(29, 70, 67, 33);
		checkPanel.add(checkClean);
		checkClean.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		Checkbox checkOccupied = new Checkbox("Occupied");
		checkOccupied.setBounds(125, 21, 92, 33);
		checkPanel.add(checkOccupied);
		checkOccupied.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		Checkbox checkVacant = new Checkbox("Vacant");
		checkVacant.setBounds(125, 66, 92, 37);
		checkPanel.add(checkVacant);
		checkVacant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		Checkbox checkInspected = new Checkbox("Inspected");
		checkInspected.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkInspected.setBounds(29, 115, 100, 33);
		checkPanel.add(checkInspected);
	}
	
	/**
	 * ComboBox for client to search specific range of rooms, if desired.
	 */
	private void roomRangeSelection() {
		JPanel rangePanel = new JPanel();
		rangePanel.setBounds(266, 36, 170, 171);
		rangePanel.setLayout(null);
		rangePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(rangePanel);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(23, 32, 42, 21);
		rangePanel.add(lblFrom);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<Object> fromComboBox = comboBoxAdder();
		fromComboBox.setBounds(65, 31, 79, 22);
		rangePanel.add(fromComboBox);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(33, 82, 22, 21);
		rangePanel.add(lblTo);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<Object> toComboBox = comboBoxAdder();
		toComboBox.setBounds(65, 81, 79, 22);
		rangePanel.add(toComboBox);
	}
	
	/**
	 * JComboBox helper method to add all of the room numbers in the hotel.
	 * @return JComboBox filled with all rooms in ascending order.
	 */
	private JComboBox<Object> comboBoxAdder() {
		JComboBox<Object> box = new JComboBox<Object>();
		int[][] roomArray = new int[5][10];		// 5 floor, 10 rooms per floor
		int roomNum = 100;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				roomArray[i][j] = roomNum++;
			}
			roomNum = (roomNum % 9) * 100;

		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				box.addItem(roomArray[i][j]);
			}
		}
		
		return box;
	}
	
	// Buttons
	private void buttons() {		
		logOutButton = new JButton("Logout");
		logOutButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		logOutButton.setBounds(605, 11, 68, 18);
		logOutButton.setFocusable(false);
		logOutButton.addActionListener(this);
		frame.getContentPane().add(logOutButton);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		buttonsPanel.setBounds(568, 36, 105, 171);
		frame.getContentPane().add(buttonsPanel);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(10, 11, 89, 23);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchButton.setFocusable(false);
		searchButton.addActionListener(this);
		buttonsPanel.add(searchButton);
		
		selectAllButton = new JButton("Select All");
		selectAllButton.setBounds(10, 38, 89, 23);
		selectAllButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		selectAllButton.setFocusable(false);
		selectAllButton.addActionListener(this);
		buttonsPanel.add(selectAllButton);
		
		clearAllButton = new JButton("Clear All");
		clearAllButton.setBounds(10, 65, 89, 23);
		clearAllButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clearAllButton.setFocusable(false);
		clearAllButton.addActionListener(this);
		buttonsPanel.add(clearAllButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logOutButton) {
			new RoleSelectionFrame();
			frame.dispose();
		}
		if (e.getSource() == searchButton) {
			//TODO
		}
		if (e.getSource() == selectAllButton) {
			//TODO
		}
		if (e.getSource() == clearAllButton) {
			//TODO
		}
	}
}
