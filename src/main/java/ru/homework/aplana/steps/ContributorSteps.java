package ru.homework.aplana.steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import org.junit.Assert;
import ru.homework.aplana.pages.ContributorPage;

public class ContributorSteps {

    ContributorPage contributorPage = new ContributorPage();

    @Когда("выбираем валюту вклада \"(.+)\"")
    @Step("Выбрана валюта вклада - {0}")
    public void setCurrency (String nameCurrency) {
        contributorPage.setCurrencyItems(nameCurrency);
    }

    @Когда("сумму вклада устанавливаем \"(.+)\"")
    @Step("Сумма вклада установленна - {0}")
    public void setAmount(String value) {
        contributorPage.inputAmount(value);
    }

    @Когда("срок вклада устанавливаем \"(.+)\"")
    @Step("Срок вклада установлен - {0}")
    public void setPeriod(String valueMonth) {
        contributorPage.selectPeriod(valueMonth);
    }

    @Когда("сумму ежемесячного платежа устанавливаем \"(.+)\"")
    @Step("Сумма ежемесячного пополнения установлена - {0}")
    public void setReplenish(String value) {
        contributorPage.inputReplenish(value);
    }

    @Когда("нажимаем на переключатель \"(.+)\"")
    @Step("Переключаем radiobutton - {0}")
    public void clickOnChecker(String nameChecker) {
        contributorPage.clickOnChecker(nameChecker);
    }

    @Когда("сравниваем значение ставки со значением \"(.+)\"")
    @Step("Значение ставки равно - {0}")
    public void equalRatePercent(String value) {
        Assert.assertEquals(contributorPage.getRatePercent(), value);
    }

    @Когда("сравниваем значение поля 'К снятию' со значением \"(.+)\"")
    @Step("Значение поля 'К снятию' равно - {0}")
    public void equalSumResult(String value) {
        Assert.assertEquals(contributorPage.getSumResult(), value);
    }

    @Когда("сравниваем значение поля 'Пополнение' со значением \"(.+)\"")
    @Step("Значение поля 'Пополнение' равно - {0}")
    public void equalSumReplenish(String value) {
        Assert.assertEquals(contributorPage.getSumReplenish(), value);
    }

    @Когда("сравниваем значение поля 'Начисленно' со значением \"(.+)\"")
    @Step("Значение поля 'Начислено' равно - {0}")
    public void equalSumEarned(String value) {
        Assert.assertEquals(contributorPage.getSumEarned(), value);
    }
}
