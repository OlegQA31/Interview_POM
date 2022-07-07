package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerReportPage extends PageBase {
    public ManagerReportPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//div[text()='Manager Report']")
    WebElement mReport;

    @FindBy(css = "div[class='navigation-element panel panel-default']:last-child")
    WebElement administration;

    @FindBy(xpath = "//a[@href='#/Administration/userManagementPage']")
    WebElement userManagement;


    public UserManagementPage transferToUMP() {
        if (pageCheck(mReport,15) == true) {
            click(mReport);
            should(administration, 2);
            click(administration);
            should(userManagement, 3);
            click(userManagement);
        }
        return new UserManagementPage(wd);
    }

    public boolean isManagerReportPage() {
        should(mReport,3);
        return mReport.isDisplayed();
    }
}
