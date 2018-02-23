/**
 * 
 */
package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
public enum AnswerEnum {
	T1Answer1(1, "Thema 1", "bsp Antworttext");
	
	
	private int id;
	private String thema;
	private String antworttext;
	
	
	private AnswerEnum(int id, String thema, String antworttext) {
		this.id = id;
		this.thema = thema;
		this.antworttext = antworttext;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the thema
	 */
	public String getThema() {
		return thema;
	}


	/**
	 * @return the antworttext
	 */
	public String getAntworttext() {
		return antworttext;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param thema the thema to set
	 */
	public void setThema(String thema) {
		this.thema = thema;
	}


	/**
	 * @param antworttext the antworttext to set
	 */
	public void setAntworttext(String antworttext) {
		this.antworttext = antworttext;
	}
	
	
	
}
