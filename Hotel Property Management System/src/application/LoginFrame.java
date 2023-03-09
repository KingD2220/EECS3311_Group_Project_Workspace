package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginFrame implements ActionListener {
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton registerButton;
	private JButton loginButton;
	private JLabel loginMsg;
	private JFrame frame  = new JFrame();
	
	/**
	 * Launch login window
	 */
	public LoginFrame() {
		window();
		labels();
		inputFields();
		buttons();
	}
	
	/**
	 * Create contents of frame.
	 */
	private void window() {	
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	// labels
	private void labels() {	
		ImageIcon image = new ImageIcon("src/application/hotel.png");
		JLabel lblImage = new JLabel();
		lblImage.setIcon(image);
		lblImage.setBounds(215, 20, 250, 250);
		frame.getContentPane().add(lblImage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font(null, Font.BOLD, 14));
		lblUsername.setBounds(250, 240, 94, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font(null, Font.BOLD, 14));
		lblPassword.setBounds(250, 265, 94, 20);
		frame.getContentPane().add(lblPassword);
		
		loginMsg = new JLabel();
		loginMsg.setFont(new Font(null, Font.ITALIC, 12));
		frame.getContentPane().add(loginMsg);
	}	
		
	// user input fields
	private void inputFields() {
		usernameInput = new JTextField();
		usernameInput.setBounds(325, 240, 108, 25);
		frame.getContentPane().add(usernameInput);
	    usernameInput.setColumns(10);
	    
	    passwordInput = new JPasswordField();
		passwordInput.setBounds(325, 265, 108, 25);
		frame.getContentPane().add(passwordInput);
	    usernameInput.setColumns(10);
	}    
	    
	// register & login buttons 
	private void buttons() {
	    registerButton = new JButton("Register");
	    registerButton.setBounds(250, 295, 90, 25);
	    frame.getContentPane().add(registerButton);
	    registerButton.addActionListener(this);
	    
	    loginButton = new JButton("Login");
		loginButton.setBounds(342, 295, 90, 25);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// login button verifies user credentials 
		if (e.getSource() == loginButton) {
			try {
				// check if user input is valid
				if (AccountsController.accountVerification(usernameInput.getText(), String.valueOf(passwordInput.getPassword()))) {
					CreateReservationFrame createFrame = new CreateReservationFrame();
					frame.setVisible(false);
				}
				else {
					// display error msg
					loginMsg.setBounds(175, 320, 500, 30);
					loginMsg.setForeground(Color.RED);
					loginMsg.setText("The credentials you entered are either not registered or incorrect!");
					usernameInput.setText("");
					passwordInput.setText("");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		// register button registers new user
		if (e.getSource() == registerButton) {
			loginMsg.setBounds(300, 320, 150, 30);
			
			// register new user and display appropriate text
			try {
				if (!usernameInput.getText().equals("") || !String.valueOf(passwordInput.getPassword()).equals("")) {
					loginMsg.setForeground(Color.BLACK);
					loginMsg.setText(AccountsController.registerAccount(usernameInput.getText(), String.valueOf(passwordInput.getPassword())));
					usernameInput.setText("");
					passwordInput.setText("");
				}
				else {
					loginMsg.setForeground(Color.RED);
					loginMsg.setText("Invalid entry!");
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
				
		}
		
	}

}
