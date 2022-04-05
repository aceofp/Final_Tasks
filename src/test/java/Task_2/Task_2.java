package Task_2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task_2 {

    private WebDriver driver;

    @Given("^User open a browser on https://mystore-testlab.coderslab.pl/$")
    public void userOpenABrowserOnSite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }

    @When("User is logged in with correct data from Task one")
    public void userIsLoggedIn() {
        WebElement signInIcon = driver.findElement(By.className("user-info"));
        signInIcon.click();
        WebElement mailBox = driver.findElement(By.className("form-control"));
        mailBox.clear();
        mailBox.sendKeys("aceofp@gmail.com");
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.clear();
        passwordBox.sendKeys("haslo_fest_oryginalne_1111");
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

    }

    @And("User pick Hummingbird Printed Sweater to buy")
    public void userPickHummingbird() {
        WebElement clothesLink = driver.findElement(By.xpath("//a[contains(text(),'Clothes')]"));
        clothesLink.click();
        WebElement sweaterLink = driver.findElement(By.xpath("//a[contains(text(),'Hummingbird printed sweater')]"));
        sweaterLink.click();


    }

    @And("User pick M size")
    public void userPickMSize() {
        WebElement dropDownMenu = driver.findElement(By.id("group_1"));
        Select select = new Select(dropDownMenu);
        select.selectByValue("2");

    }

    @And("User pick five pieces")
    public void userPickFivePieces() {
    }

    @And("User add product to the basket")
    public void userAddProductToTheBasket() {
    }

    @And("User go to checkout option")
    public void userGoToCheckoutOption() {
    }

    @And("User confirm address")
    public void userConfirmAddress() {
    }

    @And("User pick a pickup method PrestaShop pick up in store")
    public void userPickAPickupMethodPrestaShopPickUpInStore() {
    }

    @And("User pick a payment method - Pay by Check")
    public void userPickAPaymentMethodPayByCheck() {
    }

    @And("User click on order with an obligation to pay")
    public void userClickOnOrderWithAnObligationToPay() {
    }

    @Then("User take a screenshot with ammount and order confirmation")
    public void userTakeAScreenshotWithAmmountAndOrderConfirmation() {
    }
}
