package utilities;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class Utilities {

    private static WebDriver driver;
    private static Logger logger;
    public static FileInputStream fis;
    private static Properties prop;


    public void Config(){
        try {
            fis=new FileInputStream("src/test/resources/Properties/Config.properties");
            prop= new Properties();
            prop.load(fis);

            logger= Logger.getLogger("orangeHRM");
            PropertyConfigurator.configure("Properties/Log4j.properties");

            logger.info("**** Launching the browser ****");
            String browser= prop.getProperty("browserName");
            if (browser.equalsIgnoreCase("chrome")){
                driver=new ChromeDriver();
            }else if (browser.equalsIgnoreCase("Microsoft Edge")){
                driver=new EdgeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                driver=new FirefoxDriver();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
