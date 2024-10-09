import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    private final static String moscow = "Москва";
    private final static String saintPetersburg = "Санкт-Петербург";

    @FindBy(xpath = "//img[@alt = '«Авиакомпания «Победа», Группа «Аэрофлот»'][1]")
    WebElement logoElement;

    @FindBy(xpath = "//a[text() = 'Информация']")
    WebElement informationElement;

    @FindBy(xpath = "//a[text() = 'Подготовка к полёту']")
    WebElement preparingForFlightElement;

    @FindBy(xpath = "//a[text() = 'Полезная информация']")
    WebElement usefulInformationElement;

    @FindBy(xpath = "//a[text() = 'О компании']")
    WebElement aboutCompanyElement;

    @FindBy(xpath = "//div[@style = 'z-index:1']")
    WebElement ticketSearch;

    @FindBy(xpath = "//input[@placeholder = 'Откуда'][1]")
    WebElement inputWhereFrom;

    @FindBy(xpath = "//input[@placeholder = 'Куда']")
    WebElement inputWhere;

    @FindBy(xpath = "//button[text() = 'Поиск']")
    WebElement buttonSearch;

    @FindBy(xpath = "//div[@class = 'dp-1bgt86e-root']//div[@data-errored = 'true']")
    WebElement errorSearch;

    public MainPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    public String findElementTitle() {
        return driver.getTitle();
    }

    public boolean findElementLogo() {
        wait.until(ExpectedConditions.visibilityOf(logoElement));
        return logoElement.isDisplayed();
    }

    private void targetInformation() {
        action.moveToElement(informationElement).perform();
    }

    private boolean isVisiblePreparingForFlight() {
        wait.until(ExpectedConditions.visibilityOf(preparingForFlightElement));
        return preparingForFlightElement.isDisplayed();
    }

    private boolean isVisibleUsefulInformation() {
        wait.until(ExpectedConditions.visibilityOf(usefulInformationElement));
        return usefulInformationElement.isDisplayed();
    }

    private boolean isVisibleAboutCompany() {
        wait.until(ExpectedConditions.visibilityOf(aboutCompanyElement));
        return aboutCompanyElement.isDisplayed();
    }

    public boolean visibleItemsInformation() {
        boolean bool = false;
        targetInformation();
        if (isVisiblePreparingForFlight() || isVisibleUsefulInformation() || isVisibleAboutCompany()) {
            bool = true;
        }
        return bool;
    }
}
