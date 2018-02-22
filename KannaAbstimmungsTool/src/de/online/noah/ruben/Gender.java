package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
public enum Gender {

	M("Männlich"),
	F("Weiblich"),
	AAH("Apache Attack Helicopter");

	private String beschreibung;

	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	Gender(final String BESCHREIBUNG ) {
		this.beschreibung = BESCHREIBUNG;
	}

	

}
