import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class TestingPobedaSite {

    private static final String driverPath = "https://www.flypobeda.ru/";
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private MainPage mainPage;
    private static final String actualTextTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\azinov\\Desktop\\chromedrives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        action = new Actions(driver);
        driver.navigate().to(driverPath);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenMainPage() {
        mainPage = new MainPage(driver, wait, action);
        Assert.assertEquals(mainPage.findElementTitle(), actualTextTitle);
        Assert.assertTrue(mainPage.findElementLogo());
    }

    @Test
    public void testVisibleItemsInformation() {
        mainPage = new MainPage(driver, wait, action);
        Assert.assertTrue(mainPage.visibleItemsInformation());
    }
}
