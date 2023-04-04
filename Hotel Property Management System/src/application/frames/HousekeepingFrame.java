package application.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import application.controllers.HousekeepingController;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class HousekeepingFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private	JTable table;
	public static DefaultTableModel model;
	private JPanel checkPanel;
	private JRadioButton checkDirty;
	private JRadioButton checkClean;
	private JRadioButton checkInspected;
	private JRadioButton checkOccupied;
	private JRadioButton checkVacant;
	private JRadioButton[] radioButtonArray; 
	private JComboBox<Object> fromComboBox;
	private JComboBox<Object> toComboBox;
	private JButton returnButton;
	private JButton searchButton;
	HousekeepingController ctrl;
	
	public HousekeepingFrame() {
		window();
		roomsDisplay();
		setTableColumnColors();
		radioButtonSelection();
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
	 * Checkboxes for filtering search. Only one button/room status can be selected at a time and searched.
	 */
	private void radioButtonSelection() {
		checkPanel = new JPanel();
		checkPanel.setBounds(10, 36, 246, 171);
		checkPanel.setLayout(null);
		checkPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(checkPanel);
		btnDirty();
		btnClean();
		btnInspected();
		btnOccupied();
		btnVacant();
	}
	
	//set Dirty button
	private void btnDirty() {
		checkDirty = new JRadioButton("Dirty");
		checkDirty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setRadioButtons(checkDirty);			// deselects all other buttons so that user selects only one at a time.
				}	
			}
		});
		checkDirty.setBounds(29, 21, 56, 33);
		checkDirty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkDirty.setFocusable(false);
		checkPanel.add(checkDirty);
	}
	
	//set Clean button
	private void btnClean() {
		checkClean = new JRadioButton("Clean");
		checkClean.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setRadioButtons(checkClean);
				}
			}
		});
		checkClean.setBounds(29, 70, 67, 33);
		checkClean.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkClean.setFocusable(false);
		checkPanel.add(checkClean);
	}
	
	//set inspected button
	private void btnInspected() {
		checkInspected = new JRadioButton("Inspected");
		checkInspected.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setRadioButtons(checkInspected);
			}
		});
		checkInspected.setBounds(29, 115, 100, 33);
		checkInspected.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkInspected.setFocusable(false);
		checkPanel.add(checkInspected);
	}
	
	//set Occupied button
	private void btnOccupied() {
		checkOccupied = new JRadioButton("Occupied");
		checkOccupied.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setRadioButtons(checkOccupied);
			}
		});
		checkOccupied.setBounds(125, 21, 92, 33);
		checkOccupied.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkOccupied.setFocusable(false);
		checkPanel.add(checkOccupied);
	}
	
	//set Vacant button
	private void btnVacant() {
		checkVacant = new JRadioButton("Available");
		checkVacant.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setRadioButtons(checkVacant);
			}
		});
		checkVacant.setBounds(125, 66, 92, 37);
		checkVacant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkVacant.setFocusable(false);
		checkPanel.add(checkVacant);
	}
		
	/**
	 * Radio buttons helper method so only one button can be selected at a time.
	 * @param button - selected button is left as true.
	 */
	private void setRadioButtons(JRadioButton button) {
		radioButtonArray = new JRadioButton[] {checkDirty, checkClean, checkInspected, checkOccupied, checkVacant};
		for (int i = 0; i < radioButtonArray.length; i++) {
			if (radioButtonArray[i].equals(button)) {
				continue;
			} else {
				radioButtonArray[i].setSelected(false);
			}
		}
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
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rangePanel.add(lblFrom);
		
		fromComboBox = boxAdderAscending();
		fromComboBox.setBounds(65, 31, 79, 22);
		rangePanel.add(fromComboBox);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(33, 82, 22, 21);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rangePanel.add(lblTo);

		toComboBox = boxAdderDescending();
		toComboBox.setBounds(65, 81, 79, 22);
		rangePanel.add(toComboBox);

	}
	
	/**
	 * roomRangeSelection() helper method to add all of the room numbers in the hotel.
	 * @return JComboBox filled with all rooms in ascending order.
	 */
	private JComboBox<Object> boxAdderAscending() {
		JComboBox<Object> box = new JComboBox<Object>();
		int[][] roomArray = new int[5][10];		// 5 floors, 10 rooms per floor
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
	
	/**
	 * roomRangeSelection() helper method. 
	 * @return JComboBox with rooms numbers in descending order.
	 */
	private JComboBox<Object> boxAdderDescending() {
		JComboBox<Object> box = new JComboBox<Object>();
		int[][] roomArray = new int[5][10];		// 5 floors, 10 rooms per floor
		int roomNum = 509;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				roomArray[i][j] = roomNum--;
			}
			roomNum = (roomNum-100) + 10;

		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				box.addItem(roomArray[i][j]);
			}
		}
		
		return box;
	}
	
	/**
	 * Display of room numbers, room type, room status, etc. 
	 */
	private void roomsDisplay() {	
		// add column headers to table and make 2nd column cells have drop-down options
		table = new JTable() {
			public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                //create a custom cell editor for the second column
                if (modelColumn == 1) {
                    return (TableCellEditor) new DefaultCellEditor(createComboBox());
                } else {
                    return super.getCellEditor(row, column);
                }
            }
        };
		table.setBounds(10, 288, 663, 264);
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Object[] columnHeaders = {"Room Number", "Room Status", "Room Type", "Reserv. Status", "Arrival Date", "Departure Date"};
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 1;
			}
		};
		model.setColumnIdentifiers(columnHeaders);
		table.setModel(model);
		
		//add scroll capability to room status table
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,218,663,334);
		frame.getContentPane().add(scroll);
		
		//show all rooms and room status by default when frame first appears
		ctrl = new HousekeepingController("100", "509", true, true, true, true, true);
		ctrl.displayRoomDetails();;	
	}
	
	/**
	 * Set color scheme for room status and reservation status columns
	 */
	public void setTableColumnColors() {
		//set colors for room status column depending on values
		TableColumn roomStatusColumn = table.getColumnModel().getColumn(1);
		roomStatusColumn.setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (value.equals("DIRTY")) {
					cell.setBackground(Color.RED);
				} else if (value.equals("CLEAN")) {
					cell.setBackground(new Color(51, 153, 255));
				} else if (value.equals("INSPECTED")) {
					cell.setBackground(Color.GREEN);
				}
				return cell;
			}
		});
		//set colors for reservation status column depending on values
		TableColumn resStatusColumn = table.getColumnModel().getColumn(3);
		resStatusColumn.setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (value.equals("OCCUPIED")) {
					cell.setBackground(Color.RED);
				} else if (value.equals("AVAILABLE")) {
					cell.setBackground(Color.GREEN);
				} 
				return cell;
			}
		});
	}
	
	/**
	 * roomsDisplay() helper method to create/add JComboBox for room status.
	 * When user selects a room status from the combobox, the room status in the database is updated.
	 * @return JComboBox<String>
	 */
	private JComboBox<String> createComboBox() {
		final String[] VALUES = new String[] {"DIRTY", "CLEAN", "INSPECTED"};
		JComboBox<String> roomStatusBox = new JComboBox<>(VALUES);
		roomStatusBox.setEditable(false);
		roomStatusBox.setOpaque(false);
		roomStatusBox.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value.equals("DIRTY")) {
					setBackground(Color.RED);
				} else if (value.equals("CLEAN")) {
					setBackground(new Color(51, 153, 255));
				} else if (value.equals("INSPECTED")) {
					setBackground(Color.GREEN);
				}
				return c;
			}
		});
		
		roomStatusBox.addActionListener(new ActionListener() {
			// listen for user to select an item from the roomStatusBox and make an update call to controller
			boolean doubleClick = false;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (doubleClick) {
					int selectedRow = table.getSelectedRow();
					selectedRow = table.convertRowIndexToModel(selectedRow);
                    Object selected = roomStatusBox.getSelectedItem();
                    if (selectedRow != -1 && selected != null) {
                    	String roomNum = (String) table.getValueAt(selectedRow, 0);
                    	String roomStatus = (String) roomStatusBox.getSelectedItem();
                    	ctrl.roomStatusUpdate(roomNum, roomStatus);
                    }
                    doubleClick = false;
				}
				doubleClick = true;
			}
		});
		return roomStatusBox;
	}
	
	// Buttons
	private void buttons() {		
		returnButton = new JButton("<<");
		returnButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		returnButton.setBounds(605, 11, 68, 18);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);
		frame.getContentPane().add(returnButton);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		buttonsPanel.setBounds(568, 36, 105, 171);
		frame.getContentPane().add(buttonsPanel);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(10, 28, 89, 23);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchButton.setFocusable(false);
		searchButton.addActionListener(this);
		buttonsPanel.add(searchButton);
	}

	/**
	 * Button actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnButton) {
			frame.dispose();
			NavigationFrame.showNav();
		}
		if (e.getSource() == searchButton) {
			model.setRowCount(0);
			//alert user to select one filter button before clicking search
			if ( (checkDirty.isSelected() == false) && (checkClean.isSelected() == false) && (checkInspected.isSelected() == false) && (checkOccupied.isSelected() == false) && (checkVacant.isSelected() == false) ) {
				JOptionPane.showMessageDialog(frame, "Please select at least one checkbox!");
				HousekeepingController ctrl = new HousekeepingController(fromComboBox.getSelectedItem().toString(), toComboBox.getSelectedItem().toString(), true, true, true, true, true);
				ctrl.displayRoomDetails();
			}
			else {
				HousekeepingController ctrl = new HousekeepingController(fromComboBox.getSelectedItem().toString(), toComboBox.getSelectedItem().toString(), checkDirty.isSelected(), checkClean.isSelected(), checkInspected.isSelected(), checkOccupied.isSelected(), checkVacant.isSelected());
				ctrl.displayRoomDetails();
			}	
		}
	}
}



