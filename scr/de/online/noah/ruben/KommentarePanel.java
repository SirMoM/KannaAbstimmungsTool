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

	private HauptView hauptView;

	private List<EinKommentarPanel> kommentartPanels = new ArrayList<EinKommentarPanel>();
	private MyButton kommentareThema1;
	private MyButton kommentareThema2;
	private MyButton kommentareThema3;
	private MyButton naechsteSeite;
	private MyButton abstimmungBeenden;


	/**
	 * 
	 */
	public KommentarePanel(int frageID, HauptView hauptView) {
		// Alle Variable bestuecken
		this.hauptView = hauptView;
		kommentareThema1 = new MyButton("kommentareThema1", hauptView.getMyActionListener());  
		kommentareThema2 = new MyButton("kommentareThema2", hauptView.getMyActionListener());  
		kommentareThema3 = new MyButton("kommentareThema3", hauptView.getMyActionListener());  
		naechsteSeite 	 = new MyButton("nächsteSeite", hauptView.getMyActionListener());          
		abstimmungBeenden= new MyButton("abstimmungBeenden", hauptView.getMyActionListener());

		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());

		fillKommentar();
		makeView(frageID);
	}
	/**
	 * 
	 */
	public KommentarePanel(HauptView hauptView) {
		// Alle Variable bestuecken
		this.hauptView = hauptView;
		kommentareThema1 = new MyButton("kommentareThema1", hauptView.getMyActionListener());  
		kommentareThema2 = new MyButton("kommentareThema2", hauptView.getMyActionListener());  
		kommentareThema3 = new MyButton("kommentareThema3", hauptView.getMyActionListener());  
		naechsteSeite 	 = new MyButton("nächsteSeite", hauptView.getMyActionListener());          
		abstimmungBeenden= new MyButton("abstimmungBeenden", hauptView.getMyActionListener());

		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());

		fillKommentar();
		makeView(AbstimmungController.getCurrentAbstimmung().getThemaId());
	}

	public void fillKommentar() {
		ArrayList<String[]> alleZeilen = ((ArrayList) FileUsingClass.listAusCsv());
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
		this.removeAll();

		GridBagConstraints kommentarGridBagConstraints = new GridBagConstraints();
		kommentarGridBagConstraints.fill = GridBagConstraints.BOTH;
		kommentarGridBagConstraints.gridx = 0;
		kommentarGridBagConstraints.gridy = 0;
		kommentarGridBagConstraints.weightx = 1;
		kommentarGridBagConstraints.insets = new Insets(0, 0, 10, 0);

		kommentareThema1.setText("Kommentare zu Thema 1");
		kommentareThema1.setActionCommand("kommentareThema1");
		kommentareThema2.setText("Kommentare zu Thema 2");
		kommentareThema2.setActionCommand("kommentareThema2");
		kommentareThema3.setText("Kommentare zu Thema 3");
		kommentareThema3.setActionCommand("kommentareThema3");

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

		abstimmungBeenden.setText("Abstimmung Beenden");
		abstimmungBeenden.setActionCommand("abstimmungBeenden");
		kommentarGridBagConstraints.gridwidth = 1;
		kommentarGridBagConstraints.gridy++;
		kommentarGridBagConstraints.gridx = 1;
		this.add(abstimmungBeenden, kommentarGridBagConstraints);

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
	public MyButton getNaechsteSeite() {
		return naechsteSeite;
	}


	/**
	 * @return the hauptView
	 */
	public HauptView getHauptView() {
		return hauptView;
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
	public void setNaechsteSeite(MyButton naechsteSeite) {
		this.naechsteSeite = naechsteSeite;
	}




}
