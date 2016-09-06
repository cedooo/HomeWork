package javas.his.jdk8;

import static java.lang.System.out;

public class LambdaExpression {
	public static java.util.List<Person> li = new java.util.ArrayList<>();
	public static void main(String[] args) {
		new Thread(()->System.out.println(new java.util.Date())).start();
		
		java.util.List<String> input = java.util.Arrays.asList(new String[] {"apple", "orange", "pear"});
		input.forEach(out::println);
	}
	
}

class Person{
	public String name;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}