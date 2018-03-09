/**
 * 
 */
package de.online.noah.ruben;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * @author i13az81
 *
 */
public class EinKommentarPanel extends JPanel {
	
	final Dimension size = new Dimension(500, 100);
	
	Gender gender;
	int age;
	String kommentar;
	int fragenID;
	final String PERSON_INFO = "%s, %s schreibt: ";
	
	JTextArea rawKommentar = new JTextArea();
	TitledBorder genderAndAgeInBorder;
	Border blackline = BorderFactory.createLineBorder(Color.black);

	public EinKommentarPanel(Gender gender, int age, String kommentar, int fragenID) {
		super();
		this.gender = gender;
		this.age = age;
		this.kommentar = kommentar;
		this.fragenID = fragenID;
		
		this.setBackground(Color.WHITE);
		
		initAKommentar();
	}
	
	public void initAKommentar() {
		this.setLayout(new GridBagLayout());
		
		genderAndAgeInBorder = BorderFactory.createTitledBorder(blackline, String.format(PERSON_INFO, gender.getBeschreibung(), age));
		genderAndAgeInBorder.setTitleJustification(TitledBorder.LEFT);
		this.setBorder(genderAndAgeInBorder);
		
		rawKommentar.setText(kommentar);
		
		
		GridBagConstraints kommentarGridBagConstraints = new GridBagConstraints();
		kommentarGridBagConstraints.fill = GridBagConstraints.BOTH;
		kommentarGridBagConstraints.gridx = 0;
		kommentarGridBagConstraints.gridy = 0;
		kommentarGridBagConstraints.weightx = 3;
		kommentarGridBagConstraints.insets = new Insets(0, 0, 0, 0);
		
		
		kommentarGridBagConstraints.gridy = 1;
		kommentarGridBagConstraints.weighty = 3;

		this.add(rawKommentar, kommentarGridBagConstraints);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		
	}

	
	
}
