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

	private static DateTimeFormatter dateTimeFormatterFileCreation = DateTimeFormatter.ofPattern("dd_MM_yyhh_mm_ss");
	private static DateTimeFormatter dateTimeFormatterForFileWriting = DateTimeFormatter.ofPattern("dd.MM.yy  hh:mm:ss");

	//	final static File THEDIR = new File(System.getProperties().getProperty("user.home") + "\\Documents\\KanaUmfrageTool\\" );

	static final File THEDIR = new File("C:\\_PDATEN\\i13az81" + "\\Documents\\KanaUmfrageTool\\" );

	private static File loggerFile = new File(THEDIR.getAbsolutePath()+ "\\LOG" + LocalDateTime.now().format(dateTimeFormatterFileCreation) + ".log");

	private static BufferedWriter loggerFileWriter;


	public static void log(String str) {
		try {
			loggerFileWriter.write("[LOG][" + LocalDateTime.now().format(dateTimeFormatterForFileWriting) + "] " + str);
			loggerFileWriter.newLine();
			loggerFileWriter.flush();
		} catch (IOException e) {
			//Can't log cause MyLogger failed!
		}
	}	

	public static void log(String str, Exception exception) {
		try {
			loggerFileWriter.write("[Error][" + LocalDateTime.now().format(dateTimeFormatterForFileWriting) + "] " + str + " "+ exception.getMessage() + " " + getStackTrace(exception));
			loggerFileWriter.newLine();
			loggerFileWriter.flush();
		} catch (IOException e) {
			//Can't log cause MyLogger failed!
		}
	}


	private static String getStackTrace(Exception e) {
		String stackTrace = "";
		for (StackTraceElement stackTraceElement : e.getStackTrace()) {
			stackTrace += "\r\n \t\t" + stackTraceElement.toString();  
		}
		return stackTrace;
	}

	public static void createLoggingDatei() {

		if(!THEDIR.exists()) {
			THEDIR.mkdir();
		}

		if(!loggerFile.exists()) {
			try {
				loggerFile.createNewFile();
			} catch (IOException e) {
				//Can't log cause MyLogger failed!
			}
		}

		try {			
			loggerFileWriter = new BufferedWriter(new FileWriter(loggerFile));
			loggerFileWriter.write("Sir.MoM " + LocalDateTime.now().format(dateTimeFormatterFileCreation) + " LOG START");
			loggerFileWriter.newLine();
			loggerFileWriter.flush();
		} catch (IOException e) {
			//Can't log cause MyLogger failed!
		}
	}

}
