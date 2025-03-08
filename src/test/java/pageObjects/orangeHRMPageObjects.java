package pageObjects;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class orangeHRMPageObjects {
    WebDriver driver;
    Logger logger;
    FileInputStream fis;
    Properties prop;

public void driverSetup(){
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

    }catch (Exception ignored){
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

}
    public void enterCredentials() throws Exception {
        logger= Logger.getLogger("orangeHRM");
        PropertyConfigurator.configure("Properties/Log4j.properties");

        logger.info("**** Opening the URL ****");
        String browserUrl=prop.getProperty("url");
        System.out.println("url from property file : "+browserUrl);
        driver.get(browserUrl);
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys(prop.getProperty("userName"));
        Thread.sleep(2000);
       driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(prop.getProperty("loginbutton"))).click();
      Thread.sleep(2000);
    }
    public void validateTitlePage(){

        System.out.println("Page Title: "+ driver.getTitle());

    }
    public void closeApplication(){
        logger.info("**** Closing the Application ****");
        driver.quit();
    }

    public void MyInfo() throws InterruptedException {
        WebElement myinfo=driver.findElement(By.xpath("//span[text()='My Info']"));
        myinfo.click();
        Thread.sleep(3000);

    }
    public void EmployeeDetails() throws InterruptedException {
        logger.info("**** Entering the MyInfo details ****");
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Lokesh");
        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("A");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("N");
        Thread.sleep(3000);
        WebElement eid=driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"));
        eid.sendKeys("9398");

    }
    public void saveDetails(){
        WebElement savedetails=driver.findElement(By.xpath("//p[text()=' * Required']/following-sibling::button"));
        savedetails.click();
    }

}
