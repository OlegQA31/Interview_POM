import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class InitTest {
    WebDriver wd;
    @BeforeSuite
    public void init(){
        WebDriverManager.chromedriver().setup();
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://iot.plataine.com/#/Login");
    }

    public void tearDown(){
        //wd.quit();
    }

}
