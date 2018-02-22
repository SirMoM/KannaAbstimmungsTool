/**
 * 
 */
package de.online.noah.ruben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Noah Ruben
 *
 */
public class MyActionListener implements ActionListener {

	private MyButton myButton;
	
	/**
	 * @param myButton 
	 * 
	 */
	public MyActionListener(MyButton myButton) {
		this.myButton = myButton;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MyLogger.log(e.paramString());
		HauptView hv = (HauptView) myButton.getView();
		hv.setView(hv.getThemenAuswahlView());
	}
	
	

}
