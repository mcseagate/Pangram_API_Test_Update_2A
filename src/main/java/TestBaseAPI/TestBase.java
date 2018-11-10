package TestBaseAPI;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties prop;
    public static FileInputStream ip;
    public static WebDriver driver;

    public TestBase(){

        try {
            prop = new Properties();
            ip = new FileInputStream("/Users/mcseagate/IdeaProjects/Pangram_API_Test/src/main/java/TestConfigAPI/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();

        }

    }

}
