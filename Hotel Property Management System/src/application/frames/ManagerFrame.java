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
    private JLabel payLabel;
    private JButton showJButton;
    private JButton submitJButton;
    private JButton returnButton;
    private JButton addEmployeeButton;
    private JButton searchEmployeesButton;
    private JButton addButton;
    
    
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
		addEmployeeButton();
		searchEmployeeButton();
		addButton();
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
		name.setBounds(130, 123, 115, 20);
		frame.getContentPane().add(name);
		
	    emplyeeName = new JTextField();
	    emplyeeName.setEditable(false);
		emplyeeName.setBounds(257, 123, 158, 23);
		frame.getContentPane().add(emplyeeName);
		emplyeeName.setColumns(10);
	}
    
    private void jobType() {
    	JLabel jobLabel = new JLabel("Job Type:");
		jobLabel.setBounds(130, 157, 74, 14);
		frame.getContentPane().add(jobLabel);
		
		jobType = new JTextField();
		jobType.setEditable(false);
		jobType.setColumns(10);
		jobType.setBounds(257, 154, 108, 23);
		frame.getContentPane().add(jobType);
	}
    
    private void employeeEmail() {
    	JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(130, 183, 53, 14);
		frame.getContentPane().add(emailLabel);
		
		employeeEmail = new JTextField();
		employeeEmail.setEditable(false);
		employeeEmail.setColumns(10);
		employeeEmail.setBounds(257, 185, 181, 23);
		frame.getContentPane().add(employeeEmail);
	}
    
    private void hourlyPay() {
    	JLabel hourlyLabel = new JLabel("Hourly:");
		hourlyLabel.setBounds(130, 225, 94, 14);
		frame.getContentPane().add(hourlyLabel);
		
		hourly = new JTextField();
		hourly.setEditable(false);
		hourly.setColumns(10);
		hourly.setBounds(257, 222, 65, 23);
		frame.getContentPane().add(hourly);
		
	}
    
    private void hoursWorked() {
    	JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
		hoursWorkedLabel.setBounds(344, 225, 94, 14);
		frame.getContentPane().add(hoursWorkedLabel);
		
		hoursWorked = new JTextField();
		hoursWorked.setEditable(false);
		hoursWorked.setColumns(10);
		hoursWorked.setBounds(453, 222, 58, 23);
		frame.getContentPane().add(hoursWorked);
	}
    
    private void pay() {
    	payLabel = new JLabel("Pay:");
		payLabel.setBounds(130, 260, 34, 14);
		frame.getContentPane().add(payLabel);
		
		pay = new JTextField();
		pay.setEditable(false);
		pay.setColumns(10);
		pay.setBounds(257, 254, 84, 23);
		frame.getContentPane().add(pay);
		
		submitJButton = new JButton("SUBMIT");
		submitJButton.addActionListener(this);
		submitJButton.setBounds(367, 256, 74, 19);
		frame.getContentPane().add(submitJButton);
	}
    
    //Add employee button to change view to add employees
    private void addEmployeeButton() {
    	addEmployeeButton = new JButton("Add an Employee");
		addEmployeeButton.setBounds(361, 350, 150, 23);
		frame.getContentPane().add(addEmployeeButton);
		addEmployeeButton.addActionListener(this);
    }
    
    //Search employee button to change view to search employees
    private void searchEmployeeButton() {
    	searchEmployeesButton = new JButton("Search for Employees");
		searchEmployeesButton.setBounds(130, 350, 150, 23);
		frame.getContentPane().add(searchEmployeesButton);
		searchEmployeesButton.addActionListener(this);
		searchEmployeesButton.setEnabled(false);
    }
    
    private void addButton() {
    	addButton = new JButton("ADD");
		addButton.setBounds(257, 255, 74, 19);
		frame.getContentPane().add(addButton);
		addButton.addActionListener(this);
		addButton.setVisible(false);
    }
    
    //Add employee button pressed
    private void addEmployeeView() {
    	//Show/Hide appropriate buttons and labels
    	addEmployeeButton.setEnabled(false);
    	searchEmployeesButton.setEnabled(true);
    	showJButton.setVisible(false);
    	submitJButton.setVisible(false);
    	addButton.setVisible(true);
    	
    	payLabel.setVisible(false);
    	pay.setVisible(false);
    	
    	//Set fields editable and clear fields
    	fieldsEditable(true);
    	clearFields();
    }
    
    //Search employee button pressed
    private void searchEmployeeView() {
    	//Show/Hide appropriate buttons and labels
    	addEmployeeButton.setEnabled(true);
    	searchEmployeesButton.setEnabled(false);
    	showJButton.setVisible(true);
    	submitJButton.setVisible(true);
    	addButton.setVisible(false);
    	
    	payLabel.setVisible(true);
    	pay.setVisible(true);
    	
    	//Set fields not editable
    	fieldsEditable(false);
    }
    
	//Return to Navigation Frame
	private void returnButton() {
		returnButton = new JButton("<<");
		returnButton.setBounds(537, 11, 68, 18);
		returnButton.setFocusable(false);
		returnButton.setFont(new Font(null, Font.PLAIN, 10));
		frame.getContentPane().add(returnButton);
		returnButton.addActionListener(this);
	}
	
	//Enable/Disable editable fields for Search/Add view
	private void fieldsEditable(boolean editable) {
    	emplyeeName.setEditable(editable);
    	jobType.setEditable(editable);
    	employeeEmail.setEditable(editable);
		hoursWorked.setEditable(editable);
    	hourly.setEditable(editable);
	}
	
	//Clear text fields
	private void clearFields() {
    	emplyeeName.setText("");
    	jobType.setText("");
    	employeeEmail.setText("");
		hoursWorked.setText("");
    	hourly.setText("");
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
		if(e.getSource() == addEmployeeButton) {
			addEmployeeView();
		}
		if(e.getSource() == searchEmployeesButton) {
			searchEmployeeView();
		}
		if(e.getSource() == addButton) {
			//Add employee to list
		}
	}
}
