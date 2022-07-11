package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "OrgIDInput")
    WebElement orgName;

    @FindBy(id = "UserNameInpu")
    WebElement userName;

    @FindBy(id = "PasswordInput")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='login-error']")
    WebElement errorMsg;



    public LoginPage fillInTheLoginForm(String uname,String name, String pswrd){
        if(pageCheck(btnLogin,4)) {
            type(orgName, uname);
            type(userName, name);
            type(password, pswrd);
        }
        return this;
    }

    public int fieldsCounter(){
        List<WebElement> list= wd.findElements(By.xpath("//input"));
        int fieldsAmount=list.size();
        System.out.println(fieldsAmount);
        return fieldsAmount;
    }

    public LoginPage confirmLogin(){
        click(btnLogin);
        return new LoginPage(wd);
    }


    public boolean isLoginBtn() {
        should(btnLogin,3);
        return btnLogin.isDisplayed();
    }

    public LoginPage loginWithNewUserData(User user) {
        if(pageCheck(btnLogin,3)) {
            type(userName, user.getUserName());
            type(password, user.getPassword());
        }
        return new LoginPage(wd);
    }

    public RegisterPage toRegisterPage(){
        click(btnLogin);
        return new RegisterPage(wd);
    }

    public LoginPage fillInIncorrectData(User user) {
        if(fieldsCounter()==3) {
            type(orgName, "qaorg");
            type(userName, user.getUserName());
            type(password, user.getPassword());
        }else if(fieldsCounter()==2){
            type(userName, user.getUserName());
            type(password, user.getPassword());
        }
        return this;
    }

    public boolean isErrorMessagePresent(){
        return pageCheck(errorMsg,5);
    }


}
