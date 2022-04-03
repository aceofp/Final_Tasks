package Task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    @FindBy(id = "addresses-link")
    private WebElement addressTile;

    protected AccountPage(WebDriver driver) {
        super(driver);
    }

    public AddressesPage clickAddressTile() {
        addressTile.click();
        return new AddressesPage(driver);
    }
}
