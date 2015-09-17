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
		System.out.println("1^1 = " + (1^1));
		System.out.println("1^0 = " + (1^0));
		System.out.println("0^0 = " + (0^0));
		System.out.println("0^1 = " + (0^1));
		//同或 相同为true(1) 否则在为false(0)
		System.out.println("1|1 = " + (1|1));
		System.out.println("1|0 = " + (1|0));
		System.out.println("0|0 = " + (0|0));
		System.out.println("0|1 = " + (0|1));
	}

}
