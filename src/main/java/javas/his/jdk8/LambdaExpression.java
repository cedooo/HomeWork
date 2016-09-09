package javas.his.jdk8;

import java.util.Objects;

import static java.lang.System.out;
import static java.util.Arrays.asList;

/**
 * 正则表达式
 */
public class LambdaExpression {
    public static java.util.List<Person> li = new java.util.ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> out.println(new java.util.Date())).start();

        java.util.List<String> input = asList(new String[]{"apple", "orange", "pear"});
        input.forEach(out::println);

        java.util.List<Person> roster = asList(new Person("cedo", 27), new Person("dhc", 10), new Person("test", 900), new Person("chen", 64));

        processPersons(roster, p -> p.getAge() > -1 && p.getAge() < 80, p -> out.println(p));

        coustomer();
    }

    public static void processPersons(
            java.util.List<Person> roster,
            java.util.function.Predicate<Person> tester,
            java.util.function.Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    static public void coustomer() {
        int x = 13;
        java.util.function.Consumer<Integer> cus = (i) -> {
            System.out.printf("i= %d \n", i);
        };
        cus.accept((Integer) x);
    }
}

class Person {
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

    public Person(String name, int age) {
        Objects.requireNonNull(name);
        this.name = name;
        this.age = (age >= 0 && age < 200) ? age : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}