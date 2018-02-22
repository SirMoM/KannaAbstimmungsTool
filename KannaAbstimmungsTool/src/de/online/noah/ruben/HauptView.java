/**
 * 
 */
package de.online.noah.ruben;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

import javax.swing.*;

/**
 * @author Noah Ruben
 *
 */
public class HauptView extends JFrame {
	
	private JPanel personErfassenView = new JPanel();
	private JPanel themenAuswahlView = new JPanel();
	private JPanel meinungsAbgabeView = new JPanel();
	

//	public static final int ROWCOUNT = 1;
//	public static final int COLLUMCOUNT = 3;
//	public static final String[] COLUMNAMES = new String[] {"Thema 1", "Thema 2", "Thema 3"};
	
	
	
	
	public enum Gender {
		M("m", "Männlich"),
		F("f", "Weiblich"),
		AAH("aah", "Apache Attack Helicopter");
		
		private String code;
		private String beschreibung;
		
		Gender( final String code, final String beschreibung ) {
			this.code = code;
			this.beschreibung = beschreibung;
		}
		
	}
	
	// ThemenAuswahlView Components
	private MyButton thema1 = new MyButton("Thema 1", this);
	private MyButton thema2 = new MyButton("Thema 1", this);
	private MyButton thema3 = new MyButton("Thema 1", this);
	
	// PersonErfassenView Components
	private JTextField introduction = new JTextField();
	
	private JTextField ageTextField = new JTextField();
	private JLabel ageLabel = new JLabel("Alter");
	
	private JComboBox<String> genderComboBox = new JComboBox<>(); 
	private JLabel genderLabel = new JLabel("Geschlecht");
	
	private MyButton datenErfassenButton = new MyButton("datenErfassenButton", this);
	
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
		getThemenAuswahlView().setLayout(new GridLayout());

		GridBagConstraints themenAuswahlViewConstraints = new GridBagConstraints();

		themenAuswahlViewConstraints.fill = GridBagConstraints.BOTH;
		themenAuswahlViewConstraints.anchor = GridBagConstraints.CENTER;
		themenAuswahlViewConstraints.insets = new Insets(10,10,10,10);
		themenAuswahlViewConstraints.gridwidth = 1;
		themenAuswahlViewConstraints.gridheight = 1;

//		themenAuswahlViewConstraints.gridx = 0; 
//		themenAuswahlViewConstraints.gridy = 1;
		getThemenAuswahlView().add(thema1);
		
//		themenAuswahlViewConstraints.gridy = 2;
		getThemenAuswahlView().add(thema2);
		
//		themenAuswahlViewConstraints.gridy = 2;
		getThemenAuswahlView().add(thema3);
		
		GridBagConstraints personenViewConstraints = new GridBagConstraints();
		personenViewConstraints.insets = new Insets(20, 20, 20, 20);

		personenViewConstraints.gridy = 0;
		personenViewConstraints.gridx = 0;
		
		getPersonErfassenView().setBackground(Color.CYAN);
		
		getPersonErfassenView().add(ageLabel, personenViewConstraints);
		
		personenViewConstraints.gridy = 0; 
		personenViewConstraints.gridx = 2;
		personenViewConstraints.fill = GridBagConstraints.HORIZONTAL;
//		personenViewConstraints.
		
		getPersonErfassenView().add(ageTextField, personenViewConstraints);
		
		personenViewConstraints.gridy = 1; 
		personenViewConstraints.gridx = 0;
		
		getPersonErfassenView().add(genderLabel, personenViewConstraints);
		
		personenViewConstraints.gridy = 1; 
		personenViewConstraints.gridx = 2;
		
		getPersonErfassenView().add(genderComboBox, personenViewConstraints);
		
		personenViewConstraints.gridy = 2; 
		personenViewConstraints.gridx = 2;
		
		getPersonErfassenView().add(datenErfassenButton, personenViewConstraints);
		
	}
	
	public void createAllComponents() {
		thema1.setText("Thema 1");
		thema1.setBackground(new Color(0, 255, 0));
		thema1.addActionListener(new TestActionListener(this));
		thema1.setActionCommand("asd");
		System.out.println(thema1.getAction());
		
		thema2.setText("Thema 2");
		thema2.setBackground(new Color(0, 255, 0));
		
		thema3.setText("Thema 3");
		thema3.setBackground(new Color(0, 255, 0));
		
		//PersonenErfassenView Components
		introduction.setText("Bitte Alter und Geschlecht eingtagen");		

		ageTextField.setText("yy");
		ageTextField.setEditable(true);
		System.out.println("With: " + ageTextField.getSize().getWidth() + "Height :" + ageTextField.getSize().getHeight());
		
		ageTextField.setSize(1000, 20);
		System.out.println("With: " + ageTextField.getSize().getWidth() + "Height :" + ageTextField.getSize().getHeight());
		
		ageTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField SourceTextField = (JTextField) (e.getSource());
				String ageInput = SourceTextField.getText();
				if(ageInput.matches("[1-9][0-9]{0,1}")) {
					System.out.println("true");
				}else {
					System.out.println("false");
				}
			}
		});
		
		genderComboBox.addItem(Gender.M.beschreibung);
		genderComboBox.addItem(Gender.F.beschreibung);
		genderComboBox.addItem(Gender.AAH.beschreibung);
		
		datenErfassenButton.setText("Daten erfassen");
		datenErfassenButton.setActionCommand("datenErfassenButton");
		datenErfassenButton.addActionListener(new MyActionListener(datenErfassenButton));
		
	}
	
	public void setView(JPanel thePanelToShow) {
		getContentPane().removeAll();
		getContentPane().add(thePanelToShow);
		getContentPane().doLayout();
	}

	public JPanel getPersonErfassenView() {
		return personErfassenView;
	}

	public JPanel getThemenAuswahlView() {
		return themenAuswahlView;
	}

	public JPanel getMeinungsAbgabeView() {
		return meinungsAbgabeView;
	}

	public void setPersonErfassenView(JPanel personErfassenView) {
		this.personErfassenView = personErfassenView;
	}

	public void setThemenAuswahlView(JPanel themenAuswahlView) {
		this.themenAuswahlView = themenAuswahlView;
	}

	public void setMeinungsAbgabeView(JPanel meinungsAbgabeView) {
		this.meinungsAbgabeView = meinungsAbgabeView;
	}

}
