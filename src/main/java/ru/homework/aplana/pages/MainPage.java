package ru.homework.aplana.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='service']//div[@class='service__title']")
    private List<WebElement> itemMainMenu;

    public void selectMainMenuItem(String menuItem) {
        for (WebElement element : itemMainMenu) {
            WebElement itemText = element.findElement(By.xpath("./div"));
            if (itemText.getText().equalsIgnoreCase(menuItem)) {
                click(element);
                return;
            }
        }
        Assert.fail(String.format("Элемент главного меню '%s' не найден", menuItem));
    }
}
