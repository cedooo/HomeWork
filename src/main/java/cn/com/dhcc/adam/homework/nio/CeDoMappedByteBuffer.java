package cn.com.dhcc.adam.homework.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class CeDoMappedByteBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMBB();
		readByNIO();
	}
	/**
	 * MappedByteBuffer read
	 */
	public static void testMBB(){
		System.out.println("==========MappedByteBuffer=================");
		String userdir = System.getProperty("user.dir");
		String filePath = userdir + "/src/main/java/cn/com/dhcc/adam/homework/nio/github-git-cheat-sheet.pdf";
		try {
			long sTime = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream(filePath);
			FileChannel fc = fis.getChannel();
			MappedByteBuffer buffer = fc.map(MapMode.READ_ONLY, 0, fc.size());    //fc.size() -- 通道的文件的当前大小。
			//System.out.println(new String(mbb.array()));
			  
			// the buffer now reads the file as if it were loaded in memory.
	        System.out.println(buffer.isLoaded());  //prints false
	        System.out.println(buffer.capacity());  //Get the size based on content size of file
	         
	        //You can read the file from this buffer the way you like.
	        /*
	        for (int i = 0; i < buffer.limit(); i++)
	        {
	            System.out.print((char) buffer.get()); //Print the content of file
	        }
	        */
			long eTime = System.currentTimeMillis();
			System.out.println("间隔时间" + (eTime-sTime) + "ms, 文件大小：" + fc.size());
			fis.close();
			fc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * read by java.nio.*
	 */
	private static void readByNIO(){
		System.out.println("==========NIO=================");
		String proPath = System.getProperty("user.dir");
		//System.out.println(System.getProperty("user.home"));
		String filePath = proPath + "/src/main/java/cn/com/dhcc/adam/homework/nio/github-git-cheat-sheet.pdf";
		try {
			long sTime = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream(filePath);
			FileChannel fileChannel = fis.getChannel();
			int capacity = 102400;
			ByteBuffer bytebuff = ByteBuffer.allocate(capacity);
			byte[] charbyte = new byte[capacity];
			StringBuilder strbu = new StringBuilder();
			int length;
			
			long fileSize=0;
			while((length = fileChannel.read(bytebuff))!=-1){
				//System.out.println(length  + ":params:" + bytebuff.limit() + "," + bytebuff.capacity() + "," + bytebuff.position());
				bytebuff.flip();    //flip()方法将Buffer从写模式切换到读模式
				bytebuff.get(charbyte, 0 , length);
				
				String s = new String(charbyte);
				System.out.println(s);
				fileSize += length;
				//strbu.append(s);
				bytebuff.clear();
				charbyte = new byte[capacity];
			}

			long eTime = System.currentTimeMillis();
			System.out.println("间隔时间" + (eTime-sTime) + "ms, 文件大小：" + fileSize);
			
			//System.out.println("string builder length:" + strbu.length());
			System.out.println(strbu);
			fileChannel.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
