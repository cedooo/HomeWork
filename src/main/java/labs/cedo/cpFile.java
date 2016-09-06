package labs.cedo;

public class cpFile {
	public static void main(String[] args) {
		System.getProperties().forEach((a, b)-> System.out.println(a.toString() + " = " + b.toString()));
		System.out.println("------------------------------------------------------");
		System.getenv().forEach((a, b)-> System.out.println(a.toString() + " = " + b.toString()));
	}
	
	
}
