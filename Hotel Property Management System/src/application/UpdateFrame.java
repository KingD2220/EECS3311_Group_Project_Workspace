package application;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import junit.framework.Protectable;

public class UpdateFrame implements ActionListener {
	public JButton findButton;
	public JButton update; 
	public JTextField resNum;
	public JTextField firstInput;
	public JTextField lastInput;
	public JTextField phoneInput;
	public JTextField addressInput;
	private JFrame frame  = new JFrame();
	public static JTextArea feedback;
	
	public UpdateFrame() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		window();
		
	}
	private void window() {
		JLabel find = new JLabel("Res #"); 
		find.setBounds(30, 9, 94, 14);
		frame.getContentPane().add(find);
		
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(30, 133, 94, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(30, 158, 94, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPhoneNum = new JLabel("Phone Num:");
		lblPhoneNum.setBounds(30, 183, 94, 14);
		frame.getContentPane().add(lblPhoneNum);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 208, 94, 14);
		frame.getContentPane().add(lblAddress);
		
		
		//Customer Info Input
	    resNum = new JTextField();
		resNum.setBounds(84, 9, 108, 20);
		frame.getContentPane().add(resNum);
	    resNum.setColumns(10);
		
	    firstInput = new JTextField();
		firstInput.setBounds(134, 130, 108, 20);
		frame.getContentPane().add(firstInput);
		firstInput.setColumns(10);
				
		lastInput = new JTextField();
		lastInput.setColumns(10);
		lastInput.setBounds(134, 155, 108, 20);
		frame.getContentPane().add(lastInput);
				
		phoneInput = new JTextField();
		phoneInput.setColumns(10);
		phoneInput.setBounds(134, 180, 108, 20);
		frame.getContentPane().add(phoneInput);
				
		addressInput = new JTextField();
		addressInput.setColumns(10);
		addressInput.setBounds(134, 205, 427, 20);
		frame.getContentPane().add(addressInput);
		
	    findButton = new JButton("Search");
		findButton.setBounds(200, 9, 108, 20);
		frame.getContentPane().add(findButton);
		findButton.addActionListener(this);
		
		update = new JButton("Update Reservation");
		update.setBounds(273, 342, 155, 23);
		frame.getContentPane().add(update);
		update.addActionListener(this);
		
		
		feedback = new JTextArea();
		feedback.setBounds(10, 376, 661, 180);
		feedback.setLineWrap(true);
		feedback.setEditable(false);
		JScrollPane scroll = new JScrollPane(feedback);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(feedback);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ReservationController control = new ReservationController(firstInput, lastInput,
				resNum, phoneInput, addressInput);
		System.out.println(resNum.getText());
	
		if (e.getSource()== findButton) {
			control.searchAndDisplay();
		}
		if (e.getSource() == update) {
			control.update();
		}
		
	}
}