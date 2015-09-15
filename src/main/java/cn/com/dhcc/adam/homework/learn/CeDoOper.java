package cn.com.dhcc.adam.homework.learn;

public class CeDoOper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CeDoOper().right();
	}

	public void right() {
		int bitmask = 0x000F;
		int val = 0x2222;
		// prints "2"
		System.out.println(val & bitmask);
		System.out.println(+7);
		System.out.println(16 >> 2);
		System.out.println(16 >>> 2);
		System.out.println(-16 >>> 2);
		System.out.println(-16 >> 2);
		System.out.println('\u0000');
		System.out.println(0b11010);
		// - undersocre jdk1.7+
		System.out.println(0b11_010);
		System.out.println(0b11____010);
		System.out.println(0xCAFE_BABE);
	}

}
