package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    WebDriver wd;

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

    public void click(By locator) {
        wd.findElement(locator).click();
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

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
}
