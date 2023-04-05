package application.frames;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationFrame implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private JButton viewProfileButton;
	private JButton createResFrameButton;
	private JButton updateResButton;
	private JButton manageEmployeeButton;
	private JButton roomStatusButton;
	private JButton checkInOutButton;
	private JButton logoutButton;
	
	public NavigationFrame(String role) {
		
		//Reset frame every time a new user logs in
		frame.getContentPane().removeAll();
		frame.repaint();
		frame.setVisible(true);
		this.window();
		
		//Shared Buttons between all users
		viewProfileButton();
		logoutButton();
		
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
		viewProfileButton.setBounds(35, 55, 296, 102);
		frame.getContentPane().add(viewProfileButton);
		viewProfileButton.addActionListener(this);
    }
    
    private void createResFrameButton() {
    	createResFrameButton = new JButton("Create a Reservation");
		createResFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createResFrameButton.setBounds(35, 218, 296, 102);
		frame.getContentPane().add(createResFrameButton);
		createResFrameButton.addActionListener(this);
    }
    
    private void updateResFrameButton() {
    	updateResButton = new JButton("Update Reservation");
		updateResButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateResButton.setBounds(35, 377, 296, 102);
		frame.getContentPane().add(updateResButton);
		updateResButton.addActionListener(this);
    }
    
    private void manageEmployeeButton() {	
		manageEmployeeButton = new JButton("Manage Employees");
		manageEmployeeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		manageEmployeeButton.setBounds(341, 55, 296, 102);
		frame.getContentPane().add(manageEmployeeButton);
		manageEmployeeButton.addActionListener(this);
	}
    
    private void roomStatusButton() {
		roomStatusButton = new JButton("View Room Status");
		roomStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomStatusButton.setBounds(341, 218, 296, 102);
		frame.getContentPane().add(roomStatusButton);
		roomStatusButton.addActionListener(this);
    }
    
    private void checkInOutButton() {
		checkInOutButton = new JButton("Check-in/Check-out");
		checkInOutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		checkInOutButton.setBounds(341, 377, 296, 102);
		frame.getContentPane().add(checkInOutButton);
		checkInOutButton.addActionListener(this);
    }
    
    private void logoutButton() {
		logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font(null, Font.PLAIN, 10));
		logoutButton.setBounds(603, 11, 68, 23);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		frame.getContentPane().add(logoutButton);
    }
    
    //Display navigation buttons based on role of user
    private void enableRoleButtons(String role) {
    	if (role == "Manager" || role == "Admin") {
    		ManagerView();
    	}
    	
    	if (role == "Front Desk") {
    		FrontDeskView();
    	}
    	
    	if (role == "Housekeeping") {
    		HousekeepingView();
    	}
    }
    
    private void ManagerView() {
		createResFrameButton();
		updateResFrameButton();
		manageEmployeeButton();
		roomStatusButton();
		checkInOutButton();
    }
    
    private void FrontDeskView() {
    	viewProfileButton.setBounds(200, 34, 296, 102);
		
		createResFrameButton();
		createResFrameButton.setBounds(200, 166, 296, 102);
		
		updateResFrameButton();
		updateResButton.setBounds(200, 295, 296, 102);
		
		checkInOutButton();
		checkInOutButton.setBounds(200, 422, 296, 102);
    }
    
    private void HousekeepingView() {
    	viewProfileButton.setBounds(200, 34, 296, 102);
		
		roomStatusButton();
		roomStatusButton.setBounds(200, 166, 296, 102);
    }
    
    //Navigate to selected tab when button is pressed
    @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewProfileButton) {
			new EmployeeDetailsFrame();
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
		if (e.getSource() == checkInOutButton) {
			//Create check-in/check-out frame
		}
		if (e.getSource() == logoutButton) {
			frame.dispose();
			new LoginFrame();
		}
		
		frame.setVisible(false);
    }
    
    //Used to go back to Navigation Frame from other frames
    public static void showNav() {
    	frame.setVisible(true);
    }
}
