package cn.com.dhcc.adam.homework.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CeDoTryCatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("static f() return value is :" + f());
		;
		try {
			readFirstLineFromFileWithFinallyBlock("I:/times.logs");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String f() {
		String s = "return f";
		try {
			System.out.println("execute try block");
			return s;
		} finally {
			s = "result";
			System.out.println("execute finally block");
		}

	}
	/**
	 * the exception thrown from the try block is suppressed
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String readFirstLineFromFileWithFinallyBlock(String path)
			throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));    //is suppressed
			return br.readLine();
		} finally {
			br.close();
		}
	}
}
