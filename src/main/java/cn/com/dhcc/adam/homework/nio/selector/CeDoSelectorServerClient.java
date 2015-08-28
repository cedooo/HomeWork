package cn.com.dhcc.adam.homework.nio.selector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 用selector模拟服务器-客户端
 * @author cedo
 *
 */
public class CeDoSelectorServerClient {
	private static final int PORT = 9890;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CeDoSelectorServerClient().startVSC();
	}
	
	public void startVSC(){
		new Thread(new Server()).start();
		new Thread(new Client()).start();
	}
	
	private class Server implements Runnable{

		@Override
		public void run() {
			ServerSocketChannel schannel = null;
			try {
				schannel = ServerSocketChannel.open();
				schannel.configureBlocking(false);
				schannel.bind(new InetSocketAddress("127.0.0.1", PORT));
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
				while(true){
					SocketChannel socketChannel = null;
					try{
						socketChannel = schannel.accept();
						if(socketChannel!=null){
							StringBuilder strBuilder = new StringBuilder();
							boolean bye = false;
							boolean continueRead = false;
							do{
								int readedLength = socketChannel.read(byteBuffer);
								byteBuffer.flip();
								//read 
								strBuilder = new StringBuilder();
								while(byteBuffer.hasRemaining()){
									strBuilder.append((char) byteBuffer.get());
								}
								System.out.println("server recevied[" + byteBuffer.limit() + "][" + System.currentTimeMillis() +"]:  " + strBuilder.toString());
								byteBuffer.clear();
								Thread.sleep(100);
								bye = "bye".equals(strBuilder.toString().trim());
								continueRead = !bye && readedLength>0;
							}while(continueRead);
							System.out.println("bye client:diconnected.");
						}
					}catch(Exception e){
						e.printStackTrace();
					}finally {
						if(socketChannel!=null){
							try{
								socketChannel.close();
							}catch(IOException e){}
						}
					}
					Thread.sleep(100);
				}   //end while
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				if(schannel!=null){
					try {
						schannel.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	private class Client implements Runnable{

		@Override
		public void run() {
			try {
				SocketChannel channel = SocketChannel.open();
				channel.configureBlocking(true);
				boolean establised = channel.connect(new InetSocketAddress("127.0.0.1", PORT));
				if(establised){
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String msg = null;
					while((msg=br.readLine())!=null&&!"bye".equals(msg)){
						System.out.println("client input:" +  msg);
						byteBuffer.put(new String(msg).getBytes());
						byteBuffer.flip();
						while(byteBuffer.hasRemaining()){
							channel.write(byteBuffer);
						}
						byteBuffer.clear();
					}
					System.out.println("cient socketChannel closed!");
					channel.close();
				}else{
					System.out.println("establised is false!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	}

}
