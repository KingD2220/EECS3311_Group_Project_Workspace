package application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import business_logic.ReservationLogic;
import domain_objects.Reservation;
import domain_objects.Room;

public class CreateReservationFrame implements ActionListener {
	public JFrame frame = new JFrame();
	private JTextField firstInput;
	private JTextField lastInput;
	private JTextField phoneInput;
	private JTextField addressInput;
	private JTextField creditCardInput;
	public static  JTextArea feedback;
    public JButton updateButton;
	private JComboBox<Object> roomSelect;
	private JDateChooser checkInChooser;
	private JDateChooser checkOutChooser;
    SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd");
    
    CreateReservationFrame() {
    	frame.setVisible(true);
    	this.window();
    }

    private void window() {
		frame.setBounds(100, 100, 697, 600);
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
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 108, 94, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCreditCard = new JLabel("Credit Card:");
		lblCreditCard.setBounds(30, 133, 94, 14);
		frame.getContentPane().add(lblCreditCard);
		
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
		
		addressInput = new JTextField();
		addressInput.setColumns(10);
		addressInput.setBounds(134, 105, 427, 20);
		frame.getContentPane().add(addressInput);
		
		creditCardInput = new JTextField();
		creditCardInput.setColumns(10);
		creditCardInput.setBounds(134, 130, 427, 20);
		frame.getContentPane().add(creditCardInput);
		
		//Reservation Date Chooser
		JLabel lblCheckinDate = new JLabel("Check-in Date:");
		lblCheckinDate.setBounds(335, 33, 108, 14);
		frame.getContentPane().add(lblCheckinDate);
		
		JLabel lblCheckoutDate = new JLabel("Check-out Date:");
		lblCheckoutDate.setBounds(335, 58, 108, 14);
		frame.getContentPane().add(lblCheckoutDate);
		
		checkInChooser = new JDateChooser();
		checkInChooser.setBounds(453, 33, 108, 20);
		frame.getContentPane().add(checkInChooser);
		
		checkOutChooser = new JDateChooser();
		checkOutChooser.setBounds(453, 58, 108, 20);
		frame.getContentPane().add(checkOutChooser);
		
		//Room Type
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setBounds(30, 179, 94, 14);
		frame.getContentPane().add(lblRoomType);
		
		roomSelect = new JComboBox<Object>();
		roomSelect.setModel(new DefaultComboBoxModel<Object>(new String[] {"Standard", "Deluxe", "Suite", "Executive", "Presidential"}));
		roomSelect.setBounds(30, 204, 134, 22);
		frame.getContentPane().add(roomSelect);
		
		//Services
		JLabel lblServices = new JLabel("Services:");
		lblServices.setBounds(30, 255, 94, 14);
		frame.getContentPane().add(lblServices);
		
		JCheckBox parkCheck = new JCheckBox("Parking");
		parkCheck.setBounds(30, 276, 97, 23);
		frame.getContentPane().add(parkCheck);
		
		JCheckBox wifiCheck = new JCheckBox("Wifi");
		wifiCheck.setBounds(134, 276, 97, 23);
		frame.getContentPane().add(wifiCheck);
		
		JCheckBox petCheck = new JCheckBox("Pets");
		petCheck.setBounds(233, 276, 97, 23);
		frame.getContentPane().add(petCheck);
		
		//Output message
		JLabel lblOutput = new JLabel("");
		lblOutput.setForeground(new Color(0, 0, 0));
		lblOutput.setBounds(10, 376, 661, 124);
		frame.getContentPane().add(lblOutput);
		
		//Error message
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 486, 661, 14);
		frame.getContentPane().add(lblError);
		
		//Output Text
		feedback = new JTextArea();
		feedback.setBounds(10, 376, 661, 180);
		feedback.setLineWrap(true);
		feedback.setEditable(false);
		JScrollPane scroll = new JScrollPane(feedback);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(feedback);
		
		//update button
	    updateButton = new JButton("Find");
		updateButton.setBounds(540, 6, 90, 15);
		updateButton.addActionListener(this);
		frame.getContentPane().add(updateButton);
		
		//create reservation button
		JButton createButton = new JButton("Create Reservation");
		createButton.setBounds(273, 342, 155, 23);
		frame.getContentPane().add(createButton);
		createButton.addActionListener(this);
    }
    
    
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Room room = ReservationLogic.roomAvailable(roomSelect.getSelectedItem().toString()); //check if room is available
		
		if (room != null) {

			Reservation newRes = new Reservation(firstInput.getText(), lastInput.getText(), 
			addressInput.getText(), phoneInput.getText(), creditCardInput.getText());
			newRes.setArrival_date(date.format(checkInChooser.getDate()));
			newRes.setDeparture_date(date.format(checkOutChooser.getDate()));
			newRes.setRoom(room);
			room.roomReserved();
			ReservationLogic.addReservation(newRes);
			feedback.setText(newRes.toString()); //*does not include room info
		}
		else {
			feedback.setText("Error: Selected room is not available.");
		}
		
		if (e.getSource() == updateButton) {
			UpdateFrame upFrame = new UpdateFrame();
			frame.setVisible(false);
		}
	}
	
}
