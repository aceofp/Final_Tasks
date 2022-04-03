package Task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    @FindBy(name = "email")
    private WebElement loginInputBox;

    @FindBy(name = "password")
    private WebElement passwordInputBox;

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    protected LogInPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage loginUser(String email, String password) {
        loginInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        loginButton.click();
        return new AccountPage(driver);
    }
}
