package javas.his.jdk1_2;


public class Collections {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//集合接口分为两大部分： java.util.Collection 和 java.util.Map

		java.util.List<String> vcms = java.util.Arrays.asList("cedo", "java", "collection");
		//大部分方法都是synchronized @since jdk 1.0
		java.util.Vector vc = new java.util.Vector();
		
		vc.addAll(vcms);
		System.out.println(vcms);

		//方法都是非synchronized
		java.util.ArrayList<String> as = new java.util.ArrayList<>();
				System.out.println(vcms);
		
		
		//java.util.Hashtable<String, String> ht;
		
		java.util.Map<String, String> maps = new java.util.HashMap<String, String>();
		maps.put("one", vcms.get(0));
		maps.put("one", vcms.get(1));
		System.out.println(maps);
		
	}
	public void Vector(){
	}
}
