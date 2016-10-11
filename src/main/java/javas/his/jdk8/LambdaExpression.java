package javas.his.jdk8;

import java.util.Objects;

import static java.lang.System.out;
import static java.util.Arrays.asList;

/**
 * 正则表达式
 */
public class LambdaExpression {

    public static void main(String[] args) {
        new Thread(() -> out.println(new java.util.Date())).start();

        java.util.List<String> input = asList("apple", "orange", "pear");
        input.forEach(out::println);

        java.util.List<Person> roster = asList(new Person("cedo", 27), new Person("dhc", 10), new Person("test", 900), new Person("chen", 64));

        processPersons(roster, p -> p.getAge() > -1 && p.getAge() < 80, out::println);

        coustomer();
    }

    private static void processPersons(
            java.util.List<Person> roster,
            java.util.function.Predicate<Person> tester,
            java.util.function.Consumer<Person> block) {
        /*
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
        */
        roster.forEach(p->{
                if(tester.test(p)) block.accept(p);
            }
        );

    }

    static private void coustomer() {
        int x = 13;
        java.util.function.Consumer<Integer> cus = (i ->System.out.printf("i= %d \n", i));
        cus.accept(x);
    }
}

class Person {
    public String name;
    private int age;

    public String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    Person(String name, int age) {
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