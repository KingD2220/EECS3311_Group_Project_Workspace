package application.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import application.controllers.AccountsController;

public class LoginFrame implements ActionListener {
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton registerButton;
	private JButton loginButton;
	private JButton returnButton;
	private JLabel loginMsg;
	private JLabel roleLabel;
	private JComboBox<String> roleSelect;
	private JFrame frame  = new JFrame();
	
	/**
	 * Launch login window
	 */
	public LoginFrame() {
		window();
		labels();
		inputFields();
		buttons();
		roleComboBox();
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
		
		JLabel lblPassword = new JLabel("Passcode");
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
		usernameInput.setBounds(325, 240, 108, 28);
		frame.getContentPane().add(usernameInput);
	    usernameInput.setColumns(10);
	    
	    passwordInput = new JPasswordField();
		passwordInput.setBounds(325, 265, 108, 28);
		frame.getContentPane().add(passwordInput);
	    usernameInput.setColumns(10);
	}    
	   
	private void roleComboBox() {
		JLabel roleLabel = new JLabel("Job Type:");
		roleLabel.setBounds(477, 244, 94, 14);
		frame.getContentPane().add(roleLabel);
		
		roleSelect = new JComboBox<>();
		roleSelect.setModel(new DefaultComboBoxModel<>(new String[] {"Manager", "Front Desk", "Housekeeping", "Admin"}));
		roleSelect.setBounds(477, 265, 94, 22);
		frame.getContentPane().add(roleSelect);
	}
	// register & login buttons 
	private void buttons() {
	    registerButton = new JButton("Register");
	    registerButton.setBounds(250, 295, 90, 25);
	    registerButton.setFocusable(false);
	    frame.getContentPane().add(registerButton);
	    registerButton.addActionListener(this);
	    
	    loginButton = new JButton("Login");
		loginButton.setBounds(342, 295, 90, 25);
		loginButton.setFocusable(false);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(this);
		
		/*
		 * //Return to role selection screen returnButton = new JButton("<<");
		 * returnButton.setBounds(10, 9, 50, 20); returnButton.setFocusable(false);
		 * returnButton.setFont(new Font(null, Font.PLAIN, 10));
		 * frame.getContentPane().add(returnButton);
		 * returnButton.addActionListener(this);
		 */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// login button verifies user credentials 
		if (e.getSource() == loginButton) {
			try {
				// check if user input is valid
				if (AccountsController.accountVerification(usernameInput.getText(), String.valueOf(passwordInput.getPassword()),
						roleSelect.getSelectedItem().toString())) {
					NavigationFrame createFrame = new NavigationFrame(roleSelect.getSelectedItem().toString());
					frame.dispose();
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
					loginMsg.setText(AccountsController.registerAccount(usernameInput.getText(), String.valueOf(passwordInput.getPassword()),
							roleSelect.getSelectedItem().toString()));
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
		
		/*
		 * if (e.getSource() == returnButton) { new RoleSelectionFrame();
		 * frame.dispose(); }
		 */
		
	}

}
