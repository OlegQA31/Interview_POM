package pages;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected WebDriver wd;

    public PageBase(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public void type(WebElement element, String text) {
        if (text != null && !text.isEmpty()) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }


    public void click(WebElement element) {
        element.click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void should(WebElement element, int time) {
        new WebDriverWait(wd, time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean pageCheck(WebElement element, int time) {
        should(element, time);
        return element.isDisplayed();
    }

    public void typeLocationXY(WebElement element, int offSet) {
        click(element);

        Rectangle rect = element.getRect();
        Actions actions = new Actions(wd);
        actions.moveToElement(element).release().build().perform();
        int y = rect.getHeight();
        actions.moveByOffset(0, offSet * y).click().build().perform();

    }

}
