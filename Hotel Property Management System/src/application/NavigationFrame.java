package application;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationFrame implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JButton viewProfileButton;
	private JButton createResFrameButton;
	private JButton updateResButton;
	private JButton manageEmployeeButon;
	private JButton roomStatusButton;
	
	NavigationFrame() {
		this.window();
		
		//View My Profile Button
		viewProfileButton();
		
		//Get role from database***
		//If account is employee
		createResFrameButton();
		updateResFrameButton();
		
		//If account is manager
		manageEmployeeButton();
		
		//If account is house keeper
		//roomStatusButton();
		
	}
	
	//Initialize Frame
    private void window() {
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    
    private void viewProfileButton() {
    	viewProfileButton = new JButton("View My Profile");
		viewProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewProfileButton.setBounds(200, 34, 296, 102);
		frame.getContentPane().add(viewProfileButton);
    }
    
    private void createResFrameButton() {
    	createResFrameButton = new JButton("Create a Reservation");
		createResFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createResFrameButton.setBounds(200, 166, 296, 102);
		frame.getContentPane().add(createResFrameButton);
    }
    
    private void updateResFrameButton() {
    	updateResButton = new JButton("Update Reservation");
		updateResButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateResButton.setBounds(200, 295, 296, 102);
		frame.getContentPane().add(updateResButton);
    }
    
    private void manageEmployeeButton() {	
		manageEmployeeButon = new JButton("Manage Employees");
		manageEmployeeButon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		manageEmployeeButon.setBounds(200, 422, 296, 102);
		frame.getContentPane().add(manageEmployeeButon);
	}
    
    private void roomStatusButton() {
		roomStatusButton = new JButton("View Room Status");
		roomStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomStatusButton.setBounds(200, 166, 296, 102);
		frame.getContentPane().add(roomStatusButton);
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
		if (e.getSource() == manageEmployeeButon) {
			new ManagerFrame();
		}
		if (e.getSource() == roomStatusButton) {
			new HSKPFrame();
		}
		
		frame.dispose();
    }
}
