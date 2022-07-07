import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagerReportPage;
import pages.NavigationPanel;

public class CreateNewUserTest extends InitTest {

    @BeforeMethod(alwaysRun = true)
    public void firstLogin() {
        new LoginPage(wd)
                .fillInTheLoginForm("qaorg", "admin1", "Qwerty123")
                .confirmLogin();
    }

    @Test
    public void newUserCreationTest() {
        int index = (int) System.currentTimeMillis() / 1000 % 3600;
        User user = User.builder()
                .userName("Yakov" + index)
                .email("ya" + index + "@gmail.com")
                .firstName("Yakov")
                .lastName("Bashaev")
                .phone("8305568706")
                .password("Qwerty1234")
                .build();


        boolean isLoginBtnPresent=new ManagerReportPage(wd).transferToUMP()
                .createUser(user)
                .transferToNP()
                .logOut()
                .isLoginBtn();
        Assert.assertTrue(isLoginBtnPresent);

        boolean isManagerReportPresent=new LoginPage(wd).loginWithNewUserData(user)
                .toRegisterPage()
                .fillInPassword(user)
                .completeReg()
                .isManagerReportPage();
        Assert.assertTrue(isManagerReportPresent);

    }

    @AfterMethod(alwaysRun = true)
    public void logOutCheck(){
        NavigationPanel nP=new NavigationPanel(wd);
        if(nP.isLogged()){
            nP.logOut();
        }
    }
}
