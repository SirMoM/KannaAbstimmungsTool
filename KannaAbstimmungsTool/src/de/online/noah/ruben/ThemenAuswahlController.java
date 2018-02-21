package de.online.noah.ruben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Beans;

public class ThemenAuswahlController implements ActionListener{

	public ThemenAuswahlController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.out.println(e.getActionCommand());
	}

}
