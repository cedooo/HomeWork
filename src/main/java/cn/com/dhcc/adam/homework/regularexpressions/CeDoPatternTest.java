package cn.com.dhcc.adam.homework.regularexpressions;

import java.util.regex.Pattern;

public class CeDoPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Pattern.MULTILINE);
		System.out.println(Pattern.UNIX_LINES);
		System.out.println( Pattern.MULTILINE | Pattern.UNIX_LINES);
		
	}

}
