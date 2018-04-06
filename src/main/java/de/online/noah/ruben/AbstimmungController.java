/**
 * 
 */
package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
public class AbstimmungController {
	
	private AbstimmungController() throws UtilityClassException{
		throw new UtilityClassException("Utility class");
	}

	private static Abstimmung currentAbstimmung =  new Abstimmung();

	public static void personenDatenErfassen(int age, Gender gender) {
		getCurrentAbstimmung().setAge(age);
		getCurrentAbstimmung().setGender(gender);
	}
	
	
	public static void themaErfassen(String thema, int themaID) {
		getCurrentAbstimmung().setPickedThema(thema);
		getCurrentAbstimmung().setThemaId(themaID);
	}
	
	
	public static void antwortErfasssen(String antwort) {
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
