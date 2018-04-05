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

	private final Color kanaOrange = new Color(255, 150, 0);
	private final Color black = Color.BLACK;
	private final Color white = Color.WHITE;
	
	private HauptView hauptView;
	private int middlePanelIndex = 0;
	private final int middlePanelIndexCap;
	private List<EinKommentarPanel> kommentartPanels = new ArrayList<EinKommentarPanel>();
	private MyButton kommentareThema1Button;
	private MyButton kommentareThema2Button;
	private MyButton kommentareThema3Button;
	private MyButton vorherigeSeiteButton;
	private MyButton abstimmungBeendenButton;
	private MyButton naechsteSeiteButton;
	
	private int frageId;

	private List<JPanel> middlePanels;

	/**
	 * 
	 */
	public KommentarePanel(int frageID, HauptView hauptView) {
		// Alle Variable bestuecken
		this.hauptView = hauptView;
		
		this.frageId = frageID;
		
		kommentareThema1Button = new MyButton("kommentareThema1", hauptView.getMyActionListener());
		kommentareThema2Button = new MyButton("kommentareThema2", hauptView.getMyActionListener());
		kommentareThema3Button = new MyButton("kommentareThema3", hauptView.getMyActionListener());
		vorherigeSeiteButton = new MyButton("vorherigeSeite", hauptView.getMyActionListener());
		abstimmungBeendenButton = new MyButton("abstimmungBeenden", hauptView.getMyActionListener());
		naechsteSeiteButton = new MyButton("naechsteSeite", hauptView.getMyActionListener());
		this.setBackground(black);
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
		
		kommentareThema1Button = new MyButton("kommentareThema1", hauptView.getMyActionListener());
		kommentareThema2Button = new MyButton("kommentareThema2", hauptView.getMyActionListener());
		kommentareThema3Button = new MyButton("kommentareThema3", hauptView.getMyActionListener());
		vorherigeSeiteButton = new MyButton("vorherigeSeite", hauptView.getMyActionListener());
		abstimmungBeendenButton = new MyButton("abstimmungBeenden", hauptView.getMyActionListener());
		naechsteSeiteButton = new MyButton("nächsteSeite", hauptView.getMyActionListener());

		this.setBackground(black);
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
			tempJPanel.setBackground(black);
			
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

		abstimmungBeendenButton.setText("Abstimmung Beenden");
		abstimmungBeendenButton.setActionCommand("abstimmungBeenden");
		abstimmungBeendenButton.setBackground(kanaOrange);
		
		vorherigeSeiteButton.setText("Vorherige Seite");
		vorherigeSeiteButton.setActionCommand("vorherigeSeite");
		vorherigeSeiteButton.setBackground(kanaOrange);
		
		naechsteSeiteButton.setText("Nächste Seite");
		naechsteSeiteButton.setActionCommand("naechsteSeite");
		naechsteSeiteButton.setBackground(kanaOrange);

		kommentareThema1Button.setText("Kommentare zu Thema 1");
		kommentareThema1Button.setActionCommand("kommentareThema1");
		kommentareThema1Button.setBackground(kanaOrange);
		
		kommentareThema2Button.setText("Kommentare zu Thema 2");
		kommentareThema2Button.setActionCommand("kommentareThema2");
		kommentareThema2Button.setBackground(kanaOrange);
		
		kommentareThema3Button.setText("Kommentare zu Thema 3");
		kommentareThema3Button.setActionCommand("kommentareThema3");
		kommentareThema3Button.setBackground(kanaOrange);

		this.add(kommentareThema1Button, kommentarGridBagConstraints);
		kommentarGridBagConstraints.gridx = 1;
		this.add(kommentareThema2Button, kommentarGridBagConstraints);
		kommentarGridBagConstraints.gridx = 2;
		this.add(kommentareThema3Button, kommentarGridBagConstraints);

		kommentarGridBagConstraints.gridy = 1;
		kommentarGridBagConstraints.gridx = 1;

		try {
			this.add(middlePanels.get(middlePanelIndex), kommentarGridBagConstraints);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			MyLogger.log("Middle Panel size: " + middlePanels.size() + " middlePanelIndex: " + middlePanelIndex, indexOutOfBoundsException);
		}

		kommentarGridBagConstraints.gridwidth = 1;
		
		kommentarGridBagConstraints.gridy = 2;
		kommentarGridBagConstraints.gridx = 0;
		this.add(vorherigeSeiteButton, kommentarGridBagConstraints);
		
		kommentarGridBagConstraints.gridy = 2;
		kommentarGridBagConstraints.gridx = 1;
		this.add(abstimmungBeendenButton, kommentarGridBagConstraints);
				
		kommentarGridBagConstraints.gridy = 2;
		kommentarGridBagConstraints.gridx = 2;
		this.add(naechsteSeiteButton, kommentarGridBagConstraints);

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
		return kommentareThema1Button;
	}

	/**
	 * @return the kommentareThema2
	 */
	public MyButton getKommentareThema2() {
		return kommentareThema2Button;
	}

	/**
	 * @return the kommentareThema3
	 */
	public MyButton getKommentareThema3() {
		return kommentareThema3Button;
	}

	/**
	 * @return the nächsteSeite
	 */
	public MyButton getNaechsteSeite() {
		return naechsteSeiteButton;
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
		this.kommentareThema1Button = kommentareThema1;
	}

	/**
	 * @param kommentareThema2
	 *            the kommentareThema2 to set
	 */
	public void setKommentareThema2(MyButton kommentareThema2) {
		this.kommentareThema2Button = kommentareThema2;
	}

	/**
	 * @param kommentareThema3
	 *            the kommentareThema3 to set
	 */
	public void setKommentareThema3(MyButton kommentareThema3) {
		this.kommentareThema3Button = kommentareThema3;
	}

	/**
	 * @param nächsteSeite
	 *            the nächsteSeite to set
	 */
	public void setNaechsteSeite(MyButton naechsteSeite) {
		this.naechsteSeiteButton = naechsteSeite;
	}

	/**
	 * @return the frageId
	 */
	public int getFrageId() {
		return frageId;
	}
}
