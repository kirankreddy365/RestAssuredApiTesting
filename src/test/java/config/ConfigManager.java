package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	private static Properties properties = new Properties();
	private static FileInputStream fis;
	
	public static void loadConfig(String env) {
		try {
			if(fis==null) {
				fis = new FileInputStream("src/test/resources/config/config-"+env+".properties");
		        properties.load(fis);
		        System.out.println("Current Environment is: "+env);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
        
        return properties.getProperty(key);
    }

}
