package de.online.noah.ruben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
//	final static File THEDIR = new File(System.getProperties().getProperty("user.home") + "\\Documents\\KanaUmfrageTool\\" );
	
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
		try(BufferedWriter bufferedWriterCsv = new BufferedWriter(new FileWriter(RESULTGCSV, true))) {
			bufferedWriterCsv.write(csvOutputString);
			bufferedWriterCsv.newLine();
			bufferedWriterCsv.flush();
		} catch (IOException e) {
			MyLogger.log("Konnte nicht in CSV-Datei schreiben", e);
		}
	}
	
	/**
	 * Gibt ein Array aus den Zeilen der Datei zurück
	 * @return zeilenArray Das Array das zurück gegeben wird
	 */
	//TODO Mit String[][] vereinbar machen
	public static String[][] stringArrayArrayAusCsv() {
		ArrayList<String[]> zeilen = new ArrayList<String[]>();
		
		try(BufferedReader bufferedReaderCsv = new BufferedReader(new FileReader(RESULTGCSV))){
			
			String zeile;
			while((zeile = bufferedReaderCsv.readLine()) != null) {
				zeilen.add(zeile.split(";"));
			}
			bufferedReaderCsv.close();
		} catch (Exception e) {
			MyLogger.log("Can't read CSV-File", e);
		}
		
		String[][] zeilenArray = new String[zeilen.toArray().length][2];
		zeilen.toArray(zeilenArray);
		return zeilenArray;
	}
	
	public static void createDirAndFile() {
		
		if(!THEDIR.exists()) {
			THEDIR.mkdir();
		}
		
		if(!RESULTGCSV.exists()) {
			try {
				RESULTGCSV.createNewFile();
			} catch (Exception e) {
				MyLogger.log("Can't create file or directory",e);
			}
		}
	}
}
