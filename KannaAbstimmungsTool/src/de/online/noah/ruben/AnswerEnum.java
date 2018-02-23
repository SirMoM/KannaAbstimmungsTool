/**
 * 
 */
package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
public enum AnswerEnum {
	T1_ANSWERS(1, new String[] {"Antwort 1", "Antwort 2", "Antwort 3", "Antwort 4", "Antwort 5"}),
	
	T2_ANSWERS(2, new String[] {"Antwort 6", "Antwort 7", "Antwort 8", "Antwort 9", "Antwort 10"}),
	
	T3_ANSWERS(3, new String[] {"Antwort 11", "Antwort 12", "Antwort 13", "Antwort 14", "Antwort 15"});

	
	private int id;
	private String[] antworten;
	
	
	private AnswerEnum(int id, String[] antworten) {
		this.id = id;
		this.antworten = antworten;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the antworten Array
	 */
	public String[] getAntworttext() {
		return antworten;
	}
}
