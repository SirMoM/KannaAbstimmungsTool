/**
 * 
 */
package de.online.noah.ruben;

import java.awt.*;
import javax.swing.*;

/**
 * @author Noah Ruben
 *
 */
public class HauptView extends JFrame {
	
	private JPanel PersonErfassenView = new JPanel();
	private JPanel ThemenAuswahlView = new JPanel();
	
	
	public static final int ROWCOUNT = 1;
	public static final int COLLUMCOUNT = 3;
	public static final String[] COLUMNAMES = new String[] {"Thema 1", "Thema 2", "Thema 3"};
	
	private JButton thema1 = new JButton();
	private JButton thema2 = new JButton();
	private JButton thema3 = new JButton();
	
	public JPanel getPersonErfassenView() {
		return PersonErfassenView;
	}

	public JPanel getThemenAuswahlView() {
		return ThemenAuswahlView;
	}
	
	
	
	
	/**
	 * 
	 */
	public HauptView() {
		super();
		initViews();
		setVisible(true);
		setTitle("Kana Abstimmungs Tool");
	}
	
	public void initViews() {
		this.setSize(1000,500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridLayout(1,1));
		
		createAllComponents();
	
		getPersonErfassenView().setLayout(new GridBagLayout());
		getThemenAuswahlView().setLayout(new GridBagLayout());

		GridBagConstraints themenAuswahlViewConstraints = new GridBagConstraints();

		themenAuswahlViewConstraints.fill = GridBagConstraints.BOTH;
		themenAuswahlViewConstraints.anchor = GridBagConstraints.CENTER;
		themenAuswahlViewConstraints.insets = new Insets(10,10,10,10);
		themenAuswahlViewConstraints.gridwidth = 1;
		themenAuswahlViewConstraints.gridheight = 1;

		themenAuswahlViewConstraints.gridx = 0; 
		themenAuswahlViewConstraints.gridy = 1;
		getThemenAuswahlView().add(thema1);
		
		themenAuswahlViewConstraints.gridy = 2;
		getThemenAuswahlView().add(thema2);
		
		themenAuswahlViewConstraints.gridy = 2;
		getThemenAuswahlView().add(thema3);
		
		getPersonErfassenView().setBackground(Color.CYAN);
		
	}
	
	public void createAllComponents() {
		thema1.setText("Thema 1");
		thema1.setBackground(new Color(0, 255, 0));
		thema2.setText("Thema 2");
		thema2.setBackground(new Color(0, 255, 0));
		thema3.setText("Thema 3");
		thema3.setBackground(new Color(0, 255, 0));
	}
	
	public void toggleViews(JPanel thePanelToShow) {
		getContentPane().removeAll();
		getContentPane().add(thePanelToShow);
	}

}
