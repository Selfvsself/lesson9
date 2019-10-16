import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import ru.homework.aplana.steps.BaseSteps;
import ru.homework.aplana.steps.ContributorSteps;
import ru.homework.aplana.steps.MainSteps;

/*
Сценарий 1
    Перейти по ссылке
    Выбрать в меню пункт Вклады
    Выбрать Рубли
    Сумма вклада 300 000
    Срок 6 месяцев
    Ежемесячное пополнение 50 000
    Отметить - Ежемесячная капитализация
    Проверить расчеты по вкладу
        Ставка,
        к снятию через месяц,
        пополнение за 6 месяцев,
        начислено

Сценарий 2
    Перейти по ссылке
    Выбрать в меню пункт Вклады
    Выбрать Рубли
    Сумма вклада 500 000
    Срок 6 месяцев
    Ежемесячное пополнение 70 000
    Отметить - Ежемесячная капитализация
    Отметить - частичное снятие
    Проверить расчеты по вкладу
        Ставка,
        к снятию через 6 месяцев,
        пополнение за 6 месяцев,
        начислено
 */

public class TestContribution extends BaseSteps {

    @Test
    @Ignore
    @DisplayName("Сценарий 1")
    public void Test1() {
        MainSteps mainSteps = new MainSteps();
        ContributorSteps contributorSteps = new ContributorSteps();

        mainSteps.stepSelectMenuItem("Вклады");

        contributorSteps.setCurrency("Рубли");
        contributorSteps.setAmount("300000");
        contributorSteps.setPeriod("6");
        contributorSteps.setReplenish("50000");
        contributorSteps.clickOnChecker("Ежемесячная капитализация");

        contributorSteps.equalRatePercent("5.90%");
        contributorSteps.equalSumResult("562 566,02");
        contributorSteps.equalSumReplenish("250 000");
        contributorSteps.equalSumEarned("12 566,02");
    }

    @Test
    @Ignore
    @DisplayName("Сценарий 2")
    public void Test2() {
        MainSteps mainSteps = new MainSteps();
        ContributorSteps contributorSteps = new ContributorSteps();

        mainSteps.stepSelectMenuItem("Вклады");

        contributorSteps.setCurrency("Рубли");
        contributorSteps.setAmount("500000");
        contributorSteps.setPeriod("6");
        contributorSteps.setReplenish("70000");
        contributorSteps.clickOnChecker("Ежемесячная капитализация");
        contributorSteps.clickOnChecker("Частичное снятие");

        contributorSteps.equalRatePercent("5.65%");
        contributorSteps.equalSumResult("869 107,22");
        contributorSteps.equalSumReplenish("350 000");
        contributorSteps.equalSumEarned("19 107,22");
    }
}
