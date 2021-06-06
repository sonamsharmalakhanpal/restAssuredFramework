package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AutomationUtils {
	
//	public static Properties setEnvProperties() throws FileNotFoundException {
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/auuat.properties");
//        Properties props = new Properties();	
////        props = System.getProperties();
//        if (props.getProperty("envPropsImported") == null) {
//            try {
//                if(System.getProperty("environment").contains("us")){
//                    String s = System.getProperty("environment").substring(2);
//                    props.load(new FileInputStream(s + ".properties"));
//                }else {
////                  props.load(new FileInputStream(props.getProperty("environment") + ".properties"));
//                	props.load(file);
//                }
//            } catch (Exception e) {
//                System.err.println("Something went wrong loading the properties file.");
//            }
//            props.setProperty("envPropsImported", "true");
//        }
//        return props;
//    }
	
	public static Properties setEnvProperties() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/auuat.properties");
		Properties props = new Properties();
		props.load(file);
		return props;
		
    }

}
