package application.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import application.controllers.ManagementController;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
public class ManagerFrame implements ActionListener {
    public JFrame frame = new JFrame();
    
    private JTextField employeeNum;
    private JTextField emplyeeName;
    private JTextField jobType;
    private JTextField employeeEmail; 
    private JTextField hourly;
    private JTextField hoursWorked;
    private JTextField pay;
    private JButton showJButton;
    private JButton submitJButton;
    private JButton returnButton;
    
    
	public ManagerFrame() {
		frame.setVisible(true);
		this.window();
		employeeNum();
		employeeName();
		jobType();
		employeeEmail();
		hourlyPay();
		hoursWorked();
		pay();
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
    	JLabel search = new JLabel("Em. #"); 
		search.setBounds(43, 35, 94, 14);
		frame.getContentPane().add(search);
		
	    employeeNum = new JTextField();
		employeeNum.setBounds(41, 49, 65, 23);
		frame.getContentPane().add(employeeNum);
	    employeeNum.setColumns(10);
	    
	    showJButton = new JButton("SHOW");
		showJButton.addActionListener(this);
		showJButton.setBounds(118, 52, 74, 19);
		frame.getContentPane().add(showJButton);
	} 
    //Display employee name
    private void employeeName() {
		JLabel name = new JLabel("Employee Name:");
		name.setBounds(169, 140, 115, 20);
		frame.getContentPane().add(name);
		
	    emplyeeName = new JTextField();
	    emplyeeName.setEditable(false);
		emplyeeName.setBounds(296, 140, 158, 23);
		frame.getContentPane().add(emplyeeName);
		emplyeeName.setColumns(10);
	}
    
    private void jobType() {
    	JLabel jobLabel = new JLabel("Job Type:");
		jobLabel.setBounds(169, 174, 74, 14);
		frame.getContentPane().add(jobLabel);
		
		jobType = new JTextField();
		jobType.setEditable(false);
		jobType.setColumns(10);
		jobType.setBounds(296, 171, 108, 23);
		frame.getContentPane().add(jobType);
	}
    
    private void employeeEmail() {
    	JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(169, 200, 53, 14);
		frame.getContentPane().add(emailLabel);
		
		employeeEmail = new JTextField();
		employeeEmail.setColumns(10);
		employeeEmail.setBounds(296, 202, 181, 23);
		frame.getContentPane().add(employeeEmail);
	}
    
    private void hourlyPay() {
    	JLabel hourlyLabel = new JLabel("Hourly:");
		hourlyLabel.setBounds(169, 242, 94, 14);
		frame.getContentPane().add(hourlyLabel);
		
		hourly = new JTextField();
		hourly.setEditable(false);
		hourly.setColumns(10);
		hourly.setBounds(296, 239, 65, 23);
		frame.getContentPane().add(hourly);
		
	}
    
    private void hoursWorked() {
    	JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
		hoursWorkedLabel.setBounds(383, 242, 94, 14);
		frame.getContentPane().add(hoursWorkedLabel);
		
		hoursWorked = new JTextField();
		hoursWorked.setColumns(10);
		hoursWorked.setBounds(492, 239, 58, 23);
		frame.getContentPane().add(hoursWorked);
	}
    
    private void pay() {
    	JLabel payLabel = new JLabel("Pay:");
		payLabel.setBounds(169, 277, 34, 14);
		frame.getContentPane().add(payLabel);
		
		pay = new JTextField();
		pay.setColumns(10);
		pay.setBounds(296, 271, 84, 23);
		frame.getContentPane().add(pay);
		
		submitJButton = new JButton("SUBMIT");
		submitJButton.addActionListener(this);
		submitJButton.setBounds(411, 273, 84, 19);
		frame.getContentPane().add(submitJButton);
	}
    
	//Return to Navigation Frame
	public void returnButton() {
		returnButton = new JButton("<<");
		returnButton.setBounds(537, 11, 68, 18);
		returnButton.setFocusable(false);
		returnButton.setFont(new Font(null, Font.PLAIN, 10));
		frame.getContentPane().add(returnButton);
		returnButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ManagementController manage = new ManagementController(employeeNum, emplyeeName, jobType,
				 employeeEmail, hourly, hoursWorked, pay);
		if(e.getSource() == showJButton) {
			manage.getAndDispEmpl();
		}
		if(e.getSource() == returnButton) {
			frame.dispose();
			NavigationFrame.showNav();
		}
		
	}
}
