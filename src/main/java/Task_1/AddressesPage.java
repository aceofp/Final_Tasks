package Task_1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressesPage extends BasePage {
    @FindBy(className = "addresses-footer")
    private WebElement newAddress;

    @FindBy(className = "address")
    private List<WebElement> addressList;

    public WebElement getAddress(int index) {
        return addressList.get(index);
    }

    public FormPage createNewAddress() {
        newAddress.click();
        return new FormPage();
    }
}
