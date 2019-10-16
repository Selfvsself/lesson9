package ru.homework.aplana.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

public class ContributorPage extends BasePage {

    @FindBy(xpath = "//span[@class='calculator__currency-field-btn']")
    private List<WebElement> currencyItems;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement inputAmount;

    @FindBy(xpath = "//select[@name='period']")
    private WebElement selectPeriod;

    @FindBy(xpath = "//input[@name='replenish']")
    private WebElement inputReplenish;

    @FindBy(xpath = "//div[@class='calculator__check-row-field']")
    private List<WebElement> checkerBlocks;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    private WebElement itemRatePercent;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement itemSumResult;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    private WebElement itemSumReplenish;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    private WebElement itemSumEarned;

    public void setCurrencyItems(String nameCurrency) {
        for (WebElement element : currencyItems) {
            WebElement itemText = element.findElement(By.xpath("./span"));
            if (itemText.getText().equalsIgnoreCase(nameCurrency)) {
                click(element);
                return;
            }
        }
        Assert.fail(String.format("Валюта с именем '%s' не найдена"));
    }

    public void inputAmount(String value) {
        String oldValue = itemSumResult.getText();
        fillField(inputAmount, value);
        waitChangeTextElement(itemSumResult, oldValue);
    }

    public void selectPeriod(String valueMonth) {
        String oldValue = itemSumResult.getText();
        selectByValue(selectPeriod, valueMonth);
        waitChangeTextElement(itemSumResult, oldValue);
    }

    public void inputReplenish(String value) {
        String oldValue = itemSumResult.getText();
        fillField(inputReplenish, value);
        waitChangeTextElement(itemSumResult, oldValue);
    }

    public void clickOnChecker(String nameChecker) {
        for (WebElement element : checkerBlocks) {
            WebElement textElement = element.findElement(By.xpath(".//span[@class='calculator__check-text']"));
            if (textElement.getText().equalsIgnoreCase(nameChecker)) {
                String oldValue = itemSumResult.getText();
                WebElement elementClick = element.findElement(By.xpath(".//span[@class=\"calculator__check-block-input\"]"));
                click(elementClick);
                waitChangeTextElement(itemSumResult, oldValue);
                return;
            }
        }
        Assert.fail(String.format("Переключатель с именем '%s' не найден", nameChecker));
    }

    public String getRatePercent() {
        return getText(itemRatePercent);
    }

    public String getSumResult() {
        return getText(itemSumResult);
    }

    public String getSumReplenish() {
        return getText(itemSumReplenish);
    }

    public String getSumEarned() {
        return getText(itemSumEarned);
    }

}
