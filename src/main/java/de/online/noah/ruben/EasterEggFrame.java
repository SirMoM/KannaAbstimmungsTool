/**
 * 
 */
package de.online.noah.ruben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

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
	 * @param hauptView
	 *            the Frame to put it on top
	 * 
	 */
	public EasterEggFrame(HauptView hauptView) {
		cutomBackground = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pictures/satan.jpg"))));
		setLayout(new BorderLayout());
		add(cutomBackground);
		cutomBackground.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Satan ist mit dir!");
		this.setSize(474, 355);
		this.getContentPane().setBackground(Color.BLACK);
		this.doLayout();
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(hauptView);
		this.setVisible(true);

		MyLogger.log("Finished building Easter Egg");
	}
}
