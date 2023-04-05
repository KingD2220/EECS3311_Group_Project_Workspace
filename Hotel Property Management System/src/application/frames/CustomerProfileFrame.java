package application.frames;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerProfileFrame implements ActionListener {
	public JFrame frame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	
	public CustomerProfileFrame() {
		frame.setVisible(true);
		this.window();
		
	}
    //Initialize Frame
    private void window() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 697, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Profiles");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 27, 183, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHeadCount = new JLabel("Head Count");
		lblHeadCount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHeadCount.setBounds(87, 68, 183, 16);
		frame.getContentPane().add(lblHeadCount);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDate.setBounds(155, 111, 183, 16);
		frame.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(228, 68, 130, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 109, 130, 24);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(547, 66, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(547, 109, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 165, 626, 387);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(30, 165, 626, 387);
		frame.getContentPane().add(table);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
