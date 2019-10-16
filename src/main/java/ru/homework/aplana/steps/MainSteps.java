package ru.homework.aplana.steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import ru.homework.aplana.pages.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Когда("кликаем в главном меню по пункту \"(.+)\"")
    @Step("Выбран пункт главного меню - {0}")
    public void stepSelectMenuItem(String item) {
        mainPage.selectMainMenuItem(item);
    }
}
