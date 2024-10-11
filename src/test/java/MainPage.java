import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public void targetElement() {
        $(byXpath("//a[text() = 'Информация']")).hover();
    }

    public void isVisiblePreparingForFlight () {
        $(byXpath("//a[text() = 'Подготовка к полёту']")).shouldBe(visible);

    }
    public void isVisibleUsefulInformation() {
        $(byXpath("//a[text() = 'Полезная информация']")).shouldBe(visible);
    }

    public void isVisibleAboutCompany() {
        $(byXpath("//a[text() = 'О компании']")).shouldBe(visible);
    }
}
