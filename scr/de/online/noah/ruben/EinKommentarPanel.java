/**
 * 
 */
package de.online.noah.ruben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * @author Noah Ruben
 *
 */
@SuppressWarnings("serial")
public class EinKommentarPanel extends JPanel {
	
	private final Color kanaOrange = new Color(255, 150, 0);
	private final Color black = Color.BLACK;
	
	final Dimension size = new Dimension(500, 100);
	
	Gender gender;
	int age;
	String kommentar;
	int fragenID;
	final String PERSON_INFO = "%s, %s schreibt: ";
	
	JTextArea rawKommentar = new JTextArea();
	TitledBorder genderAndAgeInBorder;
	Border blackline = BorderFactory.createLineBorder(kanaOrange);

	public EinKommentarPanel(Gender gender, int age, String kommentar, int fragenID) {
		super();
		this.gender = gender;
		this.age = age;
		this.kommentar = kommentar;
		this.fragenID = fragenID;
		
		this.setBackground(black);
		
		initAKommentar();
	}
	
	public void initAKommentar() {
		this.setLayout(new GridBagLayout());
		
		genderAndAgeInBorder = BorderFactory.createTitledBorder(blackline, String.format(PERSON_INFO, gender.getBeschreibung(), age));
		genderAndAgeInBorder.setTitleJustification(TitledBorder.LEFT);
		genderAndAgeInBorder.setTitleColor(kanaOrange);
		this.setBorder(genderAndAgeInBorder);
		
		rawKommentar.setText(kommentar);
		rawKommentar.setForeground(kanaOrange);
		rawKommentar.setBackground(black);
		
		
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
