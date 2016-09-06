package javas.his.jdk1_2;

public class Collections {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//集合接口分为两大部分： java.util.Collection 和 java.util.Map

		//大部分方法都是synchronized @since jdk 1.0
		java.util.Vector vc = new java.util.Vector();
		String[] vcms = {"cedo", "java", "collection"};
		
		vc.add(vcms[0]); vc.add(vcms[1]);vc.add(vcms[2]);
		System.out.println(vcms);

		//方法都是非synchronized
		java.util.ArrayList<String> as = new java.util.ArrayList<String>();
		as.add(vcms[0]); as.add(vcms[1]);as.add(vcms[2]);
		System.out.println(vcms);
		
		
		//java.util.Hashtable<String, String> ht;
		
		java.util.Map<String, String> maps = new java.util.HashMap<String, String>();
		maps.put("one", vcms[0]);
		maps.put("one", vcms[1]);
		System.out.println(maps);
		
	}
	public void Vector(){
	}
}
