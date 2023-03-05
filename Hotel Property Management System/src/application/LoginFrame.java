package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginFrame implements ActionListener {
	private JTextField usernameInput;
	private JTextField passwordInput;
	private JButton registerButton;
	private JButton loginButton;
	JLabel loginFailedMsg;
	private JFrame frame  = new JFrame();
	
	public LoginFrame() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		window();
	}
	
	private void window() {
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 133, 94, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 155, 94, 14);
		frame.getContentPane().add(lblPassword);
		
		//user input fields
		usernameInput = new JTextField();
		usernameInput.setBounds(134, 130, 108, 20);
		frame.getContentPane().add(usernameInput);
	    usernameInput.setColumns(10);
	    
	    passwordInput = new JTextField();
		passwordInput.setBounds(134, 155, 108, 20);
		frame.getContentPane().add(passwordInput);
	    usernameInput.setColumns(10);
	    
	    registerButton = new JButton("Register");
	    registerButton.setBounds(400, 342, 100, 23);
	    frame.getContentPane().add(registerButton);
	    registerButton.addActionListener(this);
	   
	    loginButton = new JButton("Login");
		loginButton.setBounds(273, 342, 100, 23);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(this);
		loginFailedMsg = new JLabel();
		loginFailedMsg.setBounds(273, 542, 350, 23);
		frame.getContentPane().add(loginFailedMsg);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if (e.getSource() == loginButton) {
			if (AccountsController.accountVerification(usernameInput.getText(), passwordInput.getText())) {
				CreateReservationFrame createFrame = new CreateReservationFrame();
				frame.setVisible(false);
			}
			else {
				loginFailedMsg.setText("The username or password is incorrect!");
				
			
			}
			
		}
		
		if (e.getSource() == registerButton) {
			loginFailedMsg.setText(AccountsController.registerAccount(usernameInput.getText(), passwordInput.getText())); 
				
		}
		
	}

}
