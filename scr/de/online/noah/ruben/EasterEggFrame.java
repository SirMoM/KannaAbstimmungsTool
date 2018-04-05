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
 * @version //TODO
 */
public class EasterEggFrame extends JFrame {

	//TODO Relative Path
	JLabel background = new JLabel(new ImageIcon("../KannaAbstimmungsTool/bilder/satan.jpg"));
	
	/**
	 * @param gc
	 */
	public EasterEggFrame(HauptView hauptView) {
	    setLayout(new BorderLayout());
	    add(background);
	    background.setLayout(new FlowLayout());
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
