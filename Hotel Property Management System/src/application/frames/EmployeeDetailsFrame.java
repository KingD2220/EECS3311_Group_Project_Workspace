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

import com.toedter.calendar.JDateChooser;

import application.controllers.ReservationController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeDetailsFrame implements ActionListener {
    
	public JFrame frame = new JFrame();
    public JTextField employeeNum;
    public JButton returnButton;
    public JTextArea roleName;
    public JTextArea firstName;
    public JTextArea lastName;
    public JTextArea phoneNum;
    public JTextArea address;
    public JTextArea email;
    public JTextArea hoursWorked;
    public JTextArea hourlyPay;
    public JTextArea pay;
    
	public EmployeeDetailsFrame() {
		frame.setVisible(true);
		this.window();
		employeeNum();
		employeeName();
		employeePhoneNumber();
		address();
		hoursWorked();
		email();
		hourlypay();
		pay();
		role();
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
		search.setBounds(67, 54, 94, 14);
		frame.getContentPane().add(search);
		
	    employeeNum = new JTextField();
		employeeNum.setBounds(181, 49, 80, 28);
		frame.getContentPane().add(employeeNum);
	    employeeNum.setColumns(10);
	    
	    JButton submitJButton = new JButton("Search");
		submitJButton.addActionListener(this);
		submitJButton.setBounds(304, 52, 74, 19);
		frame.getContentPane().add(submitJButton);
	} 
    
    //Display employee name
    private void employeeName() {
		JLabel name = new JLabel("First Name:");
		name.setBounds(77, 123, 74, 20);
		frame.getContentPane().add(name);
		
		firstName = new JTextArea();
		firstName.setBounds(181, 117, 150, 31);
		frame.getContentPane().add(firstName);
		
    	JLabel jobLabel = new JLabel("Last Name:");
		jobLabel.setBounds(77, 167, 74, 14);
		frame.getContentPane().add(jobLabel);
		
		lastName = new JTextArea();
		lastName.setBounds(181, 155, 150, 31);
		frame.getContentPane().add(lastName);
		
	}
    
    //Display employeePhoneNumber
    private void employeePhoneNumber() {
    	JLabel emailLabel = new JLabel("Phone Number:");
		emailLabel.setBounds(50, 210, 101, 14);
		frame.getContentPane().add(emailLabel);
		
		phoneNum = new JTextArea();
		phoneNum.setBounds(181, 198, 150, 31);
		frame.getContentPane().add(phoneNum);
		
	}
    
    //Display address
    private void address() {
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(91, 261, 60, 14);
		frame.getContentPane().add(lblAddress);
		
		address = new JTextArea();
		address.setBounds(181, 255, 305, 31);
		frame.getContentPane().add(address);
		
	}
    //Display hours worked
    private void hoursWorked() {
		JLabel lblHoursWorked = new JLabel("Hours Worked:");
		lblHoursWorked.setBounds(50, 341, 101, 14);
		frame.getContentPane().add(lblHoursWorked);
		
		hoursWorked = new JTextArea();
		hoursWorked.setBounds(181, 340, 74, 31);
		frame.getContentPane().add(hoursWorked);
    	
	}
    // display email 
    private void email() {
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(105, 302, 43, 14);
		frame.getContentPane().add(lblEmail);
		
		email = new JTextArea();
		email.setBounds(181, 301, 305, 31);
		frame.getContentPane().add(email);
    	
    }
    // display role
    private void role(){
	JLabel lblRole = new JLabel("Role: ");
	lblRole.setBounds(117, 91, 43, 20);
	frame.getContentPane().add(lblRole);
	
	roleName = new JTextArea();
	roleName.setBounds(183, 83, 150, 31);
	frame.getContentPane().add(roleName);
    }
    
    // display hourly pay 
    private void hourlypay() {
		JLabel lblHourlyPay = new JLabel("Hourly Pay:");
		lblHourlyPay.setBounds(68, 384, 68, 14);
		frame.getContentPane().add(lblHourlyPay);
		
		hourlyPay = new JTextArea();
		hourlyPay.setBounds(181, 377, 74, 31);
		frame.getContentPane().add(hourlyPay);
    }
    
    // display pay
    private void pay() {
		JLabel lblPay = new JLabel("Pay:");
		lblPay.setBounds(105, 422, 34, 14);
		frame.getContentPane().add(lblPay);
		
		pay = new JTextArea();
		pay.setBounds(181, 415, 115, 31);
		frame.getContentPane().add(pay);
    }
    
    private void returnButton() {
		returnButton = new JButton("<<");
		returnButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		returnButton.setFocusable(false);
		returnButton.setBounds(557, 16, 68, 18);
		returnButton.addActionListener(this);
		frame.getContentPane().add(returnButton);
    	
	}
    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnButton) {
			NavigationFrame.showNav();
			frame.dispose();
		}
		
	}
}
