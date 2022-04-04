package Task_1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task_1 {
    HomePage homePage;
    AccountPage accountPage;
    AddressesPage addressesPage;
    FormPage formPage;
    WebDriver driver;

    @Given("open browser on (.*)$")
    public void openSite(String site) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        System.out.println(site);
        homePage = new HomePage(driver);
        homePage.openHomePage(site);
    }

    @When("^user logged in with (.*) & (.*)$")
    public void userLogin(String login, String password) {
        LogInPage loginPage = homePage.clickSignIn();
        accountPage = loginPage.loginUser(login, password);
    }

    @And("click addresses tile")
    public void clickAddressTile() {
        addressesPage = accountPage.clickAddressTile();

    }

    @And("click +create new address")
    public void clickNewAddress() {
        formPage = addressesPage.createNewAddress();
    }

    @And("^fill out and save form with correct values: (.*) (.*\\s.*) (.*) (.*) (.*) (.*)$")
    public void fillOutForm(String alias, String address, String city, String zipcode, String country, String phone) {
        addressesPage = formPage.saveAddress(alias, address, city, zipcode, country, phone);
    }

    @Then("Address is saved")
    public void addressIsSaved() {
        int index = addressesPage.lastAddressIndex();
        String actualAddressText = addressesPage.getAddressText(index);
        String expectedAddressText = "Łukasz Czekan\n" +
                "Sesame Street\n" +
                "Bytom\n" +
                "49-100\n" +
                "United Kingdom\n" +
                "500-501-666";
        String actualAliasText = addressesPage.getAliasText(index);
        String expectedAliasText = "Kermit";
        addressesPage.verifyAddress(expectedAddressText, actualAddressText);
        addressesPage.verifyAlias(expectedAliasText, actualAliasText);
    }
}
