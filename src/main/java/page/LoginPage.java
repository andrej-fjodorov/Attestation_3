import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



    public class LoginPage extends Page {
        @FindBy(xpath = "//input[@id='userName']")
        public WebElement usernameInput;
        @FindBy(xpath = "//input[@id='password']")
        public WebElement passwordInput;
        @FindBy(xpath = "//input[@id='password']")
        public WebElement loginButton;
        @FindBy(xpath = "//h2[contains(text(), 'Welcome')]")
        public WebElement welcomeLabel;

        public LoginPage(WebDriver driver) {
            super(driver);
        }

        @Step("открыть страницу входа")
        public void open() {
            driver.manage().window().maximize();
            driver.get(BASE_URL);
        }

        @Step("Ввести логин и пароль")
        public void auth(String login, String pass) {
            usernameInput.sendKeys(login);
            passwordInput.sendKeys(pass);
        }

        @Step("Перейти в раздел /profile")
        public void goToProfilePage() {
            loginButton.click();
        }

        @Attachment(value = "screenshot.png", type = "image/png")
        private byte[] getScreen(){
            return driver.findElement(By.cssSelector("body")).getScreenshotAs(OutputType.BYTES);
        }

    }
}
