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
    private JTextField employeeNum;
    private JButton returnButton;
    
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
		frame.setBounds(100, 100, 631, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    
    //Employee number input
    private void employeeNum() {
    	JLabel search = new JLabel("Employee #"); 
		search.setBounds(67, 54, 94, 14);
		frame.getContentPane().add(search);
		
	    employeeNum = new JTextField();
		employeeNum.setBounds(173, 49, 158, 23);
		frame.getContentPane().add(employeeNum);
	    employeeNum.setColumns(10);
	    
	    JButton submitJButton = new JButton("Search");
		submitJButton.addActionListener(this);
		submitJButton.setBounds(347, 53, 74, 19);
		frame.getContentPane().add(submitJButton);
	} 
    
    //Display employee name
    private void employeeName() {
		JLabel name = new JLabel("First Name:");
		name.setBounds(77, 123, 115, 20);
		frame.getContentPane().add(name);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(181, 125, 150, 20);
		frame.getContentPane().add(textArea);
		
    	JLabel jobLabel = new JLabel("Last Name:");
		jobLabel.setBounds(77, 167, 74, 14);
		frame.getContentPane().add(jobLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(181, 166, 150, 20);
		frame.getContentPane().add(textArea_1);
		
	}
    
    //Display employeePhoneNumber
    private void employeePhoneNumber() {
    	JLabel emailLabel = new JLabel("Phone Number:");
		emailLabel.setBounds(50, 210, 101, 14);
		frame.getContentPane().add(emailLabel);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(181, 209, 150, 20);
		frame.getContentPane().add(textArea_2);
		
	}
    
    //Display address
    private void address() {
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(91, 261, 101, 14);
		frame.getContentPane().add(lblAddress);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(181, 255, 150, 20);
		frame.getContentPane().add(textArea_3);
		
	}
    //Display hours worked
    private void hoursWorked() {
		JLabel lblHoursWorked = new JLabel("Hours Worked:");
		lblHoursWorked.setBounds(50, 341, 101, 14);
		frame.getContentPane().add(lblHoursWorked);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(181, 340, 150, 20);
		frame.getContentPane().add(textArea_5);
    	
	}
    // display email 
    private void email() {
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(105, 302, 101, 14);
		frame.getContentPane().add(lblEmail);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(181, 301, 150, 20);
		frame.getContentPane().add(textArea_4);
    	
    }
    // display role
    private void role(){
	JLabel lblRole = new JLabel("Role: ");
	lblRole.setBounds(117, 91, 115, 20);
	frame.getContentPane().add(lblRole);
	
	JTextArea textArea = new JTextArea();
	textArea.setBounds(183, 91, 150, 20);
	frame.getContentPane().add(textArea);
    }
    
    // display hourly pay 
    private void hourlypay() {
		JLabel lblHourlyPay = new JLabel("Hourly Pay:");
		lblHourlyPay.setBounds(68, 384, 101, 14);
		frame.getContentPane().add(lblHourlyPay);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(181, 383, 150, 20);
		frame.getContentPane().add(textArea_5);
    }
    
    // display pay
    private void pay() {
		JLabel lblPay = new JLabel("Pay:");
		lblPay.setBounds(117, 416, 101, 14);
		frame.getContentPane().add(lblPay);
		
		JTextArea textArea_5_1 = new JTextArea();
		textArea_5_1.setBounds(181, 415, 150, 20);
		frame.getContentPane().add(textArea_5_1);
    }
    
    private void returnButton() {
		JButton returnButton = new JButton("<<");
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
			frame.dispose();
			NavigationFrame.showNav();
		}
		
	}
}
