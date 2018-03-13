/**
 * 
 */
package de.online.noah.ruben;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

/**
 * @author Noah Ruben
 * @version 1.0
 */
public class TextFieldMouseListener implements MouseListener {

	private JTextField textField;
	
	/**
	 * 
	 */
	public TextFieldMouseListener(JTextField textField) {
		this.textField = textField;
	}
	
	/**
	 * 
	 */
	public TextFieldMouseListener() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (isNotNullOrDefault()) {
			textField.setText(null);
			MyLogger.log(textField.getName() + " " + "wurde auf leer gesetzt ");
		} else {
			MyLogger.log(textField.getName() + " " + "wurde nicht verändert");
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// Not needed

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// Not needed
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// Not needed
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// Not needed
	}
	
	private boolean isNotNullOrDefault() {
		return textField.getText().equals("JJ") || textField.getText() == null ;
	}
}