import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public MainPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    private static final By logoLocator = By.xpath("//img[@alt = '«Авиакомпания «Победа», Группа «Аэрофлот»'][1]");
    private static final By informationLocator = By.xpath("//a[text() = 'Информация']");
    private static final By preparingForFlightLocator = By.xpath("//a[text() = 'Подготовка к полёту']");
    private static final By usefulInformationLocator = By.xpath("//a[text() = 'Полезная информация']");
    private static final By aboutCompanyLocator = By.xpath("//a[text() = 'О компании']");


    public String findElementTitle() {
        return driver.getTitle();
    }

    public boolean findElementLogo() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoLocator)));
        return driver.findElement(logoLocator).isDisplayed();
    }

    private void targetInformation() {
        var itemInformationElement = driver.findElement(informationLocator);
        action.moveToElement(itemInformationElement).perform();

    }

    private boolean visiblePreparingForFlight() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(preparingForFlightLocator)));
        return driver.findElement(preparingForFlightLocator).isDisplayed();
    }

    private boolean visibleUsefulInformation() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(usefulInformationLocator)));
        return driver.findElement(usefulInformationLocator).isDisplayed();
    }

    private boolean visibleAboutCompany() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(aboutCompanyLocator)));
        return driver.findElement(aboutCompanyLocator).isDisplayed();
    }

    public boolean visibleItemsInformation() {
        boolean bool = false;
        targetInformation();
        if (visiblePreparingForFlight() || visibleUsefulInformation() || visibleAboutCompany()) {
            bool = true;
        }
        return bool;
    }
}
