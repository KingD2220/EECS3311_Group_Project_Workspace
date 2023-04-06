package application.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

import application.controllers.EmployeeDetailsController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeDetailsFrame implements ActionListener {
    
	public JFrame frame = new JFrame();
    public JTextField employeeNum;
    public JTextArea roleName;
    public JTextArea firstName;
    public JTextArea lastName;
    public JTextArea phoneNum;
    public JTextArea address;
    public JTextArea email;
    public JTextArea hoursWorked;
    public JTextArea hourlyPay;
    public JTextArea pay;
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
		
		//***************Delete if not needed (Hidden for now)
		pay();
		hoursWorked();
		
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
		
		firstName = new JTextArea();
		firstName.setEditable(false);
		firstName.setBounds(162, 131, 150, 25);
		frame.getContentPane().add(firstName);
		
    	JLabel lastLabel = new JLabel("Last Name:");
		lastLabel.setBounds(48, 172, 74, 14);
		frame.getContentPane().add(lastLabel);
		
		lastName = new JTextArea();
		lastName.setEditable(false);
		lastName.setBounds(162, 167, 150, 25);
		frame.getContentPane().add(lastName);
		
	}
    
    //Display employeePhoneNumber
    private void employeePhoneNumber() {
    	JLabel emailLabel = new JLabel("Phone Number:");
		emailLabel.setBounds(48, 208, 101, 14);
		frame.getContentPane().add(emailLabel);
		
		phoneNum = new JTextArea();
		phoneNum.setEditable(false);
		phoneNum.setBounds(162, 203, 150, 25);
		frame.getContentPane().add(phoneNum);
		
	}
    
    //Display address
    private void address() {
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(48, 244, 60, 14);
		frame.getContentPane().add(lblAddress);
		
		address = new JTextArea();
		address.setEditable(false);
		address.setBounds(162, 239, 305, 25);
		frame.getContentPane().add(address);
		
	}
    
    //display email 
    private void email() {
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(48, 280, 43, 14);
		frame.getContentPane().add(lblEmail);
		
		email = new JTextArea();
		email.setEditable(false);
		email.setBounds(162, 275, 305, 25);
		frame.getContentPane().add(email);
    }
    
    //display role
    private void role(){
    	JLabel lblRole = new JLabel("Role: ");
    	lblRole.setBounds(48, 82, 43, 20);
    	frame.getContentPane().add(lblRole);
	
    	roleName = new JTextArea();
    	roleName.setEditable(false);
    	roleName.setBounds(162, 80, 150, 25);
    	frame.getContentPane().add(roleName);
    }
    
    //display hourly pay 
    private void hourlypay() {
		JLabel lblHourlyPay = new JLabel("Hourly Pay:");
		lblHourlyPay.setBounds(48, 340, 68, 14);
		frame.getContentPane().add(lblHourlyPay);
		
		hourlyPay = new JTextArea();
		hourlyPay.setEditable(false);
		hourlyPay.setBounds(162, 335, 74, 25);
		frame.getContentPane().add(hourlyPay);
    }
    
    //Display hours worked
    private void hoursWorked() {
		JLabel lblHoursWorked = new JLabel("Hours Worked:");
		lblHoursWorked.setBounds(48, 371, 101, 14);
		frame.getContentPane().add(lblHoursWorked);
		
		hoursWorked = new JTextArea();
		hoursWorked.setEditable(false);
		hoursWorked.setBounds(162, 366, 74, 25);
		frame.getContentPane().add(hoursWorked);
		
		//Delete method if no longer needed
		lblHoursWorked.setVisible(false);
		hoursWorked.setVisible(false);
	}
    
    //display pay
    private void pay() {
		JLabel lblPay = new JLabel("Pay:");
		lblPay.setBounds(48, 402, 34, 14);
		frame.getContentPane().add(lblPay);
		
		pay = new JTextArea();
		pay.setEditable(false);
		pay.setBounds(162, 397, 115, 25);
		frame.getContentPane().add(pay);
		
		//Delete method if no longer needed
		lblPay.setVisible(false);
		pay.setVisible(false);
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
		EmployeeDetailsController empDetails = new EmployeeDetailsController(employeeNum, roleName, firstName, lastName, 
											   phoneNum, address, email, hoursWorked, hourlyPay, pay);
		
		if (e.getSource() == submitJButton) {
			empDetails.getAndDisplayEmployee();
		}
		if (e.getSource() == returnButton) {
			NavigationFrame.showNav();
			frame.dispose();
		}
		
	}
}
