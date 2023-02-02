package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class guiBuilder {

	private JFrame frame;
	private JTextField firstInput;
	private JTextField lastInput;
	private JTextField phoneInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiBuilder window = new guiBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 697, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Customer Info
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(30, 33, 94, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(30, 58, 94, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPhoneNum = new JLabel("Phone Num:");
		lblPhoneNum.setBounds(30, 83, 94, 14);
		frame.getContentPane().add(lblPhoneNum);
		
		//Customer Info Input
		firstInput = new JTextField();
		firstInput.setBounds(134, 30, 108, 20);
		frame.getContentPane().add(firstInput);
		firstInput.setColumns(10);
		
		lastInput = new JTextField();
		lastInput.setColumns(10);
		lastInput.setBounds(134, 55, 108, 20);
		frame.getContentPane().add(lastInput);
		
		phoneInput = new JTextField();
		phoneInput.setColumns(10);
		phoneInput.setBounds(134, 80, 108, 20);
		frame.getContentPane().add(phoneInput);
		
		//Reservation Date Chooser
		JLabel lblCheckinDate = new JLabel("Check-in Date:");
		lblCheckinDate.setBounds(335, 33, 108, 14);
		frame.getContentPane().add(lblCheckinDate);
		
		JLabel lblCheckoutDate = new JLabel("Check-out Date:");
		lblCheckoutDate.setBounds(335, 58, 108, 14);
		frame.getContentPane().add(lblCheckoutDate);
		
		JDateChooser checkInChooser = new JDateChooser();
		checkInChooser.setBounds(453, 33, 108, 20);
		frame.getContentPane().add(checkInChooser);
		
		JDateChooser checkOutChooser = new JDateChooser();
		checkOutChooser.setBounds(453, 58, 108, 20);
		frame.getContentPane().add(checkOutChooser);
		
		//Room Type
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setBounds(30, 161, 94, 14);
		frame.getContentPane().add(lblRoomType);
		
		JComboBox roomSelect = new JComboBox();
		roomSelect.setModel(new DefaultComboBoxModel(new String[] {"King", "Queen", "Double"}));
		roomSelect.setBounds(30, 186, 134, 22);
		frame.getContentPane().add(roomSelect);
		
		//Services
		JLabel lblServices = new JLabel("Services:");
		lblServices.setBounds(30, 237, 94, 14);
		frame.getContentPane().add(lblServices);
		
		JCheckBox parkCheck = new JCheckBox("Parking");
		parkCheck.setBounds(30, 258, 97, 23);
		frame.getContentPane().add(parkCheck);
		
		JCheckBox wifiCheck = new JCheckBox("Wifi");
		wifiCheck.setBounds(134, 258, 97, 23);
		frame.getContentPane().add(wifiCheck);
		
		JCheckBox petCheck = new JCheckBox("Pets");
		petCheck.setBounds(246, 258, 97, 23);
		frame.getContentPane().add(petCheck);
		
		//Create Reservation Button
		JButton createButton = new JButton("Create Reservation");
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {               //Create Reservation is clicked
				System.out.print("it works");
			}
		});
		createButton.setBounds(273, 342, 155, 23);
		frame.getContentPane().add(createButton);
	}
}
