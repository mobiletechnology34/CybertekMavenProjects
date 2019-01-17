package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {
    private static WebDriver driver;
    private Driver(){}
    public static WebDriver getDriver(){
        if(driver==null){
            //TODO
            String browser=ConfigurationReader.getProperty("browser");
            switch (browser){
                case  "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    //driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
                case  "opera":
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                 default:
                     System.out.println("Cannot found any driver");
            }
        }
        return  driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
