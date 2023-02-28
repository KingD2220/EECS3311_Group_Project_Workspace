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
	private JButton loginButton;
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
	    
	    loginButton = new JButton("Login");
		loginButton.setBounds(273, 342, 155, 23);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CreateReservationFrame createFrame = new CreateReservationFrame();
	
		if (e.getSource() == loginButton) {
		}
		
	}

}
