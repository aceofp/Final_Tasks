package Task_1;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
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
    public int addressCount() {
        return addressList.size();
    }

    public int lastAddressIndex() {
        return addressCount()-1;
    }

    public String getAliasText(int index) {
        return addressList.get(index).findElement(By.tagName("h4")).getText();

    }

    public String getAddressText(int index) {
        return addressList.get(index).findElement(By.tagName("address")).getText();
    }

    public FormPage createNewAddress() {
        newAddress.click();
        return new FormPage(driver);
    }

    public void verifyAlias(String expectedAlias, String actualAlias) {
        Assertions.assertEquals(expectedAlias, actualAlias);
    }

    public void verifyAddress(String expectedAddress, String actualAddress) {
        Assertions.assertEquals(expectedAddress, actualAddress);
    }


}
