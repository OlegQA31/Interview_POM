package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPanel extends PageBase {
    public NavigationPanel(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//span[@class='pl pl-profile pointer']")
    WebElement menu;

    @FindBy(xpath = "//div[text()='Log Out']")
    WebElement logOutBtn;

    public LoginPage logOut() {
        pause(4000);
        click(menu);
        should(logOutBtn, 2);
        click(logOutBtn);
        return new LoginPage(wd);
    }

    public boolean isLogged() {
        try {
            should(menu, 2);
            if (menu.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
        }return false;
    }

}
