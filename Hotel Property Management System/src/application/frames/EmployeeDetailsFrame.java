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


public class EmployeeDetailsFrame implements ActionListener {
    
	public JFrame frame = new JFrame();
    private JTextField employeeNum;
    
    
	public EmployeeDetailsFrame() {
		frame.setVisible(true);
		this.window();
		employeeNum();
		employeeName();
		employeePhoneNumber();
		address();
		hoursWorked();
		email();
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
	    
	    JButton submitJButton = new JButton("Submit");
		submitJButton.addActionListener(this);
		submitJButton.setBounds(347, 53, 74, 19);
		frame.getContentPane().add(submitJButton);
	} 
    
    //Display employee name
    private void employeeName() {
		JLabel name = new JLabel("First Name:");
		name.setBounds(77, 100, 115, 20);
		frame.getContentPane().add(name);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(177, 102, 150, 20);
		frame.getContentPane().add(textArea);
		
    	JLabel jobLabel = new JLabel("Last Name:");
		jobLabel.setBounds(77, 138, 74, 14);
		frame.getContentPane().add(jobLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(177, 137, 150, 20);
		frame.getContentPane().add(textArea_1);
		
	}
    
    //Display employeePhoneNumber
    private void employeePhoneNumber() {
    	JLabel emailLabel = new JLabel("Phone Number:");
		emailLabel.setBounds(50, 177, 101, 14);
		frame.getContentPane().add(emailLabel);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(177, 176, 150, 20);
		frame.getContentPane().add(textArea_2);
		
	}
    
    //Display address
    private void address() {
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(91, 227, 101, 14);
		frame.getContentPane().add(lblAddress);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(177, 226, 150, 20);
		frame.getContentPane().add(textArea_3);
		
	}
    //Display hours worked
    private void hoursWorked() {
		JLabel lblHoursWorked = new JLabel("Hours Worked:");
		lblHoursWorked.setBounds(50, 308, 101, 14);
		frame.getContentPane().add(lblHoursWorked);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(177, 302, 150, 20);
		frame.getContentPane().add(textArea_5);
    	
	}
    // display email 
    private void email() {
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(107, 271, 101, 14);
		frame.getContentPane().add(lblEmail);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(177, 270, 150, 20);
		frame.getContentPane().add(textArea_4);
    	
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
