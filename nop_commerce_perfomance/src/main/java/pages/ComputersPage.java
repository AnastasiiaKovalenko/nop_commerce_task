package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ComputersPage extends BasePage {
    public ComputersPage() {
        super();
    }

    @FindBy(xpath = "//div[@class='page category-page']")
    private WebElement popularCategoriesBanner;

    public ComputersPage openComputersPage() {
        computersTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(popularCategoriesBanner));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("ComputersPage");
        log.info("Computers page is loaded");
        return this;
    }
}
