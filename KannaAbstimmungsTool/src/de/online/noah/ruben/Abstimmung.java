/**
 * 
 */
package de.online.noah.ruben;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author Noah Ruben
 *
 */
public class Abstimmung {
	private int age;
	private Gender gender;
	private String pickedThema;
	private int themaId;
	private String answer;
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
	public String getAnswer() {
		return answer;
	}
	public int getThemaId() {
		return themaId;
	}
	public void setThemaId(int themaId) {
		this.themaId = themaId;
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
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String toCSVString() {
		return "Abstimmung;" + getAge() + ";" + getGender().getBeschreibung() + ";" + getThemaId() + ";" + getAnswer();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Abstimmung [age = " + getAge() + ", gender = " + getGender().getBeschreibung() + ", pickedThema = " + getPickedThema() + ", themaId = "
				+ getThemaId() + ", answer = " + getAnswer() + "]";
	}
	
	
	
}
