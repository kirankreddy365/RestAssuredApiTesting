package config;

import org.testng.annotations.BeforeSuite;

public class Setup {
	
	public static String env="qa";
	
	//@BeforeSuite
	public void setup() {
		String env1=System.getProperty("env");
		if (env1==null || env1=="") env=env1;
	}

}
