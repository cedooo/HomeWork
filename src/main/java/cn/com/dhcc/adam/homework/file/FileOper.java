package cn.com.dhcc.adam.homework.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class FileOper {

	public static Logger log ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}
