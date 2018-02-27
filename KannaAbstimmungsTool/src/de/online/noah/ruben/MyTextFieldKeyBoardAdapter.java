/**
 * 
 */
package de.online.noah.ruben;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

/**
 * @author Noah Ruben
 *
 */
public class MyTextFieldKeyBoardAdapter extends KeyAdapter {

	private JTextField myTextField;
	private int anzahlErlaubterZeichen;

	public MyTextFieldKeyBoardAdapter(JTextField myTextField, int anzahlErlaubterZeichen) {
		this.myTextField = myTextField;
		this.anzahlErlaubterZeichen = anzahlErlaubterZeichen;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		if(myTextField.getText().length() >= anzahlErlaubterZeichen) {
			MyLogger.log("Text out of Bounds");
			e.consume();
		}
	}
}
