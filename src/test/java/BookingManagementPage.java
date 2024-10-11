import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BookingManagementPage {
    private final static String orderNumber = "XXXXXX";
    private final static String surname = "Qwerty";

    public void goToBookingManagementTab() {
        $(byXpath("//button[@class = 'dp-r60xlk-root-root'][3]")).click();
    }

    public void visibleClientSurname() {
        $(byXpath("//input[@placeholder = 'Фамилия клиента']")).shouldBe(visible);
    }

    public void visibleBookingOrTicketNumber() {
        $(byXpath("//input[@placeholder = 'Номер бронирования или билета']")).shouldBe(visible);
    }

    public void visibleButtonSearch() {
        $(byXpath("//button[text() = 'Поиск']")).shouldBe(visible);
    }

    public void fillingClientSurname() {
        $(byXpath("//input[@placeholder = 'Фамилия клиента']")).setValue(surname);
    }

    public void fillingOrderNumber() {
        $(byXpath("//input[@placeholder = 'Номер бронирования или билета']")).setValue(orderNumber);
    }

    public void clickSearch() {
        $(byXpath("//button[text() = 'Поиск']")).click();
    }

    public void switchingToTab() {
        switchTo().window(1);
    }
}
