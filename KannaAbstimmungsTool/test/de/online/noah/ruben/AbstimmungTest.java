/**
 * 
 */
package de.online.noah.ruben;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import de.online.noah.ruben.Abstimmung;
import de.online.noah.ruben.AnswerEnum;
import de.online.noah.ruben.Gender;

/**
 * @author Noah Ruben
 *
 */

public class AbstimmungTest {

	private Abstimmung classUnderTest;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		classUnderTest = new Abstimmung();
		classUnderTest.setAge(99);
		classUnderTest.setAnswer(AnswerEnum.T1_ANSWERS.getAntworten()[0]);
		classUnderTest.setGender(Gender.AAH);
		classUnderTest.setPickedThema("t1");
		classUnderTest.setThemaId(1);
	}

	/**
	 * Test method for {@link de.online.noah.ruben.Abstimmung#toCSVString()}.
	 */
	@Test
	public void testToCSVString() {
		assertEquals(classUnderTest.toCSVString(), "Abstimmung;99;Apache Attack Helicopter;1;Antwort 1");
	}
	
	@Test
	public void testToString() {
												
		assertEquals(classUnderTest.toString(), "Abstimmung [age = 99, gender = Apache Attack Helicopter, pickedThema = t1, themaId = 1, answer = Antwort 1]");
	}
}
