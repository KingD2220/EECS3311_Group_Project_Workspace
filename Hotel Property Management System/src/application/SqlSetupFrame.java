package application;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SqlSetupFrame implements ActionListener {
   public JFrame frame = new JFrame();
   
   public SqlSetupFrame() {
	   host();
	   passWord();
	   window();
	   userName();
	   port();
	   button();
	   frame.setVisible(true);
	   
   }
   private void host() {
    JLabel host = new JLabel("HOST NAME");
    host.setBounds(120, 143, 94, 14);
	frame.getContentPane().add(host);
	JTextField hostText = new JTextField();
	hostText.setBounds(194, 140, 108, 20);
	frame.getContentPane().add(hostText);
	hostText.setColumns(10);
   
   }
   private void passWord() {
	   JLabel passLabel = new JLabel("PASSWORD");
	   passLabel.setBounds(120, 103, 94, 14);
	   frame.getContentPane().add(passLabel);
	   JPasswordField passwordField = new JPasswordField();
	   passwordField.setBounds(194, 100, 108, 20);
	   frame.getContentPane().add(passwordField);
	   passwordField.setColumns(10);
	   
}
   private void userName() {
	   JLabel userLabel = new JLabel("USERNAME");
	   userLabel.setBounds(120, 83, 94, 14);
	   frame.getContentPane().add(userLabel);
	   JTextField userField = new JTextField();
	   userField.setBounds(194, 80, 108, 20);
	   frame.getContentPane().add(userField);
	   userField.setColumns(10);
	   
}
   private void port() {
	   JLabel portLabel = new JLabel("PORT");
	   portLabel.setBounds(120, 123, 94, 14);
	   frame.getContentPane().add(portLabel);
	   JTextField portField =new JTextField();
	   portField.setBounds(194, 120, 108, 20);
	   frame.getContentPane().add(portField);
	   portField.setColumns(10);
	   
}
   public void button() {
	    JButton connectButton = new JButton("Connect");
		connectButton.setBounds(200, 180, 90, 15);
		connectButton.addActionListener(this);
		frame.getContentPane().add(connectButton);
   }
   
   private void window() {
		frame.setBounds(100, 100, 497, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
   }
   
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

public static void main(String[] args) {
	SqlSetupFrame sql = new SqlSetupFrame();
}
   
}

