package de.online.noah.ruben;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

/**
 * @author Sir.MoM
 * @version 1.0
 * @since 04.08.2017
 */
public class FileUsingClass {
	
	/**
	 * Das Verzeichnis das vorhanden sein muss wir ggf. erstellt
	 */
	final static File DASVERZEICHNIS = new File(System.getProperties().getProperty("user.home") + "\\Documents\\Geburtstags Manager\\" );
	/**
	 * Die benutzte CSV-Datei
	 */
	static File GEBURTSTAGCSV = new File(DASVERZEICHNIS.getPath() + "\\geburtstage.csv");
	
	/**
	 * Die benutzte HTML-Datei
	 */
	static File GEBURTSTAGHTML = new File(DASVERZEICHNIS.getPath() + "\\geburtstage.csv");
	
	/**
	 * Speichert einen String in die CSV Datei geburtstage.csv
	 * @param csvOutputString Der String der in die CSV-Datei zu speichern ist
	 */
	public static void inCsvDateiSpeichern(String csvOutputString) {
		try {
			BufferedWriter bufferedWriterCsv = new BufferedWriter(new FileWriter(GEBURTSTAGCSV));
			bufferedWriterCsv.write(csvOutputString);
			bufferedWriterCsv.close();
		} catch (IOException e) {
			e.printStackTrace();
			MyLogger.log(e.getStackTrace().toString(), e);
		}
	}
	
	/**
	 * Gibt ein Array aus den Zeilen der Datei zurück
	 * @return zeilenArray Das Array das zurück gegeben wird
	 */
	//TODO Mit String[][] vereinbar machen
	public static String[][] StringArrayArrayAusCsv() {
		createDir();
		ArrayList<String[]> zeilen = new ArrayList<String[]>();
		
		if(GEBURTSTAGCSV.exists() == false) {
			try {
				GEBURTSTAGCSV.getParentFile().mkdir();
				GEBURTSTAGCSV.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				MyLogger.log(e.getStackTrace().toString(),e);
			}
		}
		if(GEBURTSTAGHTML.exists() == false) {
			try {
				GEBURTSTAGHTML.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				MyLogger.log(e.getStackTrace().toString(), e);
			}
		}
		
		try {
			BufferedReader bufferedReaderCsv = new BufferedReader(new FileReader(GEBURTSTAGCSV));
			String zeile;
			while((zeile = bufferedReaderCsv.readLine()) != null) {
				zeilen.add(zeile.split(";"));
			}
			bufferedReaderCsv.close();
		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.log(e.getStackTrace().toString(), e);
		}
		
		String[][] zeilenArray = new String[zeilen.toArray().length][2];
		zeilen.toArray(zeilenArray);
		return zeilenArray;
	}
	
	public static void inHTMLDateiSpeichern() {
		try {
			BufferedWriter bufferedWriterHTML = new BufferedWriter(new FileWriter(GEBURTSTAGHTML));
//			TODO Komplette HTML-Seite mit richtigem Inhalt füllen
			bufferedWriterHTML.write("<!doctype html>\r");
			bufferedWriterHTML.write("<html lang=\"de\">\r");
				bufferedWriterHTML.write("\t<head>\r");
					bufferedWriterHTML.write("\t\t <title> Geburtstage </title>\r");
				bufferedWriterHTML.write("\t</head>\r");
				bufferedWriterHTML.write("\t<body bgcolor=\"#E6E6FA\">\r");
				bufferedWriterHTML.write("\t\t<h1>INHALT</h1>\r");
				bufferedWriterHTML.write("\t</body>\r");
			bufferedWriterHTML.write("</html>\r");
			
			bufferedWriterHTML.close();
		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.log(e.getStackTrace().toString(), e);
		}
	}
	
	public static URI getURI() {
		URI uri = FileUsingClass.GEBURTSTAGHTML.toURI();
		return uri;
	}
	
	public static void openHTMLFile() {
		try {
			Desktop.getDesktop().browse(FileUsingClass.getURI());
		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.log(e.getStackTrace().toString(), e);
		}
	}
	
	public static void createDir() {
		if(!DASVERZEICHNIS.exists()) {
			DASVERZEICHNIS.mkdir();
		}
	}
}
