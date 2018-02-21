/**
 * 
 */
package de.online.noah.ruben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;

/**
 * @author i13az81
 *
 */
public class TestActionListener implements ActionListener {
	
	private HauptView view;
	
	
	public TestActionListener(HauptView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Test");
		if (e.getActionCommand().equals("asd")) {
			System.out.println("X");
		}else if (e.getActionCommand().equals("datenErfassen")) {
			view.toggleViews(view.getThemenAuswahlView());
			view.getThemenAuswahlView().doLayout();
//			view.doLayout();
		}
		
	}

}
