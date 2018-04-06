/**
 * 
 */
package de.online.noah.ruben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * @author Noah Ruben
 * @created 05.04.2018
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class EasterEggFrame extends JFrame {

	JLabel cutomBackground;
	
	/**
	 * @param hauptView the Frame to put it on top
	 * 
	 */
	public EasterEggFrame(HauptView hauptView) {
		try {
			cutomBackground = new JLabel(new ImageIcon("../bilder/satan.jpg"));
		} catch (Exception exception) {
			MyLogger.log("Could not summon Satan", exception);
		}
		
	    setLayout(new BorderLayout());
	    add(cutomBackground);
	    cutomBackground.setLayout(new FlowLayout());
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    this.setTitle("SATAN ist mit dir");
	    this.setSize(474, 355);
	    this.getContentPane().setBackground(Color.BLACK);
	    this.doLayout();
	    this.setAlwaysOnTop(true);
	    this.setLocationRelativeTo(hauptView);
	    this.setVisible(true);
	    
	    MyLogger.log("Finished building Easter Egg");
	}
}
