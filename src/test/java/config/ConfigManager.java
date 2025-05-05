package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	private static Properties properties = new Properties();
	
//	static {
//		try {
//			
//			FileInputStream fis=new FileInputStream("\\src\\test\\resources\\config\\config.properties");
//           
//            properties.load(fis);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load config.properties!", e);
//        }
//	}
	
	public static String get(String key) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config/config.properties");
	        properties.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return properties.getProperty(key);
    }

}
