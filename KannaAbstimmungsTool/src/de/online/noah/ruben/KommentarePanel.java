/**
 * 
 */
package de.online.noah.ruben;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

/**
 * @author i13az81
 *
 */
public class KommentarePanel extends JPanel {

	private List<EinKommentarPanel> kommentartPanels = new ArrayList<EinKommentarPanel>();
	private MyButton kommentareThema1 = new MyButton("kommentareThema1", this);
	private MyButton kommentareThema2 = new MyButton("kommentareThema2", this);
	private MyButton kommentareThema3 = new MyButton("kommentareThema3", this);
	private MyButton nächsteSeite = new MyButton("nächsteSeite", this);
	
	
	/**
	 * 
	 */
	public KommentarePanel(int frageID) {
		this.setLayout(new GridBagLayout());
		fillKommentar();
		makeView(frageID);
		this.setVisible(true);
	}
	
	/**
	 * 
	 */
	public KommentarePanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		fillKommentar();
		makeView(AbstimmungController.getCurrentAbstimmung().getThemaId());
	}
	
	public void fillKommentar() {
		ArrayList<String[]> alleZeilen = (ArrayList) FileUsingClass.listAusCsv();
		for (String[] abstimmung : alleZeilen) {
			if(abstimmung.length == 5) {
				EinKommentarPanel tempKommentarPanel = new EinKommentarPanel(Gender.getGenderFromBeschreibug(abstimmung[1]), Integer.valueOf(abstimmung[0]), abstimmung[4], Integer.valueOf(abstimmung[2]));
				kommentartPanels.add(tempKommentarPanel);
			}else {
				MyLogger.log("Kein Kommmentar vorhanden");
			}
		}
	}
	
	public void makeView(int frageID) {
		
		GridBagConstraints kommentarGridBagConstraints = new GridBagConstraints();
		kommentarGridBagConstraints.fill = GridBagConstraints.BOTH;
		kommentarGridBagConstraints.gridx = 0;
		kommentarGridBagConstraints.gridy = 0;
		kommentarGridBagConstraints.weightx = 1;
		kommentarGridBagConstraints.insets = new Insets(0, 0, 10, 0);
		
		kommentareThema1.setText("Kommentare zu Thema 1");
		kommentareThema2.setText("Kommentare zu Thema 2");
		kommentareThema3.setText("Kommentare zu Thema 3");

		this.add(kommentareThema1, kommentarGridBagConstraints);
		kommentarGridBagConstraints.gridx = 1;
		this.add(kommentareThema2, kommentarGridBagConstraints);
		kommentarGridBagConstraints.gridx = 2;
		this.add(kommentareThema3, kommentarGridBagConstraints);
		
		
		kommentarGridBagConstraints.gridx = 0;
		kommentarGridBagConstraints.gridwidth = 3;
		kommentarGridBagConstraints.gridy = 1;
		for (EinKommentarPanel einKommentarPanel : kommentartPanels) {
			if (frageID == einKommentarPanel.fragenID) {
				einKommentarPanel.setVisible(true);
				this.add(einKommentarPanel, kommentarGridBagConstraints);
				System.out.println(einKommentarPanel.kommentar);
				kommentarGridBagConstraints.gridy++;
			} else {
				MyLogger.log(einKommentarPanel.kommentar + " ist kein Kommentar zur Frage mit der ID" + frageID);
			}
		}
	}

	/**
	 * @return the kommentartPanels
	 */
	public List getKommentartPanels() {
		return kommentartPanels;
	}


	/**
	 * @return the kommentareThema1
	 */
	public MyButton getKommentareThema1() {
		return kommentareThema1;
	}


	/**
	 * @return the kommentareThema2
	 */
	public MyButton getKommentareThema2() {
		return kommentareThema2;
	}


	/**
	 * @return the kommentareThema3
	 */
	public MyButton getKommentareThema3() {
		return kommentareThema3;
	}


	/**
	 * @return the nächsteSeite
	 */
	public MyButton getNächsteSeite() {
		return nächsteSeite;
	}


	/**
	 * @param kommentartPanels the kommentartPanels to set
	 */
	public void setKommentartPanels(List kommentartPanels) {
		this.kommentartPanels = kommentartPanels;
	}


	/**
	 * @param kommentareThema1 the kommentareThema1 to set
	 */
	public void setKommentareThema1(MyButton kommentareThema1) {
		this.kommentareThema1 = kommentareThema1;
	}


	/**
	 * @param kommentareThema2 the kommentareThema2 to set
	 */
	public void setKommentareThema2(MyButton kommentareThema2) {
		this.kommentareThema2 = kommentareThema2;
	}


	/**
	 * @param kommentareThema3 the kommentareThema3 to set
	 */
	public void setKommentareThema3(MyButton kommentareThema3) {
		this.kommentareThema3 = kommentareThema3;
	}


	/**
	 * @param nächsteSeite the nächsteSeite to set
	 */
	public void setNächsteSeite(MyButton nächsteSeite) {
		this.nächsteSeite = nächsteSeite;
	}
	
	
	
	
}
