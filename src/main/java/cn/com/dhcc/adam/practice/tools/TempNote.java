package cn.com.dhcc.adam.practice.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempNote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pa = Pattern.compile(POJOGenerateFromSQL.REGEX_SQL_START_SQLSERVER);
		String[] sql = {

			"CREATE TABLE [dbo].[TB_cfg_device] (",
			"	[localname] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,",
			"	[centerid] [int] NULL ,",
			"	[devname] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,",
			"	[regionid] [int] NULL ,",
			"	[deviceclassid] [smallint] NULL ,",
			"	[devflag] [smallint] NULL ,",
			"	[devflagid] [int] NULL ,",
			"	[deviceid] [int] NOT NULL ,",
			"	[objectid] [int] NULL ",
			") ON [PRIMARY]",
			"   CREATE TABLE [dbo].[TB_cfg_device_class] (",
			"GO"
				
		};
		/**
		 * 匹配开头
		 */
		for (int i = 0; i < sql.length; i++) {
			Matcher ma = pa.matcher(sql[i]);
			System.out.println(ma.matches() + " : " + sql[i]);
			if(ma.matches()){
				int gc = ma.groupCount();
				System.out.println("\t" + ma.group(1));
			}
		}
		
		Pattern pf = Pattern.compile(POJOGenerateFromSQL.REGEX_SQL_FIELD_SQL_SERVER);
		for (int i = 0; i < sql.length; i++) {
			Matcher mf = pf.matcher(sql[i]);
			System.out.println(mf.matches() + " : " + sql[i]);
			if(mf.matches()){
				int gc = mf.groupCount();
				System.out.println("\t" + mf.group(1));
			}
		}
	}

}
