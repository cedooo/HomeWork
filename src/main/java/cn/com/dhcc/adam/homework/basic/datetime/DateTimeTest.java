package cn.com.dhcc.adam.homework.basic.datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today.toString());
		System.out.println(today.getDayOfYear());
		
		Instant time = Instant.now();
		System.out.println(time);
		
		System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));
		System.out.printf("%s%n", DayOfWeek.THURSDAY.plus(4));
		System.out.printf("%d%n", Month.FEBRUARY.maxLength());
		
		YearMonth date = YearMonth.now();
		System.out.println(date + ":" + date.lengthOfMonth());
		
		boolean validLeapYear = Year.of(2012).isLeap();
		System.out.println(validLeapYear);
		
		LocalDate loc = LocalDate.parse("20150929", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(loc.toString());
		
		
		ZonedDateTime zoneddt = ZonedDateTime.now();
		System.out.println(zoneddt);
		
		//判断某年2月有多少天
		YearMonth ym = YearMonth.of(2009, Month.FEBRUARY);
		System.out.println(ym.isLeapYear() + ":" + ym.lengthOfMonth());
	}

}
