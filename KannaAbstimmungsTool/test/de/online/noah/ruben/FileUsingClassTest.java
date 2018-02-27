/**
 * 
 */
package de.online.noah.ruben;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

/**
 * @author Noah Ruben
 *
 */
public class FileUsingClassTest {
	
	
//	@Mocked
//	BufferedReader bufferedReaderMocked;
	
	FileUsingClass classUnderTest;
	
//	@Mocked
//	FileUsingClass fileUsingClassMocked;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		classUnderTest = new FileUsingClass();
	}
	
	@Test
	public void testCreateDirAndFileTHEDIR() {
		FileUsingClass.createDirAndFile();
		
		assertTrue(FileUsingClass.THEDIR.exists());
	}

	@Test
	public void testCreateDirAndFileRESULTGCSV() {
		FileUsingClass.createDirAndFile();
		
		assertTrue(FileUsingClass.RESULTGCSV.exists());

	}

	/**
	 * Test method for {@link de.online.noah.ruben.FileUsingClass#inCsvDateiSpeichern(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testInCsvDateiSpeichern(){
		FileUsingClass.createDirAndFile();
		FileUsingClass.inCsvDateiSpeichern("EinString");
		
		String zeile = null;
		
		try {
			BufferedReader bufferedReaderCsv = new BufferedReader(new FileReader(FileUsingClass.RESULTGCSV));
			zeile = bufferedReaderCsv.readLine();
			bufferedReaderCsv.close();
		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.log(e.getStackTrace().toString(), e);
		}
		
		assertEquals("EinString", zeile);
		
	}
	

	@Test(expected = Exception.class)
	public void testInCsvDateiSpeichern3(@Mocked FileUsingClass f) throws IOException{
		
		new Expectations() {
			{
				FileUsingClass.RESULTGCSV.exists();
				result = false;

				FileUsingClass.RESULTGCSV.createNewFile();
				result = new Exception();
			}
		};
		
		
		FileUsingClass.createDirAndFile();
		
		
	}
	
	@Test
	public void testStringArrayArrayAusCsv() throws IOException {
		FileUsingClass.createDirAndFile();
		
		String[][] exp2 = {{"x","y","z"}};
		
		FileUsingClass.inCsvDateiSpeichern("x;y;z");
		
		assertArrayEquals(FileUsingClass.stringArrayArrayAusCsv(), exp2 );
		
	}
}