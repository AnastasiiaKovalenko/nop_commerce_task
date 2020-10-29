package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MainPage extends BasePage {
    public MainPage() {
        super();
    }

    public MainPage openMainPage() {
        wait.until(ExpectedConditions.elementToBeClickable(computersTitle));

        perfNavigationTiming.writeToInflux("MainPage");
        log.info("Main page is loaded");
        return this;
    }

}
