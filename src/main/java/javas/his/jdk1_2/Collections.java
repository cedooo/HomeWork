package javas.his.jdk1_2;

import java.util.Arrays;

public class Collections {

	public static void main(String[] args) {
		//集合接口分为两大部分： java.util.Collection 和 java.util.Map

		//大部分方法都是synchronized @since jdk 1.0
		java.util.Vector<String> vc = new java.util.Vector<String>();
		String[] vcms = {"cedo", "java", "collection"};
		
		vc.add(vcms[0]); vc.add(vcms[1]);vc.add(vcms[2]);
		System.out.println(Arrays.toString(vcms));

		//方法都是非synchronized
		java.util.ArrayList<String> as = new java.util.ArrayList<String>();
		as.add(vcms[0]); as.add(vcms[1]);as.add(vcms[2]);
		System.out.println(Arrays.toString(vcms));
		
		
		java.util.Hashtable<String, String> ht;
		
		
	}
	public void Vector(){
	}
}
