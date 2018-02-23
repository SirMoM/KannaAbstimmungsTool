/**
 * 
 */
package de.online.noah.ruben;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Noah Ruben
 *
 */
public class MyButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1337L;
	/**
	 * 
	 */

	private String myName; 
	private JFrame view;

	/**
	 * 
	 */
	public MyButton(String name, JFrame viewOfTheButten) {
		this.myName = name;
		this.view = viewOfTheButten;
		this.addActionListener(new MyActionListener(this));
	}

	/**
	 * @param icon
	 */
	public MyButton(Icon icon) {
		super(icon);
	}

	/**
	 * @param a
	 */
	public MyButton(Action a) {
		super(a);
	}

	/**
	 * @param text
	 * @param icon
	 */
	public MyButton(String text, Icon icon) {
		super(text, icon);
	}
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String name) {
		this.myName = name;
	}

	public JFrame getView() {
		return view;
	}

	public void setView(JFrame view) {
		this.view = view;
	}
}
