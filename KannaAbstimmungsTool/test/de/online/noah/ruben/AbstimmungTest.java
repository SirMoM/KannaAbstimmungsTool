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
 * @author i13az81
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
		classUnderTest.setAge(1);
		classUnderTest.setAnswer(AnswerEnum.T1Answer1);
		classUnderTest.setGender(Gender.AAH);
		classUnderTest.setPickedThema("1");
	}

	/**
	 * Test method for {@link de.online.noah.ruben.Abstimmung#toCSVString()}.
	 */
	@Test
	public void testToCSVString() {
		assertEquals(classUnderTest.toCSVString(), "Abstimmung;1;Apache Attack Helicopter;1;bsp Antworttext");
	}
	
	@Test
	public void testToString() {
		assertEquals(classUnderTest.toString(), "Abstimmung [age = 1, gender = Apache Attack Helicopter, pickedThema = 1, answer = bsp Antworttext]");
	}
}
