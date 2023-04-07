package application.frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;

import application.controllers.ReservationController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateReservationFrame implements ActionListener {
	public JFrame frame = new JFrame();
	private JTextField firstInput;
	private JTextField lastInput;
	private JTextField phoneInput;
	private JTextField addressInput;
	private JPasswordField creditInput;
	public static  JTextArea feedback;
    public	JButton updateButton;
    private JButton clearButton;
    private JButton returnButton;
	private JComboBox<String> roomSelect;
	private JDateChooser checkInChooser;
	private JDateChooser checkOutChooser;
    SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd");
    
    /**
     * Launch reservation window
     */
     CreateReservationFrame() {
    	frame.setVisible(true);
    	this.window();
    	
    	//Customer Info Input
    	firstName();
    	lastName();
    	phoneNumber();
    	address();
		creditCard();
		
		//Reservation Date Chooser
		dateChooser();
		
		//Room Type Selector
		roomSelector();
		
		//Services Checks
		services();
		
		//Feedback Text Window
		feedbackWindow();
		
		//Buttons
		createReservationButton();
		updateButton();
		showCreditCardButton();
		clearButton();
		returnButton();
    }
    
    //Initialize Frame
    private void window() {
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    
    //First name input
    private void firstName() {
    	JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(30, 33, 94, 14);
		frame.getContentPane().add(lblFirstName);
		
		firstInput = new JTextField();
		firstInput.setBounds(134, 30, 108, 25);
		frame.getContentPane().add(firstInput);
		firstInput.setColumns(10);
    }
    
    //Last name input
    private void lastName() {
    	JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(30, 58, 94, 14);
		frame.getContentPane().add(lblLastName);
		
		lastInput = new JTextField();
		lastInput.setColumns(10);
		lastInput.setBounds(134, 55, 108, 26);
		frame.getContentPane().add(lastInput);
    }
    
    //Phone Number Input
    private void phoneNumber() {
    	JLabel lblPhoneNum = new JLabel("Phone Num:");
		lblPhoneNum.setBounds(30, 83, 94, 14);
		frame.getContentPane().add(lblPhoneNum);
		
		phoneInput = new JTextField();
		phoneInput.setColumns(10);
		phoneInput.setBounds(134, 80, 108, 25);
		frame.getContentPane().add(phoneInput);
    }
    
    //Address Input
    private void address() {
    	JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 108, 94, 14);
		frame.getContentPane().add(lblAddress);
		
		addressInput = new JTextField();
		addressInput.setColumns(10);
		addressInput.setBounds(134, 105, 427, 28);
		frame.getContentPane().add(addressInput);
    }
    
    //Credit Card Input
    private void creditCard() {
		JLabel lblCreditCard = new JLabel("Credit Card:");
		lblCreditCard.setBounds(30, 133, 94, 14);
		frame.getContentPane().add(lblCreditCard);
		
		creditInput = new JPasswordField();
		creditInput.setBounds(134, 130, 427, 28);
		creditInput.setEchoChar('\u25cf');
		frame.getContentPane().add(this.creditInput);
    }
    
    //Reservation Date Chooser
    private void dateChooser() {
    	//Check-in Date
		JLabel lblCheckinDate = new JLabel("Check-in Date:");
		lblCheckinDate.setBounds(294, 33, 108, 14);
		frame.getContentPane().add(lblCheckinDate);
		
		checkInChooser = new JDateChooser();
		checkInChooser.setBounds(397, 33, 164, 25);
		frame.getContentPane().add(checkInChooser);
		
		//Check-out Date
		JLabel lblCheckoutDate = new JLabel("Check-out Date:");
		lblCheckoutDate.setBounds(294, 58, 108, 14);
		frame.getContentPane().add(lblCheckoutDate);
		
		checkOutChooser = new JDateChooser();
		checkOutChooser.setBounds(397, 58, 164, 25);
		frame.getContentPane().add(checkOutChooser);
    }
    
    //Room Type Selector
    private void roomSelector() {
    	JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setBounds(30, 179, 94, 14);
		frame.getContentPane().add(lblRoomType);
		
		roomSelect = new JComboBox<>();
		roomSelect.setModel(new DefaultComboBoxModel<>(new String[] {"Standard", "Deluxe", "Suite", "Executive", "Presidential"}));
		roomSelect.setBounds(26, 196, 108, 22);
		frame.getContentPane().add(roomSelect);
    }
    
    //Services Checkboxes
    private void services() {
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
    }
    
    //Feedback Text Window
    private void feedbackWindow() {
		feedback = new JTextArea();
		feedback.setBounds(10, 376, 661, 180);
		feedback.setLineWrap(true);
		feedback.setEditable(false);
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(feedback);
    }

    //Create Reservation Button
    private void createReservationButton() {
		ActionListener create = new ReservationController(firstInput, lastInput, creditInput, //create new reservation controller when pressed
				addressInput, phoneInput, roomSelect, checkInChooser, checkOutChooser);
		JButton createButton = new JButton("Create Reservation");
		createButton.setBounds(273, 342, 155, 23);
		frame.getContentPane().add(createButton);
		createButton.addActionListener(create);
    }
    
    //Update Reservation Button
    private void updateButton() {
	    updateButton = new JButton("Find >>");
		updateButton.setBounds(581, 33, 90, 20);
		updateButton.setFocusable(false);
		updateButton.addActionListener(this);
		frame.getContentPane().add(updateButton);
    }
    
    //Return to Navigation Frame
    private void returnButton() {
		returnButton = new JButton("<<");
		returnButton.setFont(new Font(null, Font.PLAIN, 10));
		returnButton.setBounds(603, 11, 68, 18);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);
		frame.getContentPane().add(returnButton);
    }
    
    private void clearButton() {
	    clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		clearButton.setBounds(603, 347, 68, 18);
		frame.getContentPane().add(clearButton);
    }
    
    //Show/Hide Credit Card Button
    private void showCreditCardButton() {
    	JCheckBox showCreditButton = new JCheckBox("Show/Hide");
		showCreditButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (showCreditButton.isSelected()) {
					creditInput.setEchoChar((char)0);
				}
				else {
					creditInput.setEchoChar('\u25cf');
				}
			}
		});
		showCreditButton.setBounds(571, 129, 100, 23);
		frame.getContentPane().add(showCreditButton);
		
    }
    
	//Button Pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		// if the button pressed is the update button
		if (e.getSource()== updateButton) {
			UpdateFrame upFrame = new UpdateFrame();
			frame.setVisible(false);
		}
		// clears input fields
		if (e.getSource() == clearButton) {
			clearFields();
		}
		// returns user back to navigation frame
		if (e.getSource() == returnButton) {
			frame.dispose();
			NavigationFrame.showNav();
		}
	}
	
	//Clears all input fields
	public void clearFields() {
		firstInput.setText("");
		lastInput.setText("");
		phoneInput.setText("");
		addressInput.setText("");
		creditInput.setText("");
		roomSelect.setSelectedItem("Standard");
		checkInChooser.setCalendar(null);
		checkOutChooser.setCalendar(null);
	}
}
