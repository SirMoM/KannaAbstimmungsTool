/**
 * 
 */
package de.online.noah.ruben;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	private int middlePanelIndex = 0;
	private final int middlePanelIndexCap;
	private List<EinKommentarPanel> kommentartPanels = new ArrayList<EinKommentarPanel>();
	private MyButton kommentareThema1;
	private MyButton kommentareThema2;
	private MyButton kommentareThema3;
	private MyButton vorherigeSeite;
	private MyButton abstimmungBeenden;
	private MyButton naechsteSeite;
	
	private int frageId;

	private List<JPanel> middlePanels;

	/**
	 * 
	 */
	public KommentarePanel(int frageID, HauptView hauptView) {
		// Alle Variable bestuecken
		this.hauptView = hauptView;
		
		this.frageId = frageID;
		
		kommentareThema1 = new MyButton("kommentareThema1", hauptView.getMyActionListener());
		kommentareThema2 = new MyButton("kommentareThema2", hauptView.getMyActionListener());
		kommentareThema3 = new MyButton("kommentareThema3", hauptView.getMyActionListener());
		vorherigeSeite = new MyButton("vorherigeSeite", hauptView.getMyActionListener());
		abstimmungBeenden = new MyButton("abstimmungBeenden", hauptView.getMyActionListener());
		naechsteSeite = new MyButton("naechsteSeite", hauptView.getMyActionListener());
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());

		fillKommentarPanels();
		middlePanels = createMiddlepanels(frageId);
		middlePanelIndexCap = middlePanels.size() - 1;
		makeView(frageId);
	}

	/**
	 * 
	 */
	public KommentarePanel(HauptView hauptView) {
		// Alle Variable bestuecken
		this.hauptView = hauptView;
		
		this.frageId = AbstimmungController.getCurrentAbstimmung().getThemaId();
		
		kommentareThema1 = new MyButton("kommentareThema1", hauptView.getMyActionListener());
		kommentareThema2 = new MyButton("kommentareThema2", hauptView.getMyActionListener());
		kommentareThema3 = new MyButton("kommentareThema3", hauptView.getMyActionListener());
		vorherigeSeite = new MyButton("vorherigeSeite", hauptView.getMyActionListener());
		abstimmungBeenden = new MyButton("abstimmungBeenden", hauptView.getMyActionListener());
		naechsteSeite = new MyButton("nächsteSeite", hauptView.getMyActionListener());

		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());

		fillKommentarPanels();
		middlePanels = createMiddlepanels(frageId);
		middlePanelIndexCap = middlePanels.size();
		makeView(frageId);
	}

	private List<JPanel> createMiddlepanels(int frageID) {
		List<JPanel> kommentareForThisFrage = new ArrayList<>();
		List<JPanel> listOfPanels = new ArrayList<>();
		
		for (EinKommentarPanel einKommentarPanel : kommentartPanels) {
			if (einKommentarPanel.fragenID == frageID) {
				kommentareForThisFrage.add(einKommentarPanel);
			}
		}

		for (int i = 0; i < kommentareForThisFrage.size(); i += 5) {
			JPanel tempJPanel = new JPanel(new GridLayout(5,1));
			
			for (int j = 0; j < 5; j++) {
				try {
					tempJPanel.add(kommentareForThisFrage.get(i + j));
				} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
					MyLogger.log("", indexOutOfBoundsException);
					break;
				}
			}
			listOfPanels.add(tempJPanel);
		}

		return listOfPanels;
	}

	public void fillKommentarPanels() {
		ArrayList<String[]> alleZeilen = ((ArrayList) FileUsingClass.listAusCsv());
		for (String[] abstimmung : alleZeilen) {
			if (abstimmung.length == 5) {
				EinKommentarPanel tempKommentarPanel = new EinKommentarPanel(
						Gender.getGenderFromBeschreibug(abstimmung[1]), Integer.valueOf(abstimmung[0]), abstimmung[4],
						Integer.valueOf(abstimmung[2]));
				kommentartPanels.add(tempKommentarPanel);
			} else {
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

		abstimmungBeenden.setText("Abstimmung Beenden");
		abstimmungBeenden.setActionCommand("abstimmungBeenden");
		
		vorherigeSeite.setText("Vorherige Seite");
		vorherigeSeite.setActionCommand("vorherigeSeite");
		
		naechsteSeite.setText("Nächste Seite");
		naechsteSeite.setActionCommand("naechsteSeite");

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

		kommentarGridBagConstraints.gridy = 1;
		kommentarGridBagConstraints.gridx = 1;

		this.add(middlePanels.get(middlePanelIndex), kommentarGridBagConstraints);

		kommentarGridBagConstraints.gridwidth = 1;
		
		kommentarGridBagConstraints.gridy = 2;
		kommentarGridBagConstraints.gridx = 0;
		this.add(vorherigeSeite, kommentarGridBagConstraints);
		
		kommentarGridBagConstraints.gridy = 2;
		kommentarGridBagConstraints.gridx = 1;
		this.add(abstimmungBeenden, kommentarGridBagConstraints);
				
		kommentarGridBagConstraints.gridy = 2;
		kommentarGridBagConstraints.gridx = 2;
		this.add(naechsteSeite, kommentarGridBagConstraints);

	}

	public void nextMiddlePanel() {
		middlePanelIndexCircle(1);
	}

	public void previousMiddlePanel() {
		middlePanelIndexCircle(-1);
	}

	private void middlePanelIndexCircle(int shift) {
		if ((middlePanelIndex + shift)  > middlePanelIndexCap) {
			middlePanelIndex =  0;
		} else if ((middlePanelIndex + shift)  < 0) {
			middlePanelIndex = middlePanelIndexCap;
		} else {
			middlePanelIndex = middlePanelIndex + shift;
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
	 * @param kommentartPanels
	 *            the kommentartPanels to set
	 */
	public void setKommentartPanels(List kommentartPanels) {
		this.kommentartPanels = kommentartPanels;
	}

	/**
	 * @param kommentareThema1
	 *            the kommentareThema1 to set
	 */
	public void setKommentareThema1(MyButton kommentareThema1) {
		this.kommentareThema1 = kommentareThema1;
	}

	/**
	 * @param kommentareThema2
	 *            the kommentareThema2 to set
	 */
	public void setKommentareThema2(MyButton kommentareThema2) {
		this.kommentareThema2 = kommentareThema2;
	}

	/**
	 * @param kommentareThema3
	 *            the kommentareThema3 to set
	 */
	public void setKommentareThema3(MyButton kommentareThema3) {
		this.kommentareThema3 = kommentareThema3;
	}

	/**
	 * @param nächsteSeite
	 *            the nächsteSeite to set
	 */
	public void setNaechsteSeite(MyButton naechsteSeite) {
		this.naechsteSeite = naechsteSeite;
	}

	/**
	 * @return the frageId
	 */
	public int getFrageId() {
		return frageId;
	}
}
