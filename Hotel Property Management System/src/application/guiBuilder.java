package application;

import java.awt.EventQueue;
import java.awt.event.ActionListener;



public class guiBuilder {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiBuilder window = new guiBuilder();
					ActionListener loginFrame  = new LoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	
}
