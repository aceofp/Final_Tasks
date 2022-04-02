package Task_1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    @FindBy(id = "addresses-link")
    private WebElement addressTile;

    public AddressesPage clickAddressTile() {
        addressTile.click();
        return new AddressesPage();
    }
}
