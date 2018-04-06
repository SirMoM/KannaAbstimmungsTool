/**
 * 
 */
package de.online.noah.ruben;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author Noah Ruben
 *
 */
@SuppressWarnings("serial")
public class HauptView extends JFrame{
	private final Color kanaOrange = new Color(255, 150, 0);
	private final Color black = Color.BLACK;

	private final MyActionListener myActionListener = new MyActionListener(this); 

	/**
	 * 	Die aktuelle Abstimmung als Objetkt
	 */
	private Abstimmung currentAbstimmung = new Abstimmung();

	private JPanel personErfassenView =  new JPanel();
	private JPanel themenAuswahlView = new JPanel();
	private JPanel meinungsAbgabeView = new JPanel();


	// themenAuswahlView Components
	private MyButton thema1 = new MyButton("Thema 1", myActionListener);
	private MyButton thema2 = new MyButton("Thema 2", myActionListener);
	private MyButton thema3 = new MyButton("Thema 3", myActionListener);

	// personErfassenView Components
	private JLabel introductionLabel = new JLabel();

	private JTextField ageTextField = new JTextField("ageTextFieldMouseListener");
	private JLabel ageLabel = new JLabel();

	private JComboBox<String> genderComboBox = new JComboBox<>(); 
	private JLabel genderLabel = new JLabel();

	private MyButton datenErfassenButton = new MyButton("Daten Erfassen Button", myActionListener);


	//	meinungsAbgabeView Components
	private JLabel questionLabel = new JLabel("Frage");
	private JComboBox<String> answersComboBox = new JComboBox<>(); 
	private JLabel commentLabel = new JLabel("Kommentar");
	private JTextField commentTextField = new JTextField();

	/**
	 * 
	 */
	public HauptView() {
		this.getContentPane().setBackground(black);
		initViews();
		setTitle("Kana Abstimmungs Tool");
		setVisible(true);
		this.setView(this.getPersonErfassenView());
	}

	public void initViews() {
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		initPersonErfassenView();

		initThemenAuswahlView();

	}

	void initMeinungsAbgabeView() {
		AnswerEnum buildViewFromThisAnswerEnum = AnswerEnum.getEnumFromId(AbstimmungController.getCurrentAbstimmung().getThemaId());

		questionLabel.setText(buildViewFromThisAnswerEnum.getFrage());
		questionLabel.setForeground(kanaOrange);
		
		//Fill ComboBox
		answersComboBox.setBackground(kanaOrange);
		for (String str : buildViewFromThisAnswerEnum.getAntworten()) {
			answersComboBox.addItem(str);
		}


		commentLabel.setText("Du kannst hier noch ein Kommentar abgeben");
		commentLabel.setForeground(kanaOrange);
		
		commentTextField.setText("");
		commentTextField.setEditable(true);
		commentTextField.addKeyListener(new MyTextFieldKeyBoardAdapter(commentTextField, 140));
		commentTextField.setBackground(kanaOrange);
		
		datenErfassenButton.setActionCommand("datenErfassenButton2");


		getMeinungsAbgabeView().setLayout(new GridBagLayout());
		getMeinungsAbgabeView().setBackground(black);

		GridBagConstraints meinungsAbgabeViewConstraints = new GridBagConstraints();
		meinungsAbgabeViewConstraints.fill = GridBagConstraints.HORIZONTAL;
		meinungsAbgabeViewConstraints.insets = new Insets(20, 20, 20, 20);

		meinungsAbgabeViewConstraints.gridx = 0;
		meinungsAbgabeViewConstraints.gridy = 0;
		getMeinungsAbgabeView().add(questionLabel, meinungsAbgabeViewConstraints);

		meinungsAbgabeViewConstraints.gridx = 0;
		meinungsAbgabeViewConstraints.gridy = 1;
		getMeinungsAbgabeView().add(answersComboBox, meinungsAbgabeViewConstraints);

		meinungsAbgabeViewConstraints.gridx = 0;
		meinungsAbgabeViewConstraints.gridy = 2;
		getMeinungsAbgabeView().add(commentLabel, meinungsAbgabeViewConstraints);

		meinungsAbgabeViewConstraints.gridx = 0;
		meinungsAbgabeViewConstraints.gridy = 3;
		getMeinungsAbgabeView().add(commentTextField, meinungsAbgabeViewConstraints);

		meinungsAbgabeViewConstraints.gridx = 0;
		meinungsAbgabeViewConstraints.gridy = 4;
		getMeinungsAbgabeView().add(datenErfassenButton, meinungsAbgabeViewConstraints);

	}

	private void initPersonErfassenView() {
		//Introduction Label
		introductionLabel.setText("Bitte Alter und Geschlecht eingtagen");
		introductionLabel.setForeground(kanaOrange);

		//Age Label
		ageLabel.setText("Alter:");
		ageLabel.setLabelFor(ageTextField);
		ageLabel.setForeground(kanaOrange);

		// Age Textfield 
		ageTextField.setText("JJ");
		ageTextField.setName("ageTextField");
		ageTextField.setEditable(true);
		ageTextField.addMouseListener(new TextFieldMouseListener(ageTextField));
		ageTextField.addKeyListener(new MyTextFieldKeyBoardAdapter(ageTextField, 2));
		ageTextField.setBackground(kanaOrange);
		ageTextField.setForeground(black);
		
		//Gender Label
		genderLabel.setName("genderLabel");
		genderLabel.setText("Geschlecht: ");
		genderLabel.setForeground(kanaOrange);

		//Gender Combobox /Dropdown Menue
		genderComboBox.addItem(Gender.M.getBeschreibung());
		genderComboBox.addItem(Gender.F.getBeschreibung());
		genderComboBox.addItem(Gender.AAH.getBeschreibung());
		genderComboBox.setBackground(kanaOrange);
		genderComboBox.setForeground(black);


		// Datenerfassen Button die 1.
		datenErfassenButton.setText("Daten erfassen");
		datenErfassenButton.setActionCommand("datenErfassenButton1");
		datenErfassenButton.setBackground(kanaOrange);
		datenErfassenButton.setForeground(black);

		//Panel Setup
		getPersonErfassenView().setLayout(new GridBagLayout());
		getPersonErfassenView().setBackground(black);
		getPersonErfassenView().setForeground(kanaOrange);

		GridBagConstraints personenViewConstraints = new GridBagConstraints();
		personenViewConstraints.insets = new Insets(20, 20, 20, 20);
		personenViewConstraints.fill = GridBagConstraints.HORIZONTAL;


		personenViewConstraints.gridy = 0;
		personenViewConstraints.gridx = 0;
		personenViewConstraints.gridwidth = 2;
		getPersonErfassenView().add(introductionLabel, personenViewConstraints);

		personenViewConstraints.gridwidth = 1;
		personenViewConstraints.gridy = 1;
		personenViewConstraints.gridx = 0;
		getPersonErfassenView().add(ageLabel, personenViewConstraints);

		personenViewConstraints.gridy = 1; 
		personenViewConstraints.gridx = 1;
		getPersonErfassenView().add(ageTextField, personenViewConstraints);
		personenViewConstraints.gridy = 2; 
		personenViewConstraints.gridx = 0;
		getPersonErfassenView().add(genderLabel, personenViewConstraints);

		personenViewConstraints.gridy = 2; 
		personenViewConstraints.gridx = 1;
		getPersonErfassenView().add(genderComboBox, personenViewConstraints);

		personenViewConstraints.gridy = 3; 
		personenViewConstraints.gridx = 1;
		getPersonErfassenView().add(datenErfassenButton, personenViewConstraints);


	}

	private void initThemenAuswahlView() {
		// Thema 1 Button
		thema1.setText("Thema 1");
		thema1.setBackground(kanaOrange);
		thema1.setActionCommand("t1");


		// Thema 2 Button
		thema2.setText("Thema 2");
		thema2.setBackground(kanaOrange);
		thema2.setActionCommand("t2");

		// Thema 3 Button
		thema3.setText("Thema 3");
		thema3.setBackground(kanaOrange);
		thema3.setActionCommand("t3");

		// Panel Setup
		getThemenAuswahlView().setLayout(new GridLayout());
		getThemenAuswahlView().add(thema1);
		getThemenAuswahlView().add(thema2);
		getThemenAuswahlView().add(thema3);
	}

	public void setView(JPanel thePanelToShow) {
		getContentPane().removeAll();
		getContentPane().add(thePanelToShow);
		getContentPane().doLayout();
		thePanelToShow.doLayout();
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

	/**
	 * @return the ageTextField
	 */
	public JTextField getAgeTextField() {
		return ageTextField;
	}

	/**
	 * @return the genderComboBox
	 */
	public JComboBox<String> getGenderComboBox() {
		return genderComboBox;
	}

	public Abstimmung getCurrentAbstimmung() {
		return currentAbstimmung;
	}

	/**
	 * @return the answers
	 */
	public JComboBox<String> getAnswers() {
		return answersComboBox;
	}

	/**
	 * @return the commentTextField
	 */
	public JTextField getCommentTextField() {
		return commentTextField;
	}

	/**
	 * @return the myActionListener
	 */
	public MyActionListener getMyActionListener() {
		return myActionListener;
	}

	public void setCurrentAbstimmung(Abstimmung currentAbstimmung) {
		this.currentAbstimmung = currentAbstimmung;
	}

	/**
	 * @param ageTextField the ageTextField to set
	 */
	public void setAgeTextField(JTextField ageTextField) {
		this.ageTextField = ageTextField;
	}

	/**
	 * @param genderComboBox the genderComboBox to set
	 */
	public void setGenderComboBox(JComboBox<String> genderComboBox) {
		this.genderComboBox = genderComboBox;
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
