/**
 * 
 */
package de.online.noah.ruben;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Sir.MoM
 * @version 1.0
 * @since 25.09.2017
 */
public class MyLogger{
	
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd_MM_yyhh_mm_ss");
	
	final static File THEDIR = new File(System.getProperties().getProperty("user.home") + "\\Documents\\KanaUmfrageTool\\" );
	
//	final static File THEDIR = new File("C:\\_PDATEN\\i13az81" + "\\Documents\\KanaUmfrageTool\\" );
	
	private static File loggerFile = new File(THEDIR.getAbsolutePath().toString() + "\\LOG" + LocalDateTime.now().format(df) + ".log");
	
	private static BufferedWriter loggerFileWriter;
	
	
	public static void log(String str) {
		try {
			loggerFileWriter.write("[LOG][" + LocalDateTime.now().format(df) + "] " + str + "\n");
			loggerFileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void log(String str, Exception exception) {
		try {
			loggerFileWriter.write("["+ exception.getMessage() +"]"+"[" + LocalDateTime.now().format(df) + "] " + str + "\n");
			loggerFileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void createLoggingDatei() {

		if(!THEDIR.exists()) {
			THEDIR.mkdir();
			System.out.println("MyLogger.createLoggingDatei()");
		}
		
		if(!loggerFile.exists()) {
			try {
				loggerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {			
			loggerFileWriter = new BufferedWriter(new FileWriter(loggerFile));
			loggerFileWriter.write("Sir.MoM " + LocalDateTime.now().format(df) + " LOG START");
			loggerFileWriter.newLine();
			loggerFileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
