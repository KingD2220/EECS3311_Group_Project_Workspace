package application;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

public class NavigationFrame {
	
	public JFrame frame = new JFrame();
	
	NavigationFrame() {
		this.window();
		
		//View My Profile Button
		viewProfileButton();
		
		//Create and update button
		createResFrameButton();
		updateResFrameButton();
		
		//If account is manager.....................
		managerEmployeeButton();
	}
	
	//Initialize Frame
    private void window() {
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    private void viewProfileButton() {
    	JButton viewProfileButton = new JButton("View My Profile");
		viewProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewProfileButton.setBounds(200, 34, 296, 102);
		frame.getContentPane().add(viewProfileButton);
    }
    private void createResFrameButton() {
    	JButton createResFrameButton = new JButton("Create a Reservation");
		createResFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createResFrameButton.setBounds(200, 166, 296, 102);
		frame.getContentPane().add(createResFrameButton);
    }
    
    private void updateResFrameButton() {
    	JButton updateResButton = new JButton("Update Reservation");
		updateResButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateResButton.setBounds(200, 295, 296, 102);
		frame.getContentPane().add(updateResButton);
    }
    
    private void managerEmployeeButton() {	
		JButton manageEmployeeButon = new JButton("Manage Employees");
		manageEmployeeButon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		manageEmployeeButon.setBounds(200, 422, 296, 102);
		frame.getContentPane().add(manageEmployeeButon);
			
	}
}
