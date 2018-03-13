package de.online.noah.ruben;

/**
 * @author Sir.MoM
 * @version 1.0
 */
public class MainProgramm {
	public static void main(String[] args) {
		FileUsingClass.createDirAndFile();
		MyLogger.createLoggingDatei();
		MyLogger.log("All hail Satan");
		
		EinKommentarPanel testpanel = new EinKommentarPanel(Gender.AAH, 18, "DAS IST EIN KOMMENTAR UND JA ICH WEISS DAS ISCH SCHREIE", 1);
		EinKommentarPanel testpanel2 = new EinKommentarPanel(Gender.AAH, 18, "DAS IST EIN KOMMENTAR UND JA ICH WEISS DAS ISCH SCHREIE 2", 1);
		
		testpanel.setVisible(true);
		
		HauptView x = new HauptView();
		x.setView(x.getPersonErfassenView());
	}
}


