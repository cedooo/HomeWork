package javas.his.jdk8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Collections {

	public static void main(String[] args) {

		// java.util.Hashtable<String, String> ht;
		//java.util.Set s = java.util.Collections.synchronizedSet(new java.util.HashSet());
		vectorAndArrayList();
		traversingAggregate();
		arrayList();
        hashMap();
        treeMap();

		int h;
		String key = "chendong";
		String key2 = "cedo";
		System.out.println( (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16) ) ;
		h = 0;
		System.out.println( (key2 == null) ? 0 : (h = key2.hashCode()) ^ (h >>> 16) ) ;
	}

	public static final void vectorAndArrayList() {
		// 集合接口分为两大部分： java.util.Collection 和 java.util.Map

		// 大部分方法都是synchronized @since jdk 1.0
		java.util.Vector<String> vc = new java.util.Vector<String>();
		String[] vcms = { "cedo", "java", "collection" };

		vc.add(vcms[0]);
		vc.add(vcms[1]);
		vc.add(vcms[2]);
        vc.add(null);
		System.out.println(Arrays.toString(vcms));

		// 方法都是非synchronized
		java.util.ArrayList<String> as = new java.util.ArrayList<String>();
		as.add(vcms[0]);
		as.add(vcms[1]);
		//as.add(vcms[2]);
		System.out.println(Arrays.toString(vcms));

		System.out.println(vc.retainAll(as));


	}
	public static final void interfaces(){
		
	}
	
	
	public static  void traversingAggregate(){
		java.util.Collection<String> vk = new java.util.Vector<>();
		vk.add("one");
		vk.add("two");
		vk.add("three");
		vk.add("five");
		System.out.println("traversing by aggregate");
		vk.stream().forEach(e -> System.out.println(e.toString()));
		
		
		System.out.println(vk.stream().map(Object::toString).collect(Collectors.joining(" ^_^ ")));
		
	}

	static public void arrayList(){
		java.util.List<String> list = new java.util.ArrayList<String>();
		list.addAll(java.util.Arrays.asList("String", "cedo", "happy"));
		Object[] partOfList = list.toArray();
		System.out.println(java.util.Arrays.toString(partOfList));
	}

	static public void hashMap(){
	    java.util.Map<String, String> map = new java.util.HashMap<>();
        map.put(null, "");
        map.put("not null", "cedo");

    }

    static public void treeMap(){
        java.util.Map<String, String> tMap = new java.util.TreeMap<>();
//        tMap.put(null, "");
		//java.util.HashSet<String> hs;
    }
	
}
