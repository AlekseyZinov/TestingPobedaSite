import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchOrderPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public SearchOrderPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text() = 'Заказ с указанными параметрами не найден']")
    private WebElement errorSearchOrder;

    public boolean isVisibleErrorSearchOrder() {
        return errorSearchOrder.isDisplayed();
    }
}
