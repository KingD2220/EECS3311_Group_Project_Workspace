package application.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import application.controllers.ManagementController;


public class EmployeeDetailsFrame implements ActionListener {
    
	public JFrame frame = new JFrame();
    public JTextField employeeNum;
    public JTextField roleName;
    public JTextField firstName;
    public JTextField lastName;
    public JTextField phoneNum;
    public JTextField address;
    public JTextField email;
    public JTextField hoursWorked;
    public JTextField hourlyPay;
    public JTextField pay;
    public JButton returnButton;
    public JButton submitJButton;
    
	public EmployeeDetailsFrame() {
		frame.setVisible(true);
		this.window();
		employeeNum();
		employeeName();
		employeePhoneNumber();
		address();
		email();
		hourlypay();
		
		role();
		searchButton();
		returnButton();
		
	}
    
    //Initialize Frame
    private void window() {
		frame.setBounds(100, 100, 631, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    
    //Employee number input
    private void employeeNum() {
    	JLabel search = new JLabel("Employee #"); 
		search.setBounds(48, 27, 94, 14);
		frame.getContentPane().add(search);
		
	    employeeNum = new JTextField();
		employeeNum.setBounds(162, 22, 80, 25);
		frame.getContentPane().add(employeeNum);
	    employeeNum.setColumns(10);
	} 
    
    //Display employee name
    private void employeeName() {
		JLabel firstLabel = new JLabel("First Name:");
		firstLabel.setBounds(48, 133, 74, 20);
		frame.getContentPane().add(firstLabel);
		
		firstName = new JTextField();
		firstName.setEditable(false);
		firstName.setBounds(162, 131, 150, 25);
		frame.getContentPane().add(firstName);
		
    	JLabel lastLabel = new JLabel("Last Name:");
		lastLabel.setBounds(48, 172, 74, 14);
		frame.getContentPane().add(lastLabel);
		
		lastName = new JTextField();
		lastName.setEditable(false);
		lastName.setBounds(162, 167, 150, 25);
		frame.getContentPane().add(lastName);
		
	}
    
    //Display employeePhoneNumber
    private void employeePhoneNumber() {
    	JLabel emailLabel = new JLabel("Phone Number:");
		emailLabel.setBounds(48, 208, 101, 14);
		frame.getContentPane().add(emailLabel);
		
		phoneNum = new JTextField();
		phoneNum.setEditable(false);
		phoneNum.setBounds(162, 203, 150, 25);
		frame.getContentPane().add(phoneNum);
		
	}
    
    //Display address
    private void address() {
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(48, 244, 60, 14);
		frame.getContentPane().add(lblAddress);
		
		address = new JTextField();
		address.setEditable(false);
		address.setBounds(162, 239, 305, 25);
		frame.getContentPane().add(address);
		
	}
    
    //display email 
    private void email() {
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(48, 280, 43, 14);
		frame.getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setEditable(false);
		email.setBounds(162, 275, 305, 25);
		frame.getContentPane().add(email);
    }
    
    //display role
    private void role(){
    	JLabel lblRole = new JLabel("Role: ");
    	lblRole.setBounds(48, 82, 43, 20);
    	frame.getContentPane().add(lblRole);
	
    	roleName = new JTextField();
    	roleName.setEditable(false);
    	roleName.setBounds(162, 80, 150, 25);
    	frame.getContentPane().add(roleName);
    }
    
    //display hourly pay 
    private void hourlypay() {
		JLabel lblHourlyPay = new JLabel("Hourly Pay:");
		lblHourlyPay.setBounds(48, 340, 68, 14);
		frame.getContentPane().add(lblHourlyPay);
		
		hourlyPay = new JTextField();
		hourlyPay.setEditable(false);
		hourlyPay.setBounds(162, 335, 74, 25);
		frame.getContentPane().add(hourlyPay);
    }
    
    //Button to search and display employee info
    private void searchButton() {
    	submitJButton = new JButton("Search");
 		submitJButton.addActionListener(this);
 		submitJButton.setBounds(252, 25, 74, 19);
 		frame.getContentPane().add(submitJButton);
    }
    
    //Button to return to navigation
    private void returnButton() {
		returnButton = new JButton("<<");
		returnButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		returnButton.setFocusable(false);
		returnButton.setBounds(537, 11, 68, 18);
		returnButton.addActionListener(this);
		frame.getContentPane().add(returnButton);
    	
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		ManagementController empDetails = new ManagementController(employeeNum, firstName, lastName, roleName,
											   email, phoneNum, address, hourlyPay);
		
		if (e.getSource() == submitJButton) {
			empDetails.getAndDispEmpl();
		}
		if (e.getSource() == returnButton) {
			NavigationFrame.showNav();
			frame.dispose();
		}
		
	}
}
