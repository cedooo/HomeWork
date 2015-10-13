package cn.com.dhcc.adam.practice.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 利用sql自动生成POJO
 * 参数： 0-SQL文件位置 ， 1-生成POJO包名
 * @author cedo
 *
 */
public class POJOGenerateFromSQL {
	private String packageName = null;
	private String filePath = null;
	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		POJOGenerateFromSQL pgfs = new POJOGenerateFromSQL();
		boolean loadSuccess = pgfs.loadParam(args);
		if(loadSuccess){
			pgfs.readAndGenerate();
		}
		
	}
	/**
	 * 加载参数
	 * @param args
	 * @return
	 */
	private boolean loadParam(String[] args){
		if(args==null||args.length<2){
			System.err.println("参数错误");
			return false;
		}
		filePath = args[0];
		if(args.length==2){
			packageName = args[1];
		}
		return true;
	}
	/**
	 * 读取sql文件
	 */
	private void readAndGenerate(){
		File sqlFile = new File(filePath);
		if(sqlFile.exists()){
			BufferedReader bfr = null;
			try {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(sqlFile),"UNICODE");
				bfr = new BufferedReader(isr);
				String lineStr = null;
				while((lineStr=bfr.readLine())!=null){
					boolean isCreateSqlStatementStart = 
							Pattern.matches(REGEX_SQL_START_SQLSERVER, lineStr);
					if(isCreateSqlStatementStart){
						String tableName = getTableName(lineStr); 
						List<String> field = new ArrayList<String>();    //一个SQL可能由多行组成
						/**
						 * getthefullsql();
						 */
						while((lineStr=bfr.readLine())!=null){
							boolean isCreateSqlStatementEnd = Pattern.matches(REGEX_SQL_END_SQLSERVER, lineStr);
							if(!isCreateSqlStatementEnd){
								field.add(lineStr);
							}else{
								break;
							}
						}
						generatePOJO(tableName, field);
					}else{
						continue;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(bfr!=null){
					try {
						bfr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	/**
	 * 生成相应java POJO 文件
	 * @param tableName 表名
	 * @param sqlStatement 字段sql List
	 */
	private void generatePOJO(String tableName, List<String> sqlStatement) {
		String fileName = tableName+ ".java";
		File javaFile = new File(fileName);
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(javaFile));
			StringBuilder javacode = new StringBuilder();
			javacode.append(packageName!=null?"package " + packageName+"; \n":"");
			javacode.append("\n");
			javacode.append("public class " + tableName + " { \n");
			javacode.append("\n");
			List<String> fieldList = new ArrayList<String>();
			for (String fieldStatement : sqlStatement) {
				Matcher matcher = Pattern.compile(REGEX_SQL_FIELD_SQL_SERVER).matcher(fieldStatement);
				if(matcher.matches()){
					String field = matcher.group(1);
					fieldList.add(field);
					javacode.append("\tprivate String " + field + ";\n" );
				}
			}
			
			javacode.append("\n");
			/**
			 * 生成getter setter
			 */
			for (String fie : fieldList) {
				String getterName = "get" + fie.substring(0, 1).toUpperCase() + fie.substring(1);
				javacode.append("\tpublic String " + getterName + "(){\n" +
						"\t\treturn this." + fie + ";\n" +
								"\t}\n");
				String setterName = "set" + fie.substring(0, 1).toUpperCase() + fie.substring(1);
				javacode.append("\tpublic void " + setterName + "(String " + fie + "){\n" +
						"\t\t this." + fie + " = " + fie + ";\n" +
								"\t}\n");
			}
			javacode.append("}");
			osw.append(javacode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(osw!=null){
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 得到表名
	 * @param lineStr
	 * @return
	 */
	private String getTableName(String lineStr) {
		Matcher matcher = Pattern.compile(REGEX_SQL_START_SQLSERVER).matcher(lineStr);
		boolean matched = matcher.matches();
		return matched&&matcher.groupCount()>0?matcher.group(1):null;
	}
	/**
	 * SQL创建语句regular expression
	 */
	final static public String REGEX_SQL_START_SQLSERVER = "\\s*CREATE TABLE \\[dbo\\].\\[([\\w]{1,})\\] \\($";
	/**
	 * SQL创建结束语句regular expression
	 */
	final static public String REGEX_SQL_END_SQLSERVER = "\\) ON \\[[\\w]+\\]";
	/**
	 * SQL 字段语句声明regular expression
	 */
	final static public String REGEX_SQL_FIELD_SQL_SERVER = "\\s*\\[([\\w]+)\\]\\s*\\[[\\w]+\\].+,*$";
}
