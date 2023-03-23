package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RoleSelectionFrame implements ActionListener {

	private JFrame frame = new JFrame();
	private JButton mgrButton;
	private JButton resoButton;
	private JButton hskpButton;
	
	/**
	 * Launch RoleSelectionFrame
	 */
	public RoleSelectionFrame() {
		window();
		heading();
		mgrButton();
		resoButton();
		hskpButton();
	}
	
	/**
	 * Create contents of frame.
	 */
	private void window() {	
		ImageIcon imageIcon = new ImageIcon("src/application/hotel.png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		frame.setIconImage(imageIcon.getImage());
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}	
	
	/**
	 * Contents of heading label
	 */
	private void heading() {
		JLabel roleLabel = new JLabel("Select your role...");
		roleLabel.setFont(new Font(null, Font.ITALIC, 22));
		roleLabel.setBounds(256, 90, 169, 50);
		frame.getContentPane().add(roleLabel);
	}
	
	/**
	 * Contents of manager button
	 */
	private void mgrButton() {
		mgrButton = new JButton("Manager");
		mgrButton.setBounds(21, 205, 189, 147);
		mgrButton.setFont(new Font(null, Font.BOLD, 18));
		mgrButton.setFocusable(false);
		mgrButton.setBackground(Color.cyan);
		frame.getContentPane().add(mgrButton);
		mgrButton.addActionListener(this);
	}	
	
	/**
	 * Contents of reservation button
	 */
	private void resoButton() {
		String s = "Reservations/\nFront Desk";
		resoButton = new JButton("<html>" + s.replaceAll("\\n", "<br>") + "</html>");	
		resoButton.setBounds(248, 205, 189, 147);
		resoButton.setFont(new Font(null, Font.BOLD, 18));
		resoButton.setFocusable(false);
		resoButton.setBackground(Color.cyan);
		frame.getContentPane().add(resoButton);
		resoButton.addActionListener(this);
	}	
	
	/**
	 * Contents of housekeeping button
	 */
	private void hskpButton() {
		JButton hskpButton = new JButton("Housekeeping");
		hskpButton.setBounds(471, 205, 189, 147);
		hskpButton.setFont(new Font(null, Font.BOLD, 18));
		hskpButton.setFocusable(false);
		hskpButton.setBackground(Color.cyan);
		frame.getContentPane().add(hskpButton);
		hskpButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mgrButton) {
			// do something
		}
		if (e.getSource() == resoButton) {
			new LoginFrame();
			frame.dispose();
		}
		if (e.getSource() == hskpButton) {
			// do something
		}
	}
}
