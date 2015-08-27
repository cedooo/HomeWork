package cn.com.dhcc.adam.homework.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;

public class FileOper {

	public static Logger log ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readByStream();
		readByNIO();
	}
	/**
	 * read by stream
	 */
	private static void readByStream(){
		String proPath = System.getProperty("user.dir");
		//System.out.println(System.getProperty("user.home"));
		String filePath = proPath + "/src/main/java/cn/com/dhcc/adam/homework/file/testfile.txt";
		File file = new File(filePath);
		FileReader osr = null;
		
		try {
			osr = new FileReader(file);
			int i;
			StringBuilder sb = new StringBuilder();
			while((i = osr.read())!=-1 ){
				sb.append((char)i);
			}
			System.out.println(sb.toString());
			
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			sb=new StringBuilder();
			while((line=br.readLine())!=null){
				sb.append(line+"\n");
			}
			System.out.println("====BufferedReader====\n" + sb.toString());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(osr!=null){
				try {
					osr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * read by java.nio.*
	 */
	private static void readByNIO(){
		System.out.println("==========NIO=================");
		String proPath = System.getProperty("user.dir");
		//System.out.println(System.getProperty("user.home"));
		String filePath = proPath + "/src/main/java/cn/com/dhcc/adam/homework/file/testfile.txt";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			FileChannel fileChannel = fis.getChannel();
			int capacity = 13;
			ByteBuffer bytebuff = ByteBuffer.allocate(capacity);
			byte[] charbyte = new byte[capacity];
			StringBuilder strbu = new StringBuilder();
			int length;
			
			while((length = fileChannel.read(bytebuff))!=-1){
				//System.out.println(length  + ":params:" + bytebuff.limit() + "," + bytebuff.capacity() + "," + bytebuff.position());
				bytebuff.flip();    //flip()方法将Buffer从写模式切换到读模式
				bytebuff.get(charbyte, 0 , length);
				
				String s = new String(charbyte);
//				System.out.println(s);
				
				strbu.append(s);
				bytebuff.clear();
				charbyte = new byte[capacity];
			}
			
			System.out.println("string builder length:" + strbu.length());
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
