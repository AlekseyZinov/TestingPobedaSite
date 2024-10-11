import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchOrderPage {

    public void visibleErrorSearchOrder() {
        $(byXpath("//div[@class = 'message_error']")).shouldBe(visible, Duration.ofSeconds(35));
    }
}
