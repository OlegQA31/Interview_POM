package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UserManagementPage extends PageBase {
    public UserManagementPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//div[text()='User Management']")
    WebElement userManagement;

    @FindBy(xpath = "//button[@id='createUser']")
    WebElement createUserBtn;

    @FindBy(xpath = "//div[@class='modal-content']//label[text()='Create User']")
    WebElement headerOfUserForm;

    @FindBy(xpath = "//input[@id='UsernameInput']")
    WebElement inputUserName;

    @FindBy(xpath = "//input[@id='EmailInput']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='FirstNameInput']")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='LastNameInput']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement inputPhoneNumber;

    @FindBy(xpath = "//div[@id='user_roles']")
    WebElement inputRole;

    @FindBy(xpath = "//div[@id='user_homepage']")
    WebElement inputHomePage;

    @FindBy(xpath = "//input[@id='PasswordInput']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id='ConfirmPasswordInput']")
    WebElement inputConfirmPassword;

//    @FindBy(xpath = "//button[@id='cancel']")   ///to not to create a lot of new users
//    WebElement cancel;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//button[@id='close']")
    WebElement closeBtn;



    public UserManagementPage createUser(User user) {
        if (pageCheck(createUserBtn, 2)) {
            click(createUserBtn);
            if (pageCheck(headerOfUserForm, 2)) {
                fillInTheForm(user);
                confirmCreation();
                closeSuccessCreation();
            }
        }
        return this;
    }

    public void fillInTheForm(User user) {
        type(inputUserName, user.getUserName());
        type(inputEmail, user.getEmail());
        type(inputFirstName, user.getFirstName());
        type(inputLastName, user.getLastName());
        type(inputPhoneNumber, user.getPhone());
        typeLocationXY(inputRole,2);
        typeLocationXY(inputHomePage,3);
        type(inputPassword,user.getPassword());
        type(inputConfirmPassword,user.getPassword());
    }

    public void confirmCreation(){
        click(submitBtn);
    }

    public void closeSuccessCreation(){
        should(closeBtn,3);
        click(closeBtn);
    }

    public NavigationPanel transferToNP(){
        return new NavigationPanel(wd);
    }
}
