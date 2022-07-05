package pages;

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
    WebElement btn;

    public LoginPage fillInTheForm(String uname,String name, String pswrd){
        type(orgName,uname);
        type(userName,name);
        type(password,pswrd);
        return this;
    }

    public ManagerReportPage confirmLogin(){
        click(btn);
        return new ManagerReportPage(wd);
    }
}
