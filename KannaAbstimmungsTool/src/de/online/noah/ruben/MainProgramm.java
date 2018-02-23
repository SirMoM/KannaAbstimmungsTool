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
		
		HauptView x = new HauptView();
		x.setView(x.getPersonErfassenView());
		
	}
}


