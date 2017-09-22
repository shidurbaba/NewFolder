package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
public static WebDriver driver; //instance of this Webdriver Class is accessible to all the classes
    public String saucelab_username = "";
public String browserstack_username = "";
public String saucelab_accesskey = "";
public String browserstack_accesskey = "";

// useCloudEnv is boolean type
    @BeforeMethod
    @Parameters ({"useCloudEnv","cloudEnvName", "os", "os_version", "browserName", "browserVersion","url"})
public void setup(boolean useCloudEnv, String cloudEnvName, String os, String os_version, String browserName,
                  String browserVersion, String url) throws MalformedURLException { //this is setter method

    if(useCloudEnv == true){ //checks if we are using cloud environment
        if (cloudEnvName.equalsIgnoreCase("browserstack")) {
            getCloudDriver(cloudEnvName, browserstack_accesskey, browserstack_username, os, os_version, browserName, browserVersion, url, os_version);
        }else if (cloudEnvName.equalsIgnoreCase("saucelab")){
            getCloudDriver(cloudEnvName, saucelab_accesskey, saucelab_username, os, os_version, browserName, browserVersion, url, os_version);
        }
    }else{
        getlocalDriver(browserName, os);//modify this get method to getChromeDriver and getFireFoxDriver
    }

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(36, TimeUnit.SECONDS);
    driver.navigate().to(url);//keeps history of webpages
    driver.manage().window().maximize();
}
//this is getter method which will set your driver
public WebDriver getCloudDriver(String cloudEnvName, String browserstack_accesskey, String envName, String envUsernmane, String envAccessKey, String browserName,
                                String browserVersion, String os, String os_version) throws MalformedURLException {

    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability("browser", browserName); // browser key will be equal to browserName
    cap.setCapability("browser_version", browserVersion);// cloud runs on key and value pair
    cap.setCapability("os", os); //Operating System
    cap.setCapability("os_version", os_version); //Operating Version

    if(envName.equalsIgnoreCase("saucelabs")) { //if our environment name is saucelab or browserstack set the remote webdriver accordingly
        driver = new RemoteWebDriver(new URL("http://" + envUsernmane + ":" + envAccessKey + "@ondemand.saucelabs.com:88/wd/hub"), cap);
    }else if(envName.equalsIgnoreCase("browserstack")){
        driver = new RemoteWebDriver(new URL("http://" + envUsernmane + ":" + envAccessKey + "@hub-cloud.browserstack.com/wd/hub"), cap);
    }
    //WebDriver  driver = new RemoteWebDriver(new URL ( "htt:// + envUsername + ":" + envAccessKey + "@hub-cloud.browserstack.com/wd/hub");

    return driver;
}

public WebDriver getlocalDriver(@Optional("chrome") String browserName, @Optional("linux") String os) { //checking for browser and our operating system
    if (browserName.equalsIgnoreCase("chrome")) { //based on our browser and os will be setting our browser
        if (os.equalsIgnoreCase("windows")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\moses\\IdeaProjects\\SeleniumPractice\\Generic\\driver\\chromedriver.exe");
        } else if (os.equalsIgnoreCase("linux") || os.equalsIgnoreCase("mac") || os.equalsIgnoreCase("os x") ){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\moses\\IdeaProjects\\SeleniumPractice\\Generic\\driver\\chromedriver");
        }
            driver = new ChromeDriver();
    }else if (browserName.equalsIgnoreCase("firefox")){
        if (os.equalsIgnoreCase("windows")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\moses\\IdeaProjects\\SeleniumPractice\\Generic\\driver\\geckodriver.exe");
        } else if (os.equalsIgnoreCase("linux") || os.equalsIgnoreCase("Mac")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\moses\\IdeaProjects\\SeleniumPractice\\Generic\\driver\\geckodriver");
        }
            driver = new FirefoxDriver();
    }
    return driver;
}

@AfterMethod
public void finishup(){
    driver.close();
}


public void navigateForward(){
    driver.navigate().forward();
}
public void navigateBackward(){
        driver.navigate().back();
    }
 public String getCurrentPageUrl(){
    String title = driver.getTitle();
    return title;
 }
 public void clearInputField(String locator){
     driver.findElement(By.cssSelector(locator)).clear();
 }

 public void typeByCSS(String locator, String value){
     driver.findElement(By.cssSelector(locator)).clear();
 }





}

