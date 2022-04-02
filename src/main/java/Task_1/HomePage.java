package Task_1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(className = "user-info")
    private WebElement signInButton;

    public HomePage openHomePage(String url) {
        driver.get(url);
        return this;
    }
    public LogInPage clickSignIn() {
        signInButton.click();
        return new LogInPage();
    }

}
