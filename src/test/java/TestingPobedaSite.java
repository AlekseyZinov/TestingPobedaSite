import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;



public class TestingPobedaSite {

    private MainPage mainPage;
    private TicketSearchPage ticketSearchPage;
    private BookingManagementPage bookingManagementPage;
    private SearchOrderPage searchOrderPage;

    private final static String driverPath = "https://www.flypobeda.ru/";
    private static final String actualTextTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";

    @Before
    public void setUp() {
        Selenide.open(driverPath);
        String str = $(byXpath("//title")).innerText();
        Assert.assertEquals(str, actualTextTitle);
        $(byXpath("//img[@alt = '«Авиакомпания «Победа», Группа «Аэрофлот»'][1]")).shouldBe(visible);
    }

    @Test
    public void testVisibleItemsInformation () {
        mainPage = new MainPage();
        mainPage.targetElement();
        mainPage.isVisiblePreparingForFlight();
        mainPage.isVisibleUsefulInformation();
        mainPage.isVisibleAboutCompany();
    }

    @Test
    public void testTicketSearch() {
        ticketSearchPage = new TicketSearchPage();
        ticketSearchPage.scrollTicketSearch();
        ticketSearchPage.textInputWhereFrom();
        ticketSearchPage.textInputWhere();
        ticketSearchPage.clickButtonSearch();
        ticketSearchPage.visibleErrorSearch();
    }

    @Test
    public void testBookingManagement() {
        bookingManagementPage = new BookingManagementPage();
        bookingManagementPage.goToBookingManagementTab();
        bookingManagementPage.visibleBookingOrTicketNumber();
        bookingManagementPage.visibleClientSurname();
        bookingManagementPage.visibleButtonSearch();
        bookingManagementPage.fillingClientSurname();
        bookingManagementPage.fillingOrderNumber();
        bookingManagementPage.clickSearch();
        bookingManagementPage.switchingToTab();
        searchOrderPage = new SearchOrderPage();
        searchOrderPage.visibleErrorSearchOrder();
    }
}
