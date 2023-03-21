package application;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

public class NavigationFrame {
	
	public JFrame frame = new JFrame();
	
	NavigationFrame() {
		this.window();
		createResFrame();
		updateResFrame();
		
		//If account is manager.....................
		managerEmployeeButton();
	}
	
	//Initialize Frame
    private void window() {
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
    }
    
    private void createResFrame() {
    	JButton createResFrameButton = new JButton("Create a Reservation");
		createResFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createResFrameButton.setBounds(200, 55, 296, 102);
		frame.getContentPane().add(createResFrameButton);
    }
    
    private void updateResFrame() {
    	JButton updateResButton = new JButton("Update Reservation");
		updateResButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateResButton.setBounds(200, 200, 296, 102);
		frame.getContentPane().add(updateResButton);
    }
    
    private void managerEmployeeButton() {
		JButton manageEmployeesButton = new JButton("Manage Employees");
		manageEmployeesButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		manageEmployeesButton.setBounds(200, 345, 296, 102);
		frame.getContentPane().add(manageEmployeesButton);
			
	}
}
