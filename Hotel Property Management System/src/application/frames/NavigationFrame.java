package application.frames;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationFrame implements ActionListener{
	
	private JFrame frame = new JFrame();
	private JButton viewProfileButton;
	private JButton createResFrameButton;
	private JButton updateResButton;
	private JButton manageEmployeeButton;
	private JButton roomStatusButton;
	
	NavigationFrame(String role) {
		
		frame.setVisible(true);
		this.window();
		
		//View My Profile Button
		viewProfileButton();
		
		//Display buttons based on role
		enableRoleButtons(role);
	}
	
	//Initialize Frame
    private void window() {
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    
    //Buttons
    private void viewProfileButton() {
    	viewProfileButton = new JButton("View My Profile");
		viewProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewProfileButton.setBounds(200, 34, 296, 102);
		frame.getContentPane().add(viewProfileButton);
		viewProfileButton.addActionListener(this);
    }
    
    private void createResFrameButton() {
    	createResFrameButton = new JButton("Create a Reservation");
		createResFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createResFrameButton.setBounds(200, 166, 296, 102);
		frame.getContentPane().add(createResFrameButton);
		createResFrameButton.addActionListener(this);
    }
    
    private void updateResFrameButton() {
    	updateResButton = new JButton("Update Reservation");
		updateResButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateResButton.setBounds(200, 295, 296, 102);
		frame.getContentPane().add(updateResButton);
		updateResButton.addActionListener(this);
    }
    
    private void manageEmployeeButton() {	
		manageEmployeeButton = new JButton("Manage Employees");
		manageEmployeeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		manageEmployeeButton.setBounds(200, 422, 296, 102);
		frame.getContentPane().add(manageEmployeeButton);
		manageEmployeeButton.addActionListener(this);
	}
    
    private void roomStatusButton() {
		roomStatusButton = new JButton("View Room Status");
		roomStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomStatusButton.setBounds(200, 166, 296, 102);
		frame.getContentPane().add(roomStatusButton);
		roomStatusButton.addActionListener(this);
    }
    
    //Display navigation buttons based on role of user
    private void enableRoleButtons(String role) {
    	if (role == "Housekeeping") {
    		roomStatusButton();
    	}
    	else { //Create buttons shared by employees and managers
    		createResFrameButton();
    		updateResFrameButton();
    	}
    	if (role.equalsIgnoreCase("Manager")) {
    		manageEmployeeButton();
    	}
    }
    
    //Navigate to selected tab when button is pressed
    @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewProfileButton) {
			//Create Profile Frame
		}
		if (e.getSource() == createResFrameButton) {
			new CreateReservationFrame();
		}
		if (e.getSource() == updateResButton) {
			new UpdateFrame();
		}
		if (e.getSource() == manageEmployeeButton) {
			new ManagerFrame();
		}
		if (e.getSource() == roomStatusButton) {
			new HousekeepingFrame();
		}
		
		frame.dispose();
    }
}
