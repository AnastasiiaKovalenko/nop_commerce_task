package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

@Log4j2
public class DesktopsPage extends BasePage {
    public DesktopsPage() {
        super();
    }

    @FindBy(xpath = "//div[@class='page category-page']//h2[@class='title']//a[@href='/desktops']")
    private WebElement desktopsPageButton;

    @FindBy(xpath = "//h2[@class='product-title']/a")
    private List<WebElement> desktopsProductsList;

    @FindBy(xpath = "//div[@class='breadcrumb']//strong[text()]")
    private WebElement openedDesktopsTitle;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='picture']//img")
    private WebElement productImage;

    public DesktopsPage openDesktopsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsPageButton));
        desktopsPageButton.click();
        log.info("Clicked on 'laptopsPageButton'");
        wait.until(ExpectedConditions.elementToBeClickable(desktopsProductsList.get(0)));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("LaptopsPage");
        log.info("Laptops list is appeared");
        return this;
    }

    public DesktopsPage openFirstDesktop() {
        String firstLaptopInTheListName = desktopsProductsList.get(0).getText();
        log.info("Let's grab first laptop: " + firstLaptopInTheListName);
        desktopsProductsList.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        Assert.assertTrue(openedDesktopsTitle.getText().contains(firstLaptopInTheListName), "Wrong laptop was opened");
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("ProductPage");
        log.info("Asserted that the laptop we wanted to open and actually opened laptop are the same product");
        return this;
    }

}
