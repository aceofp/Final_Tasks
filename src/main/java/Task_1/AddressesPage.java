package Task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressesPage extends BasePage {
    @FindBy(css = ".addresses-footer>a")
    private WebElement newAddress;

    @FindBy(className = "address")
    private List<WebElement> addressList;

    protected AddressesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddress(int index) {
        return addressList.get(index);
    }

    public FormPage createNewAddress() {
        newAddress.click();
        return new FormPage(driver);
    }
}
