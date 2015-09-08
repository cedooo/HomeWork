package cn.com.dhcc.adam.homework.concurrency;
/**
 * 
 * @author cedo
 *
 */
public class ThreadExecuteTime {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 可能出现 0 0 或者1 1 这种结果
		 */
		new Thread(new PrintThread()).start();
		new Thread(new SetThread()).start();
		new Thread(new PrintThread()).start();
	}

}
class InfoObj{
	static int value = 0;
	//volatile static int value = 0;
}
class SetThread implements Runnable{

	@Override
	public void run() {
		InfoObj.value++;
	}
	
}
class PrintThread implements Runnable{

	@Override
	public void run() {
		System.out.println(InfoObj.value);
	}
	
}