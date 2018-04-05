/**
 * 
 */
package de.online.noah.ruben;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * @author Noah Ruben
 *
 */
public class MyActionListener implements ActionListener {

	private MyButton myButton;
	private HauptView hauptView;
	KommentarePanel theKommentarePanel;


	/**
	 * @param myButton 
	 * 
	 */
	public MyActionListener(HauptView hv) {
		this.hauptView = hv;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//		MyLogger.log(event.paramString());
		
		switch (event.getActionCommand()) {

		case "datenErfassenButton1":

			try {
				AbstimmungController.personenDatenErfassen(getAgeFromTextField(), getGenderFromDropDown());
				//Change View
				hauptView.setView(hauptView.getThemenAuswahlView());
				MyLogger.log("##########-Themen Auswahl View-##########");
			} catch (Exception e) {
				MyLogger.log("getAgeFromTextField() failed", e);
			}
			break;

		case "t1":
			AbstimmungController.themaErfassen("t1", 1);
			//Change View
			hauptView.initMeinungsAbgabeView();
			hauptView.setView(hauptView.getMeinungsAbgabeView());
			MyLogger.log("##########-Meinungs Abgabe T1 View-##########");
			break;

		case "t2":
			AbstimmungController.themaErfassen("t2", 2);
			//Change View
			hauptView.initMeinungsAbgabeView();
			hauptView.setView(hauptView.getMeinungsAbgabeView());
			MyLogger.log("##########-Meinungs Abgabe T2 View-##########");
			break;


		case "t3":
			AbstimmungController.themaErfassen("t3", 3);
			//Change View
			hauptView.initMeinungsAbgabeView();
			hauptView.setView(hauptView.getMeinungsAbgabeView());
			MyLogger.log("##########-Meinungs Abgabe T3 View-##########");
			break;

		case "datenErfassenButton2":
			AbstimmungController.antwortErfasssen(getAntwortDropDown());
			AbstimmungController.getCurrentAbstimmung().setComment(hauptView.getCommentTextField().getText());

			if(AbstimmungController.getCurrentAbstimmung().isEasterEgg() && AbstimmungController.getCurrentAbstimmung().isValidAbstimmung()) {
				MyLogger.log("Easter Egg aktivated");
				EasterEggFrame easterEggFrame = new EasterEggFrame();
			}
			
			if (!AbstimmungController.getCurrentAbstimmung().isValidAbstimmung()) {
				JOptionPane.showMessageDialog(hauptView, "Die Abstimmung konnte nicht gewertet werden", "Ungültige Abstimmung", JOptionPane.ERROR_MESSAGE);
				MyLogger.log("Ungultige Abstimmung");
				//Reset Views
				hauptView.setVisible(false);
				hauptView = new HauptView();
				MyLogger.log("##########-Neue Abstimmung-##########");
			}else {
				//save Abstimmung
				MyLogger.log(AbstimmungController.getCurrentAbstimmung().toCSVString());
				MyLogger.log(AbstimmungController.getCurrentAbstimmung().toString());
				FileUsingClass.inCsvDateiSpeichern(AbstimmungController.getCurrentAbstimmung().toCSVString());
				theKommentarePanel = new KommentarePanel(hauptView);
				hauptView.setView(theKommentarePanel);
				SwingUtilities.updateComponentTreeUI(hauptView);
				MyLogger.log("##########-Kommentare View nach der Abstimmung-##########");
			}
			break;

		case "kommentareThema1":
			theKommentarePanel = new KommentarePanel(1, hauptView);
			hauptView.setView(theKommentarePanel);
			SwingUtilities.updateComponentTreeUI(hauptView);
			MyLogger.log("##########-Kommentare View Thema 1-##########");
			break;

		case "kommentareThema2":
			theKommentarePanel = new KommentarePanel(2, hauptView);
			hauptView.setView(theKommentarePanel);
			SwingUtilities.updateComponentTreeUI(hauptView);
			MyLogger.log("##########-Kommentare View Thema 2-##########");
			break;

		case "kommentareThema3":
			theKommentarePanel = new KommentarePanel(3, hauptView);
			hauptView.setView(theKommentarePanel);
			SwingUtilities.updateComponentTreeUI(hauptView);
			MyLogger.log("##########-Kommentare View Thema 3-##########");
			break;

		case "abstimmungBeenden":
			hauptView.setVisible(false);
			hauptView = new HauptView();
			MyLogger.log("##########-Neue Abstimmung-##########");
			break;
		
		case "vorherigeSeite":
			MyLogger.log("Vorherige Seite");
			this.theKommentarePanel.nextMiddlePanel();
			this.theKommentarePanel.makeView(theKommentarePanel.getFrageId());
			SwingUtilities.updateComponentTreeUI(hauptView);
			break;

		case "naechsteSeite":
			MyLogger.log("Naechste Seite");
			this.theKommentarePanel.previousMiddlePanel();
			this.theKommentarePanel.makeView(theKommentarePanel.getFrageId());
			SwingUtilities.updateComponentTreeUI(hauptView);
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

	/**
	 * @return the myButton
	 */
	public MyButton getMyButton() {
		return myButton;
	}

	/**
	 * @return the hauptView
	 */
	public HauptView getHauptView() {
		return hauptView;
	}

	/**
	 * @param myButton the myButton to set
	 */
	public void setMyButton(MyButton myButton) {
		this.myButton = myButton;
	}

	/**
	 * @param hauptView the hauptView to set
	 */
	public void setHauptView(HauptView hauptView) {
		this.hauptView = hauptView;
	}
}
