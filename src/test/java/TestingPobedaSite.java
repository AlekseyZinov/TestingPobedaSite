import com.codeborne.selenide.Selenide;
import com.sun.source.tree.AssertTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;


public class TestingPobedaSite {

    private static final String driverPath = "https://www.flypobeda.ru/";
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private MainPage mainPage;
    private TicketSearchPage ticketSearchPage;
    private BookingManagementPage bookingManagementPage;
    private SearchOrderPage searchOrderPage;
    private static final String actualTextTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\azinov\\Desktop\\chromedrives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        action = new Actions(driver);
        driver.get("https://www.flypobeda.ru/");
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

    @Test
    public void testTicketSearch() {
        ticketSearchPage = new TicketSearchPage(driver, wait, action);
        ticketSearchPage.scrollToTicketSearch();
        ticketSearchPage.textInputWhereFrom();
        ticketSearchPage.textInputWhere();
        ticketSearchPage.clickButtonSearch();
        Assert.assertTrue(ticketSearchPage.isVisibleErrorSearch());
    }

    @Test
    public void testBookingManagement() {
        bookingManagementPage = new BookingManagementPage(driver, wait, action);
        Assert.assertTrue(bookingManagementPage.chekBookingManagement());
        bookingManagementPage.searchBySurnameAndTicketNumber();
        bookingManagementPage.moveNewWindow();
        searchOrderPage = new SearchOrderPage(driver, wait, action);
        Assert.assertTrue(searchOrderPage.isVisibleErrorSearchOrder());
    }
}
