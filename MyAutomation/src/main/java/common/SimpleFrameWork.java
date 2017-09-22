package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleFrameWork {

    public static WebDriver driver ;
    public String baseurl;


    @BeforeMethod
    public void setup() {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\moses\\IdeaProjects\\MyAutomation\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseurl = "http://www.google.com";
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }



}


