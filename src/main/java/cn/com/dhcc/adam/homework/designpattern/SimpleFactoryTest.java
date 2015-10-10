package cn.com.dhcc.adam.homework.designpattern;

import java.text.DateFormat;
import java.util.Date;

public abstract class SimpleFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(df.format(new Date()));
		DateFormat dft = DateFormat.getTimeInstance(DateFormat.FULL);
		System.out.println(dft.format( new Date()));
	}

}
