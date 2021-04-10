package co.com.sofka.stepdefinitions;

import co.com.sofka.log.Log4jData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileReader;
import java.util.Properties;

public class Hooks {

    public static Log4jData Log4jData;
    public static WebDriver driver;

    @Before
    public void setUp(){
        try{

            Log4jData = new Log4jData(Hooks.class.getName());
            Properties p = new Properties();
            p.load(new FileReader("files/properties/config.properties"));

            String navigator = p.getProperty("navigator");
            String pageWeb = p.getProperty("pageWeb");
            if(navigator != "" && navigator != null) {
                if(navigator.equalsIgnoreCase("Chrome")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.get(pageWeb);
                    driver.manage().window().maximize();
                }
                else if(navigator.equalsIgnoreCase("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.get(pageWeb);
                    driver.manage().window().maximize();
                }
                else {
                    System.out.println("Invalid option Selected hence defaulting to Chrome");
                    navigator = "Chrome";
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.get(pageWeb);
                    driver.manage().window().maximize();
                }
            }
            else {
                navigator = "Chrome";
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(pageWeb);
                driver.manage().window().maximize();
            }
            Log4jData.getLogger().info("Opening website https://www.saucedemo.com/");
        }catch (WebDriverException webEx){
            Log4jData.getLogger().info("WebDriver Failed: " + webEx.getMessage());
        }catch (Exception ex){
            Log4jData.getLogger().fatal(ex.getMessage());
        }
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
        Log4jData.getLogger().info("Browser closed!");
    }
}
