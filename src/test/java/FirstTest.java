import org.testng.annotations.Test;
import pages.LoginPage;

public class FirstTest extends InitTest{
@Test
    public void loginSuccessTest(){
    new LoginPage(wd)
            .fillInTheForm("qaorg","admin","Qwerty123")
            .confirmLogin();
}
}
