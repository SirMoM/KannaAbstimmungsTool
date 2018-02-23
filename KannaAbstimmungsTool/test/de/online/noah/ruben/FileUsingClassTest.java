/**
 * 
 */
package de.online.noah.ruben;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import de.online.noah.ruben.FileUsingClass;
import de.online.noah.ruben.MyLogger;
import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import mockit.Verifications;

/**
 * @author i13az81
 *
 */
public class FileUsingClassTest {
	
	
//	@Mocked
//	BufferedReader bufferedReaderMocked;
	
	FileUsingClass classUnderTest;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		classUnderTest = new FileUsingClass();
	}

	/**
	 * Test method for {@link de.online.noah.ruben.FileUsingClass#inCsvDateiSpeichern(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testInCsvDateiSpeichern(){
		classUnderTest.inCsvDateiSpeichern("TestString");
		
		String zeile = null;
		
		try {
			BufferedReader bufferedReaderCsv = new BufferedReader(new FileReader(FileUsingClass.RESULTGCSV));
			zeile = bufferedReaderCsv.readLine();
			bufferedReaderCsv.close();
		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.log(e.getStackTrace().toString(), e);
		}
		
		assertEquals("TestString", zeile);
		
	}
	
	@Test
	public void testStringArrayArrayAusCsv() throws IOException {
		
		String[][] exp2 = {{"x","y","z"}};
		
		classUnderTest.inCsvDateiSpeichern("x;y;z");
		
		assertArrayEquals(classUnderTest.StringArrayArrayAusCsv(), exp2 );
		
	}

	@Test
	public void testCreateDirAndFileTHEDIR() {
		classUnderTest.createDirAndFile();
		
		assertTrue(classUnderTest.THEDIR.exists());
	}

	@Test
	public void testCreateDirAndFileRESULTGCSV() {
		classUnderTest.createDirAndFile();
		
		assertTrue(classUnderTest.RESULTGCSV.exists());

	}

}