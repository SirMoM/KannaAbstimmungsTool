/**
 * 
 */
package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
public enum AnswerEnum {
	T1_ANSWERS(1, "Frage 1", new String[] {"Antwort 1", "Antwort 2", "Antwort 3", "Antwort 4", "Antwort 5"}),
	
	T2_ANSWERS(2, "Frage 2", new String[] {"Antwort 6", "Antwort 7", "Antwort 8", "Antwort 9", "Antwort 10"}),
	
	T3_ANSWERS(3, "Frage 3", new String[] {"Antwort 11", "Antwort 12", "Antwort 13", "Antwort 14", "Antwort 15"}),

	ERROR(0, "Es ist ein Fehler aufgetreten!",  new String[] {"Fehler!", "Fehler!", "Fehler!", "Fehler!", "Fehler!"});
	
	private int id;
	private String frage;
	private String[] antworten;
	
	
	private AnswerEnum(int id, String frage, String[] antworten) {
		this.id = id;
		this.antworten = antworten;
		this.frage = frage;
		
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the frage
	 */
	public String getFrage() {
		return frage;
	}

	/**
	 * @return the antworten Array
	 */
	public String[] getAntworten() {
		return antworten;
	}


	public static AnswerEnum getEnumFromId(int themaId) {
		switch (themaId) {
		case 1:
			return T1_ANSWERS;
		case 2:
			return T2_ANSWERS;
		case 3:
			return T3_ANSWERS;
		default:
			return ERROR;
		}
	}
}
