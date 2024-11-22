package two.q7;

public class Person {
	public enum Gender{
		MALE, FEMALE
	}
	private Gender gender;
	private int age;
	private int height;
	
	public Person(Gender gender, int age, int height) {
		this.gender = gender;
		this.age = age;
		this.height = height;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
}
