package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private  static Properties properties;

    static  {
        String path="configuration.properties";
        try {
            //this line will open your file
            FileInputStream inputStream=new FileInputStream(path);
            properties= new Properties();
            //we neepripertiesd to load opened file to the
            properties.load(inputStream);
            inputStream.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public  static String getProperty(String key){
        //getProperty method takes one string as  a  key
        //and it will return value from.properties file
       return  properties.getProperty(key);
    }


}
