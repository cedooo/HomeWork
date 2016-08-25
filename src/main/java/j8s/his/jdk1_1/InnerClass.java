package j8s.his.jdk1_1;
/**
 * 
 * @author cedo
 *
 */
public class InnerClass {
	public static void main(String[] args) {
		System.out.println(Outer.NestedButNotInner.z);
	}
}
class HasStatic {
    static int j = 100;
    
}
class Outer {
    class Inner extends HasStatic {
        static final int x = 3;  // OK: constant variable
        //static int y = 4;  // Compile-time error: an inner class
    }
    static class NestedButNotInner{
        static int z = 5;    // OK: not an inner class . static nested class 
    }
    interface NeverInner {}  // Interfaces are never inner
}

/**

http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

Terminology: Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes.


 because an inner class is associated with an instance, it cannot define any static members itself.


http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.1.3

An inner class is a nested class that is not explicitly or implicitly declared static.

*/