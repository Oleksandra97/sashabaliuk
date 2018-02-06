package core;

import java.io.*;
import java.util.Properties;

public class PropertyHandler {
    private static PropertyHandler instance;
    private Properties properties;
    FileInputStream fileInputStream;

    public PropertyHandler() {
        try {
            fileInputStream = new FileInputStream("./src/test/resources/testData.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static PropertyHandler getInstance() {
        if(instance == null){
            instance = new PropertyHandler();
        }
        return instance;
    }

    private Properties getProperties(){
        return properties;
    }

    public String getStringProperty(String propertyName) {
        return PropertyHandler.getInstance().getProperties().getProperty(propertyName);
    }
}
