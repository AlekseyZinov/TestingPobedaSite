import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TicketSearchPage {

    private final static String moscow = "Москва";
    private final static String saintPetersburg = "Санкт-Петербург";

    public void scrollTicketSearch() {
        $(byXpath("//div[@style = 'z-index:1']")).scrollTo();
    }

    public void textInputWhereFrom() {
        $(byXpath("//input[@placeholder = 'Откуда'][1]")).setValue(moscow).pressEnter();
    }

    public void textInputWhere() {
        $(byXpath("//input[@placeholder = 'Куда']")).setValue(saintPetersburg).pressEnter();
    }

    public void clickButtonSearch() {
        $(byXpath("//button[text() = 'Поиск']")).click();
    }

    public void visibleErrorSearch() {
        $(byXpath("//div[@class = 'dp-1bgt86e-root']//div[@data-errored = 'true']")).shouldBe(visible);
    }
}
