package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import business_logic.SearchingLogic;
import domain_objects.Reservation;

public class UpdateResController implements ActionListener {

	 private JTextField resnumField;

	public UpdateResController(JTextField resnumField) {
		super();
		this.resnumField = resnumField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Reservation res;
		res =SearchingLogic.searchByResNum(Integer.parseInt(resnumField.getText()));
		
	}
	    
}
