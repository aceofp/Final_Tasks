package Task_2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class Task_2 {

    private WebDriver driver;

    @Given("^User open a browser on https://mystore-testlab.coderslab.pl/$")
    public void userOpenABrowserOnSite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");

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
        WebElement tshirtLink = driver.findElement(By.xpath("//a[contains(text(),'Hummingbird printed t-shirt')]"));
        tshirtLink.click();


    }

    @And("User pick size")
    public void userPickSize() {
        WebElement dropDownMenu = driver.findElement(By.id("group_1"));
        Select select = new Select(dropDownMenu);
        select.selectByValue("2");

    }

    @And("User pick five pieces")
    public void userPickFivePieces() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement quantityBox = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.sendKeys("5");
    }

    @And("User add product to the basket")
    public void userAddProductToTheBasket() {
        WebElement basketButton = driver.findElement(By.cssSelector("button[data-button-action=\"add-to-cart\"]"));
        basketButton.click();
        driver.navigate().refresh();
    }

    @And("User go to checkout option")
    public void userGoToCheckoutOption() {
        WebElement cartButton = driver.findElement(By.xpath("//span[contains(text(),'Cart')]"));
        cartButton.click();
        WebElement checkoutButton = driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]"));
        checkoutButton.click();

    }

    @And("User confirm address")
    public void userConfirmAddress() {
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
        continueButton.click();
    }

    @And("User pick a pickup method PrestaShop pick up in store")
    public void userPickPickupMethod() {
        WebElement confirmButton = driver.findElement(By.name("confirmDeliveryOption"));
        confirmButton.click();

    }

    @And("User pick a payment method - Pay by Check")
    public void userPickAPaymentMethodPayByCheck() {
        WebElement paycheckIcon = driver.findElement(By.cssSelector("#payment-option-1"));
        paycheckIcon.click();
    }

    @And("User click on order with an obligation to pay")
    public void userClickOnOrderWithAnObligationToPay() {
        WebElement termsBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        termsBox.click();
        WebElement obligationButton = driver.findElement(By.xpath("//button[contains(text(),'Order with an obligation to pay')]"));
        obligationButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,170)", "");
    }

    @Then("User take a screenshot with amount and order confirmation")
    public void userTakeAScreenshotWithAmountAndOrderConfirmation() throws Exception {
        takeScreenshot(driver, "src/test/resources/screenshots/testResult.png");
    }

    public static void takeScreenshot(WebDriver webdriver, String fileWithPath) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}




