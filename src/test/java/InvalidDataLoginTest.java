import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationPanel;

public class InvalidDataLoginTest extends InitTest {

    @BeforeMethod(alwaysRun = true)
    public void logOutCheck() {
        NavigationPanel nP = new NavigationPanel(wd);
        if (nP.isLogged()) {
            nP.logOut();
        }
    }

    @Test
    public void loginWithInvalidDataTest(){
        int index = (int) System.currentTimeMillis() / 1000 % 3600;
        User user= User.builder().userName("John"+index).password("Qq").build();


        boolean errorMessagePresent=new LoginPage(wd)
                .fillInIncorrectData(user)
                .confirmLogin()
                .isErrorMessagePresent();

        Assert.assertTrue(errorMessagePresent);
    }
}
