package praktikum;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverRule {
    private WebDriver driver;

    public void initDriver(){
        if(System.getProperty("browser").equals("firefox")){
            startFirefox();
        }
        else {
            startChrome();
        }
    }
    public void startFirefox(){
        WebDriverManager.firefoxdriver().setup();
        var opts = new FirefoxOptions().configureFromEnv();
        driver = new FirefoxDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void startChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}