package cn.com.dhcc.adam.homework.basic.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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
		
		System.out.println(ZoneId.systemDefault());
		//时区
		Set<String> allZoneId = ZoneId.getAvailableZoneIds();
		System.out.println("======================================");
		for (String zoneId : allZoneId) {
			System.out.print("\t" + zoneId);
		}
		System.out.println("\n======================================");
		
		
		Instant nowIns = Instant.now();
		LocalDateTime ldt = LocalDateTime.ofInstant(nowIns, ZoneId.systemDefault());
		System.out.println(ldt);
		ZoneId losA = ZoneId.of("America/Los_Angeles");
		LocalDateTime losldt = LocalDateTime.ofInstant(nowIns, losA);
		System.out.println(losldt);
		
		//Clock
		Clock nowClock = Clock.systemUTC();
		System.out.println(nowClock);
	}

}
