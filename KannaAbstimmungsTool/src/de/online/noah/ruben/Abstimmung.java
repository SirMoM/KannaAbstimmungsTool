/**
 * 
 */
package de.online.noah.ruben;

/**
 * @author Noah Ruben
 *
 */
/**
 * @author i13az81
 *
 */
public class Abstimmung {
	private int age;
	private Gender gender;
	private String pickedThema;
	private AnswerEnum answer;
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @return the pickedThema
	 */
	public String getPickedThema() {
		return pickedThema;
	}
	/**
	 * @return the answer
	 */
	public AnswerEnum getAnswer() {
		return answer;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @param pickedThema the pickedThema to set
	 */
	public void setPickedThema(String pickedThema) {
		this.pickedThema = pickedThema;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(AnswerEnum answer) {
		this.answer = answer;
	}
	
	public String toCSVString() {
		return "Abstimmung;" + getAge() + ";" + getGender().getBeschreibung() + ";" + getPickedThema() + ";" + getAnswer().getAntworttext();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Abstimmung [age = " + getAge() + ", gender = " + getGender().getBeschreibung() + ", pickedThema = " + getPickedThema() + ", answer = "
				+ getAnswer().getAntworttext() + "]";
	}
}
