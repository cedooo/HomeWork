package cn.com.dhcc.adam.homework.basic.operators;

public class BitwiseOR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int si = 5;
		si ^= 817;
		System.out.println(si);
		System.out.println(817^5);
		System.out.println(817|5);
		//异或 相异为true(1) 否则在为false(0)
		System.out.println("======异或(exclusive or)======");
		System.out.println("1^1 = " + (0b0000_0001^0b0000_0001));
		System.out.println("1^0 = " + (0b0000_0001^0b0000_0000));
		System.out.println("0^0 = " + (0b0000_0000^0b0000_0000));
		System.out.println("0^1 = " + (0b0000_0000^0b0000_0001));
		//或 有真为true(1) 否则在为false(0)
		System.out.println("======或======");
		System.out.println("1|1 = " + (0b0000_0001|0b0000_0001));
		System.out.println("1|0 = " + (0b0000_0001|0b0000_0000));
		System.out.println("0|0 = " + (0b0000_0000|0b0000_0000));
		System.out.println("0|1 = " + (0b0000_0000|0b0000_0001));
		
		System.out.println(0b0_0001_0011);
		
		System.out.println(2^3);
		
		
	}

}
