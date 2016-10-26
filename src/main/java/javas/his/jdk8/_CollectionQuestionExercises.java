package javas.his.jdk8;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * http://docs.oracle.com/javase/tutorial/collections/interfaces/QandE/questions
 * .html
 * 
 * @author cedo
 *
 */
public class _CollectionQuestionExercises {

	public static void main(String[] args) {
		String vargs[] = {"cedo", "www", "java", "collections", "cedo", "Java"};
		_CollectionQuestionExercises.question1(vargs);
		_CollectionQuestionExercises.question2(vargs);
	}

	/**
	 * Write a program that prints its arguments in random order. Do not make a
	 * copy of the argument array. Demonstrate how to print out the elements
	 * using both streams and the traditional enhanced for statement.
	 * 
	 * @param args
	 */
	public static void question1(String[] args) {

		java.util.List<String> argl = Arrays.asList(args);
		java.util.Collections.shuffle(argl);
		// the streams
		//argl.stream().forEach(e -> System.out.print(e));
		out.println(argl.stream().map(Object::toString).collect(Collectors.joining(", ")));
		// the traditional enhance
		for (String arg : argl) {
			out.print(arg);
		}

	}

	/**
	 * Take the FindDups example and modify it to use a SortedSet instead of a
	 * Set. Specify a Comparator so that case is ignored when sorting and
	 * identifying set elements.
	 * 
	 * public static void main(String[] args) {
     *   Set<String> s = new HashSet<String>();
     *   for (String a : args)
     *         s.add(a);
     *          System.out.println(s.size() + " distinct words: " + s);
     * }
	 * 
	 * @param args
	 */
	public static void question2(String[] args) {
		java.util.Set<String> ss = new java.util.HashSet<String>();
		java.util.Comparator<String> com = new java.util.Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
			
		};
		java.util.SortedSet<String> sss = new java.util.TreeSet<>();
		for (String a : args)
			ss.add(a);
		out.println("\n" + ss.size() + " distinct words: " + ss);
		StringBuffer sb;
	}
	
}
