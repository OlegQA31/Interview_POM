package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "OrgIDInput")
    WebElement orgName;

    @FindBy(id = "UserNameInput")
    WebElement userName;

    @FindBy(id = "PasswordInput")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement btnLogin;

    public LoginPage fillInTheLoginForm(String uname,String name, String pswrd){
        type(orgName,uname);
        type(userName,name);
        type(password,pswrd);
        return this;
    }

    public ManagerReportPage confirmLogin(){
        click(btnLogin);
        return new ManagerReportPage(wd);
    }


    public boolean isLoginBtn() {
        should(btnLogin,3);
        return btnLogin.isDisplayed();
    }

    public LoginPage loginWithNewUserData(User user) {
        type(userName,user.getUserName());
        type(password,user.getPassword());
        return new LoginPage(wd);
    }

    public RegisterPage toRegisterPage(){
        click(btnLogin);
        return new RegisterPage(wd);
    }
}
