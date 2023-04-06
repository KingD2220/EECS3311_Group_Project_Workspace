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
    private JTextField employeeFirstName;
    private JTextField employeeLastName;
    private JTextField jobType;
    private JTextField employeeEmail; 
    private JTextField hourly;
    private JTextField hoursWorked;
    private JTextField pay;
    private JTextField employeePhone;
    private JTextField employeeAddress;
    private JLabel search;
    private JLabel payLabel;
    private JLabel hoursWorkedLabel;
    private JButton showJButton;
    private JButton submitJButton;
    private JButton returnButton;
    private JButton addEmployeeButton;
    private JButton searchEmployeesButton;
    private JButton addButton;
    public static JLabel feedback;
    
    
	public ManagerFrame() {
		frame.setVisible(true);
		this.window();
		
		employeeNum();
		employeeFirstName();
		employeeLastName();
		jobType();
		employeeEmail();
		employeePhone();
		employeeAddress();
		hourlyPay();
		hoursWorked();
		pay();
		feedback();
		
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
    	search = new JLabel("Em. #"); 
		search.setBounds(42, 11, 94, 14);
		frame.getContentPane().add(search);
		
	    employeeNum = new JTextField();
	    employeeNum.setEditable(true);
		employeeNum.setBounds(40, 25, 65, 23);
		frame.getContentPane().add(employeeNum);
	    employeeNum.setColumns(10);
	    
	    showJButton = new JButton("SHOW");
		showJButton.addActionListener(this);
		showJButton.setBounds(117, 28, 74, 19);
		frame.getContentPane().add(showJButton);
	} 
    //Display employee name
    private void employeeFirstName() {
    	JLabel firstLabel = new JLabel("First  Name:");
		firstLabel.setBounds(130, 66, 115, 20);
		frame.getContentPane().add(firstLabel);
		
		employeeFirstName = new JTextField();
		employeeFirstName.setEditable(false);
		employeeFirstName.setColumns(10);
		employeeFirstName.setBounds(257, 66, 158, 23);
		frame.getContentPane().add(employeeFirstName);
    }
    
    private void employeeLastName() {
		JLabel lastLabel = new JLabel("Last Name:");
		lastLabel.setBounds(130, 97, 115, 20);
		frame.getContentPane().add(lastLabel);
		
	    employeeLastName = new JTextField();
	    employeeLastName.setEditable(false);
		employeeLastName.setBounds(257, 97, 158, 23);
		frame.getContentPane().add(employeeLastName);
		employeeLastName.setColumns(10);
	}
    
    private void jobType() {
    	JLabel jobLabel = new JLabel("Job Type:");
		jobLabel.setBounds(130, 131, 74, 14);
		frame.getContentPane().add(jobLabel);
		
		jobType = new JTextField();
		jobType.setEditable(false);
		jobType.setColumns(10);
		jobType.setBounds(257, 128, 108, 23);
		frame.getContentPane().add(jobType);
	}
    
    private void employeeEmail() {
    	JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(130, 163, 53, 14);
		frame.getContentPane().add(emailLabel);
		
		employeeEmail = new JTextField();
		employeeEmail.setEditable(false);
		employeeEmail.setColumns(10);
		employeeEmail.setBounds(257, 159, 181, 23);
		frame.getContentPane().add(employeeEmail);
	}
    
    private void hourlyPay() {
    	JLabel hourlyLabel = new JLabel("Hourly:");
		hourlyLabel.setBounds(130, 287, 94, 14);
		frame.getContentPane().add(hourlyLabel);
		
		hourly = new JTextField();
		hourly.setEditable(false);
		hourly.setColumns(10);
		hourly.setBounds(257, 284, 65, 23);
		frame.getContentPane().add(hourly);
		
	}
    
    private void hoursWorked() {
    	hoursWorkedLabel = new JLabel("Hours Worked:");
		hoursWorkedLabel.setBounds(344, 287, 94, 14);
		frame.getContentPane().add(hoursWorkedLabel);
		
		hoursWorked = new JTextField();
		hoursWorked.setEditable(true);
		hoursWorked.setColumns(10);
		hoursWorked.setBounds(453, 284, 58, 23);
		frame.getContentPane().add(hoursWorked);
	}
    
    private void employeePhone() {
    	JLabel phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setBounds(130, 197, 94, 14);
		frame.getContentPane().add(phoneLabel);
		
		employeePhone = new JTextField();
		employeePhone.setEditable(false);
		employeePhone.setColumns(10);
		employeePhone.setBounds(257, 193, 181, 23);
		frame.getContentPane().add(employeePhone);
    }
    
    private void employeeAddress() {
    	JLabel adressLabel = new JLabel("Address:");
		adressLabel.setBounds(130, 231, 94, 14);
		frame.getContentPane().add(adressLabel);
		
		employeeAddress = new JTextField();
		employeeAddress.setEditable(false);
		employeeAddress.setColumns(10);
		employeeAddress.setBounds(257, 227, 181, 23);
		frame.getContentPane().add(employeeAddress);
    }
    
    private void pay() {
    	payLabel = new JLabel("Pay:");
		payLabel.setBounds(130, 322, 34, 14);
		frame.getContentPane().add(payLabel);
		
		pay = new JTextField();
		pay.setEditable(false);
		pay.setColumns(10);
		pay.setBounds(257, 316, 84, 23);
		frame.getContentPane().add(pay);
		
		submitJButton = new JButton("SUBMIT");
		submitJButton.addActionListener(this);
		submitJButton.setBounds(367, 318, 74, 19);
		frame.getContentPane().add(submitJButton);
	}
    
    private void feedback() {
		feedback = new JLabel("");
		feedback.setFont(new Font("Tahoma", Font.BOLD, 11));
		feedback.setBounds(10, 414, 595, 14);
		frame.getContentPane().add(feedback);
    }
    
    //Add employee button to change view to add employees
    private void addEmployeeButton() {
    	addEmployeeButton = new JButton("Add an Employee");
		addEmployeeButton.setBounds(361, 367, 150, 23);
		frame.getContentPane().add(addEmployeeButton);
		addEmployeeButton.addActionListener(this);
    }
    
    //Search employee button to change view to search employees
    private void searchEmployeeButton() {
    	searchEmployeesButton = new JButton("Search for Employees");
		searchEmployeesButton.setBounds(130, 367, 150, 23);
		frame.getContentPane().add(searchEmployeesButton);
		searchEmployeesButton.addActionListener(this);
		searchEmployeesButton.setEnabled(false);
    }
    
    private void addButton() {
    	addButton = new JButton("ADD");
		addButton.setBounds(257, 317, 74, 19);
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
    	
    	search.setVisible(false);
    	employeeNum.setVisible(false);
    	
    	hoursWorkedLabel.setVisible(false);
    	hoursWorked.setVisible(false);
    	
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
    	
    	search.setVisible(true);
    	employeeNum.setVisible(true);
    	
    	hoursWorkedLabel.setVisible(true);
    	hoursWorked.setVisible(true);
    	
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
		employeeFirstName.setEditable(editable);
    	employeeLastName.setEditable(editable);
    	jobType.setEditable(editable);
    	employeeEmail.setEditable(editable);
    	employeePhone.setEditable(editable);
    	employeeAddress.setEditable(editable);
    	hourly.setEditable(editable);
	}
	
	//Clear text fields
	private void clearFields() {
		employeeNum.setText("");
		employeeFirstName.setText("");
    	employeeLastName.setText("");
    	jobType.setText("");
    	employeeEmail.setText("");
    	employeePhone.setText("");
    	employeeAddress.setText("");
		hoursWorked.setText("");
    	hourly.setText("");
    	pay.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ManagementController manage = new ManagementController(employeeNum, employeeFirstName, employeeLastName, jobType,
				 employeeEmail, employeePhone, employeeAddress, hourly);
		
		//reset feedback text
		feedback.setText("");
		
		if(e.getSource() == showJButton) {
			manage.getAndDispEmpl();
		}
		if(e.getSource() == returnButton) {
			frame.dispose();
			NavigationFrame.showNav();
		}
		if(e.getSource() == addEmployeeButton) {
			clearFields();
			addEmployeeView();
		}
		if(e.getSource() == searchEmployeesButton) {
			clearFields();
			searchEmployeeView();
		}
		if(e.getSource() == addButton) {
			if(manage.addEmployee()) {
				clearFields();
			}
		}
		if(e.getSource() == submitJButton) {
			double weeklyWage = Double.parseDouble(hourly.getText()) * Integer.parseInt(hoursWorked.getText());
			String wage = String.format("%.2f", weeklyWage);
			pay.setText(wage);
		}
	}
}
