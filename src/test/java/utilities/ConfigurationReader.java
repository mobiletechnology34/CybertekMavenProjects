package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    //read the properties file
    static {

        String path="configuration.properties";
        try {

            //java cannot rad files directly, it needs inputStream  to read the files
            //inputStream takes the location of the file as a constroctpr.
            FileInputStream fileInputStream=new FileInputStream(path);

            //properties is ued to read specifically properties files, files with key value pair.
            properties=new Properties();

            //file contents are load to properties from the inputStream
            properties.load(fileInputStream);

            //all inputStream must be closed
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // return the value of specific property
    public static String getProperty(String property){
        return properties.getProperty(property);
    }

}
