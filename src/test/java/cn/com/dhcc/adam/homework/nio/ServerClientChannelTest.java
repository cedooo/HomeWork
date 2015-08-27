package cn.com.dhcc.adam.homework.nio;

public class ServerClientChannelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new CeDoClientL()).start();
	}

}
