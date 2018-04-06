/**
 * 
 */
package de.online.noah.ruben;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

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
		classUnderTest.setComment("Das ist ein Test-Kommentar");
	}

	/**
	 * Test method for {@link de.online.noah.ruben.Abstimmung#toCSVString()}.
	 */
	@Test
	public void testToCSVString() {
		assertEquals(classUnderTest.toCSVString(),
				"99;Apache Attack Helicopter;1;Antwort 1;Das ist ein Test-Kommentar");
	}

	@Test
	public void testToString() {
		String result = classUnderTest.toString();
		String expectedResult = "Abstimmung [age = 99, gender = Apache Attack Helicopter, pickedThema = t1, themaId = 1, answer = Antwort 1, comment = Das ist ein Test-Kommentar]";
		
		assertThat(result, is(expectedResult));
	}

	@Test
	public void testIsValidAbstimmung() {
		assertTrue(classUnderTest.isValidAbstimmung());
		classUnderTest.setAnswer(null);
		assertFalse(classUnderTest.isValidAbstimmung());
	}
}
