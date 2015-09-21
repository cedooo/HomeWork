package cn.com.dhcc.adam.homework.regularexpressions;

import java.util.regex.*;
import java.io.Console;

public class ConsoleRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		Pattern pattern = Pattern.compile(console
				.readLine("please enter the regex:"));
		Matcher matcher = pattern.matcher(console
				.readLine("string for match::"));
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
