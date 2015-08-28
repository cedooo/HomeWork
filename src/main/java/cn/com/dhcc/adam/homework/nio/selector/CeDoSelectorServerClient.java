package cn.com.dhcc.adam.homework.nio.selector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

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
		new CeDoSelectorServerClient().startSimSC();
	}
	
	public void startSimSC(){
		new Thread(new SelectorServer()).start();
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
	/**
	 * selector server
	 * @author cedo
	 *
	 */
	private class SelectorServer implements Runnable{
		public void run() {
			ServerSocketChannel schannel = null;
			try {
				schannel = ServerSocketChannel.open();
				schannel.configureBlocking(false);
				schannel.bind(new InetSocketAddress("127.0.0.1", PORT));
				
				Selector selector = Selector.open();
				schannel.register(selector, SelectionKey.OP_ACCEPT);
				
				System.out.println("ready channel:" + selector.select());
				
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
				while(keyIterator.hasNext()) {
				    SelectionKey key = keyIterator.next();
				    if(key.isAcceptable()) {
				        // a connection was accepted by a ServerSocketChannel.
				    } else if (key.isConnectable()) {
				        // a connection was established with a remote server.
				    } else if (key.isReadable()) {
				        // a channel is ready for reading
				    } else if (key.isWritable()) {
				        // a channel is ready for writing
				    }
				    keyIterator.remove();
				}
			
			} catch (IOException e) {
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
