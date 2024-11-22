package two.q7;

import java.util.function.Predicate;

import two.q7.Person.Gender;

public class Sample {
	public static void main(String[] args) {
		Predicate<Person> isMale = p -> p.getGender().equals(Gender.MALE);
		Predicate<Person> isFemale = p -> p.getGender().equals(Gender.FEMALE);
		Predicate<Person> isAdult = p -> p.getAge() >= 20;
		Predicate<Person> isHeight = p -> p.getHeight() >= 170;
		//結果をまとめる
		Predicate<Person> criteria = isMale.or(isFemale).and(isAdult).and(isHeight);
		//
		Person person = new Person(Gender.MALE, 20, 169);
		if(criteria.test(person)) {
			System.out.println("OK");
			return;
		}
		System.out.println("NG");
	}
}
