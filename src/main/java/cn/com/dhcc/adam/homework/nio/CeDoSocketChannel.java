package cn.com.dhcc.adam.homework.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class CeDoSocketChannel {

	public static final int PORT = 9999;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		r();
	}
	/**
	 * 启动服务器端socket
	 */
	public static void r(){
		new Thread(new CeDoServerL()).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new CeDoClientL()).start();
	}
}

class CeDoServerL implements Runnable{

	@Override
	public void run() {
		try {
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(CeDoSocketChannel.PORT));
			ssc.configureBlocking(false);
			while(true){
				SocketChannel sc = ssc.accept();
				if(sc!=null){
					System.out.println("\nflag:" + sc.getRemoteAddress() + ", timestamp:" + System.currentTimeMillis());
					ByteBuffer buffer = ByteBuffer.allocate(10240);
					sc.read(buffer);
					buffer.flip();
					for (int i = 0; i < buffer.limit(); i++)
			        {
			            System.out.print((char) buffer.get()); //Print the content of file
			        }
					sc.close();
				}
				Thread.sleep(100l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
class CeDoClientL implements Runnable{

	@Override
	public void run() {
		SocketChannel sc = null;
		try {
			sc = SocketChannel.open();
			sc.connect(new InetSocketAddress("127.0.0.1", CeDoSocketChannel.PORT));
			ByteBuffer bb = ByteBuffer.allocate(1024);
			String info = "Hello Server! -- " + System.currentTimeMillis();
			bb.put(info.getBytes());
			bb.flip();
			while(bb.hasRemaining()){
				sc.write(bb);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sc!=null){
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
