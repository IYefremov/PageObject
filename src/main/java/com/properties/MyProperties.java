package com.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {
    public static String getProperties(String key)   {
        String value = "";
        try {
            Properties prop = new Properties();
       //     Properties projectPath = System.getProperties("user.dir");
            InputStream inpStream = new FileInputStream("G:\\Cyberiansoft\\Automation\\JavaProjects\\Projects\\PageObject\\src\\main\\java\\com\\properties\\myProperties.properties");
            prop.load(inpStream);
            value = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getCause());
            e.getStackTrace();
        }
        return value;
    }
}
