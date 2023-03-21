package application;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;



public class guiBuilder {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if("Nimbus".equals(info.getName()))
						 UIManager.setLookAndFeel(info.getClassName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ActionListener loginFrame  = new LoginFrame();
			}
		});
	}
}
