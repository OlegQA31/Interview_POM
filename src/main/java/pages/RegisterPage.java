package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//input[@id='PasswordInput']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id='ConfirmPasswordInput']")
    WebElement inputConfirmPassword;

    @FindBy(xpath = "//button[@id='registerSubmit']")
    WebElement regSubmitBtn;



    public RegisterPage fillInPassword(User user) {
        if(pageCheck(regSubmitBtn,3)){
            type(inputPassword,user.getPassword());
            type(inputConfirmPassword,user.getPassword());
        }
        return new RegisterPage(wd);
    }

    public ManagerReportPage completeReg() {
        click(regSubmitBtn);
        return new ManagerReportPage(wd);
    }
}
