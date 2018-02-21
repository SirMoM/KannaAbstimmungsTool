package de.online.noah.ruben;

/**
 * @author Sir.MoM
 * @version 1.0
 */
public class MainProgramm {
	public static void main(String[] args) {
		System.out.println("All hail Satan");

		FileUsingClass.createDirAndFile();
		MyLogger.createLoggingDatei();
		FileUsingClass.inCsvDateiSpeichern("test;test2");
		MyLogger.log("All hail Satan");
		
		HauptView x = new HauptView();
		x.toggleViews(x.getThemenAuswahlView());
		x.toggleViews(x.getPersonErfassenView());
	}
}


