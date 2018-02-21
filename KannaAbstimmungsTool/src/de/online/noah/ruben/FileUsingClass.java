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
	//final static File THEDIR = new File(System.getProperties().getProperty("user.home") + "\\Documents\\KanaUmfrageTool\\" );
	
	final static File THEDIR = new File("C:\\_PDATEN\\i13az81" + "\\Documents\\KanaUmfrageTool\\" );
	
	/**
	 * Die benutzte CSV-Datei
	 */
	static File RESULTGCSV = new File(THEDIR.getPath() + "\\result.csv");
	
	/**
	 * Speichert einen String in die CSV Datei result.csv
	 * @param csvOutputString Der String der in die CSV-Datei zu speichern ist
	 */
	public static void inCsvDateiSpeichern(String csvOutputString) {
		try {
			BufferedWriter bufferedWriterCsv = new BufferedWriter(new FileWriter(RESULTGCSV));
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
		ArrayList<String[]> zeilen = new ArrayList<String[]>();
		
		try {
			BufferedReader bufferedReaderCsv = new BufferedReader(new FileReader(RESULTGCSV));
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
	
	public static void createDirAndFile() {
		
		if(!THEDIR.exists()) {
			System.out.println(THEDIR.getAbsolutePath());
			THEDIR.mkdir();
		}
		
		if(RESULTGCSV.exists() == false) {
			try {
				RESULTGCSV.getParentFile().mkdir();
				RESULTGCSV.createNewFile();
			} catch (Exception e) {
				System.out.println("note");
				e.printStackTrace();
				MyLogger.log(e.getStackTrace().toString(),e);
			}
		}		
	}
}
