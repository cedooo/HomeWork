package cn.com.dhcc.adam.homework.nio.selector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import cn.com.dhcc.adam.homework.nio.CeDoSocketChannel;

public class CeDoSelector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSelector();
	}
	/**
	 * 测试selector basic
	 */
	static public void testSelector(){
		try {
			SocketChannel sc = SocketChannel.open();
			sc.configureBlocking(false);
			Selector selector = Selector.open();
			String attachStr = "LOCALHOST";
			SelectionKey skey = sc.register(selector, SelectionKey.OP_WRITE, attachStr);
			System.out.println("isValid:" + skey.isValid());
			//skey.cancel();
			//System.out.println("isValid:" + skey.isValid());
			
			ByteBuffer bb = ByteBuffer.allocate(1024);
			bb.put(new String("Hello Wrold! @Selector").getBytes());

			SocketChannel selectedSC;
			//得到需要的socket
			Set<SelectionKey> keySet = selector.keys();
			Iterator<SelectionKey> itr = keySet.iterator();
			while(itr.hasNext()){
				SelectionKey sk = itr.next();
				if(sk.attachment()!=null&& attachStr.equals(sk.attachment().toString())){
					selectedSC = (SocketChannel) sk.channel();
					System.out.println(sk.channel().getClass());
					try {
						boolean established = selectedSC.connect(new InetSocketAddress("127.0.0.1",  CeDoSocketChannel.PORT));
						bb.flip();
						System.out.println(sk.isConnectable()+ "," + sk.isWritable() + "," + sk.isAcceptable() + "," + sk.isReadable());
						System.out.println(established + "," + selectedSC.isConnected());
						while(bb.hasRemaining()){
							selectedSC.write(bb);
						}
					}catch(IOException e){
						e.printStackTrace();
					}finally{
						if(selectedSC!=null){
							selectedSC.close();
						}
					}
					break;
				}else{
					continue;
				}
			}
			
			//sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
