import org.testng.annotations.Test;

import static util.Constants.*;

public class RDDemo extends SetUpScenario {

    @Test(priority = 1)
    public void openBasePage() {
        MAIN_PAGE.openMainPage();
    }

    @Test(priority = 2)
    public void openComputersSection() {
        COMPUTERS_PAGE.openComputersPage();
    }

    @Test(priority = 3)
    public void openLaptopsPage() {
        DESKTOPS_PAGE.openDesktopsPage();
    }

    @Test(priority = 4)
    public void openFirstLaptopInTheList() {
        DESKTOPS_PAGE.openFirstDesktop();
    }
}
