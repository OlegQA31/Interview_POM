import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class InitTest {

    String browser=System.getProperty("browser", BrowserType.CHROME);
    WebDriver wd;

    @BeforeSuite
    public void init(){
        if(browser.equals(BrowserType.CHROME)){
            WebDriverManager.chromedriver().setup();
            wd=new ChromeDriver();

        }else if(browser.equals(BrowserType.EDGE)){
            WebDriverManager.edgedriver().setup();
            wd=new EdgeDriver();
        }

        wd.manage().window().maximize();
        wd.navigate().to("https://iot.plataine.com/#/Login");
    }
    @AfterSuite
    public void tearDown(){
        wd.quit();
    }

}
