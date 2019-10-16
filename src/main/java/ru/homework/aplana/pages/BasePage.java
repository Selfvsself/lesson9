package ru.homework.aplana.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.homework.aplana.steps.BaseSteps;
import ru.homework.aplana.steps.Hooks;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage {
    WebDriver driver;

    public BasePage(){
        driver = BaseSteps.getDriver();
        if (driver == null) {
            driver = Hooks.getDriver();
        }
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void fillField(WebElement element, String value)  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectByValue(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public String getText(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        return element.getText();
    }

    void waitChangeTextElement(WebElement element, String oldValue) {
        new WebDriverWait(driver, 10).until(new Function<WebDriver, Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return !element.getText().equals(oldValue);
            }
        });
    }

}
