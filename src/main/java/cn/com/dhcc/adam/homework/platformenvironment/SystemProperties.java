package cn.com.dhcc.adam.homework.platformenvironment;

import java.util.Map;

public class SystemProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sysProperties();
		envKey();
		System.out.println(System.getSecurityManager());
	}

	public static void sysProperties() {
		String[] sysPro = { "file.separator", "java.class.path", "java.home",
				"java.vendor", "java.vendor.url", "java.version",
				"line.separator", "os.arch", "os.name", "os.version",
				"path.separator", "user.dir", "user.home", "user.name" };
		for (int i = 0; i < sysPro.length; i++) {
			System.out.println(sysPro[i] + " = "
					+ System.getProperty(sysPro[i]));
		}

		System.out.println(System.getProperties());
	}

	public static void envKey() {
		System.out.println("--------------------------------");
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}
	}

}
