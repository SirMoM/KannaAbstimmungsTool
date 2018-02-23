/**
 * 
 */
package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
public class AbstimmungController {

	private static Abstimmung currentAbstimmung =  new Abstimmung();

	public static void personenDatenErfassen(int age, Gender gender) {
		getCurrentAbstimmung().setAge(age);
		getCurrentAbstimmung().setGender(gender);
	}
	
	
	public static void themaErfassen(String thema) {
		getCurrentAbstimmung().setPickedThema(thema);
	}
	
	
	public static void antwortErfasssen(AnswerEnum antwort) {
		getCurrentAbstimmung().setAnswer(antwort);
		
	}
	

	public static void reset() {
		setCurrentAbstimmung(null);
		setCurrentAbstimmung(new Abstimmung());
	}

	public static Abstimmung getCurrentAbstimmung() {
		return currentAbstimmung;
	}

	public static void setCurrentAbstimmung(Abstimmung currentAbstimmung) {
		AbstimmungController.currentAbstimmung = currentAbstimmung;
	}
	
	
}
