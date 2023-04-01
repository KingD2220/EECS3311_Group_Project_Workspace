package application.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import application.controllers.HousekeepingController;

import javax.swing.JScrollPane;
import java.awt.Checkbox;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class HousekeepingFrame implements ActionListener {
	private JFrame frame =new JFrame();
	private JTable table;
	public static DefaultTableModel model;
	private Checkbox checkDirty;
	private Checkbox checkClean;
	private Checkbox checkInspected;
	private Checkbox checkOccupied;
	private Checkbox checkVacant;
	private Checkbox[] checkboxArray;
	private JComboBox<Object> fromComboBox;
	private JComboBox<Object> toComboBox;
	private JButton returnButton;
	private JButton searchButton;
	private JButton selectAllButton;
	private JButton clearAllButton;
	private boolean dirty;
	private boolean clean;
	private boolean inspected;
	private boolean occupied;
	private boolean vacant; 
	HousekeepingController ctrl;
	
	public HousekeepingFrame() {
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
	 * Checkboxes for filtering search.
	 */
	private void checkBoxSelection() {
		JPanel checkPanel = new JPanel();
		checkPanel.setBounds(10, 36, 246, 171);
		checkPanel.setLayout(null);
		checkPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(checkPanel);
		
		checkDirty = new Checkbox("Dirty");
		checkDirty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					dirty = true;
				}
				else {
					dirty = false;
				}
			}
		});
		checkDirty.setBounds(29, 21, 56, 33);
		checkDirty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkDirty.setFocusable(false);
		checkPanel.add(checkDirty);
		
		checkClean = new Checkbox("Clean");
		checkClean.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					clean = true;
				}
				else {
					clean = false;
				}
			}
		});
		checkClean.setBounds(29, 70, 67, 33);
		checkClean.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkClean.setFocusable(false);
		checkPanel.add(checkClean);
		
		checkInspected = new Checkbox("Inspected");
		checkInspected.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					inspected = true;
				}
				else {
					inspected = false;
				}
			}
		});
		checkInspected.setBounds(29, 115, 100, 33);
		checkInspected.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkInspected.setFocusable(false);
		checkPanel.add(checkInspected);
		
		checkOccupied = new Checkbox("Occupied");
		checkOccupied.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					occupied = true;
				}
				else {
					occupied = false;
				}
			}
		});
		checkOccupied.setBounds(125, 21, 92, 33);
		checkOccupied.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkOccupied.setFocusable(false);
		checkPanel.add(checkOccupied);
		
		checkVacant = new Checkbox("Available");
		checkVacant.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					vacant = true;
				}
				else {
					vacant = false;
				}
			}
		});
		checkVacant.setBounds(125, 66, 92, 37);
		checkVacant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkVacant.setFocusable(false);
		checkPanel.add(checkVacant);
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
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnHeaders);
		table.setModel(model);
		
		// add scroll capability to room status table
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,218,663,334);
		frame.getContentPane().add(scroll);
		
		// show all rooms and room status by default when frame first appears
		ctrl = new HousekeepingController("100", "509", true, true, true, true, true);
		ctrl.displayRoomDetails();;	
	}
	
	private JComboBox<String> createComboBox() {
		JComboBox<String> roomStatusBox = new JComboBox<>();
		roomStatusBox.setEditable(true);
		roomStatusBox.addItem("DIRTY");
		roomStatusBox.addItem("CLEAN");
		roomStatusBox.addItem("INSPECTED");
		roomStatusBox.setEditable(false);
		
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
                    	
                    	System.out.println(roomNum + ": " + roomStatus);			//remove comment
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

	/**
	 * Button actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		checkboxArray = new Checkbox[] {checkDirty, checkClean, checkInspected, checkOccupied, checkVacant};
	
		if (e.getSource() == returnButton) {
			frame.dispose();
			NavigationFrame.showNav();
		}
		if (e.getSource() == searchButton) {
			model.setRowCount(0);
			if ( (checkDirty.getState() == false) && (checkClean.getState() == false) && (checkInspected.getState() == false) && (checkOccupied.getState() == false) && (checkVacant.getState() == false) ) {
				JOptionPane.showMessageDialog(frame, "Please select at least one checkbox!");
			}
			HousekeepingController ctrl = new HousekeepingController(fromComboBox.getSelectedItem().toString(), toComboBox.getSelectedItem().toString(), dirty, clean, inspected, occupied, vacant);
			ctrl.displayRoomDetails();
		}
		if (e.getSource() == selectAllButton) {
			for (int i = 0; i < checkboxArray.length; i++) {
				if (checkboxArray[i].getState() == false) {
					checkboxArray[i].setState(true);
				}
			}
		}
		if (e.getSource() == clearAllButton) {
			for (int i = 0; i < checkboxArray.length; i++) {
				if (checkboxArray[i].getState() == true) {
					checkboxArray[i].setState(false);
				}
			}	
		}
	}
	
	
	// to be removed later	
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
				ActionListener hskpFrame  = new HousekeepingFrame();

			}
		});
	}
}

