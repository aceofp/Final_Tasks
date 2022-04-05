package Task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BasePage {
    @FindBy(name = "alias")
    private WebElement aliasInputBox;

    @FindBy(name = "address1")
    private WebElement addressInputBox;

    @FindBy(name = "city")
    private WebElement cityInputBox;

    @FindBy(name = "postcode")
    private WebElement zipcodeInputBox;

    @FindBy(name = "id_country")
    private WebElement countryInputBox;

    @FindBy(name = "phone")
    private WebElement phoneInputBox;

    @FindBy(name = "submitAddress")
    private WebElement saveButton;

    protected FormPage(WebDriver driver) {
        super(driver);
    }


    public AddressesPage saveAddress(String alias, String address, String city, String zipcode, String country, String phone) {
        Select select = new Select(countryInputBox);
        aliasInputBox.sendKeys(alias);
        addressInputBox.sendKeys(address);
        cityInputBox.sendKeys(city);
        zipcodeInputBox.sendKeys(zipcode);
        select.selectByValue("17");
        phoneInputBox.sendKeys(phone);
        saveButton.submit();
        return new AddressesPage(driver);

    }
}
