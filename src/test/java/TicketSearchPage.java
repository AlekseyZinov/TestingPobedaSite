import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public TicketSearchPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    private final static String moscow = "Москва";
    private final static String saintPetersburg = "Санкт-Петербург";

    @FindBy(xpath = "//div[@style = 'z-index:1']")
    private WebElement ticketSearch;

    @FindBy(xpath = "//input[@placeholder = 'Откуда'][1]")
    private WebElement inputWhereFrom;

    @FindBy(xpath = "//div[@class = 'dp-1ct2iey-root'][@tabindex]")
    private WebElement itemSelectWhereFrom;

    @FindBy(xpath = "//input[@placeholder = 'Куда']")
    private WebElement inputWhere;

    @FindBy(xpath = "//button[text() = 'Поиск']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class = 'dp-1bgt86e-root']//div[@data-errored = 'true']")
    private WebElement errorSearch;

    public void scrollToTicketSearch() {
        action.scrollToElement(ticketSearch).perform();
    }

    public void textInputWhereFrom() {
        inputWhereFrom.click();
        inputWhereFrom.sendKeys(Keys.BACK_SPACE, moscow);
        wait.until(ExpectedConditions.visibilityOf(itemSelectWhereFrom));
        inputWhereFrom.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void textInputWhere() {
        inputWhere.click();
        inputWhere.sendKeys(Keys.BACK_SPACE, saintPetersburg);
        wait.until(ExpectedConditions.visibilityOf(itemSelectWhereFrom));
        inputWhere.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void clickButtonSearch() {
        buttonSearch.click();
    }

    public boolean isVisibleErrorSearch() {
        wait.until(ExpectedConditions.visibilityOf(errorSearch));
        return errorSearch.isDisplayed();
    }
}
