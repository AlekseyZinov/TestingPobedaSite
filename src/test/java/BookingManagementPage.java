import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingManagementPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public BookingManagementPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    private final static String orderNumber = "XXXXXX";
    private final static String surname = "Qwerty";

    @FindBy(xpath = "//button[@class = 'dp-r60xlk-root-root'][3]")
    private WebElement buttonBookingManagement;

    @FindBy(xpath = "//input[@placeholder = 'Фамилия клиента']")
    private WebElement inputClientSurname;

    @FindBy(xpath = "//input[@placeholder = 'Номер бронирования или билета']")
    private WebElement inputBookingOrTicketNumber;

    @FindBy(xpath = "//button[text() = 'Поиск']")
    private WebElement buttonSearch;

    private void goToBookingManagementTab() {
        buttonBookingManagement.click();
    }

    private boolean isVisibleClientSurname() {
        return inputClientSurname.isDisplayed();
    }

    private boolean isVisibleBookingOrTicketNumber() {
        return inputBookingOrTicketNumber.isDisplayed();
    }

    private boolean isVisibleButtonSearch() {
        return buttonSearch.isDisplayed();
    }

    public boolean chekBookingManagement() {
        boolean bool = false;
        goToBookingManagementTab();
        if (isVisibleClientSurname() || isVisibleBookingOrTicketNumber() || isVisibleButtonSearch()) {
            bool = true;
        }
        return bool;
    }

    private void fillingClientSurname() {
        inputClientSurname.sendKeys(surname);
    }

    private void fillingOrderNumber() {
        inputBookingOrTicketNumber.sendKeys(orderNumber);
    }

    private void clickSearch() {
        buttonSearch.click();
    }

    public void searchBySurnameAndTicketNumber() {
        fillingClientSurname();
        fillingOrderNumber();
        clickSearch();
    }
}
