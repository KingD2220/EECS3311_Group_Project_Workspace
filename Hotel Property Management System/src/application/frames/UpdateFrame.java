package application.frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import application.controllers.ReservationController;
import domain_objects_Rooms.Reservation;

public class UpdateFrame implements ActionListener {
	public JButton findButton;
	public JButton update; 
	public JButton returnButton;
	public JTextField resNum;
	public JTextField firstInput;
	public JTextField lastInput;
	public JTextField phoneInput;
	public JTextField addressInput;
	private JFrame frame  = new JFrame();
	public static JTextArea feedback;
	
	public UpdateFrame() {
		window();
		
		//Customer Info Input
		reservationNumber();
		firstName();
		lastName();
		phoneNumber();
		address();
		
		//Buttons
		findButton();
		updateButton();
		returnButton();
		
		//Feedback Text Window
		feedbackWindow();
	}
	private void window() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	//Reservation Number Input
	public void reservationNumber() {
		JLabel find = new JLabel("Res. #"); 
		find.setBounds(70, 9, 70, 14);
		frame.getContentPane().add(find);
		
	    resNum = new JTextField();
		resNum.setBounds(134, 9, 108, 23);
		frame.getContentPane().add(resNum);
	    resNum.setColumns(10);
	}
	
	//First Name Input
	public void firstName() {
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(30, 133, 94, 14);
		frame.getContentPane().add(lblFirstName);
		
	    firstInput = new JTextField();
		firstInput.setBounds(134, 130, 108, 23);
		frame.getContentPane().add(firstInput);
		firstInput.setColumns(10);
	}
	
	//Last Name Input
	public void lastName() {
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(30, 158, 94, 14);
		frame.getContentPane().add(lblLastName);
		
		lastInput = new JTextField();
		lastInput.setColumns(10);
		lastInput.setBounds(134, 155, 108, 23);
		frame.getContentPane().add(lastInput);
	}
	
	//Phone Number Input
	public void phoneNumber() {
		JLabel lblPhoneNum = new JLabel("Phone Num:");
		lblPhoneNum.setBounds(30, 183, 94, 14);
		frame.getContentPane().add(lblPhoneNum);
		
		phoneInput = new JTextField();
		phoneInput.setColumns(10);
		phoneInput.setBounds(134, 180, 108, 23);
		frame.getContentPane().add(phoneInput);
	}
	
	//Address Input
	public void address() {
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 208, 94, 14);
		frame.getContentPane().add(lblAddress);
				
		addressInput = new JTextField();
		addressInput.setColumns(10);
		addressInput.setBounds(134, 205, 427, 23);
		frame.getContentPane().add(addressInput);
	}
	
	//Find Reservation Button
	public void findButton() {
		findButton = new JButton("Search");
		findButton.setBounds(275, 9, 108, 20);
		frame.getContentPane().add(findButton);
		findButton.addActionListener(this);
	}
	
	//Update Reservation Button
	public void updateButton() {
		update = new JButton("Update Reservation");
		update.setBounds(273, 342, 155, 23);
		frame.getContentPane().add(update);
		update.addActionListener(this);
	}
	
	//Return to previous screen
	public void returnButton() {
		returnButton = new JButton("<<");
		returnButton.setBounds(10, 9, 50, 20);
		returnButton.setFocusable(false);
		returnButton.setFont(new Font(null, Font.PLAIN, 10));
		frame.getContentPane().add(returnButton);
		returnButton.addActionListener(this);
	}
	
	//Feedback Text Window
	public void feedbackWindow() {
		feedback = new JTextArea();
		feedback.setBounds(10, 376, 661, 180);
		feedback.setLineWrap(true);
		feedback.setEditable(false);
		frame.getContentPane().add(feedback);
	}
	
	//Button handler
	@Override
	public void actionPerformed(ActionEvent e) {
		ReservationController control = new ReservationController(firstInput, lastInput,
				resNum, phoneInput, addressInput);
	
		if (e.getSource() == findButton) {
			control.searchAndDisplay();
		}
		if (e.getSource() == update) {
			control.update();
		}
		if (e.getSource() == returnButton) {
			new CreateReservationFrame();
			frame.dispose();
		}
		
	}
}