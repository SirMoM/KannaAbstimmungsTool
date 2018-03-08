/**
 * 
 */
package de.online.noah.ruben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author Noah Ruben
 *
 */
public class MyActionListener implements ActionListener {

	private MyButton myButton;
	private HauptView hauptView;
	
	/**
	 * @param myButton 
	 * 
	 */
	public MyActionListener(MyButton myButton) {
		this.myButton = myButton;
		this.hauptView = (HauptView) myButton.getView();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		MyLogger.log(event.paramString());

		switch (event.getActionCommand()) {

		case "datenErfassenButton1":
			try {
				AbstimmungController.personenDatenErfassen(getAgeFromTextField(), getGenderFromDropDown());
				//Change View
				hauptView.setView(hauptView.getThemenAuswahlView());
			} catch (Exception e) {
				MyLogger.log("getAgeFromTextField() failed", e);
			}
			break;

		case "t1":
			AbstimmungController.themaErfassen("t1", 1);
			//Change View
			hauptView.initMeinungsAbgabeView();
			hauptView.setView(hauptView.getMeinungsAbgabeView());
			break;

		case "t2":
			AbstimmungController.themaErfassen("t2", 2);
			//Change View
			hauptView.initMeinungsAbgabeView();
			hauptView.setView(hauptView.getMeinungsAbgabeView());
			break;


		case "t3":
			AbstimmungController.themaErfassen("t3", 3);
			//Change View
			hauptView.initMeinungsAbgabeView();
			hauptView.setView(hauptView.getMeinungsAbgabeView());
			break;

		case "datenErfassenButton2":
			AbstimmungController.antwortErfasssen(getAntwortDropDown());
			AbstimmungController.getCurrentAbstimmung().setComment(hauptView.getCommentTextField().getText());
			
			if (!AbstimmungController.getCurrentAbstimmung().isValidAbstimmung()) {
				JOptionPane.showMessageDialog(hauptView, "Die Abstimmung konnte nicht gewertet werden", "Ungültige Abstimmung", JOptionPane.ERROR_MESSAGE);
				MyLogger.log("Ungultige Abstimmung");
				//Reset Views
				hauptView.setVisible(false);
				hauptView = new HauptView();
			}else {
				//save Abstimmung
				MyLogger.log(AbstimmungController.getCurrentAbstimmung().toCSVString());
				MyLogger.log(AbstimmungController.getCurrentAbstimmung().toString());
				FileUsingClass.inCsvDateiSpeichern(AbstimmungController.getCurrentAbstimmung().toCSVString());
				AbstimmungController.reset();
			}
			break;

		default:
			MyLogger.log("[Default] Pressing this Button " + myButton.getMyName() + " did nothing");
			break;
		}
	}

	private int getAgeFromTextField() throws FalseAgeFormatException {
		String alterString = hauptView.getAgeTextField().getText();
		if(alterString.matches("[1-9][0-9]{0,1}")) {
			return Integer.valueOf(alterString);
		}else {
			JOptionPane.showMessageDialog(hauptView, "Das Alter bitte in Jahren (JJ) angeben!", "Eingabe Fehler", JOptionPane.ERROR_MESSAGE);
			throw new FalseAgeFormatException("Alter ist nicht im validen Format angegeben");
		}
	}

	private Gender getGenderFromDropDown() {
		return Gender.getGenderFromBeschreibug((String) hauptView.getGenderComboBox().getSelectedItem());
	}
	
	private String getAntwortDropDown() {
		return (String) hauptView.getAnswers().getSelectedItem();
	}
}
